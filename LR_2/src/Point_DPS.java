public class Point_DPS
{

    public void Pass(Car car)
    {
        if (car.Move())
        {
            System.out.println("Транспорт пройдет контроль");
        }
        else System.out.println("Транспорт не пройдет контроль");
    }
    public void Pass (Truck truck)
    {
        if (truck.Move())
        {
            System.out.println("Транспорт пройдет контроль");
        }
        else System.out.println("Транспорт не пройдет контроль");
    }
}
