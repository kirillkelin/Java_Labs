
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;

public class Frame extends JFrame {
    // Создание Строк
    JLabel question_label = new JLabel("Введите Ваш вопрос: ");
    JLabel timer = new JLabel("Таймер: ");
    JLabel value = new JLabel("");
    JLabel answer = new JLabel("Ответ на вопрос: ");
    JLabel str = new JLabel("");
    // Создание кнопки
    JButton launch = new JButton("Запуск программы");
    private int count = 3;
    JTextField que = new JTextField(400);
    JPanel jPanel = new JPanel();
    FlowLayout f1 = new FlowLayout();
    private final int width = 600;
    private final int height = 300;


    public Frame()
    {
        Random rand = new Random();
        List text = new List();
        // Добавление ответов на вопросы в list
        text.add("Да");
        text.add("Нет");
        text.add("Наверное нет");
        text.add("Однозначно да");
        text.add("Наверное да");
        text.add("Точно нет");
        text.add("Точно да");



        jPanel.setLayout(f1);
        // Создание стартового окна
        this.setSize(this.width, this.height);
        this.setTitle("Программа \"Шар с ответами\"");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(jPanel);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds(dimension.width/2 - this.width/2,dimension.height/2 - this.height/2, this.width,this.height);
        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(null);


        // Устанавливаем координаты для надписей
        que.setBounds(200,0, 300, 30);
        str.setBounds(150,130, 300, 30);
        question_label.setBounds(0,0,200,30 );
        // Смена шрифта и его размера
        question_label.setFont(new Font("Dialog", Font.PLAIN, 18));

        launch.setBounds(0,50, 200, 30);

        value.setBounds(75,50, 100, 100);

        timer.setBounds(0,74,100,50);

        answer.setBounds(0,130, 300, 30);
        answer.setFont(new Font("Dialog", Font.PLAIN, 18));
        // Добавление надписей и кнопок на экран
        this.add(timer);
        this.add(question_label);
        this.add(launch);
        this.add(que);
        this.add(value);
        this.add(str);
        this.add(answer);

        timer.setFont(new Font("Dialog", Font.PLAIN, 18));
        this.add(timer);
        //value.setFont(new Font("Dialog", Font.PLAIN, 18));
        //value.setBounds(60,50, 100, 100);
        // Принцип работы таймера
        Timer timerT = new Timer(1000, e -> {
            if (count >= 0) {
                value.setText(String.valueOf(count--));
            } else {
                ((Timer) (e.getSource())).stop();
                count = 3;
                launch.setEnabled(true);

                value.setText("");

                int number = rand.nextInt(0,4);
                str.setText(text.getItem(number));


            }
        });
        timerT.setInitialDelay(0);
        this.setVisible(true);

        // Класс по обработке события
        class LaunchListener implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == launch) {
                    timerT.start();
                    launch.setEnabled(false);

                }
            }
        }
        // Добавление события
        launch.addActionListener(new LaunchListener());

//        que.addKeyListener(new KeyAdapter()
//        {
//            @Override
//            public void keyPressed(KeyEvent e)
//            {
//                //Pattern p = Pattern.compile("((\\W){0,}$)");
//                Pattern p = Pattern.compile("([a-zA-Z0-9]*$)");
//                String t = que.getText();
//                System.err.println(t);
//                Matcher m = p.matcher(t);
//
//                if (!m.matches()) {
//                    que.setEnabled(false);
//                    que.setText("Ошибка ввода!");
//
//
//                    que.addMouseListener(new MouseAdapter() {
//                        @Override
//                        public void mouseClicked(MouseEvent e) {
//                            super.mouseClicked(e);
//                            que.setText("");
//                            que.setEnabled(true);
//                        }
//                    });
//                }
//            }
//        });
    }






}
