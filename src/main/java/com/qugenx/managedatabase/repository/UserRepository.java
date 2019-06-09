package com.qugenx.managedatabase.repository;

import com.qugenx.managedatabase.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("myUserRepository")
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    public UserEntity findByFirstName(String firtName);

}
