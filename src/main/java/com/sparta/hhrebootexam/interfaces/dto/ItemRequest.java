package com.sparta.hhrebootexam.interfaces.dto;

public record ItemRequest(
        String title,
        String content,
        int price,
        String username
) {
}
