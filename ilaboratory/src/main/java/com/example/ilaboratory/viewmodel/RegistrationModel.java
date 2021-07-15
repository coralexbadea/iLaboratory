package com.example.ilaboratory.viewmodel;

import com.example.ilaboratory.domain.Student;
import com.example.ilaboratory.domain.User;
import com.example.ilaboratory.service.StudentService;
import com.example.ilaboratory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.HashMap;

@Component
public class RegistrationModel {

    @Autowired
    UserService userService;
    @Autowired
    StudentService studentService;
    public HashMap<String, Object> create(User user, BindingResult bindingResult){
        HashMap<String, Object> model = new HashMap<>();
        User userExists = userService.findUserByUserName(user.getUserName());
        if (userExists != null) {
            bindingResult
                    .rejectValue("userName", "error.user",
                            "There is already a user registered with the user name provided");
        }
        Student student = studentService.findStudentByToken(user.getToken());
        if (student == null) {
            bindingResult
                    .rejectValue("token", "error.user",
                            "The entered token is not valid.");
        }

        if (!bindingResult.hasErrors()) {
            user.setStudent(student);
            student.setUser(user);
            userService.saveUser(user);

            model.put("successMessage", "User has been registered successfully");
            model.put("user", new User());
        }
        return model;
    }

}
