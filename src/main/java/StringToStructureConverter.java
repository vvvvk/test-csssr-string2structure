import java.util.*;
import java.util.stream.Collectors;

public class StringToStructureConverter {

    public static Map<Character, List<String>> convert(String src) {
        Map<Character, List<String>> map;
        List<String> words;

        words = splitToWords(src);
        map = groupingBy1stLetter(words);
        sortWordsInGroups(map);
        map = filterMap(map);
        map = sortMapByKey(map);

        return map;
    }

    private static Map<Character, List<String>> sortMapByKey(Map<Character, List<String>> map) {
        return new TreeMap<>(map);
    }

    private static Map<Character, List<String>> filterMap(Map<Character, List<String>> map) {
        return map.entrySet().stream()
                .filter(e -> e.getValue().size() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static void sortWordsInGroups(Map<Character, List<String>> map) {
        Comparator<String> wordOrderComparator = (s1, s2) -> {
            int res = s2.length() - s1.length();
            return res != 0 ? res : s1.compareToIgnoreCase(s2);
        };

        map.forEach((k, v) -> v.sort(wordOrderComparator));
    }

    private static Map<Character, List<String>> groupingBy1stLetter(List<String> words) {
        return words.stream().collect(Collectors.groupingBy(w -> w.charAt(0)));
    }

    private static List<String> splitToWords(String src) {
        return Arrays.asList(src.split(" "));
    }
}
