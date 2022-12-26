package comparators;

import precious_stones.PreciousStone;

import java.util.Comparator;

public class MyComparator implements Comparator<PreciousStone> {

    @Override
    public int compare(PreciousStone o1, PreciousStone o2) {

        if (o1.getType().getValue()!=o2.getType().getValue()) {
            return Integer.compare(o1.getType().getValue(), o2.getType().getValue());
        } else if (o1.getPricePerCarat() != o2.getPricePerCarat())
            return Integer.compare(o1.getPricePerCarat(), o2.getPricePerCarat());
        else
            return o1.getName().compareTo(o2.getName());
    }
}
