package user.usecases;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import user.entities.Loans;
import user.filehandeling.CSVReader;
import user.filehandeling.CSVWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by gideon on 8/3/2017.
 */
@RunWith(HierarchicalContextRunner.class)
public class AggregateInteractorTest
{
    List<Loans> initialList;
    List<Loans> expectedList;
    TupleGeneratorImpl tupleGenerator;
    @Before
    public void setupAggregateInteractor()
    {
        tupleGenerator = new TupleGeneratorImpl();
    }

    public class OneColumnAggregation
    {
        @Before
        public void setupAggregateData()
        {
            initialList = Arrays.asList(
                    new Loans("27729554427", "'Network 1'", "'12-Mar-2016'", "'Loan Product 1'", 1000.00),
                    new Loans("27722342551", "'Network 2'", "'16-Mar-2016'", "'Loan Product 1'", 1122.00),
                    new Loans("27725544272", "'Network 3'", "'17-Mar-2016'", "'Loan Product 2'", 2084.00),
                    new Loans("27725326345", "'Network 3'", "'18-Mar-2016'", "'Loan Product 2'", 3098.00),
                    new Loans("27729234533", "'Network 2'", "'01-Apr-2016'", "'Loan Product 1'", 5671.00),
                    new Loans("27723453455", "'Network 3'", "'12-Apr-2016'", "'Loan Product 3'", 1928.00),
                    new Loans("27725678534", "'Network 2'", "'15-Apr-2016'", "'Loan Product 3'", 1747.00),
                    new Loans("27729554427", "'Network 1'", "'16-Apr-2016'", "'Loan Product 2'", 1801.00));

            expectedList = Arrays.asList(
                    new Loans("27722342551","'Network 2'","'16-Mar-2016'","'Loan Product 1'",8540.0,3),
                    new Loans("27729554427","'Network 1'","'12-Mar-2016'","'Loan Product 1'",2801.0,2),
                    new Loans("27725544272","'Network 3'","'17-Mar-2016'","'Loan Product 2'",7110.0,3));
        }
        @Test
        public void Aggregate()
        {
            OneGroupingKeyGeneratorStub keyGenerator = new OneGroupingKeyGeneratorStub();
            tupleGenerator.setGroupingKeyGenerator(keyGenerator);

            Assert.assertEquals(tupleGenerator.Group(initialList).toString(), expectedList.toString());
        }
    }

    public class ThreeColumnAggregation
    {
        @Before
        public void setupAggregateData()
        {
            initialList = Arrays.asList(
                    new Loans("27729554427", "'Network 1'", "'12-Mar-2016'", "'Loan Product 1'", 1000.00),
                    new Loans("27722342551", "'Network 2'", "'16-Mar-2016'", "'Loan Product 1'", 1122.00),
                    new Loans("27725544272", "'Network 3'", "'17-Mar-2016'", "'Loan Product 2'", 2084.00),
                    new Loans("27725326345", "'Network 3'", "'18-Mar-2016'", "'Loan Product 2'", 3098.00),
                    new Loans("27729234533", "'Network 2'", "'01-Apr-2016'", "'Loan Product 1'", 5671.00),
                    new Loans("27723453455", "'Network 3'", "'12-Apr-2016'", "'Loan Product 3'", 1928.00),
                    new Loans("27725678534", "'Network 2'", "'15-Apr-2016'", "'Loan Product 3'", 1747.00),
                    new Loans("27729554427", "'Network 1'", "'16-Apr-2016'", "'Loan Product 2'", 1801.00));

            expectedList = Arrays.asList(
                    new Loans("27722342551","'Network 2'","'16-Mar-2016'","'Loan Product 1'",1122.0,1),
                    new Loans("27729234533","'Network 2'","'01-Apr-2016'","'Loan Product 1'",5671.0,1),
                    new Loans("27725678534","'Network 2'","'15-Apr-2016'","'Loan Product 3'",1747.0,1),
                    new Loans("27723453455","'Network 3'","'12-Apr-2016'","'Loan Product 3'",1928.0,1),
                    new Loans("27725544272","'Network 3'","'17-Mar-2016'","'Loan Product 2'",5182.0,2),
                    new Loans("27729554427","'Network 1'","'12-Mar-2016'","'Loan Product 1'",1000.0,1),
                    new Loans("27729554427","'Network 1'","'16-Apr-2016'","'Loan Product 2'",1801.0,1));
        }
        @Test
        public void Aggregate()
        {
            GroupingKeyGeneratorImpl keyGenerator = new GroupingKeyGeneratorImpl();
            tupleGenerator.setGroupingKeyGenerator(keyGenerator);

            Assert.assertEquals(tupleGenerator.Group(initialList).toString(), expectedList.toString());
        }
    }

    public class FileReadingTest
    {
        @Before
        public void setupCSVData()
        {
            expectedList = Arrays.asList(
                    new Loans("27729554427", "'Network 1'", "'12-Mar-2016'", "'Loan Product 1'", 1000.00),
                    new Loans("27722342551", "'Network 2'", "'16-Mar-2016'", "'Loan Product 1'", 1122.00),
                    new Loans("27725544272", "'Network 3'", "'17-Mar-2016'", "'Loan Product 2'", 2084.00),
                    new Loans("27725326345", "'Network 3'", "'18-Mar-2016'", "'Loan Product 2'", 3098.00),
                    new Loans("27729234533", "'Network 2'", "'01-Apr-2016'", "'Loan Product 1'", 5671.00),
                    new Loans("27723453455", "'Network 3'", "'12-Apr-2016'", "'Loan Product 3'", 1928.00),
                    new Loans("27725678534", "'Network 2'", "'15-Apr-2016'", "'Loan Product 3'", 1747.00),
                    new Loans("27729554427", "'Network 1'", "'16-Apr-2016'", "'Loan Product 2'", 1801.00));
        }
        @Test
        public void readFile()
        {
            CSVReader reader = new CSVReader();
            reader.setFilePath("F:/loans.csv");
            initialList = reader.read();
            Assert.assertEquals(initialList.toString(), expectedList.toString());

        }
    }

    public class FileWritingTest
    {
        @Before
        public void setupCSVData()
        {
            initialList= Arrays.asList(
                    new Loans("27729554427", "'Network 1'", "'12-Mar-2016'", "'Loan Product 1'", 1000.00),
                    new Loans("27722342551", "'Network 2'", "'16-Mar-2016'", "'Loan Product 1'", 1122.00),
                    new Loans("27725544272", "'Network 3'", "'17-Mar-2016'", "'Loan Product 2'", 2084.00),
                    new Loans("27725326345", "'Network 3'", "'18-Mar-2016'", "'Loan Product 2'", 3098.00),
                    new Loans("27729234533", "'Network 2'", "'01-Apr-2016'", "'Loan Product 1'", 5671.00),
                    new Loans("27723453455", "'Network 3'", "'12-Apr-2016'", "'Loan Product 3'", 1928.00),
                    new Loans("27725678534", "'Network 2'", "'15-Apr-2016'", "'Loan Product 3'", 1747.00),
                    new Loans("27729554427", "'Network 1'", "'16-Apr-2016'", "'Loan Product 2'", 1801.00));
        }
        @Test
        public void readFile()
        {
            String filePath = "F:/test.csv";
            CSVWriter writer = new CSVWriter();
            writer.setFilePath(filePath);
            writer.write(initialList.toString());
            String expectedData = retrieveCSVData(filePath);
            Assert.assertEquals(initialList.toString(),expectedData.toString());
        }

        private String retrieveCSVData(String filePath)
        {
            String expectedData = "";
            try
            {
                Scanner scanner = new Scanner(new File(filePath));
                expectedData = scanner.nextLine();
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            return expectedData;
        }
    }
}
