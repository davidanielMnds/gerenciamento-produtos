package util;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMTGitHubDarkIJTheme;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import javax.swing.UIManager;

public class UIConfig {
    public static void setup() {
        FlatMTGitHubDarkIJTheme.setup();
        try {
            Font fonte = Font.createFont(
                Font.TRUETYPE_FONT,
                UIConfig.class.getResourceAsStream("/JetBrainsMono-Regular.ttf")
            ).deriveFont(Font.PLAIN, 13f);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(fonte);
            UIManager.getLookAndFeelDefaults().put("defaultFont", fonte);
        } catch (FontFormatException | IOException e) {
        }
    }
}