package com.shopping.prototyp1.repositories;

import com.shopping.prototyp1.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Component
public interface UserRepository extends JpaRepository<User, Long> {

  @Modifying
  @Transactional
  @Query(value = "select userid, password, loggingStatus "
      + "         from user"
      + "         where loggingStatus =:status ", nativeQuery = true)
  public List<User> findUserwithLoginStatus(@Param("status") String status);
}
