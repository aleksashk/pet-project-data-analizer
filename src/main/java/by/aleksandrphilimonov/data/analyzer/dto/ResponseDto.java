package by.aleksandrphilimonov.data.analyzer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
    private int wordsCount;
    private String[] mostFrequentWords;
}
