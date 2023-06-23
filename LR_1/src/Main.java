import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число: ");
        int number = scan.nextInt();
        int temp = number;
        int sum = 0;
        while(number > 0)
        {
            int x;
            x = number % 10;
            sum = sum * 10 + x;
            number = number / 10;
        }
        if (temp == sum)
        {
            System.out.println("Число " + temp + " палиндром!" );
            int number_2 = temp * temp;
            int temp_2 = number_2;
            int sum_2 = 0;
            while(number_2 > 0)
            {
                int x;
                x = number_2 % 10;
                sum_2 = sum_2 * 10 + x;
                number_2 = number_2 / 10;
            }
            if (temp_2 == sum_2) {System.out.print("Квадрат числа " + temp + " палиндром!" );}
            else {System.out.println("Квадрат числа " + temp + " не палиндром!" );}
        }
        else {System.out.print("Число " + temp + " не палиндром!" );}

    }
}