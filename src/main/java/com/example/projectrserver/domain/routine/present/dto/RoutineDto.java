package com.example.projectrserver.domain.routine.present.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class RoutineDto {
    private Integer id;
    private String title;
    private String content;
    private List<String> tags;
    private String writer;
    private String intro;

    private List<RoutineList> routineInfo;


    @Getter
    @Builder
    public static class RoutineList {
        private String title;
        private String startTime;
        private String lastTime;

        public RoutineList(String title, String startTime, String lastTime) {
            this.title = title;
            this.startTime = startTime;
            this.lastTime = lastTime;
        }
    }
}
