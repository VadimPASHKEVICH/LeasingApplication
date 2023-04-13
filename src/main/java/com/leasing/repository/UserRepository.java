package com.leasing.repository;
import com.leasing.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByLogin(String login);

    @Query(nativeQuery = true, value = "SELECT role FROM roles WHERE user_id=:id")
    String getRole(int id);

    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO roles (id,user_id,role) VALUES (DEFAULT,:userId,'USER')")
    void setUserRole(int userId);
}