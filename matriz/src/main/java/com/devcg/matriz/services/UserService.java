package com.devcg.matriz.services;

import com.devcg.matriz.dto.UserDto;
import com.devcg.matriz.entities.User;
import com.devcg.matriz.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.UserTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private  UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserDto findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found"));
        return new UserDto(user);
    }

    //Converte a lista de User em um fluxo.
    //Transforma cada User em um UserDto.
    //Coleta os UserDto em uma lista.
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserDto::new).collect(Collectors.toList());
    }

    @Transactional
    public UserDto insert(UserDto dto) {
        User user = new User();
        copyDtoToEntity(dto, user);
        user = userRepository.save(user);
        return new UserDto(user);
    }

    @Transactional
    public UserDto update(Long id, UserDto dto) {
        try {
            User user = userRepository.getReferenceById(id);
            copyDtoToEntity(dto, user);
            user = userRepository.save(user);
            return new UserDto(user);
        }
        catch (EntityNotFoundException e) {
            throw new RuntimeException("User not found");
        }
    }

    @Transactional
    public void delete(Long id) {
        if(!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Database exception");
        }
    }

    private void copyDtoToEntity(UserDto dto, User user) {
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
    }
}
