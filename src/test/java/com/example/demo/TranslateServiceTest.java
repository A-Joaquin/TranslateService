package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TranslateServiceTest {

    private ApiTranslate apiTranslate;
    private TranslateService translateService;

    @BeforeEach
    void setUp() {
        apiTranslate = Mockito.mock(ApiTranslate.class);
        translateService = new TranslateService(apiTranslate);
    }

    @Test
    void translateText() {
        TranslateRequestDto requestDto = new TranslateRequestDto("hello world");
        when(apiTranslate.translate(requestDto.text())).thenReturn("hola mundo");

        String result = translateService.translateText(requestDto);
        assertEquals("hola mundo", result);
        verify(apiTranslate).translate(requestDto.text());
    }
}
