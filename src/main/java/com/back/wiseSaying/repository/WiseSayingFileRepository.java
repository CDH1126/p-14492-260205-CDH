package com.back.wiseSaying.repository;

import com.back.standard.util.Util;
import com.back.wiseSaying.entity.WiseSaying;

import java.util.Map;

public class WiseSayingFileRepository {


    public WiseSaying save(WiseSaying wiseSaying) {

        if (wiseSaying.isNew()) {

            increaseLastId();
            int lastId = getLastId();

            wiseSaying.setId(lastId);
            Map<String, Object> wiseSayingMap = wiseSaying.toMap();
            String jsonStr = Util.json.toString(wiseSayingMap);
            Util.file.set("%s/%d.json".formatted(getDbPath(), wiseSaying.getId()), jsonStr);
        }
        return wiseSaying;
    }


    public String getDbPath() {
        return "db/wiseSaying";
    }

    private int getLastId() {
        return Util.file.getAsInt("%s/lastId.txt".formatted(getDbPath()), 0);
    }


    private void increaseLastId() {
        Util.file.set("%s/lastId.txt".formatted(getDbPath()), String.valueOf(getLastId() + 1));
    }


    public WiseSaying findByIdOrNull(int id) {
        String jsonStr = Util.file.get("%s/%d.json".formatted(getDbPath(), id), "");

        if (jsonStr.isBlank()) { // isBlank() - 공백일 경우를 체크함
            return null;
        }

        Map<String, Object> map = Util.json.toMap(jsonStr);
        return WiseSaying.fromMap(map);
    }


    public void clear() {
        Util.file.delete(getDbPath());
    }




}
