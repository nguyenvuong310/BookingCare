package com.example.bookingCare.Service;

import com.example.bookingCare.models.User;
import com.example.bookingCare.models.UserNoPassword;
import com.example.bookingCare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserNoPassword> findAllUser() {
        List<User> users = this.userRepository.findAll();
        List<UserNoPassword> userNoPasswords = new ArrayList<>();
        for (User user : users) {
            UserNoPassword item = new UserNoPassword();
            item.setId(user.getId());
            item.setUserName(user.getUserName());
            item.setName(user.getName());
            item.setGender(user.getGender());
            item.setBirthday(user.getBirthday());
            item.setAddress(user.getAddress());
            item.setPhoneNumber(user.getPhoneNumber());
            userNoPasswords.add(item);
        }
        return userNoPasswords;
    }
    public UserNoPassword findUserById(Long id) {
        Optional<User> optionalUseruser = this.userRepository.findById(id);
        if (optionalUseruser.isPresent()) {
            User user = optionalUseruser.get();
            UserNoPassword item = new UserNoPassword();
            item.setId(user.getId());
            item.setUserName(user.getUserName());
            item.setName(user.getName());
            item.setGender(user.getGender());
            item.setBirthday(user.getBirthday());
            item.setAddress(user.getAddress());
            item.setPhoneNumber(user.getPhoneNumber());
            return item;
        } else {
            return null;
        }
    }
    public void createNewUser(User user) {
        this.userRepository.save(user);
    }
    public boolean checkValidID(Long id) {
        if (id <= 0) return false;
        return true;
    }
    public User updateUser(User editUser,Long id) {
        return this.userRepository.findById(id)
                .map(user -> {
                    user.setName(editUser.getName());
                    user.setUserName(editUser.getUserName());
                    user.setAddress(editUser.getAddress());
                    user.setBirthday(editUser.getBirthday());
                    user.setPhoneNumber(editUser.getPhoneNumber());
                    user.setPassword(editUser.getPassword());
                    user.setGender(editUser.getGender());
                    return this.userRepository.save(user);
                })
                .orElse(null);
    }
    public boolean deleteUserById(Long id) {
        Optional<User> optionalUser = this.userRepository.findById(id);
        if (optionalUser.isPresent()) {
            this.userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
