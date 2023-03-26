package com.leasing.repository;

import com.leasing.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByLogin(String login);

    @Query(nativeQuery = true, value = "SELECT roles FROM roles WHERE user_id=:id")
    String getRole(int id);

    @Query(nativeQuery = true, value = "INSERT INTO role(user_id,roles) VALUES (:userId, 'USER')")
    boolean addUserRole(int userId);
}
