package user.usecases;

import user.entities.Loans;

import java.util.List;

/**
 * Created by gideon on 8/3/2017.
 */
public interface TupleGenerator
{
    List Group(List<Loans> originalList);
}
