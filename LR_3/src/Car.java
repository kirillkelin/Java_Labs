public class Car extends Transport
{
    private Radio radio;
    public Radio getRadio()
    {
        return radio;
    }
    public void setRadio(Radio radio)
    {
        this.radio = radio;
    }
    public Car()
    {
        radio = new Radio();
    }
    public Car(String brand, int max_speed, int ID,  Radio radio)
    {
        super(brand,max_speed,ID);
        this.radio = radio;
    }
    @Override
    public boolean Move()
    {
        if (this.max_speed >= 90)
        {
            this.control = false;
        }
        else this.control = true;
        return this.control;
    }
}
