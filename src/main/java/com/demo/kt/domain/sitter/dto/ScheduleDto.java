package com.demo.kt.domain.sitter.dto;

import com.demo.kt.domain.sitter.model.Schedule;

public record ScheduleDto(
        String day,
        String startTime,
        String endTime
) {

    public static ScheduleDto of(Schedule schedule) {
        return new ScheduleDto(schedule.getDay(), schedule.getStartTime(), schedule.getEndTime());
    }
}
