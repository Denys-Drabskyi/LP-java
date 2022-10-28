package necklace;

import comparators.MyComparator;
import json.JsonConverter;
import json.JsonConverterDataBuilder;
import precious_stones.PreciousStone;

import java.util.*;
import java.util.stream.Collectors;

public class Necklace {
    private LinkedHashSet<PreciousStone> stones;

    public Necklace(LinkedHashSet<PreciousStone> stones) {
        this.stones = stones;
    }

    public LinkedHashSet<PreciousStone> getStones() {
        return stones;
    }

    public void setStones(LinkedHashSet<PreciousStone> stones) {
        this.stones = stones;
    }

    public void sortByRarityAndValue (){
        TreeSet<PreciousStone> treeSet = new TreeSet<>(new MyComparator());
        treeSet.addAll(stones);
        this.stones = new LinkedHashSet<>(treeSet);
        System.out.printf("Посортовані каміння: %s",stones);
    }

    public void addStone (PreciousStone stone){
        this.stones.add(stone);
    }

    public void replaceStone (int index, PreciousStone stone){
        ArrayList<PreciousStone> list = new ArrayList<>(stones);
        list.remove(index);
        list.add(index, stone);
        this.stones = new LinkedHashSet<>(list);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Намисто з порядком каменів :");
        for (PreciousStone stone:stones) {
            sb.append(String.format("\n%s - %s",stone.getType().getName(), stone.getName()));
        }
        return sb.toString();
    }
}
