package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Produto;
import util.ConnectionFactory;

public class ProdutoDAO {
    //--------------------------ATRIBUTO--------------------
    private static ProdutoDAO instance;
    
    //--------------------------CONSTRUTOR--------------------
    private ProdutoDAO() {}
    
    //--------------------------SINGLETON--------------------
    public static ProdutoDAO getInstance()
    {
        if(instance==null)
        {
            return new ProdutoDAO();
        }
        return instance;
    }
    
    //--------------------------METODOS--------------------
    
    //--------------------------GET PRODUTO----------------
    public Produto getProduto(Integer id)
    {
        String sql = "SELECT * FROM produtos WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery())
            {
                if(rs.next())
                {
                    Produto p = new Produto(rs.getString("nome"),
                            rs.getInt("quantidade"),
                            rs.getDouble("preco"));
                    p.setID(rs.getInt("id"));
                    return p;
                }
            }
        }catch(SQLException e)
            {
                JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
            }
        return null;
    }
    
    //--------------------------PRODUTOEXISTE -BOOLEAN -INTEGER ----------------
    public boolean produtoExiste(Integer id)
    {
        String sql = "SELECT 1 FROM produtos WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery())
            {
                if(rs.next()) {return true;}
            }
        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
        }
        return false;
    }
    
    //--------------------------PRODUTOEXISTE -BOOLEAN -STRING ----------------
    public boolean produtoExiste(String nome)
    {
        String sql = "SELECT 1 FROM produtos WHERE nome = ?";
        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, nome);
            try (ResultSet rs = stmt.executeQuery())
            {
                if(rs.next()) {return true;}
            }
        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
        }
        return false;
    }
    
    
}
/*
--------------------------METODOS PARA ADICIONAR--------------------
public Produto getProduto(Integer id)
public boolean produtoExiste(Integer id)
public boolean produtoExiste(String nome)
public void adicionarProduto(String nome, int quantidade, double preco)
public List<Produto> lerProdutos()
public atualizarProduto(Integer id, String novoNome)
{
    cria produto novo
    coloca as mesmas informações
    if !isBlank()
    muda
    atualiza tudo mas continua igual oq for blank    
}
public void deletarProduto(Integer id)

    




*/