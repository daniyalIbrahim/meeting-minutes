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
@Document(collection = "objects")
public class Employee extends BaseObject {

    @Transient
    public static final String seq_name="employee_seq";

    private String TITLE;
    private String FIRST_NAME;
    private String LAST_NAME;
    private Date BIRTH_DATE;
    private List<String> ROLE_NAMES;
    private String EMPLOYEE_SINCE;

    @Unique
    private String USERNAME;
    private String PASSWORD;
    private long PHONE;
    @Unique
    private String EMAIL;
    private String ADDRESS;
}
