package by.aleksandrphilimonov.data.analyzer.controller;

import by.aleksandrphilimonov.data.analyzer.api.DataRequest;
import by.aleksandrphilimonov.data.analyzer.api.DataResponse;
import by.aleksandrphilimonov.data.analyzer.service.AnalyzerService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Data
@RequiredArgsConstructor
public class AnalyzerController {
    @Value("${countOfWords}")
    private String countOfWords;

    private final AnalyzerService analyzerService;


    @PostMapping("/api/wordstat")
    public DataResponse analyze(@Valid @RequestBody DataRequest request) {

        DataResponse dataResponse = new DataResponse();
        dataResponse.setWordsCount(analyzerService.getNumberOfWords(request.getText()));
        dataResponse.setMostFrequentWords(analyzerService.getWordsArray(request.getText(), Integer.parseInt(countOfWords)));

        return dataResponse;
    }

}
