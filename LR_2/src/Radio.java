import java.util.Scanner;
public class Radio
{
    private String station;
    private boolean status_of_work;
    public String getStation()
    {
        return station;
    }
    public void setStation(String station)
    {
        this.station = station;
    }
    public boolean getStatus_of_work()
    {
        return status_of_work;
    }
    public void setStatus_of_work(boolean status_of_work)
    {
        this.status_of_work = status_of_work;
    }
    public Radio()
    {
        station = "Europa plus";
        status_of_work = false;
    }
    public Radio(String station, boolean status_of_work)
    {
        this.station = station;
        this.status_of_work = status_of_work;
    }
    public void PlayTunes()
    {
        int a;
        if (!this.status_of_work)
        {
            System.out.println("Радио выключено! Если хотите включить радио введите: 1 ");
            Scanner scan = new Scanner(System.in);
            a = scan.nextInt();
            if (a == 1)
            {
                this.status_of_work = true;
            }
        }
    }
}
