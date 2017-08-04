package user.usecases;

import user.entities.Loans;

/**
 * Created by gideon on 8/3/2017.
 */
public class OneGroupingKeyGeneratorStub implements GroupingKeyGenerator
{
    @Override
    public String getGroupingKey(Loans loans)
    {
        return loans.getNetwork();
    }
}
