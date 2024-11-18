package com.sparta.hhrebootexam.interfaces.controller;

import com.sparta.hhrebootexam.domain.item.dto.ItemResult;
import com.sparta.hhrebootexam.domain.item.service.ItemService;
import com.sparta.hhrebootexam.interfaces.dto.ItemDeleteResponse;
import com.sparta.hhrebootexam.interfaces.dto.ItemRequest;
import com.sparta.hhrebootexam.interfaces.dto.ItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    // 판매 게시글 작성
    @PostMapping("/post")
    public ItemResponse createItem(@RequestBody ItemRequest dto) {
        ItemResult result =  itemService.createItem(dto.title(), dto.content(), dto.price(), dto.username());
        return ItemResponse.of(result);
    }

    // 판매 게시글 전체 리스트 조회
    @GetMapping("/post")
    public List<ItemResponse> getItems() {
        List<ItemResult> result = itemService.getItems();
        return ItemResponse.of(result);
    }

    // 판매 게시글 수정
    @PutMapping("/post/{id}")
    public ItemResponse updateItem(@PathVariable Long id, @RequestBody ItemRequest dto) {
        ItemResult result = itemService.updateItem(id, dto.title(), dto.content(), dto.price());
        return ItemResponse.of(result);
    }

    // 게시글 삭제
    @DeleteMapping("/post/{id}")
    public ResponseEntity<ItemDeleteResponse> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.ok(new ItemDeleteResponse("삭제완료"));
    }
}
