import java.io.*;
import java.util.Objects;
import java.util.Properties;
import java.util.Scanner;

public class ControllerTruck
{
    public ModelTruck model;
    public View view;
    public Properties prop;
    public ControllerTruck(ModelTruck model, View view, Properties prop)
    {
        this.model = model;
        this.view = view;
        this.prop = prop;
    }
    public static int inputInt()
    {
        Scanner sc = new Scanner(System.in);
        int i;
        while (true) {
            try {
                i = Integer.parseInt(sc.next());
                if(i <= 0)
                {
                    System.out.println("Введите целое положительное число: ");
                    Log.logger.warning("Был некорректный ввод.");
                }
                else {break;}
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите целое число: ");
                Log.logger.warning("Был некорректный ввод.");
            }
        }
        return i;
    }
    public static String inputStr()
    {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    public Truck Add(ModelTruck model)
    {
        this.view.view("Введите марку грузовика: ");
        String brand = inputStr();
        this.view.view("Введите номер грузовика:");
        int number = inputInt();
        this.view.view("Введите скорость грузовика: ");
        int max_speed = inputInt();
        this.view.view("Введите вес грузовика: ");
        int weight = inputInt();
        this.view.view("Введите высоту грузовика: ");
        int height = inputInt();

        Truck truck = new Truck(brand, max_speed, number, weight, height);
        model.trucks.add(truck);

        return truck;
    }

    public void Delete(ModelTruck model) throws IOException {
        this.view.view("Введите номер грузовика: ");
        int number = inputInt();
        this.model.trucks.removeIf(truck -> number == truck.getID());
        this.SaveToFile("java.txt", false);
    }
    public void StartProgram(String file) throws IOException {
        FileInputStream fis;
        this.prop = new Properties();

        try
        {
            fis = new FileInputStream("settings.ini");
            prop.load(fis);

            String login = prop.getProperty("login");

            String password = prop.getProperty("password");
            while (true)
            {
                this.view.view("Введите пароль:");
                String pass = inputStr();
                if (Objects.equals(pass, password))
                {
                    this.view.view("Добро пожаловать, " + login + "!");
                    Log.logger.info("Программа была запущена");
                    Menu();
                    break;
                }
                else
                {
                    this.view.view("Пароль неверный!");
                    Log.logger.info("Программа не запущена");
                }


            }
        }
            catch (IOException e) {
                System.err.println("ОШИБКА: Файл свойств отсуствует!");
            } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void SearchID(String id)
    {
        File file = new File("java.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            int sum = 0;

            while ((line = br.readLine()) != null)
            {
                int index = line.indexOf(id); // Поиск слова в строке
                if(index != -1)
                {
                    System.out.println(line);
                    sum += 1;
                }

            }
            if (sum == 0) {System.out.println("В базе нет автомобился с таким номером!");}

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Reading()
    {
        File file = new File("java.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void SaveToFile(String FileName, boolean Update) throws java.io.IOException
    {
        boolean Result = false;
        FileWriter dataOut = null;
        try {
            dataOut = new FileWriter(FileName, Update);
            for (Truck truck : this.model.trucks)
            {
                dataOut.append(truck.toString()).append("\n");
            }
            Result = true;
        } catch (IOException exc) {
            System.err.println(exc.getMessage());
        } finally {
            assert dataOut != null;
            dataOut.close();
        }
    }
    public void Menu() throws Exception
    {
        int p = 1;
        while(p == 1) {
            String a = inputStr();
            while (a != "0")
            {
                int menu;
                this.view.PrintMenu();
                menu = inputInt();
                if (menu == 7) {
                    this.view.view("Вы завершили выполнение программы.");
                    Log.logger.info("Программа была завершена.");
                    p = 0;
                    break;
                }
                switch (menu) {
                    case 1:
                        this.Add(this.model);
                        Log.logger.info("Автомобиль был добавлен в программу.");
                        break;
                    case 2:
                        if (this.model.trucks.size() == 0) {
                            this.view.view("В программе нет ни одного грузовика!");
                            Log.logger.info("Была неудачная попытка удалить автомобиль из программы.");
                            break;
                        }
                        this.Delete(model);
                        Log.logger.info("Автомобиль был удален из программы");
                        break;
                    case 3:
                        if (this.model.trucks.size() == 0) {
                            this.view.view("В программе нет ни одного грузовика!");
                            Log.logger.info("Была неудачная попытка перезаписать файл.");
                            break;
                        }
                        this.SaveToFile("java.txt", false);
                        Log.logger.info("Файл был перезаписан. Объекты добавлены в файл.");
                        break;
                    case 4:
                        if (this.model.trucks.size() == 0) {
                            this.view.view("В программе нет ни одного автомобиля!");
                            Log.logger.info("Была неудачная попытка дозаписать файл.");
                            break;
                        }
                        this.SaveToFile("java.txt", true);
                        Log.logger.info("Файл был дозаписан. Объекты добавлены в файл.");
                        break;
                    case 5:
                        this.view.view("Введите номер грузовика, который хотите вывести:");
                        int number = inputInt();
                        this.SearchID(Integer.toString(number));
                        break;
                    case 6:
                        this.Reading();
                        Log.logger.info("Произошло чтение из файла.");
                        break;
                    default:
                        this.view.view("Попробуйте ввести значение снова: ");
                        break;
                }
                break;
            }
        }
    }

}
