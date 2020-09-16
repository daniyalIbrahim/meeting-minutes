package dev.meeting.minutes.web.service;

import dev.meeting.minutes.web.model.Employee;
import dev.meeting.minutes.web.repository.EmployeeRepo;
import dev.meeting.minutes.web.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService extends GenericService<Employee> {

     @Autowired
     EmployeeRepo repo;

    @Override
    public GenericRepository<Employee> getRepository() {
        return repo;
    }
}



