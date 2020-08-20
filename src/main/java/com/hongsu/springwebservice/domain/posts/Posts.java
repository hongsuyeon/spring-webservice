package com.hongsu.springwebservice.domain.posts;

import com.hongsu.springwebservice.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter             // 클래스의 모든 필드의 Getter 메소드 자동생성
@NoArgsConstructor  //생성자 자동추가
@Entity
public class Posts extends BaseTimeEntity {

    @Id //PK필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increase
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder//인스턴스를 생성시, 생성자만을 통해서 생성하는데 어려움이 있어, 고안된 패턴
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
