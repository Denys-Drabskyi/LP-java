package commands.main.necklace.delete;

import json.JsonConverterData;
import necklace.Necklace;
import org.junit.jupiter.api.Test;
import precious_stones.PreciousStone;

import java.util.Arrays;
import java.util.LinkedHashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class DeleteNecklessTest {

    @Test
    public void necklaceDeleteTest(){
        JsonConverterData data = JsonConverterData.builder().necklace(
                new Necklace(new LinkedHashSet<>(
                        Arrays.asList(
                            mock(PreciousStone.class),
                            mock(PreciousStone.class)
                        )
                ))
        ).build();
        DeleteNeckless command = new DeleteNeckless(data);
        command.execute();
        assertEquals(0 ,data.getNecklace().getStones().size() );

    }

}