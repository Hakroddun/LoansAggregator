package user.usecases;

import user.entities.Loans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TupleGeneratorImpl implements TupleGenerator
{
    private GroupingKeyGenerator Generator;
    private Map<String, Loans> groupingMap;
    private String groupingKey;

    public void setGroupingKeyGenerator(GroupingKeyGenerator generator)
    {
        Generator = generator;
    }

    private void countAmountOfLoans(Loans groupingLoans)
    {
        groupingLoans.setCount(groupingLoans.getCount() + 1);
    }

    private void sumLoanAmounts(Loans groupingLoans, Loans loans)
    {
        groupingLoans.setAmount(groupingLoans.getAmount() + loans.getAmount());
    }

    private void groupValuesByKey(Loans loans)
    {
        if (groupingMap.containsKey(groupingKey))
        {
            Loans groupingLoans = groupingMap.get(groupingKey);
            sumLoanAmounts(groupingLoans,loans);
            countAmountOfLoans(groupingLoans);
        }
        else
        {
            groupingMap.put(groupingKey, loans);
        }
    }

    @Override
    public List Group(List<Loans> originalList)
    {
        groupingMap = new HashMap<String, Loans>();
        for (Loans loans : originalList)
        {
            groupingKey = Generator.getGroupingKey(loans);
            groupValuesByKey(loans);
        }
        return new ArrayList<Loans>(groupingMap.values());
    }

}