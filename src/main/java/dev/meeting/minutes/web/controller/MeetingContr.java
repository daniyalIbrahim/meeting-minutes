package dev.meeting.minutes.web.controller;


import dev.meeting.minutes.web.model.Meeting;
import dev.meeting.minutes.web.service.GenericService;
import dev.meeting.minutes.web.service.MeetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Optional;


@CrossOrigin
@RestController
@RequestMapping("/meeting")
public class MeetingContr extends GenericController<Meeting> {

    @Autowired
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeContr.class);

    @Autowired
    MeetingService meetingService;

    @Override
    public GenericService<Meeting> getService() {
        return meetingService;
    }

    /**
     *  GET
     */
    @GetMapping("/get/all")
    public ResponseEntity<?> listMeetings(){
        try {
            Iterable<Meeting> list =meetingService.findAll();
            return ResponseEntity.ok().body(list);
        } catch (Exception e) {
            LOG.error("Error sending object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while fetching data");
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> GetMeeting(@PathVariable("id") String id){
        try {
            Optional<Meeting> x = meetingService.getoneobject(id);
            return ResponseEntity.ok().body(x);
        } catch (Exception e) {
            LOG.error("Error sending object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while fetching data");
    }
    /**
     *  PUT
     */
    @PutMapping("/update")
    public ResponseEntity<?> MeetingUpdate(@RequestBody Meeting meeting){
        try {

            meeting.setTimeUpdate(Calendar.getInstance().toInstant());
            meetingService.save(meeting);
            return ResponseEntity.ok().body("ok");
        } catch (Exception e) {
            LOG.error("Error sending object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while creating data");
    }
    /**
     *  POST
     */
    @PostMapping("/create")
    public ResponseEntity<?> MeetingCreate(@RequestBody Meeting meeting){
        try {
            meeting.setTimeInserted(Calendar.getInstance().toInstant());
            meeting.setTimeUpdate(Calendar.getInstance().toInstant());
            meetingService.save(meeting);
            return ResponseEntity.ok().body("created employee object");
        } catch (Exception e) {
            LOG.error("Error creating object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while creating data");
    }
    /**
     *  DELETE
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> MeetingDelete(@PathVariable("id") String id){
        try {
            meetingService.delete(id);
            return ResponseEntity.ok().body("deleted");
        } catch (Exception e) {
            LOG.error("Error creating object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while creating data");
    }
}

