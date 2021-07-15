package com.example.ilaboratory.service;

import com.example.ilaboratory.domain.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public interface UserService {
    public User findUserByUserName(String userName);

    public User saveUser(User user) ;
    @Transactional
    public List<User> listAllByRole(String role ) ;

    public User findById(Long id);
    public void delete(Long id);
    public User getCurrentUser() ;

}
