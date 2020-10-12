package com.example.demo.Model;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserInfoRepository userRepo;

    public List<UserInfo> listAll() {
        return (List<UserInfo>) userRepo.findAll();
    }

    public void save(UserInfo user) {
        userRepo.save(user);
    }

    public UserInfo get(Integer id) {
        return userRepo.findById(id).get();
    }

    public void delete(Integer id) {
        userRepo.deleteById(id);
    }
}
