package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ApiTranslateImpl implements ApiTranslate {

    private final Map<String, String> dictionary;

    // Inyectamos el diccionario desde TranslateProperties
    public ApiTranslateImpl(TranslateProperties translateProperties) {
        this.dictionary = translateProperties.getDictionary();
    }

    @Override
    public String translate(String text) {
        // Dividimos el texto en palabras y tratamos de traducir cada palabra
        return Arrays.stream(text.split(" "))
                .map(word -> dictionary.getOrDefault(word.toLowerCase(), word))
                .collect(Collectors.joining(" "));
    }
}
