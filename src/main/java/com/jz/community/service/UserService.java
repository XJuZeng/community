package com.jz.community.service;

import com.jz.community.dao.UserRepository;
import com.jz.community.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
        public void save(User user){
            userRepository.save(user);
        }
        public Optional<User> findOne(Long id){
            return userRepository.findById(id);
        }
        public List<User> findAll(){
            return userRepository.findAll();
        }
}
