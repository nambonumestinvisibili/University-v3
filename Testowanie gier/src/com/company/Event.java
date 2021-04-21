package com.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class Event {
    String eventName;
    @Setter
    LocalDateTime startTime;
    @Setter
    LocalDateTime endTime;

    public Event(@NonNull String eventName, @NonNull LocalDateTime startDate,
                 @NonNull int durationInMinutes) {
        this.eventName = eventName;
        this.startTime = startDate;
        this.endTime = startTime.plusMinutes(durationInMinutes);
    }

    public boolean isOverlapping(Event event2){
        boolean isOverlapping = !startTime.isAfter(event2.endTime) && !event2.startTime.isAfter(endTime);
        if (isOverlapping){
            return !endTime.isEqual(event2.startTime) && !startTime.isEqual(event2.endTime);
        }
        return false;

    }
}
