package dev.meeting.minutes.web.model.dbsequence;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@Document(collection = "database_sequence")
public class DatabaseSequence {

    @Id
    public String id;
    public long seq;
}
