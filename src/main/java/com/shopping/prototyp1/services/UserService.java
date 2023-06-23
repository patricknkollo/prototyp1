package com.shopping.prototyp1.services;

import com.shopping.prototyp1.entities.User;
import com.shopping.prototyp1.exceptions.NoValidListException;
import com.shopping.prototyp1.exceptions.NoValidUserException;
import com.shopping.prototyp1.exceptions.UserNotFoundException;
import com.shopping.prototyp1.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@Component
public class UserService {

  Logger logger = LoggerFactory.getLogger(UserService.class);

  @Autowired
  UserRepository repository;

  @Transactional
  public ResponseEntity<User> saveUser(User user){
    User savedUser = repository.save(user);
    ResponseEntity<User>responseEntity = new ResponseEntity<>(savedUser, HttpStatus.OK);
    return responseEntity;
  }

  @Transactional
  public ResponseEntity<List<User>> saveUsers(List<User> users) throws Exception{
    ResponseEntity<List<User>> responseEntity = new ResponseEntity<>(HttpStatus.OK);
    if (users.isEmpty() || users.size()==0 || users == null){
      logger.warn("the list of users is empty, has no element or is null !!!");
      throw new NoValidListException("redifine your user's list!", "the list of users is empty, has no element or is null");
    }
    else {
      List<User>savedUsers = new ArrayList<>();
      for (User user:users) {
        if(user == null){
          logger.warn("this user is null !!!");
          throw new NoValidUserException("redifine your user's list!", "the list of users is empty, has no element or is null");
        }
        else {
          User savedUser = repository.save(user);
          savedUsers.add(user);
        }
      }
      responseEntity = new ResponseEntity<>(savedUsers, HttpStatus.OK);
    }
    return responseEntity;
  }

  @Transactional
  public ResponseEntity<List<User>> parseCSVFile(final MultipartFile file) throws Exception{
    ResponseEntity<List<User>> responseEntity = new ResponseEntity<>(HttpStatus.OK);
      List<User>savedUsers = new ArrayList<>();
      try(final BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
        String line;
        while((line= br.readLine())!= null){
          String [] data = line.split(",");
          User userToSave = new User();
          userToSave.setLoggingStatus(data[0]);
          userToSave.setPassword(data[1]);
          savedUsers.add(userToSave);
        }

      } catch (Exception e) {
        e.printStackTrace();
        logger.error("Failed to parse CSV file {}", e);
        throw new Exception("Failed to parse CSV file {}", e);
      }
      responseEntity = new ResponseEntity<>(savedUsers, HttpStatus.CREATED);
    return  responseEntity;
  }

  @Transactional
  @Async
  public CompletableFuture<List<User>> saveCSVusers(MultipartFile file) throws Exception{
    ResponseEntity<List<User>> responseEntity = parseCSVFile(file);
    List<User> users = responseEntity.getBody();
    ResponseEntity<List<User>> responseEntityOfUsersTosave = saveUsers(users);
    List<User>savedUsers = responseEntityOfUsersTosave.getBody();
    return  CompletableFuture.completedFuture(savedUsers);
  }

  @Transactional
  public ResponseEntity<List<User>> getAllUsers() throws Exception{
    List<User>users = repository.findAll();
    ResponseEntity<List<User>>responseEntity= new ResponseEntity<>(HttpStatus.OK);
    if(users.isEmpty()){
      throw new NoValidListException("the list of users is empty");
    }
    else {
      responseEntity = new ResponseEntity<>(users, HttpStatus.OK);
    }
   return responseEntity;
  }

  @Transactional
  public ResponseEntity<Optional<User>> getUserWithID(Long userId) throws Exception{
    Optional<User>optionalUser = repository.findById(userId);
    if(!optionalUser.isPresent()){
      throw new NoValidUserException("the user is not present!");
    }
    else {
      return new ResponseEntity<>(optionalUser, HttpStatus.FOUND);
    }
  }

  @Transactional
  public ResponseEntity<User> UpdateUserWithID(User user, Long userId) throws Exception{
    Optional<User>optionalUser = repository.findById(userId);
    if(!optionalUser.isPresent()){
      return  new ResponseEntity<>(optionalUser.get(), HttpStatus.NOT_FOUND);
    }
    else {
      optionalUser.get().setPassword(user.getPassword());
      optionalUser.get().setLoggingStatus(user.getLoggingStatus());
      User savedUser = repository.save(optionalUser.get());
      return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }
  }
  @Transactional
  public void deleteUserWithID(Long userId) throws Exception{
    Optional<User>optionalUser = repository.findById(userId);
    if(optionalUser.isPresent()){
      repository.deleteById(userId);
    }
    else throw new UserNotFoundException("the user with the given id doesn't exist !!!");
  }

  public ResponseEntity<List<User>> getUserWithStatus(String status){
      List<User>users = repository.findUserwithLoginStatus(status);
      return users!=null
               ? new ResponseEntity<>(users, HttpStatus.FOUND)
               : new ResponseEntity<>(users, HttpStatus.NOT_FOUND);
  }
}
