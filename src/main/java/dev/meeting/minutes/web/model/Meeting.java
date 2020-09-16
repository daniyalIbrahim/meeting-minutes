package dev.meeting.minutes.web.model;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.checkerframework.common.aliasing.qual.Unique;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@RequiredArgsConstructor
@Document(collection = "meetings")
public class Meeting extends BaseObject {

    @Transient
    public static final String seq_name="meeting_seq";

    private String PROJECT_NAME;
    private String MEETING_PURPOSE;
    private Date MEETING_DATE;
    private Date MEETING_TIME;
    private String MEETING_LOCATION;
    private List<String> MEETING_FACILITATOR;
    private List<String> MEETING_ATTENDEES;
    private String ISSUED_BY;

    private String TIME_ALLOTED;
    private String AGENDA_TOPIC;
    private String AGENDA_PRESENTER;

    private String DISCUSSIONS;
    private String CONCLUSIONS;

    private String NEXT_STEPS;
    private String ASSIGNED_TO;
    private String DUE_DATE;

    private String OBSERVERS;
    private List<String> RESOURCE_PERSONS;
    private String SPECIAL_NOTES;




}
