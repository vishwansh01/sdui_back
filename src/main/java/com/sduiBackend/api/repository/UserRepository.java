package com.sduiBackend.api.repository;
import com.sduiBackend.api.interfaces.UserView;
import com.sduiBackend.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<UserView> findById(Long id);
}
