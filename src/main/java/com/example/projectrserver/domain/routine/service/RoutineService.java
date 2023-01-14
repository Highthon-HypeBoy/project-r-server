package com.example.projectrserver.domain.routine.service;

import com.example.projectrserver.domain.routine.domain.Routine;
import com.example.projectrserver.domain.routine.domain.RoutineInfo;
import com.example.projectrserver.domain.routine.domain.repository.RoutineInfoRepository;
import com.example.projectrserver.domain.routine.domain.repository.RoutineRepository;
import com.example.projectrserver.domain.routine.exception.TimeNotMatchException;
import com.example.projectrserver.domain.routine.present.dto.RoutineAddRequest;
import com.example.projectrserver.domain.tag.domain.Tag;
import com.example.projectrserver.domain.tag.domain.repository.TagRepository;
import com.example.projectrserver.domain.user.facade.UserFacade;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RoutineService {
    private final RoutineRepository routineRepository;
    private final RoutineInfoRepository routineInfoRepository;
    private final TagRepository tagRepository;
    private final UserFacade userFacade;

    @Transactional
    public void addRoutine(RoutineAddRequest request) {
        Routine routine = routineRepository.save(
                Routine.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .intro(request.getIntro())
                        .user(userFacade.getCurrentUser())
                        .build()
        );

        for (String tag : request.getTags()) {
            tagRepository.save(
                    Tag.builder()
                            .routine(routine)
                            .name(tag)
                            .build()
            );
        }

        for (RoutineAddRequest.RequestDto requestDto : request.getRoutineInfo()) {
            routineInfoRepository.save(
                    RoutineInfo.builder()
                            .title(requestDto.getTitle())
                            .startTime(requestDto.getStartTime())
                            .lastTime(requestDto.getLastTime())
                            .routine(routine)
                            .build()
            );
        }
    }

}
