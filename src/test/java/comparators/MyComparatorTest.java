package comparators;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import precious_stones.PreciousStone;
import precious_stones.StoneType;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyComparatorTest {

    public static Stream<Arguments> source() {
        return Stream.of(
                Arguments.arguments(
                        PreciousStone.builder()
                                .name("name1")
                                .type(new StoneType("1",1))
                                .pricePerCarat(10).build(),
                        PreciousStone.builder()
                                .name("name2")
                                .type(new StoneType("1",3))
                                .pricePerCarat(17).build()
                        ),
                Arguments.arguments(
                        PreciousStone.builder()
                                .name("name1")
                                .type(new StoneType("1",3))
                                .pricePerCarat(10).build(),
                        PreciousStone.builder()
                                .name("name2")
                                .type(new StoneType("1",3))
                                .pricePerCarat(17).build()),
                Arguments.arguments(
                        PreciousStone.builder()
                                .name("name1")
                                .type(new StoneType("1",3))
                                .pricePerCarat(10).build(),
                        PreciousStone.builder()
                                .name("name2")
                                .type(new StoneType("1",3))
                                .pricePerCarat(10).build())
                );

    }

    @ParameterizedTest
    @MethodSource("source")
    public void comparatorTest(PreciousStone preciousStone1, PreciousStone preciousStone2){
        MyComparator myComparator = new MyComparator();

        if (preciousStone1.getType().getValue() != preciousStone2.getType().getValue())
            assertEquals(
                    Integer.compare(
                        preciousStone1.getType().getValue(),
                        preciousStone2.getType().getValue()
                    ),
                    myComparator.compare(preciousStone1,preciousStone2));
        else if (preciousStone1.getPricePerCarat() != preciousStone2.getPricePerCarat())
            assertEquals(
                    Integer.compare(
                        preciousStone1.getPricePerCarat(),
                        preciousStone2.getPricePerCarat()
                    ),
                    myComparator.compare(preciousStone1,preciousStone2));
        else {
            assertEquals(
                    preciousStone1.getName().compareTo(preciousStone2.getName()),
                    myComparator.compare(preciousStone1,preciousStone2));
        }
    }



}