import precious_stones.PreciousStone;
import json.JsonConverter;
import json.JsonConverterData;
import json.JsonConverterDataBuilder;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Comparator<PreciousStone> comparator = new Comparator<PreciousStone>() {
            @Override
            public int compare(PreciousStone o1, PreciousStone o2) {
                return 0;
            }
        };
        TreeSet<PreciousStone> test1 = new TreeSet<>(comparator);

        test1.add(new PreciousStone("",1,1,""));
        List<PreciousStone> test = test1.stream().toList();



//        JsonConverterData jsonConverterData = new JsonConverterDataBuilder().setGemStones(first).setSemiPreciousGems(second).build();
        JsonConverterData jsonConverterData = new JsonConverterDataBuilder().setStones(test).build();

        String s = JsonConverter.convertToJson(jsonConverterData);
        System.out.println(s);
        JsonConverterData jsonConverterData1 = JsonConverter.convertToJsonConverterData(s);

        System.out.println(jsonConverterData);
        System.out.println(jsonConverterData1.getStones().get(0).getClass());
//        System.out.println(jsonConverterData1.getSemiPreciousGems().get(1).getClass());
    }

    public static boolean isValidName(String text)
    {
        Pattern pattern = Pattern.compile(
                "# Match a valid Windows filename (unspecified file system).          \n" +
                        "^                                # Anchor to start of string.        \n" +
                        "(?!                              # Assert filename is not: CON, PRN, \n" +
                        "  (?:                            # AUX, NUL, COM1, COM2, COM3, COM4, \n" +
                        "    CON|PRN|AUX|NUL|             # COM5, COM6, COM7, COM8, COM9,     \n" +
                        "    COM[1-9]|LPT[1-9]            # LPT1, LPT2, LPT3, LPT4, LPT5,     \n" +
                        "  )                              # LPT6, LPT7, LPT8, and LPT9...     \n" +
                        "  (?:\\.[^.]*)?                  # followed by optional extension    \n" +
                        "  $                              # and end of string                 \n" +
                        ")                                # End negative lookahead assertion. \n" +
                        "[^<>:\"/\\\\|?*\\x00-\\x1F]*     # Zero or more valid filename chars.\n" +
                        "[^<>:\"/\\\\|?*\\x00-\\x1F\\ .]  # Last char is not a space or dot.  \n" +
                        "$                                # Anchor to end of string.            ",
                Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE | Pattern.COMMENTS);
        Matcher matcher = pattern.matcher(text);
        boolean isMatch = matcher.matches();
        return isMatch;
    }
}
