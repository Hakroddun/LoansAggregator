package user.filehandeling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by gideon on 8/4/2017.
 */
public class CSVWriter implements Writer
{
    private String filePath;

    @Override
    public void write(String DataToWrite)
    {
        try
        {
            File outputFile = new File(filePath);
            if (!outputFile.exists())
            {
                PrintWriter writer = new PrintWriter(outputFile);
                writer.write(DataToWrite);
                writer.flush();
                writer.close();
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }
}
