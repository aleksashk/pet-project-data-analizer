package by.aleksandrphilimonov.data.analyzer.service;

import by.aleksandrphilimonov.data.analyzer.api.DataRequest;
import by.aleksandrphilimonov.data.analyzer.api.DataResponse;
import by.aleksandrphilimonov.data.analyzer.entity.WordStat;
import org.springframework.stereotype.Service;

@Service
public class AnalyzerService {

    public DataResponse getResponse(DataRequest request) {
        WordStat wordStat = new WordStat(request.getText());
        DataResponse dataResponse = new DataResponse();
        dataResponse.setWordsCount(wordStat.getNumberOfWords());
        dataResponse.setMostFrequentWords(wordStat.getWordsArray());

        return dataResponse;
    }
}
