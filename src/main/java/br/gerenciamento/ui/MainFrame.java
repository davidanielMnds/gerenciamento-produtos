package br.gerenciamento.ui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    //------------------------VARIAVEIS-----------------------------------
    private final CardLayout cardLayout = new CardLayout();
    private final JPanel painelConteudo = new JPanel(cardLayout);
    private boolean sideBarExpandida = false;
    private JPanel sideBar;
    private final FormProdutos formProdutos = new FormProdutos();
    private JButton btnProdutos;
    private JButton btnAdicionar;
    private final ImageIcon iconProdutos = new ImageIcon(MainFrame.class.getResource("/icons/listar.png"));
    private final ImageIcon iconAdicionar = new ImageIcon(MainFrame.class.getResource("/icons/adicionar.png"));
    
    
    public MainFrame()
    {
        //------------------------CONFIGURAÇÕES JFRAME--------------------
        setTitle("Gerenciamento de Produtos");
        setSize(900, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        //-------------------------PANELS PRINCIPAIS----------------------
        add(criarSideBar(), BorderLayout.WEST);
        add(painelConteudo, BorderLayout.CENTER);
        painelConteudo.add(formProdutos, "produtos");
        painelConteudo.add(new FormAdicionar(), "adicionar");
        
        cardLayout.show(painelConteudo, "produtos");
        
    }
    
    //--------------------------PANEL SIDE BAR--------------------------------------------
    private JPanel criarSideBar()
    {
        //-----------DEFININDO JANELA------------------
        sideBar = new JPanel();
        sideBar.setLayout(new BoxLayout(sideBar, BoxLayout.Y_AXIS));
        sideBar.setPreferredSize(new Dimension(50, 0));
        
        //-----------ICONE DO MENU----------------------
        ImageIcon iconMenu = new ImageIcon(MainFrame.class.getResource("/icons/menu.png"));
        //-----------CRIANDO BOTOES E ADICIOANNDO-------
        JButton btnMenu = new JButton(iconMenu);
        btnProdutos = new JButton();
        btnProdutos.setIcon(iconProdutos);
        btnAdicionar = new JButton();
        btnAdicionar.setIcon(iconAdicionar);
        
        sideBar.add(btnMenu);
        sideBar.add(btnProdutos);
        sideBar.add(btnAdicionar);
        
        //------------AÇÕES DOS BOTOES------------------
        btnMenu.addActionListener(e -> mudarSideBar());
        btnProdutos.addActionListener(e-> cardLayout.show(painelConteudo, "produtos"));
        btnAdicionar.addActionListener(e-> cardLayout.show(painelConteudo, "adicionar"));
        
        return sideBar;
    }
    
    //--------------------------METODO MUDAR SIDE-BAR--------------------------------------
    public void mudarSideBar()
    {   
        //---------------------RECOLHIDA-----------------
        if(sideBarExpandida==true)
        {
            sideBar.setPreferredSize(new Dimension(50, 0));
            btnProdutos.setIcon(iconProdutos);
            btnProdutos.setText("");
            btnAdicionar.setIcon(iconAdicionar);
            btnAdicionar.setText("");
        }
        //----------------------EXPANDIDA----------------
        else
       {
           sideBar.setPreferredSize(new Dimension(160, 0));
           btnProdutos.setText("Produtos");
           btnAdicionar.setText("Adicionar");
       }
        sideBarExpandida = !sideBarExpandida;
        revalidate();
        repaint();
    }
    
}
