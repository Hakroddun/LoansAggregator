package user.filehandeling;

import user.entities.Loans;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by gideon on 8/4/2017.
 */
public class CSVReader implements Reader
{
    private String filePath;

    @Override
    public List read()
    {
        String cvsSplitBy = ",";
        ArrayList<Loans> loansList = new ArrayList<Loans>();

        try
        {
            Scanner scanner = new Scanner(new File(filePath));
            scanner.useDelimiter(",");
            scanner.nextLine();
            while(scanner.hasNextLine())
            {
                String[] loanDetails = scanner.nextLine().split(cvsSplitBy);
                Loans loan = new Loans(loanDetails[0],loanDetails[1],loanDetails[2],loanDetails[3],Double.parseDouble(loanDetails[4]));
                loansList.add(loan);
            }
            scanner.close();

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return loansList;
    }

    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }
}
