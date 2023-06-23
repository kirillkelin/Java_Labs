import java.util.Objects;
import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите данные автомобиля(марка машины, максимальная скорость, название станции, статус работы радио(вкл/выкл):");
        String brand = in.nextLine();
        int speed = in.nextInt();
        in.nextLine();
        String station = in.nextLine();
        String status = in.nextLine();
        boolean status_of_work;
        status_of_work = Objects.equals(status, "вкл");
        Radio radio = new Radio(station,status_of_work);
        Car car1 = new Car(brand,speed,radio);
        radio.PlayTunes();
        Point_DPS dps = new Point_DPS();
        dps.Pass(car1);
        System.out.println("Введите данные грузовика(марка машины, максимальная скорость, вес, высота кузова:");
        String brand1 = in.nextLine();
        int speed1 = in.nextInt();
        in.nextLine();
        int weight1 = in.nextInt();
        int height1 = in.nextInt();
        Truck truck1 = new Truck(brand1,speed1,weight1,height1);
        Point_DPS dps1 = new Point_DPS();
        dps1.Pass(truck1);
    }
}