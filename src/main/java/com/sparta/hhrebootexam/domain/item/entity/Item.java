package com.sparta.hhrebootexam.domain.item.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "Item")
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 게시글 번호

    @Column(nullable = false, name = "title")
    private String title; // 게시글 제목

    @Column(nullable = false, name = "content")
    private String content; // 게시글 내용

    @Column(nullable = false, name = "price")
    private int price; // 가격

    @Column(nullable = false, name = "username")
    private String userName; // 작성자

    public Item(String title, String content, int price, String userName) {
        this.title = title;
        this.content = content;
        this.price = price;
        this.userName = userName;
    }

    public void update(String title, String content, int price) {
        this.title = title;
        this.content = content;
        this.price = price;
    }

}
