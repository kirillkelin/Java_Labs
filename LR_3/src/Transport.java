public class Transport
{
    protected String brand;
    protected int max_speed;
    protected int ID;
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
    public void setID(int ID) {this.ID = ID;}
    public int getID()
    {
        return ID;
    }

    public Transport()
    {
        this.brand = "Мерседес";
        this.max_speed = 70;
        this.control = false;
        this.ID = 228322;
    }
    public Transport(String brand, int max_speed, int ID)
    {
        this.brand = brand;
        this.max_speed = max_speed;
        this.ID = ID;
    }
    public boolean Move()
    {
        return true;
    }
}
