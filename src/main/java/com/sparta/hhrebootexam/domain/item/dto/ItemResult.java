package com.sparta.hhrebootexam.domain.item.dto;

public record ItemResult(
        Long id,
        String title,
        String content,
        int price,
        String username
) {
}
