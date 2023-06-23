package com.shopping.prototyp1.controllers;

import com.shopping.prototyp1.entities.Department;
import com.shopping.prototyp1.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@Component
@RequestMapping(path = "/api/deptcontroller")
@CrossOrigin(origins = "http://localhost:3000")
public class DepartmentController {

  @Autowired
  private DepartmentService service;

  @RequestMapping(path = "/save", method = RequestMethod.POST)
  public @ResponseBody ResponseEntity<Optional<Department>> saveDept(@RequestBody Department department){
    return service.saveDept(department);
  }
  @RequestMapping(path = "/deptByid/{thisid}", method = RequestMethod.GET)
  public ResponseEntity<Optional<Department>> getDeptById(@PathVariable("thisid") Long id){
    return service.getDeptById(id);
  }
  @RequestMapping(path = "/depts", method = RequestMethod.GET)
  public ResponseEntity<List<Department>> getAllDepartments(){
    return service.getAllDepartments();
  }
  @RequestMapping(path = "/update/{thisid}", method = RequestMethod.GET)
  public ResponseEntity<Department> UpdateDepartments(@RequestBody Department department, @PathVariable("thisid") Long id){
    return service.UpdateDepartments(department,id);
  }
  @RequestMapping(path = "/delete/deptByid/{thisid}", method = RequestMethod.GET)
  public void deleteDept (@PathVariable("thisid") Long id){
   service.deleteDept(id);
  }
  @RequestMapping(path = "/departementByName", method = RequestMethod.GET)
  public @ResponseBody ResponseEntity<List<Department>> getDeptByName(@RequestParam String name){
    return service.getDeptByName(name);
  }
}
