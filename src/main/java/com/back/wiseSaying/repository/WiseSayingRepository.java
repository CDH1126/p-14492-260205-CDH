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

    public boolean delete(int id) {
        return wiseSayings.removeIf(wiseSaying -> wiseSaying.getId() == id);
    }


    public WiseSaying findByIdOrNull(int id) {

        return wiseSayings.stream()
                .filter(wiseSaying -> wiseSaying.getId() == id)
                .findFirst()
                .orElse(null);
    }


    public List<WiseSaying> findListDesc(int page, int pageSize) {
        return wiseSayings.reversed()
                .stream()
                .skip((page - 1) * pageSize)
                .limit(pageSize)
                .toList();
    }


    public List<WiseSaying> findByContentKeywordOrderByDesc(String kw, int page, int pageSize) {
        return wiseSayings.reversed()
                .stream()
                .skip((page - 1) * pageSize)
                .filter(w -> w.getSaying().contains(kw))
                .limit(pageSize)
                .toList();
    }


    public List<WiseSaying> findByAuthorKeywordOrderByDesc(String kw, int page, int pageSize) {
        return wiseSayings.reversed()// reversed() 순서 주의하기
                .stream()
                .skip((page - 1) * pageSize)
                .filter(w -> w.getAuthor().contains(kw))
                .limit(pageSize)
                .toList();
    }



}