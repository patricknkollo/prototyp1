package com.shopping.prototyp1.controllers;

import com.shopping.prototyp1.entities.User;
import com.shopping.prototyp1.services.UserService;
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
@RequestMapping(path = "/api/UserController")
public class UserController {

  @Autowired
  UserService service;

  @RequestMapping(path = "/save/user", method = RequestMethod.POST)
  public @ResponseBody ResponseEntity<User> saveUser(@RequestBody User user){
    return service.saveUser(user);
  }

  @RequestMapping(path = "/save/multiple/users", method = RequestMethod.POST)
  public @ResponseBody ResponseEntity<List<User>> saveUsers(@RequestBody List<User> users)throws Exception{
   return service.saveUsers(users);
  }

  @RequestMapping(path = "/save/csv/users", method = RequestMethod.POST)
  public @ResponseBody CompletableFuture<List<User>> saveCSVusers(@RequestBody MultipartFile file) throws Exception{
    return service.saveCSVusers(file);
  }

  @RequestMapping(path = "/all/users", method = RequestMethod.GET)
  public @ResponseBody ResponseEntity<List<User>> getAllUsers() throws Exception{
    return service.getAllUsers();
  }

  @RequestMapping(path = "/user/id/{thisid}", method = RequestMethod.GET)
  public @ResponseBody ResponseEntity<Optional<User>> getUserWithID(@PathVariable("thisid") Long userId) throws Exception{
   return service.getUserWithID(userId);
  }

  @RequestMapping(path = "/update/user", method = RequestMethod.PUT)
  public @ResponseBody ResponseEntity<User> updateUser(@RequestBody User user, @RequestParam Long userId) throws Exception{
    return service.UpdateUserWithID(user, userId);
  }
  @RequestMapping(path = "/delete/user", method = RequestMethod.DELETE)
  public void deleteUserWithID(@RequestParam("id") Long userId) throws Exception{
    service.deleteUserWithID(userId);
  }
  @RequestMapping(path = "/user/status", method = RequestMethod.GET)
  public @ResponseBody ResponseEntity<List<User>> getUserWithStatus(@RequestParam String status){
   return service.getUserWithStatus(status);
  }
}
