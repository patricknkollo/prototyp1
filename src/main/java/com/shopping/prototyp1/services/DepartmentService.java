package com.shopping.prototyp1.services;

import com.shopping.prototyp1.entities.Department;
import com.shopping.prototyp1.repositories.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Component
public class DepartmentService {

  private Logger logger = LoggerFactory.getLogger(DepartmentService.class);

  @Autowired
  private DepartmentRepository repository;

  @Transactional
  public ResponseEntity<Optional<Department>> saveDept(Department department){
    Department dept = repository.save(department);
    return dept != null ?
        new ResponseEntity<>(Optional.of(dept), HttpStatus.FOUND) :
        new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
  }
  public ResponseEntity<Optional<Department>> getDeptById(Long id){
    Optional<Department> departements = repository.findById(id);
    return departements != null ?
        new ResponseEntity<>(departements, HttpStatus.FOUND) :
        new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
  }
  public ResponseEntity<List<Department>> getAllDepartments(){
    List<Department> departments = repository.findAll();
    return departments != null ?
            new ResponseEntity<>(departments, HttpStatus.FOUND) :
              new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
  }

  public ResponseEntity<Department> UpdateDepartments(Department department, Long id){
    Optional<Department> dept = repository.findById(id);
    if(dept.isPresent()){
      logger.info("the department {} founded", dept.get().getName());
      dept.get().setDescription(department.getDescription());
      dept.get().setName(department.getName());
      Department savedDept = repository.save(dept.get());
      return  new ResponseEntity<>(savedDept, HttpStatus.ACCEPTED);
    }
    else
      logger.info("the department not founded");
    return  new ResponseEntity<>(null, HttpStatus.ACCEPTED);
  }

  public void deleteDept (Long id){
    Optional<Department> departement = repository.findById(id);
    if(departement.isPresent()){
      repository.deleteById(id);
      logger.info("department {} has been deleted", departement.get().getName());
    }
  }
  public ResponseEntity<List<Department>> getDeptByName(String name){
    List<Department>departments = repository.findDepartmentByName(name);
    return departments != null ?
        new ResponseEntity<>(departments, HttpStatus.FOUND):
        new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
  }
}
