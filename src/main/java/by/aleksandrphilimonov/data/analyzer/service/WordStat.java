package by.aleksandrphilimonov.data.analyzer.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class WordStat {
    private String text;

    private static final Integer COUNT_OF_WORDS = 5;

    private List<String> cleanString() {
        return Arrays.stream(text.split(" "))
                .map(s -> s.replaceAll("[^a-zA-Zа-яА-Я]+", ""))
                .filter(s -> s.length() > 0)
                .collect(Collectors.toList());
    }

    public String[] getWordsArray() {
        Map<String, Integer> sortedMap = getStringIntegerSortedMap();

        return sortedMap.keySet().stream().limit(COUNT_OF_WORDS).toArray(String[]::new);
    }

    private Map<String, Integer> getStringIntegerSortedMap() {
        Map<String, Integer> stringIntegerMap = getStringIntegerMap();
        Map<String, Integer> sortedMap = stringIntegerMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry::getKey))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                ));
        return sortedMap;
    }

    private Map<String, Integer> getStringIntegerMap() {
        List<String> stringList = cleanString();
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        for (String word : stringList) {
            stringIntegerMap.merge(word, 1, Integer::sum);
        }
        return stringIntegerMap;
    }

    public int getNumberOfWords() {
        return cleanString().size();
    }

}
