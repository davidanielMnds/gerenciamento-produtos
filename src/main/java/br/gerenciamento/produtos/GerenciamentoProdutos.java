package br.gerenciamento.produtos;

import javax.swing.SwingUtilities;
import ui.MainFrame;
import util.UIConfig;

public class GerenciamentoProdutos {

    public static void main(String[] args) {
        UIConfig.setup();
        SwingUtilities.invokeLater(() ->
        {
            new MainFrame().setVisible(true);
        });
    }
}
