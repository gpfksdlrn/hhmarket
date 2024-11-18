package com.sparta.hhrebootexam.infrastructer.repository;

import com.sparta.hhrebootexam.domain.item.entity.Item;
import com.sparta.hhrebootexam.domain.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemRepository {
    private final ItemJpaRepository jpaRepository;

    @Override
    public Item save(Item item) {
        return jpaRepository.save(item);
    }

    @Override
    public List<Item> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public Item findById(Long id) {
        return jpaRepository.findById(id).orElseThrow(() -> new NullPointerException("Item with id " + id + " not found"));
    }

    @Override
    public void delete(Item item) {
        jpaRepository.delete(item);
    }
}

