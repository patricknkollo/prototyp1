package com.shopping.prototyp1.controllers;

import com.shopping.prototyp1.entities.Administrator;
import com.shopping.prototyp1.services.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Component
@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping(path = "/api/AdministratorController")
public class
AdministratorController {

  @Autowired
  AdministratorService service;

  @RequestMapping(path = "/save/admin", method = RequestMethod.POST)
  public @ResponseBody
  ResponseEntity<Administrator> saveAdmin(@RequestBody Administrator admin){
    return service.saveAdmin(admin);
  }

  @RequestMapping(path = "/save/multiple/admins", method = RequestMethod.POST)
  public @ResponseBody ResponseEntity<List<Administrator>> saveAdmins(@RequestBody List<Administrator> admins)throws Exception{
    return service.saveAdmins(admins);
  }

  @RequestMapping(path = "/save/csv/admins", method = RequestMethod.POST)
  public @ResponseBody
  CompletableFuture<List<Administrator>> saveCSVadmins(@RequestBody MultipartFile file) throws Exception{
    return service.saveCSVadmins(file);
  }

  @RequestMapping(path = "/all/admins", method = RequestMethod.GET)
  public @ResponseBody ResponseEntity<List<Administrator>> getAllAdmins() throws Exception{
    return service.getAllAdmins();
  }

  @RequestMapping(path = "/user/id/{thisid}", method = RequestMethod.GET)
  public @ResponseBody ResponseEntity<Optional<Administrator>> getAdminWithID(@PathVariable("thisid") Long adminId) throws Exception{
    return service.getAdminWithID(adminId);
  }

  @RequestMapping(path = "/update/admin", method = RequestMethod.PUT)
  public @ResponseBody ResponseEntity<Administrator> updateAdmin(@RequestBody Administrator admin, @RequestParam Long adminId) throws Exception{
    return service.updateAdminWithID(admin, adminId);
  }
  @RequestMapping(path = "/delete/admin", method = RequestMethod.DELETE)
  public void deleteAdminWithID(@RequestParam("id") Long adminId) throws Exception{
    service.deleteAdminWithID(adminId);
  }
}
