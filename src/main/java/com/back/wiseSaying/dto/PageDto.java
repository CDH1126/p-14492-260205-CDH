package com.back.wiseSaying.dto;

import com.back.wiseSaying.entity.WiseSaying;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor // 클래스의 매개변수를 받는 생성자를 만들 때 사용
@Getter
public class PageDto {
    private int page;
    private int pageSize;
    private int totalCount;
    private List<WiseSaying> content;

}
