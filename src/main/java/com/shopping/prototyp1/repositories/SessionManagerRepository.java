package com.shopping.prototyp1.repositories;

import com.shopping.prototyp1.entities.SessionManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface SessionManagerRepository extends JpaRepository <SessionManager, Long> {
}
