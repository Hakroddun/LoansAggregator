package user.usecases;

import java.util.List;

/**
 * Created by gideon on 8/4/2017.
 */
public class LoansDataFormatter implements DataFormatter
{
    @Override
    public String Format(List data)
    {
        String formattedData;
        formattedData = data.toString();
        return formattedData;
    }
}
