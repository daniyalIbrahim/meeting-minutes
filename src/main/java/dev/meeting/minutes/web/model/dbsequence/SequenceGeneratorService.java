package dev.meeting.minutes.web.model.dbsequence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class SequenceGeneratorService {


    private MongoOperations mongoOperations;


    @Autowired
    public SequenceGeneratorService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }
    /**
     *  Method to generate auto incrementing ID for our models
     * @param seqName
     * @return
     */
    public String generateSequence(String seqName){
        DatabaseSequence counter = mongoOperations.findAndModify(
                query(where("_id").is(seqName)),
                new Update().inc("seq",1),options().returnNew(true).upsert(true),
                DatabaseSequence.class
        );
        String str = Long.toString(counter.getSeq());
        return !Objects.isNull(counter) ? str:"1";

    }
}
