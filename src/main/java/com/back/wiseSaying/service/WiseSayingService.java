package com.back.wiseSaying.service;

import com.back.global.AppContext;
import com.back.wiseSaying.dto.PageDto;
import com.back.wiseSaying.entity.WiseSaying;
import com.back.wiseSaying.repository.WiseSayingRepository;

import java.util.Optional;

import static com.back.global.AppContext.wiseSayingMemRepository;

public class WiseSayingService {

    private WiseSayingRepository wiseSayingRepository ;

    public WiseSayingService() {
        this.wiseSayingRepository = AppContext.wiseSayingFileRepository;
    }

    public WiseSaying write(String saying, String author) {
        WiseSaying wiseSaying = new WiseSaying(0, saying, author);
        wiseSayingMemRepository.save(wiseSaying);

        return wiseSaying;
    }

    public PageDto findListDesc(String kw, String kwt, int page, int pageSize) {
        return switch (kwt) {
            case "content" -> wiseSayingMemRepository.findByContentContainingDesc(kw, page, pageSize);
            case "author" -> wiseSayingMemRepository.findByContentContainingDesc(kw, page, pageSize);
            default -> wiseSayingMemRepository.findAll(page, pageSize);
        };
    }

    public boolean delete(int id) {
        Optional<WiseSaying> wiseSayingOp = wiseSayingRepository.findById(id);
        if(wiseSayingOp.isEmpty()) {
            return false;
        }
        return wiseSayingRepository.delete(wiseSayingOp.get());
    }

    public WiseSaying findByIdOrNull(int id) {
        return wiseSayingRepository.findById(id).orElse(null);
    }


    public void modify(WiseSaying wiseSaying, String newSaying, String newAuthor) {

        wiseSaying.setSaying(newSaying);
        wiseSaying.setAuthor(newAuthor);

        wiseSayingMemRepository.save(wiseSaying);
    }


}