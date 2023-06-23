public class Truck extends Transport
{
    private int weight;
    private int height;
    public int getWeight()
    {
        return weight;
    }
    public void setWeight(int weight)
    {
        this.weight = weight;
    }
    public int getHeight()
    {
        return height;
    }
    public void setHeight(int height)
    {
        this.height = height;
    }
    public Truck()
    {
        this.weight = 1000;
        this.height = 7;
    }
    public Truck(String brand, int max_speed, int weight, int height)
    {
        super(brand,max_speed);
        this.height = height;
        this.weight = weight;
    }
    @Override
    public boolean Move()
    {
        if ((this.max_speed >= 90)||(this.weight >= 10000) || (this.height >= 5))
        {
            this.control = false;
        }
        else this.control = true;
        return this.control;
    }
}