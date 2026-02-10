package com.back.wiseSaying.repository;

import com.back.wiseSaying.dto.PageDto;
import com.back.wiseSaying.entity.WiseSaying;

import java.util.Optional;


public interface WiseSayingRepository {
    // 반환 타입 _ 메서드명 (매개변수)
    WiseSaying save(WiseSaying wiseSaying);
    Optional<WiseSaying> findById(int id);
    PageDto findAll(int page, int pageSize);
    boolean delete(WiseSaying wiseSaying1);
    PageDto findByContentContainingDesc(String kw, int page, int pageSize);
    PageDto findByAuthorContainingDesc(String kw, int page, int pageSize);

}
