package by.aleksandrphilimonov.data.analyzer.controller;

import by.aleksandrphilimonov.data.analyzer.api.DataRequest;
import by.aleksandrphilimonov.data.analyzer.api.DataResponse;
import by.aleksandrphilimonov.data.analyzer.service.AnalyzerService;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Data
public class AnalyzerController {
    private final AnalyzerService analyzerService;

    @PostMapping("/api/wordstat")
    public DataResponse analyze(@Valid @RequestBody DataRequest request) {

        return analyzerService.getResponse(request);
    }

}
