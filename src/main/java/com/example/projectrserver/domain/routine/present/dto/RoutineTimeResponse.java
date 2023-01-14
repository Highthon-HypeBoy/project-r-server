package com.example.projectrserver.domain.routine.present.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RoutineTimeResponse {
    private String startTime;
    private String lastTime;
}
