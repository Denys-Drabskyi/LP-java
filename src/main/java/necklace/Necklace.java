package necklace;

import comparators.MyComparator;
import json.JsonConverter;
import json.JsonConverterDataBuilder;
import precious_stones.PreciousStone;

import java.util.*;
import java.util.stream.Collectors;

public class Necklace {
    private List<PreciousStone> stones;

    public Necklace(List<PreciousStone> stones) {
//        TreeSet<PreciousStone> set = new TreeSet<>(new MyComparator());
//        set.addAll(stones);
//        this.stones = set;
        this.stones = stones;
    }

    public List<PreciousStone> getStones() {
        return stones;
    }

    public void setStones(ArrayList<PreciousStone> stones) {
        this.stones = stones;
    }

    public void sortByRarityAndValue (){
        TreeSet<PreciousStone> treeSet = new TreeSet<>(new MyComparator());
        treeSet.addAll(stones);
        this.stones = new ArrayList<>(treeSet);
        System.out.printf("Посортовані каміння: %s",stones);
    }

    public void addStone (PreciousStone stone){
        this.stones.add(stone);
    }

    public void replaceStone (int index, PreciousStone stone){
        this.stones.remove(index);
        this.stones.add(index, stone);
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
