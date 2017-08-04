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
        AggregateInteractorImpl aggregateInteractor = setInteractorModules(tupleGenerator, formatter, reader, writer);
        aggregateInteractor.Aggregate();
    }

    private static AggregateInteractorImpl setInteractorModules(TupleGeneratorImpl tupleGenerator, LoansDataFormatter formatter, CSVReader reader, CSVWriter writer)
    {
        AggregateInteractorImpl aggregateInteractor = new AggregateInteractorImpl();
        aggregateInteractor.setTupleGenerator(tupleGenerator);
        aggregateInteractor.setFormatter(formatter);
        aggregateInteractor.setReader(reader);
        aggregateInteractor.setWriter(writer);
        return aggregateInteractor;
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
        writer.setFilePath("F:/Test.csv");
        return writer;
    }

    private static CSVReader createCSVReader()
    {
        CSVReader reader = new CSVReader();
        reader.setFilePath("F:/Loans.csv");
        return reader;
    }
}
