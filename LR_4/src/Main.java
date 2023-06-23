import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Main
{

    public static void main(String[] args) throws Exception
    {

//        Handler file = new FileHandler("logger.txt");
//        Log.logger.addHandler(file);
//
//        Properties prop = new Properties();
//        Preloader preloader = new Preloader("settings.ini", prop);
//
//        ModelTruck model = new ModelTruck();
//        View view = new View();
//        ControllerTruck controller = new ControllerTruck(model, view, prop);

//        controller.StartProgram("settings.ini");
//        for(int i = 0; i < 100; i ++) {
//            int ID = (int) (Math.random() * ((1000000) + 1));
//            System.out.println(ID);
//        }
        FileArrayList.SaveToFile("file10", false,10, Transport.creating_arraylist());
        FileArrayList.SaveToFile("file100", false,100, Transport.creating_arraylist());
        FileArrayList.SaveToFile("file1000", false,1000, Transport.creating_arraylist());
        FileArrayList.SaveToFile("file10000", false,10000, Transport.creating_arraylist());
        FileArrayList.SaveToFile("file100000", false,100000, Transport.creating_arraylist());

        FileLinkedList.SaveToFile("Linked10", false, 10, Transport.creating_linkedlist());
        FileLinkedList.SaveToFile("Linked100", false, 100, Transport.creating_linkedlist());
        FileLinkedList.SaveToFile("Linked1000", false, 1000, Transport.creating_linkedlist());
        FileLinkedList.SaveToFile("Linked10000", false, 10000, Transport.creating_linkedlist());
        FileLinkedList.SaveToFile("Linked100000", false, 100000, Transport.creating_linkedlist());
    }
}
