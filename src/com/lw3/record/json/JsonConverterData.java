package com.lw3.record.json;
import com.lw3.droids.Droid;
import com.lw3.droids.SneakyDroid;
import com.lw3.droids.TankDroid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JsonConverterData {
    private List<GameDataDto> games = new ArrayList<>();
    private List<SneakyDroid> sneakyDroids = new ArrayList<>();
    private List<TankDroid> tankDroids = new ArrayList<>();

    public ArrayList<Droid> getCreatedDroids(){
        ArrayList<Droid> droids = new ArrayList<>(sneakyDroids);
        droids.addAll(tankDroids);
        return droids;
    }
//
//
//    public JsonConverterData(List<PreciousStone> stones, Necklace necklace, List<StoneType> types) {
//        this.necklace = Objects.requireNonNullElseGet(necklace, () -> new Necklace(new LinkedHashSet<>()));
//        this.stones = Objects.requireNonNullElseGet(stones, ArrayList::new);
//        this.types = Objects.requireNonNullElseGet(types, ArrayList::new);
//    }

}