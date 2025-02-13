package com.magic8ball.magic8ball.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private Repository repository;
    @PostMapping("/students")
    public studentEntity saveStudent(@RequestBody studentEntity student) {

        return repository.save(student);
    }

       @GetMapping("/students")
               public List<studentEntity> getstudentEntity(){
           return repository.findAll();
        }
        @PutMapping("/students/{id}")
        public studentEntity updatestudentEntity(@RequestBody studentEntity student,@PathVariable Integer id) {
        studentEntity studentEntity = repository.findById(id).get();
        studentEntity.setStudentFirstName(student.getStudentFirstName());
        studentEntity.setStudentLastName(student.getStudentLastName());
        studentEntity.setStudentEmail(student.getStudentEmail());
        studentEntity.setStudentPhoneNumber(student.getStudentPhoneNumber());
            return repository.save(studentEntity);
        }

        @DeleteMapping("/students/{id}")
    public String student(@PathVariable Integer id){
        studentEntity student = repository.findById(id).get();
        repository.delete(student);
        return "User deleted successfully";
        }




}
