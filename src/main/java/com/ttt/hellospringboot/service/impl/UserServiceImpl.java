package com.ttt.hellospringboot.service.impl;

import com.ttt.hellospringboot.entity.User;
import com.ttt.hellospringboot.model.dto.UserDto;
import com.ttt.hellospringboot.model.mapper.UserMapper;
import com.ttt.hellospringboot.repository.UserRepository;
import com.ttt.hellospringboot.service.intf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

//    private static List<User> listUser = new ArrayList<User>();
//    static {
//        listUser.add(new User(1, "Nguyen thi mong mo", "mongmo@gmail.com", "485210","avatar.img","12346"));
//        listUser.add(new User(2, "Nguyen chienmo", "mongmo@gmail.com", "48521066645","avatar.img","12346"));
//        listUser.add(new User(3, "Nung thi mong manh", "mongmo@gmail.com", "48521021564","avatar.img","12346"));
//        listUser.add(new User(4, "mai anh bao duoc khon", "mongmo@gmail.com", "485232610","avatar.img","12346"));
//        listUser.add(new User(5, "Nguyen thi hiadasid mo", "mongmo@gmail.com", "405185210","avatar.img","12346"));
//        listUser.add(new User(6, "Nguyen thi masdadong mo", "mongmo@gmasdaail.com", "5656485210","avatar.img","12346"));
//    }
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> saveAllUser(List<User> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public List<UserDto> getListUser() {
        List<UserDto> result  = new ArrayList<UserDto>();
        List<User> listUser = userRepository.findAll();
        System.out.println(listUser);
        for (User user : listUser){
            result.add(UserMapper.toUserDto(user));
        }
        return result;
    }

    @Override
    public UserDto getUserById(int id) {
        List<User> listUser = userRepository.findAll();
        for( User user : listUser){
            if(user.getId() == id){
                return UserMapper.toUserDto(user);
            }
        }
        return null;
    }

    @Override
    public List<UserDto> searchUser(String keyword) {
        List<User> listUser = userRepository.findAll();
        List<UserDto> result = new ArrayList<>();
        for( User user : listUser){
            if(user.getName().contains(keyword)){
                result.add(UserMapper.toUserDto(user));
            }
        }
        return result;
    }

    @Override
    public String deleteUser(int id) {
         userRepository.deleteById(id);
        return "da xoa: " + id;
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhone(user.getPhone());
        existingUser.setAvatar(user.getAvatar());
        existingUser.setPassword(user.getPassword());
        return userRepository.save(existingUser);
    }
}
