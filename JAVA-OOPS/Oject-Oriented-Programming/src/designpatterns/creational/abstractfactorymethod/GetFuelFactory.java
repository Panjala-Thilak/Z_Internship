package abstractfactorymethod;

class GetFuelFactory
{
    public Fuel getFuel(String fuelType)
    {
        if(fuelType==null)
            return null;
        if (fuelType.equalsIgnoreCase("petrol"))
        {
            return new Petrol();
        }
        else if(fuelType.equalsIgnoreCase("diesel"))
        {
            return new Diesel();
        }

        return null;
    }
}
