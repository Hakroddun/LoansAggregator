package user.usecases;

import user.filehandeling.CSVReader;
import user.filehandeling.CSVWriter;

/**
 * Created by gideon on 8/4/2017.
 */
public class CreateValidationCSV
{
    public static void main(String[] args)
    {
        TupleGeneratorImpl tupleGenerator = CreateTupleGenerator();
        CSVReader reader = createCSVReader();
        CSVWriter writer = createCSVWriter();
        LoansDataFormatter formatter = new LoansDataFormatter();
        AggregateInteractorImpl aggregateInteractor = new AggregateInteractorImpl(tupleGenerator, reader, writer, formatter);
        aggregateInteractor.Aggregate();
    }

    private static TupleGeneratorImpl CreateTupleGenerator()
    {
        GroupingKeyGeneratorImpl groupingKeyGenerator = new GroupingKeyGeneratorImpl();
        TupleGeneratorImpl tupleGenerator = new TupleGeneratorImpl();
        tupleGenerator.setGroupingKeyGenerator(groupingKeyGenerator);
        return tupleGenerator;
    }

    private static CSVWriter createCSVWriter()
    {
        CSVWriter writer = new CSVWriter();
        writer.setFilePath("D:/Output.csv");
        return writer;
    }

    private static CSVReader createCSVReader()
    {
        CSVReader reader = new CSVReader();
        reader.setFilePath("D:/Loans.csv");
        return reader;
    }
}
