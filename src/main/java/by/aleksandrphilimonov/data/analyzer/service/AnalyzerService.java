package by.aleksandrphilimonov.data.analyzer.service;

import by.aleksandrphilimonov.data.analyzer.api.DataRequest;
import by.aleksandrphilimonov.data.analyzer.api.DataResponse;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AnalyzerService {

    private static final String COUNT_OF_WORDS = "5";

    private String[] getWordsArray(String msg, int countOfWords) {
        List<String> stringList = cleanString(msg);

        Map<String, Integer> stringIntegerMap = new HashMap<>();
        for (String word : stringList) {
            stringIntegerMap.merge(word, 1, Integer::sum);
        }

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

        return sortedMap.keySet().stream().limit(countOfWords).toArray(String[]::new);
    }

    private static List<String> cleanString(String msg) {
        return Arrays.stream(msg.split(" ")).map(s -> s.replaceAll("[^a-zA-Zа-яА-Я]+", "")).filter(s -> s.length() > 0).collect(Collectors.toList());
    }

    public DataResponse getResponse(DataRequest request) {
        DataResponse dataResponse = new DataResponse();
        String text = request.getText();
        dataResponse.setWordsCount(getNumberOfWords(text));
        dataResponse.setMostFrequentWords(getWordsArray(text, Integer.parseInt(COUNT_OF_WORDS)));

        return dataResponse;
    }

    private int getNumberOfWords(String msg) {
        return cleanString(msg).size();
    }
}
