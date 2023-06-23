package com.security.repository;

import com.security.model.UserDtls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDtls,Integer> {
    public boolean existsByEmail(String email);

    UserDtls findByEmail(String email);
}
