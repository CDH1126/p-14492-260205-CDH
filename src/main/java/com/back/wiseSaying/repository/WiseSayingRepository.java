package com.back.wiseSaying.repository;

import com.back.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {

    private List<WiseSaying> wiseSayings = new ArrayList<>();
    private int lastId = 0;

    public WiseSaying save(WiseSaying wiseSaying) {
        if(wiseSaying.isNew()) { // 객체를 다룰 땐 (클래스)자신의 영역 안에서
            wiseSaying.setId(++lastId);
            wiseSayings.add(wiseSaying);
        }

        return wiseSaying;
    }

    public List<WiseSaying> findListDesc() {
        return wiseSayings.reversed()
                .stream()
                .limit(5)
                .toList();
    }


    public boolean delete(int id) {
        return wiseSayings.removeIf(wiseSaying -> wiseSaying.getId() == id);
    }


    public WiseSaying findByIdOrNull(int id) {

        return wiseSayings.stream()
                .filter(wiseSaying -> wiseSaying.getId() == id)
                .findFirst()
                .orElse(null);
    }


    public List<WiseSaying> findByContentKeywordOrderByDesc(String kw) {
        return wiseSayings.reversed()
                .stream()
                .filter(w -> w.getSaying().contains(kw))
                .toList();
    }


    public List<WiseSaying> findByAuthorKeywordOrderByDesc(String kw) {
        return wiseSayings.reversed()// reversed() 순서 주의하기
                .stream()
                .filter(w -> w.getAuthor().contains(kw))
                .limit(5)
                .toList();
    }



}