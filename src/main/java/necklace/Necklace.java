package necklace;

import comparators.MyComparator;
import lombok.extern.slf4j.Slf4j;
import precious_stones.PreciousStone;

import java.util.*;
@Slf4j
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
        List<PreciousStone> list = new ArrayList<>(this.stones.stream().toList());
        list.remove(index);
        list.add(index,stone);
        log.info("replaced stone in necklace from "+list.get(index).getName()+" to " + stone.getName());
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
