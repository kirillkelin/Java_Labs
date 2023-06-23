import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Component extends JComponent
{
    public void paintComponent(Graphics g)
    {
        JPanel jPanel = new JPanel();
//        frame.add()
        Font font = new Font("Bitstream Charter", Font.BOLD, 20);
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(font);
        g2.drawString("Введите Ваш вопрос: ", 20, 30);
        Rectangle2D r2 = new Rectangle2D.Double(20, 50, 600,40);
//        g2.draw(r2);
        g2.setPaint(Color.white);
        g2.fill(r2);

//        JPanel jPanel = new JPanel();
//        this.add(jPanel);
//        jPanel.add(new JButton("Запуск программы"));

    }
}
