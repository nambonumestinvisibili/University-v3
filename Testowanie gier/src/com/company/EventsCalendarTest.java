package com.company;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class EventsCalendarTest {
    EventsCalendar eCalendar = new EventsCalendar();
    LocalDateTime ld1 = LocalDateTime.of(2020, 3,1,10,0);
    LocalDateTime ld2 = LocalDateTime.of(2020, 3, 1,10, 30);
    LocalDateTime ld3 = LocalDateTime.of(2020, 3, 1,11, 0);
    LocalDateTime ld4 = LocalDateTime.of(2020, 3, 1,12, 0);
    Event e1 = new Event("e1", ld1, 30);
    Event e2 = new Event("e2", ld4, 60);
    Event e3 = new Event("e3", ld1, 60);
    @Test
    void addValidEvents(){
        assertDoesNotThrow(() -> {
            eCalendar.addEvent(e1);
            eCalendar.addEvent(e2);
        });
    }

    @Test
    void addOverlappingEventThrowsException() {
        var e = assertThrows(Exception.class, () -> {
            eCalendar.addEvent(e1);
            eCalendar.addEvent(e3);
        });

        assertTrue(e.getMessage().equals("Event overlaps foregoing events"));
    }

    @Test
    void addNearlyOverlappingEvents() throws Exception {
        assertDoesNotThrow(() -> {
            eCalendar.addEvent(new Event("e1", ld1, 30));
            eCalendar.addEvent(new Event("e2", ld2, 30));

        });
    }

    @Test
    void addExistingNameEventThrowsException(){
        var e = assertThrows(Exception.class, () -> {
            eCalendar.addEvent(e1);
            eCalendar.addEvent(new Event("e1", ld2, 10));
        });

        assertEquals(e.getMessage(), "Event name already exists");
    }

    @Test
    void deleteValidEvent() throws Exception {
        eCalendar.addEvent(e1);
        eCalendar.delete(e1.eventName);
        assertEquals( 0, eCalendar.listOfEvents.size());
    }

    @Test
    void deleteInvalidEvent() throws Exception {
        assertThrows(Exception.class, () -> {
            eCalendar.delete(e1.eventName);
        });
    }

    @Test
    void modifyCausesOverlap() throws Exception {
        eCalendar.addEvent(e1);
        eCalendar.addEvent(e2);
        assertThrows(Exception.class, () -> {
            eCalendar.modify(e2.eventName,
                    LocalDateTime.of(2020, 3,1,10,0),
                    LocalDateTime.of(2020, 3, 1, 11, 0));
        });
    }

    @Test
    void modifyValid() throws Exception {
        eCalendar.addEvent(e1);
        LocalDateTime previousEndTime = e1.endTime;
        LocalDateTime previousStartTime = e1.startTime;

        LocalDateTime newEndTime = LocalDateTime.of(2019, 01, 1, 1, 1);
        LocalDateTime newStartTime = LocalDateTime.of(2019, 01, 1, 1, 3);


        eCalendar.modify(e1.eventName,
                newStartTime,
                newEndTime
                );

        assertTrue((e1.startTime == previousStartTime && e1.endTime == previousEndTime)
                        || e1.startTime == newStartTime && e1.endTime == newEndTime
                );

    }

    @Test
    void modifyNonExistentEvent(){
        assertThrows(Exception.class, () -> {
            eCalendar.modify("e1", LocalDateTime.now(), LocalDateTime.now());
        });
    }
}