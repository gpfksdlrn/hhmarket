package com.sparta.hhrebootexam.infrastructer.repository;

import com.sparta.hhrebootexam.domain.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemJpaRepository extends JpaRepository<Item, Long> {
}
