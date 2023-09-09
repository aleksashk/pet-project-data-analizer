package by.aleksandrphilimonov.data.analyzer.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataResponse {
    private int wordsCount;
    private String[] mostFrequentWords;
}
