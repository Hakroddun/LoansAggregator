package user.entities;

/**
 * Created by gideon on 8/3/2017.
 */
public class Loans
{
    private String MSISDN;
    private String Network;
    private String Date;
    private String Product;
    private double Amount;
    private int Count;

    public Loans(String msisdn, String network, String date, String product, double amount)
    {
        this.Date = date;
        this.Amount = amount;
        this.MSISDN = msisdn;
        this.Product = product;
        this.Network = network;
        this.Count = 1;
    }

    public Loans(String msisdn, String network, String date, String product, double amount, int count)
    {
        this.Date = date;
        this.Amount = amount;
        this.MSISDN = msisdn;
        this.Product = product;
        this.Network = network;
        this.Count = count;
    }

    @Override
    public String toString() {
        return String.format("Loans(%s,%s,%s,%s,%s,%s)",MSISDN,Network,Date,Product,Amount,Count);
    }

    public String getMSISDN()
    {
        return MSISDN;
    }

    public String getNetwork()
    {
        return Network;
    }

    public String getDate()
    {
        return Date;
    }

    public String getProduct()
    {
        return Product;
    }

    public double getAmount()
    {
        return Amount;
    }

    public int getCount()
    {
        return Count;
    }

    public void setMSISDN(String MSISDN)
    {
        this.MSISDN = MSISDN;
    }

    public void setNetwork(String network)
    {
        Network = network;
    }

    public void setDate(String date)
    {
        Date = date;
    }

    public void setProduct(String product)
    {
        Product = product;
    }

    public void setAmount(double amount)
    {
        Amount = amount;
    }

    public void setCount(int count)
    {
        Count = count;
    }
}
