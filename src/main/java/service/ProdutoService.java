package service;
import exception.ProdutoDuplicadoException;
import exception.ProdutoNaoEncontradoException;
import java.sql.SQLException;
import model.Produto;
import repository.ProdutoDAO;

public class ProdutoService {
    //--------------------------ATRIBUTO--------------------
    private static ProdutoService instance;
    
    //--------------------------CONSTRUTOR--------------------
    public ProdutoService() {}
    
    //--------------------------SINGLETON--------------------
    public static ProdutoService getInstance()
    {
        if(instance==null)
        {
            return new ProdutoService();
        }
        return instance;
    }
    
    //--------------------------MÉTODOS--------------------
    
    //--------------------------GET PRODUTO--------------------
    public Produto getProduto(Integer id) throws ProdutoNaoEncontradoException
    {
        Produto produto = ProdutoDAO.getInstance().getProduto(id);
        if(produto==null) {throw new ProdutoNaoEncontradoException(id);}
        return produto;
    }
    
    //--------------------PRODUTO EXISTE -BOOLEAN -INTEGER--------------------
    public boolean produtoExiste(Integer id) throws SQLException
    {
        return ProdutoDAO.getInstance().produtoExiste(id);
    }
    
    //--------------------PRODUTO EXISTE -BOOLEAN -STRING--------------------
    public boolean produtoExiste(String nome) throws SQLException
    {
        return ProdutoDAO.getInstance().produtoExiste(nome);
    }
    
    
    
}

/*
--------------------------METODOS PARA VERIFICAR--------------------
public Produto getProduto(Integer id) X
public boolean produtoExiste(Integer id) X
public boolean produtoExiste(String nome) 
--------------------------METODOS PARA ADICIONAR--------------------
public void adicionarProduto(String nome, int quantidade, double preco) 
public List<Produto> lerProdutos()
public atualizarProduto(Produto produtoAtualizado, Integer id)
{
    cria produto novo
    coloca as mesmas informações
    if !isBlank()
    muda
    atualiza tudo mas continua igual oq for blank    
}
public void deletarProduto(Integer id) 
*/
