package com.lw3.record.json;
import com.lw3.game.team.Team;
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
    private Team team1;
    private Team team2;

    private boolean firstTeamAttacks;

    private String moves;
//
//
//    public JsonConverterData(List<PreciousStone> stones, Necklace necklace, List<StoneType> types) {
//        this.necklace = Objects.requireNonNullElseGet(necklace, () -> new Necklace(new LinkedHashSet<>()));
//        this.stones = Objects.requireNonNullElseGet(stones, ArrayList::new);
//        this.types = Objects.requireNonNullElseGet(types, ArrayList::new);
//    }

}