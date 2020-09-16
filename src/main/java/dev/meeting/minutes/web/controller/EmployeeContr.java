package dev.meeting.minutes.web.controller;

import dev.meeting.minutes.web.model.Employee;
import dev.meeting.minutes.web.model.Meeting;
import dev.meeting.minutes.web.service.EmployeeService;
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
@RequestMapping("/employee")
public class EmployeeContr extends GenericController<Employee> {

    @Autowired
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeContr.class);

    @Autowired
    EmployeeService employeeService;


    @Override
    public GenericService<Employee> getService() {
        return employeeService;
    }

    /**
     *  GET
     */
    @GetMapping("/get/all")
    public ResponseEntity<?> listEmployees(){
        try {
            Iterable<Employee> list =employeeService.findAll();
            return ResponseEntity.ok().body(list);
        } catch (Exception e) {
            LOG.error("Error sending object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while fetching data");
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> GetEmployee(@PathVariable("id") String id){
        try {
            Optional<Employee> x = employeeService.getoneobject(id);
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
    public ResponseEntity<?> EmployeeUpdate(@RequestBody Employee c){
        try {

            c.setTimeUpdate(Calendar.getInstance().toInstant());
            employeeService.save(c);
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
    public ResponseEntity<?> EmployeeCreate(@RequestBody Employee c){
        try {
            c.setTimeInserted(Calendar.getInstance().toInstant());
            c.setTimeUpdate(Calendar.getInstance().toInstant());
            employeeService.save(c);
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
    public ResponseEntity<?> EmployeeDelete(@PathVariable("id") String id){
        try {
            employeeService.delete(id);
            return ResponseEntity.ok().body("deleted");
        } catch (Exception e) {
            LOG.error("Error creating object", e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while creating data");
    }
}

