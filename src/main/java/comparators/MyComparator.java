package comparators;

import org.slf4j.LoggerFactory;
import precious_stones.PreciousStone;

import java.util.Comparator;

public class MyComparator implements Comparator<PreciousStone> {

    @Override
    public int compare(PreciousStone o1, PreciousStone o2) {
        if (o1.getType().getValue()<o2.getType().getValue()) {
//            LoggerFactory.getLogger(this.getClass()).debug(o1.getType().getValue()+" "+o2.getType().getValue());
            return 1;
        } else if (o1.getType().getValue() == o2.getType().getValue() && o1.getPricePerCarat() > o2.getPricePerCarat())
            return 1;
        else
            return o1.getName().compareTo(o2.getName());
    }
}
