package by.aleksandrphilimonov.data.analyzer.service;

import by.aleksandrphilimonov.data.analyzer.api.DataRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AnalyzerServiceTest {

    static AnalyzerService service;

    static String text;
    static DataRequest request;

    @BeforeAll
    static void setUp(){
        service = new AnalyzerService();
        text = "Привет! Hello!";
        request = new DataRequest(text);
    }

//    @Test
//    void getWordsArray() {
//        String[] expected = {"Hello", "Привет"};
//        String[] actual = service.getResponse(request).getMostFrequentWords();
//        assertArrayEquals(expected, actual);
//    }
}