public class Transport
{
    protected String brand;
    protected int max_speed;
    protected boolean control;
    public String getBrand()
    {
        return brand;
    }
    public void setBrand(String brand)
    {
        this.brand = brand;
    }
    public int getMax_speed()
    {
        return max_speed;
    }
    public void setMax_speed(int max_speed)
    {
        this.max_speed = max_speed;
    }
    public boolean getControl()
    {
        return control;
    }
    public void setControl(boolean control)
    {
        this.control = control;
    }
    public Transport()
    {
        this.brand = "Мерседес";
        this.max_speed = 70;
        this.control = false;
    }
    public Transport(String brand, int max_speed)
    {
        this.brand = brand;
        this.max_speed = max_speed;
    }
    public boolean Move()
    {
        return true;
    }
}