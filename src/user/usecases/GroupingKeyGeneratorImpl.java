package user.usecases;

import user.entities.Loans;

public class GroupingKeyGeneratorImpl implements GroupingKeyGenerator
{
    public String getGroupingKey(Loans loans)
    {
        return loans.getNetwork() + loans.getDate().substring(3, 6) + loans.getProduct();
    }
}