package com.sparta.hhrebootexam.interfaces.dto;

import com.sparta.hhrebootexam.domain.item.dto.ItemResult;

import java.util.ArrayList;
import java.util.List;

public record ItemListResponse (
        List<ItemResponse> itemResponseList
){

    public static ItemListResponse of(List<ItemResult> resultList) {
        List<ItemResponse> resList = new ArrayList<>();

        for (ItemResult result : resultList) {
            resList.add(new ItemResponse(
                    result.id(),
                    result.title(),
                    result.content(),
                    result.price(),
                    result.username()
            ));
        }

        return new ItemListResponse(resList);
    }
}
