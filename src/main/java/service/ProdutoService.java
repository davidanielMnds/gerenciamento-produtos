package service;
import exception.EntradaInvalidaException;
import exception.PrecoMenor0Exception;
import exception.ProdutoDuplicadoException;
import exception.ProdutoNaoEncontradoException;
import exception.QuantidadeMenor0Exception;
import java.sql.SQLException;
import java.util.List;
import model.Produto;
import repository.ProdutoDAO;
import util.ConversorService;

public class ProdutoService {
    //--------------------------ATRIBUTO----------------------
    private static ProdutoService instance;
    
    //--------------------------CONSTRUTOR--------------------
    public ProdutoService() {}
    
    //--------------------------SINGLETON---------------------
    public static ProdutoService getInstance()
    {
        if(instance==null)
        {
            instance = new ProdutoService();
        }
        return instance;
    }
    
    //--------------------MÉTODOS--------------------------------------------
    
    //--------------------GET PRODUTO----------------------------------------
    public Produto getProduto(Integer id) throws ProdutoNaoEncontradoException, SQLException
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
    
    //--------------------ADICIONAR PRODUTO----------------------------------
    public void adicionarProduto(String nome, int quantidade, double preco)
            throws ProdutoDuplicadoException, SQLException
    {
        if(produtoExiste(nome)) {throw new ProdutoDuplicadoException(nome);}
        ProdutoDAO.getInstance().adicionarProduto(nome, quantidade, preco);
    }
    
    //--------------------LISTAR PRODUTOS------------------------------------
    public List<Produto> listarProdutos() throws SQLException
    {
        return ProdutoDAO.getInstance().listarProdutos();
    }
    
    public void atualizarProduto(Integer id, String nome, String quantidadeTexto, String precoTexto)
            throws ProdutoDuplicadoException, ProdutoNaoEncontradoException,
            PrecoMenor0Exception, QuantidadeMenor0Exception, SQLException, EntradaInvalidaException
    {
        Produto produto = getProduto(id);
        //---------------------VERIFICAR NOME---------------------
        if(!nome.isBlank())
        {
            if(produtoExiste(nome)) {throw new ProdutoDuplicadoException(nome);}
            produto.setNome(nome);
        }
        //---------------------VERIFICAR QUANTIDADE---------------------
        if(!quantidadeTexto.isBlank())
        {
            int quantidade = ConversorService.converterInt(quantidadeTexto, "quantidade");
            if (quantidade<0) {throw new QuantidadeMenor0Exception(quantidade);}
            produto.setQuantidade(quantidade);
        }
        //---------------------VERIFICAR QUANTIDADE---------------------
        if(!precoTexto.isBlank())
        {
            double preco = ConversorService.converterDouble(precoTexto, "preço");
            if (preco < 0) {throw new PrecoMenor0Exception(preco);}
            produto.setPreco(preco);
        }
        ProdutoDAO.getInstance().atualizarProtudo(produto, id);
    }
    
    public void deletarPrdoduto(Integer id) throws ProdutoNaoEncontradoException, SQLException
    {
        if(!produtoExiste(id)) {throw new ProdutoNaoEncontradoException(id);}
        ProdutoDAO.getInstance().deletarProduto(id);
    }
    
}

/*
--------------------------METODOS PARA VERIFICAR--------------------
public Produto getProduto(Integer id) X
public boolean produtoExiste(Integer id) X
public boolean produtoExiste(String nome) X
--------------------------METODOS PARA ADICIONAR--------------------
public void adicionarProduto(String nome, int quantidade, double preco) X
public List<Produto> listarProdutos() X
public atualizarProduto(Produto produtoAtualizado, Integer id) X
{
    cria produto novo
    coloca as mesmas informações
    if !isBlank()
    muda
    atualiza tudo mas continua igual oq for blank    
}
public void deletarProduto(Integer id) X
*/
