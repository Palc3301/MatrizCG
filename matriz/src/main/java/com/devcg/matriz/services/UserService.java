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
public interface UserService {

        @Transactional(readOnly = true)
        UserDTO findById(Long id);

        List<UserDTO> findAll();

        @Transactional
        UserDTO insert(UserDTO dto);

        @Transactional
        UserDTO update(Long id, UserDTO dto);

        @Transactional
        void delete(Long id);

}
