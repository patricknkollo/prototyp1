package com.shopping.prototyp1.repositories;

import com.shopping.prototyp1.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface DepartmentRepository extends JpaRepository<Department, Long> {

  @Query(value = "SELECT * FROM Departement Where name = :thisname", nativeQuery = true)
  public List<Department> findDepartmentByName(@Param("thisname") String name);
}
