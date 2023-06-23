import javax.swing.*;
import java.awt.*;
// Класс для создания фрейма
public class Frame extends JFrame
{
    private final int width = 900;
    private final int height = 600;
    public Frame()
    {
        Logic game = new Logic();
        this.add(game);
        // Создание панели
        this.setSize(this.width, this.height);
        this.setTitle("Игра Теннис");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.BLACK);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds(dimension.width/2 - this.width/2,dimension.height/2 - this.height/2, this.width,this.height);
        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(null);

    }
}
