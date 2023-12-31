package by.aleksandrphilimonov.data.analyzer.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataRequest {
    @NotNull
    private String text;
}
