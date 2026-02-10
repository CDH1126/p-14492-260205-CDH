package com.back.repository;

import com.back.global.AppContext;
import com.back.wiseSaying.entity.WiseSaying;
import com.back.wiseSaying.repository.WiseSayingFileRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WiseSayingFileRepositoryTest {


    private WiseSayingFileRepository wiseSayingFileRepository;

    public WiseSayingFileRepositoryTest() {
        AppContext.init();
        wiseSayingFileRepository = AppContext.wiseSayingFileRepository;
    }


    @BeforeEach
    public void beforeClear() { // junit 사용을 위해 public으로 선언
        wiseSayingFileRepository.clear();
    }

    @AfterEach
    public void afterClear() { // junit 사용을 위해 public으로 선언
        wiseSayingFileRepository.clear();
    }

    @Test
    @DisplayName("명언 저장")

    void t1() {
        WiseSaying wiseSaying = new WiseSaying(0, "꿈을 지녀라. 그러면 어려운 현실을 이길 수 있다.", "괴테");

        wiseSayingFileRepository.save(wiseSaying);

        WiseSaying foundedWiseSaying = wiseSayingFileRepository.findById(1).get(); // 옵셔널로 반환 시 .get() 사용

        assertThat(foundedWiseSaying).isEqualTo(wiseSaying);

        System.out.println(wiseSaying);
        System.out.println(foundedWiseSaying);

    }


    @Test
    @DisplayName("2개 이상의 명언 저장")
    void t2() {
        WiseSaying wiseSaying1 = new WiseSaying("꿈을 지녀라. 그러면 어려운 현실을 이길 수 있다.", "괴테");
        WiseSaying wiseSaying2 = new WiseSaying("너 자신을 알라", "소크라테스");

        wiseSayingFileRepository.save(wiseSaying1);
        wiseSayingFileRepository.save(wiseSaying2);

        WiseSaying foundedWiseSaying1 = wiseSayingFileRepository.findById(1).get(); // 옵셔널로 반환 시 .get() 사용
        assertThat(foundedWiseSaying1).isEqualTo(wiseSaying1);

        WiseSaying foundedWiseSaying2 = wiseSayingFileRepository.findById(2).get(); // 옵셔널로 반환 시 .get() 사용
        assertThat(foundedWiseSaying2).isEqualTo(wiseSaying2);
    }


    @Test
    @DisplayName("명언 삭제")
    void t3() {
        WiseSaying wiseSaying1 = new WiseSaying("꿈을 지녀라. 그러면 어려운 현실을 이길 수 있다.", "괴테");
        WiseSaying wiseSaying2 = new WiseSaying("너 자신을 알라", "소크라테스");

        wiseSaying1 = wiseSayingFileRepository.save(wiseSaying1);
        wiseSaying2 = wiseSayingFileRepository.save(wiseSaying2);

        wiseSayingFileRepository.delete(wiseSaying1); // id를 가지고 삭제

        WiseSaying foundedWiseSaying1 = wiseSayingFileRepository.findById(1).orElse(null);
        assertThat(foundedWiseSaying1).isNull();

    }


}


