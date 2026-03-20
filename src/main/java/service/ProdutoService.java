package service;
import exception.ProdutoDuplicadoException;
import exception.ProdutoNaoEncontradoException;
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
    public Produto getProduto(Integer id) throws ProdutoNaoEncontradoException
    {
        Produto produto = ProdutoDAO.getInstance().getProduto(id);
        if(produto==null) {throw new ProdutoNaoEncontradoException(id);}
        return produto;
    }
    
}

/*
--------------------------METODOS PARA VERIFICAR--------------------
public Produto getProduto(Integer id) X
public boolean produtoExiste(Integer id) X
public boolean produtoExiste(String nome) X
--------------------------METODOS PARA ADICIONAR--------------------
public void adicionarProduto(String nome, int quantidade, double preco) X
public List<Produto> lerProdutos()
public atualizarProduto(Produto produtoAtualizado, Integer id)X
{
    cria produto novo
    coloca as mesmas informações
    if !isBlank()
    muda
    atualiza tudo mas continua igual oq for blank    
}
public void deletarProduto(Integer id) X
*/
