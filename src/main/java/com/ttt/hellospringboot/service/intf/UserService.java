package com.ttt.hellospringboot.service.intf;

import com.ttt.hellospringboot.entity.User;
import com.ttt.hellospringboot.model.dto.UserDto;
import com.ttt.hellospringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public User save(User user);
    public List<User> saveAllUser(List<User> users);
    public List<UserDto> getListUser();
    public UserDto getUserById(int id);
    public List<UserDto> searchUser(String keyword);
    public String deleteUser(int id);
    public User updateUser(User user);
}
