import java.util.Objects;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;



public class Main
{

    public static void main(String[] args) throws Exception
    {

        Handler file = new FileHandler("logger.txt");
        Log.logger.addHandler(file);

        Properties prop = new Properties();
        Preloader preloader = new Preloader("settings.ini", prop);

        ModelTruck model = new ModelTruck();
        View view = new View();
        ControllerTruck controller = new ControllerTruck(model, view, prop);

        controller.StartProgram("settings.ini");

    }
}
