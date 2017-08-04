package user.usecases;

import java.util.List;

/**
 * Created by gideon on 8/4/2017.
 */
public class LoansDataFormatter implements DataFormatter
{
    @Override
    public String Format(String data)
    {
        String formattedData = data;
        formattedData = formattedData.replace("Loans(","");
        formattedData = formattedData.replace("),",",\n");
        formattedData = formattedData.replace("[","");
        formattedData = formattedData.replace(")]","");
        return formattedData;
    }
}
