package com.kajal.api.repository;
import com.kajal.api.entity.User;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findByEmailCustom(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.name LIKE %:name%")
    List<User> searchByName(@Param("name") String name);
}
