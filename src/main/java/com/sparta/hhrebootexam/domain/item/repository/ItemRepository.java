package com.sparta.hhrebootexam.domain.item.repository;

import com.sparta.hhrebootexam.domain.item.entity.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {

    Item save(Item item);

    List<Item> findAll();

    Item findById(Long id);

    void delete(Item item);
}
