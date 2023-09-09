package by.aleksandrphilimonov.data.analyzer.api;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DataRequest {
    @NotNull
    private String text;
}
