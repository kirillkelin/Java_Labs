import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame{
    private int width = 1920;
    private int height = 1080;

    public Frame()
    {
        this.setSize(this.width, this.width);
        this.setTitle("Graphics");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        Component component = new Component();
        this.add(component);
    }

}
