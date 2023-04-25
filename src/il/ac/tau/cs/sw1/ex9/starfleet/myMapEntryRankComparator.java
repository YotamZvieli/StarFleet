package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Comparator;
import java.util.Map;

public class myMapEntryRankComparator implements Comparator<Map.Entry<OfficerRank,Integer>> {

    @Override
    public int compare(Map.Entry<OfficerRank, Integer> o1, Map.Entry<OfficerRank, Integer> o2) {
        if(Integer.compare(o1.getValue(),o2.getValue()) != 0){
            return Integer.compare(o1.getValue(),o2.getValue());
        }
        else {
            return o1.getKey().compareTo(o2.getKey());
        }
    }
}
