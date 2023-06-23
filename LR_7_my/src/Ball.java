import java.awt.*;
// Класс, создающий мячик
public class Ball extends Rectangle implements Runnable
{

    public int x_offset = 4; // Смещение шарика по оси x
    public int y_offset = 4; // Смещение шарика по оси y

    public Ball(int x, int y, int width, int height)
    {
        super(x,y,width,height);
    }
    // Рисуем мячик
    public void paint(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillOval(x,y,width,height);
    }

    @Override
    public void run() {

    }
}
