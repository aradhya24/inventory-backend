package com.inventory.imsbackend.repository;

import com.inventory.imsbackend.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {

}
