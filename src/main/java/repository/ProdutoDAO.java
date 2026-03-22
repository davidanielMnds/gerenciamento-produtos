package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
            instance = new ProdutoDAO();
        }
        return instance;
    }
    
    //--------------------------METODOS--------------------
    
    //--------------------------GET PRODUTO----------------
    public Produto getProduto(Integer id) throws SQLException
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
        }
        return null;
    }
    
    //---------------------------LISTAR PRODUTOS PESQUISA------
    public List<Produto> listarProdutosPesquisa(String nome) throws SQLException
    {
        String sql = "SELECT * FROM produtos WHERE nome LIKE ?";
        List<Produto> lista = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, nome+"%");
            try (ResultSet rs = stmt.executeQuery())
            {
                while(rs.next())
                {
                    Produto p = new Produto(rs.getString("nome"), rs.getInt("quantidade"), rs.getDouble("preco"));
                    p.setID(rs.getInt("id"));
                    lista.add(p);
                }
            }
        }
        return lista;
    }
    
    //--------------------------PRODUTOEXISTE -BOOLEAN -INTEGER ----------------
    public boolean produtoExiste(Integer id) throws SQLException
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
        }
        return false;
    }
    
    //--------------------------PRODUTOEXISTE -BOOLEAN -STRING ----------------
    public boolean produtoExiste(String nome) throws SQLException
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
        }
        return false;
    }
    
    //--------------------------ADICIONAR PRODUTO----------------
    public void adicionarProduto(String nome, int quantidade, double preco) throws SQLException
    {
        String sql = "INSERT INTO produtos (nome, quantidade, preco) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, nome);
            stmt.setInt(2, quantidade);
            stmt.setDouble(3, preco);
            stmt.executeUpdate();
        }
    }
    
    //--------------------------ATUALIZAR PRODUTO----------------------
    public void atualizarProduto(Produto produtoAtualizado, Integer id) throws SQLException
    {
        String sql = "UPDATE produtos SET nome = ?, quantidade = ?, preco = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, produtoAtualizado.getNome());
            stmt.setInt(2, produtoAtualizado.getQuantidade());
            stmt.setDouble(3, produtoAtualizado.getPreco());
            stmt.setInt(4, id);
            stmt.executeUpdate();
            
        }
    }
    
    //--------------------------LISTAR PRODUTOS----------------------
    public List<Produto> listarProdutos() throws SQLException
    {
        String sql = "SELECT * FROM produtos";
        List<Produto> lista = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql))
        {
            try(ResultSet rs = stmt.executeQuery())
            {
                while(rs.next())
                {
                    Produto p = new Produto(
                            rs.getString("nome"),
                            rs.getInt("quantidade"),
                            rs.getDouble("preco")
                    );
                    p.setID(rs.getInt("id"));
                    lista.add(p);     
                }
            }
        }
        return lista;
    }
    
    //--------------------------DELETAR PRODUTO----------------------
    public void deletarProduto(Integer id) throws SQLException
    {
        String sql = "DELETE FROM produtos WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }    
}
