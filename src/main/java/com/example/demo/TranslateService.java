package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class TranslateService {

    private final ApiTranslate apiTranslate;

    public TranslateService(ApiTranslate apiTranslate) {
        this.apiTranslate = apiTranslate;
    }

    public String translateText(TranslateRequestDto requestDto) {
        return apiTranslate.translate(requestDto.text());
    }
}
