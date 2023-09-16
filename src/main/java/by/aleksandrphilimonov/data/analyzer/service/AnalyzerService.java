package by.aleksandrphilimonov.data.analyzer.service;

import by.aleksandrphilimonov.data.analyzer.api.DataRequest;
import by.aleksandrphilimonov.data.analyzer.api.DataResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnalyzerService {

    private static final Integer COUNT_OF_WORDS = 5;
    public static final String NOT_WORD = "[^a-zA-Zа-яА-Я]+";
    public static final String SPACE = " ";
    public static final String EMPTY_STRING = "";

    public DataResponse getResponse(DataRequest request) {
        List<String> wordsList = getWordsList(request.getText());

        DataResponse dataResponse = new DataResponse();
        dataResponse.setWordsCount(getNumberOfWords(wordsList));
        dataResponse.setMostFrequentWords(getMostFrequentWords(wordsList));

        return dataResponse;
    }

    private List<String> getWordsList(String text) {
        return Arrays.stream(text.split(SPACE))
                .map(s -> s.replaceAll(NOT_WORD, EMPTY_STRING))
                .filter(s -> s.length() > 0)
                .collect(Collectors.toList());
    }

    public String[] getMostFrequentWords(List<String> wordsList) {
        List<WordStat> sortedList = getSortedWordStatList(wordsList);

        return sortedList.stream()
                .map(WordStat::getText)
                .limit(COUNT_OF_WORDS)
                .toArray(String[]::new);
    }

    private List<WordStat> getSortedWordStatList(List<String> wordsList) {
        List<WordStat> wordStatList = getWordStatList(wordsList);
        order(wordStatList);
        return wordStatList;
    }

    private List<WordStat> getWordStatList(List<String> wordsList) {
        List<WordStat> wordStatList = new ArrayList<>();
        for (String word : wordsList) {
            wordStatIncreaseCounter(wordStatList, word);
        }
        return wordStatList;
    }

    private void wordStatIncreaseCounter(List<WordStat> wordStatList, String word) {
        if (wordStatList.stream()
                .noneMatch(i -> i.getText().equals(word))) {
            wordStatList.add(new WordStat(word, 1));
        } else {
            wordStatList.stream()
                    .filter(e -> e.getText().equals(word))
                    .findFirst()
                    .ifPresent(e -> e.setCounter(e.getCounter() + 1));
        }
    }

    public int getNumberOfWords(List<String> wordsList) {
        return wordsList.size();
    }

    private static void order(List<WordStat> wordStatList) {

        wordStatList.sort((o1, o2) -> {

            Integer x1 = o1.getCounter();
            Integer x2 = o2.getCounter();
            int sComp = x2.compareTo(x1);

            if (sComp != 0) {
                return sComp;
            }

            String y1 = o1.getText();
            String y2 = o2.getText();
            return y1.compareTo(y2);
        });
    }

}
