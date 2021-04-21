package com.company;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class EventsCalendar {
    ArrayList<Event> listOfEvents;

    public EventsCalendar(){
        listOfEvents = new ArrayList<>();
    }

    public void addEvent(Event event) throws Exception {
        if (eventExists(event.eventName)){
            throw new Exception("Event name already exists");
        }
        else if (areEventsOverlappingWith(event)){
            throw new Exception("Event overlaps foregoing events");
        }
        else {
            listOfEvents.add(event);
        }
    }

    public void delete(String eventName) throws Exception {
        if (eventExists(eventName)){

            int index = 0;
            for (var e : listOfEvents ) {
                if (e.eventName.equals(eventName)){
                    break;
                }
                index++;
            }

            listOfEvents.remove(index);
        }
        else {
            throw new Exception("Tried deleting non-existent event");
        }

    }

    public void modify(String eventName, LocalDateTime start, LocalDateTime end) throws Exception {
        Event dummyEvent = new Event(eventName, start, end);
        if (areEventsOverlappingWith(dummyEvent)){
            throw new Exception("Event overlaps foregoing events");
        }
        else {
            for (var e: listOfEvents) {
                if (e.eventName.equals(eventName)){
                    e.endTime = end;
                    e.startTime = start;
                    return;
                }
            }
        }
        throw new Exception("You tried to modify a non-existent event");
    }

    private boolean eventExists(String eventName) throws Exception {
        return listOfEvents.stream()
                .anyMatch(x -> x.eventName.equals(eventName));
    }

    private boolean areEventsOverlappingWith(Event event) throws Exception {
        return listOfEvents.stream().anyMatch(x -> x.isOverlapping(event));
    }




}
