package com.back.wiseSaying.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class WiseSaying {
    private int id;
    private String saying;
    private String author;


    public boolean isNew() {
        return id == 0;
    }

}