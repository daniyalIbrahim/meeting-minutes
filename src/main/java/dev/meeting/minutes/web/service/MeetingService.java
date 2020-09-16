package dev.meeting.minutes.web.service;


import dev.meeting.minutes.web.model.Meeting;
import dev.meeting.minutes.web.repository.GenericRepository;
import dev.meeting.minutes.web.repository.MeetingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MeetingService extends GenericService<Meeting> {

    @Autowired
    MeetingRepo meetingRepo;

    @Override
    public GenericRepository<Meeting> getRepository() {
        return meetingRepo;
    }
}



