package user.usecases;

import user.filehandeling.Reader;
import user.filehandeling.Writer;

import java.util.*;

/**
 * Created by gideon on 8/3/2017.
 */
public class AggregateInteractorImpl implements AggregateInteractor
{
    private TupleGenerator tupleGenerator;
    private Reader reader;
    private Writer writer;
    private DataFormatter formatter;

    public void setTupleGenerator(TupleGenerator tupleGenerator)
    {
        this.tupleGenerator = tupleGenerator;
    }

    public void setReader(Reader reader)
    {
        this.reader = reader;
    }

    public void setWriter(Writer writer)
    {
        this.writer = writer;
    }

    public void setFormatter(DataFormatter formatter)
    {
        this.formatter = formatter;
    }

    public AggregateInteractorImpl(TupleGenerator tupleGenerator, Reader reader, Writer writer, DataFormatter formatter)
    {
        this.tupleGenerator = tupleGenerator;
        this.reader = reader;
        this.writer = writer;
        this.formatter = formatter;
    }

    @Override
    public void Aggregate()
    {
        List list = reader.read();
        list = tupleGenerator.Group(list);
        String formattedData = formatter.Format(list.toString());
        writer.write(formattedData);
    }
}
