package com.sparta.hhrebootexam.domain.item.service;

import com.sparta.hhrebootexam.domain.item.dto.ItemResult;
import com.sparta.hhrebootexam.domain.item.entity.Item;
import com.sparta.hhrebootexam.domain.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public ItemResult createItem(String title, String content, int price, String userName) {
        Item item = itemRepository.save(new Item(title, content, price, userName));
        return new ItemResult(item.getId(), item.getTitle(), item.getContent(), item.getPrice(), item.getUserName());
    }

    @Transactional(readOnly = true)
    public List<ItemResult> getItems() {
        List<Item> items = itemRepository.findAll();
        List<ItemResult> itemResultList = new ArrayList<>();

        for(Item item : items) {
            itemResultList.add(new ItemResult(item.getId(), item.getTitle(), item.getContent(), item.getPrice(), item.getUserName()));
        }

        return itemResultList;
    }

    @Transactional
    public ItemResult updateItem(Long id, String title, String content, int price) {
        // 데이터 조회
        Item item = itemRepository.findById(id);

        // 엔티티 업데이트
        item.update(title, content, price);

        // 저장 및 반환
        return new ItemResult(item.getId(), item.getTitle(), item.getContent(), item.getPrice(), item.getUserName());
    }

    @Transactional
    public void deleteItem(Long id) {
        Item item = itemRepository.findById(id);
        itemRepository.delete(item);
    }
}
