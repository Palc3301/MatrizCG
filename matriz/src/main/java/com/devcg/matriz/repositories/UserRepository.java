package com.devcg.matriz.repositories;

import com.devcg.matriz.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
}
