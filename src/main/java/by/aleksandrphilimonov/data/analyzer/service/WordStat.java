package by.aleksandrphilimonov.data.analyzer.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class WordStat {
    private String text;

    private Integer counter = 5;
}
