package com.sparta.hhrebootexam.interfaces.dto;

import com.sparta.hhrebootexam.domain.item.dto.ItemResult;

import java.util.ArrayList;
import java.util.List;

public record ItemResponse(
        Long id,
        String title,
        String content,
        int price,
        String username
) {
    public static ItemResponse of(ItemResult result) {
        return new ItemResponse(
                result.id(),
                result.title(),
                result.content(),
                result.price(),
                result.username()
        );
    }

    public static List<ItemResponse> of(List<ItemResult> results) {
        List<ItemResponse> itemResponses = new ArrayList<>();
        for(ItemResult result : results) {
            itemResponses.add(of(result));
        }
        return itemResponses;
    }
}
