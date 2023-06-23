import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
// Класс, обрабатывающий логику игры
public class Logic extends JPanel implements ActionListener, KeyListener, Runnable
{
    Image image;
    Graphics graphics;
    Racket racket1;
    Racket racket2;
    Ball ball;
    Thread Racket1Thread; // поле потока первой ракетки
    Thread Racket2Thread; // поле потока второй ракетки
    int score1 = 0;
    int score2 = 0;
    static final int totalScore = 2;
        private Timer time;


// Консруктор для класса
    public Logic()
    {
        // KeyListener будет перерисовывать экран
        addKeyListener(this);
        Start_game();

        time = new Timer(10, this); // создаем таймер
        this.setFocusable(true); // связь окошка с клавишами
        time.start(); // возможность использования клавишей
    }
    // Метод для начала игры
    public void Start_game()
    {
        racket1 = new Racket(0, 220, 10, 100, 1);
        racket2 = new Racket(872, 220, 10, 100, 2);
        Racket1Thread = new Thread((Runnable) racket1); // Создаем поток первой ракетки
        Racket2Thread = new Thread((Runnable) racket2); // Создаем поток второй ракетки
        Racket1Thread.start();
        Racket2Thread.start();
        ball = new Ball(440, 270, 20, 20);
    }
    // Метод для рисования объектов
    public void paint(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,900,600);
        racket1.paint(g);
        racket2.paint(g);
        ball.paint(g);
        g.drawLine(450, 0, 450, 600);
        Font f = new Font("Arial", Font.BOLD, 40);
        g.setFont(f);
        g.drawString(String.valueOf(score1), 400, 40);
        g.drawString(String.valueOf(score2), 478, 40);
        Font f1 = new Font("Arial", Font.BOLD, 20);
        g.setFont(f1);
        if(score1 == totalScore)
        {
            g.drawString("Победил игрок 1!", 50,170);
            g.drawString("Нажмите Enter, чтобы начать заново", 50, 250);
            time.stop();
            restart();
        }
        if(score2 == totalScore)
        {
            g.drawString("Победил игрок 2!", 500,170);
            g.drawString("Нажмите Enter, чтобы начать заново", 500, 250);
            time.stop();
            restart();
        }
    }
    // Метод для рестарта игры
    public void restart() {
        score1 = 0;
        score2 = 0;
        Start_game();

    }

    // Обработка(логика) полета мяча
    @Override
    public void actionPerformed(ActionEvent e)
    {
        repaint();
        ball.x += ball.x_offset; // Перемещение мячика по оси x
        ball.y += ball.y_offset; // Перемещение мячика по оси y
        // При встерче со стеной меняем напрвление на противоположное
        if (ball.y < 0)
            ball.y_offset = -ball.y_offset;
        if (ball.y > 535)
            ball.y_offset = -ball.y_offset;
        // Логика отскока мяча от ракетки(если есть пересечение двух прямоугольников)
        if (new Rectangle(ball.x, ball.y, 10, 10).intersects(new Rectangle(872, racket2.y, 10, 100))) {
            ball.x_offset= -ball.x_offset;
        }
        if (new Rectangle(ball.x, ball.y, 10, 10).intersects(new Rectangle(0, racket1.y, 10, 100))) {
            ball.x_offset = -ball.x_offset;
        }
        if (ball.x < -20) {
            score2++;
            time.stop();
            ball.x = 440;
            ball.y = 270;
            racket1.x = 0;
            racket1.y = 220;
            racket2.x = 872;
            racket2.y = 220;
        }
        if (ball.x > 920) {
            score1++;
            time.stop();
            ball.x = 440;
            ball.y = 270;
            racket1.x = 0;
            racket1.y = 220;
            racket2.x = 872;
            racket2.y = 220;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    // Логика для перемещения ракеток по клавишам
    @Override
    public void keyPressed(KeyEvent e)
    {
        // Перемещение левой ракетки
        if ((e.getKeyCode() == KeyEvent.VK_W)) {
            racket1.y -= 10;
            if (racket1.y < 0)
                racket1.y = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            racket1.y += 10;
            if (racket1.y >= 460)// Ограничение снизу
                racket1.y = 460;
        }
        // Перемещение правой ракетки
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            racket2.y += 10;
            if (racket2.y >= 460)// Ограничение снизу
                racket2.y = 460;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            racket2.y -= 10;
            if (racket2.y < 0)
                racket2.y = 0;
        }
    }
    // Кнопка для рестарта игры
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            time.start();
        }
    }

    @Override
    public void run()
    {
        if (score1 == totalScore)
        {
            int answer = JOptionPane.showConfirmDialog(null, "Winner - Player 1!!!\n" +
                    "Restart?", "Finish", JOptionPane.YES_NO_OPTION);
            if (answer == 0) {
                restart();
                run();
            } else
                System.exit(0);
        }

        if (score2 == totalScore) {
            int answer = JOptionPane.showConfirmDialog(null, "Winner - Player 2!!!\n" +
                    "Restart?", "Finish", JOptionPane.YES_NO_OPTION);
            if (answer == 0) {
                restart();
                run();
            }
            else
                System.exit(0);
        }
    }
}
