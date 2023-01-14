package com.example.projectrserver.domain.routine.service;

import com.example.projectrserver.domain.routine.domain.repository.RoutineRepository;
import com.example.projectrserver.domain.routine.facade.RoutineInfoFacade;
import com.example.projectrserver.domain.routine.present.dto.RoutineListDto;
import com.example.projectrserver.domain.tag.domain.facade.TagFacade;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RoutineListService {
    private final RoutineRepository routineRepository;
    private final TagFacade tagFacade;
    private final RoutineInfoFacade routineInfoFacade;

    @Transactional
    public RoutineListDto RoutineList() {

        List<RoutineListDto.RoutineList> routineList = routineRepository.findAll()
                .stream()
                .map(routine -> RoutineListDto.RoutineList.builder()
                        .title(routine.getTitle())
                        .id(routine.getId())
                        .tags(tagFacade.getTagList(routine))
                        .content(routine.getContent())
                        .writer(routine.getUser().getName())
                        .startTime(routineInfoFacade.getTime(routine).getStartTime())
                        .lastTime(routineInfoFacade.getTime(routine).getLastTime())
                        .build())
                .collect(Collectors.toList());

        return RoutineListDto.builder()
                .routineList(routineList)
                .build();
    }
}
