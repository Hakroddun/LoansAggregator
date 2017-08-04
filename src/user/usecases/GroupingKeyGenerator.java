package user.usecases;

import user.entities.Loans;

/**
 * Created by gideon on 8/3/2017.
 */
public interface GroupingKeyGenerator
{
    public String getGroupingKey(Loans loans);
}
