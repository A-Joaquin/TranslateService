package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/translate")
public class TranslateController {

    private final TranslateService translateService;

    public TranslateController(TranslateService translateService) {
        this.translateService = translateService;
    }

    @PostMapping("/text")
    public TranslateResponseDto translateText(@RequestBody TranslateRequestDto requestDto) {
        String translatedText = translateService.translateText(requestDto);
        return new TranslateResponseDto(translatedText);
    }
}
