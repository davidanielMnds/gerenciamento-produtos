package service;
import exception.EntradaInvalidaException;
import exception.NomeVazioException;
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
    private ProdutoService() {}
    
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
    
    //--------------------LISTAR PRODUTOS PESQUISA---------------------------
    public List<Produto> listarProdutosPesquisa(String nome) throws SQLException
    {
        List<Produto> lista = ProdutoDAO.getInstance().listarProdutosPesquisa(nome);
        return lista;
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
    
    //--------------------ADICIONAR PRODUTO ----------------------------------
    public void adicionarProduto(String nome, int quantidade, double preco)
            throws ProdutoDuplicadoException, SQLException, QuantidadeMenor0Exception, PrecoMenor0Exception
    {
        if(produtoExiste(nome)) {throw new ProdutoDuplicadoException(nome);}
        if(quantidade<0) {throw new QuantidadeMenor0Exception(quantidade);}
        if(preco<0) {throw new PrecoMenor0Exception(preco);}
        ProdutoDAO.getInstance().adicionarProduto(nome, quantidade, preco);
    }
    
    //---------------------ADICIONAR PRODUTO -ATRIBUTOS EM STRING--------------
    public void adicionarProduto(String nome, String TXTquantidade, String TXTpreco)
            throws EntradaInvalidaException, ProdutoDuplicadoException, NomeVazioException, SQLException, QuantidadeMenor0Exception, PrecoMenor0Exception
    {   
        if(nome.isBlank()) {throw new NomeVazioException();}
        int quantidade = ConversorService.converterInt(TXTquantidade, "quantidade");
        double preco = ConversorService.converterDouble(TXTpreco, "preço");
        if(quantidade<0) {throw new QuantidadeMenor0Exception(quantidade);}
        if(preco<0) {throw new PrecoMenor0Exception(preco);}
        adicionarProduto(nome, quantidade, preco);
    }
    
    //--------------------LISTAR PRODUTOS------------------------------------
    public List<Produto> listarProdutos() throws SQLException
    {
        return ProdutoDAO.getInstance().listarProdutos();
    }
    
    //------------------------ATUALIZAR PRODUTO--------------------------------
    public void atualizarProduto(String TXTid, String nome, String quantidadeTexto, String precoTexto)
            throws ProdutoDuplicadoException, ProdutoNaoEncontradoException,
            PrecoMenor0Exception, QuantidadeMenor0Exception, SQLException, EntradaInvalidaException
    {
        if(TXTid.isBlank()) {throw new EntradaInvalidaException("id");}
        int id = ConversorService.converterInt(TXTid, "id");
        Produto produto = getProduto(id);
        //---------------------VERIFICAR NOME---------------------
        if(!nome.isBlank())
        {
            if(produtoExiste(nome)&& !nome.equals(produto.getNome())) {throw new ProdutoDuplicadoException(nome);}
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
        ProdutoDAO.getInstance().atualizarProduto(produto, id);
    }
    
    //----------------------------------- DELETAR PRODUTO------------------------------------------
    public void deletarProduto(Integer id) throws ProdutoNaoEncontradoException, SQLException
    {
        if(!produtoExiste(id)) {throw new ProdutoNaoEncontradoException(id);}
        ProdutoDAO.getInstance().deletarProduto(id);
    }    
}

