package necklace;

import comparators.MyComparator;
import json.JsonConverter;
import json.JsonConverterDataBuilder;
import precious_stones.PreciousStone;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Necklace {
    private List<PreciousStone> stones;

    public Necklace(List<PreciousStone> stones) {
        this.stones = stones;
    }

    public List<PreciousStone> getStones() {
        return stones;
    }

    public void setStones(List<PreciousStone> stones) {
        this.stones = stones;
        writeChanges();
    }

    public void sortByRarityAndValue (){
        TreeSet<PreciousStone> treeSet = new TreeSet<>(new MyComparator());
        treeSet.addAll(stones);
        this.stones = treeSet.stream().toList();
        System.out.printf("Посортовані каміння: %s",stones);
        writeChanges();
    }

    private void writeChanges (){
        JsonConverter.convertToJson(new JsonConverterDataBuilder().setNecklace(this).build());
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
