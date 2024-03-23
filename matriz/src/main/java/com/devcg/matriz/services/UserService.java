package com.devcg.matriz.services;

import com.devcg.matriz.dto.UserDTO;
import com.devcg.matriz.entities.User;
import com.devcg.matriz.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found"));
        return new UserDTO(user);
    }

    //Converte a lista de User em um fluxo.
    //Transforma cada User em um UserDto.
    //Coleta os UserDto em uma lista.
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public UserDTO insert(UserDTO dto) {
        User user = new User();
        copyDtoToEntity(dto, user);
        user = userRepository.save(user);
        return new UserDTO(user);
    }

    @Transactional
    public UserDTO update(Long id, UserDTO dto) {
        try {
            User user = userRepository.getReferenceById(id);
            copyDtoToEntity(dto, user);
            user = userRepository.save(user);
            return new UserDTO(user);
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

    private void copyDtoToEntity(UserDTO dto, User user) {
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
    }
}
