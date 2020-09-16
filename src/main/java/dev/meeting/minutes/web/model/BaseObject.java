package dev.meeting.minutes.web.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.checkerframework.common.aliasing.qual.Unique;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;



@Setter
@Getter
@Document(collection = "objects")
public class BaseObject {

    @Id
    @Unique
    private String bid;

    private boolean processed;
    private boolean deleted;
    private Instant timeUpdate;
    private Instant timeInserted;
}
