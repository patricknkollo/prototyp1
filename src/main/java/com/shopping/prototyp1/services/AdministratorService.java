package com.shopping.prototyp1.services;

import com.shopping.prototyp1.entities.Administrator;
import com.shopping.prototyp1.exceptions.NoValidListException;
import com.shopping.prototyp1.exceptions.NoValidUserException;
import com.shopping.prototyp1.exceptions.UserNotFoundException;
import com.shopping.prototyp1.repositories.AdministratorRepository;
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
public class AdministratorService {
  Logger logger = LoggerFactory.getLogger(UserService.class);

  @Autowired
  AdministratorRepository repository;

  @Transactional
  public ResponseEntity<Administrator> saveAdmin(Administrator admin){
    Administrator savedAdmin = repository.save(admin);
    ResponseEntity<Administrator>responseEntity = new ResponseEntity<>(savedAdmin, HttpStatus.OK);
    return responseEntity;
  }

  @Transactional
  public ResponseEntity<List<Administrator>> saveAdmins(List<Administrator> admins) throws Exception{
    ResponseEntity<List<Administrator>> responseEntity = new ResponseEntity<>(HttpStatus.OK);
    if (admins.isEmpty() || admins.size()==0 || admins == null){
      logger.warn("the list of users is empty, has no element or is null !!!");
      throw new NoValidListException("redifine your user's list!", "the list of users is empty, has no element or is null");
    }
    else {
      List<Administrator>savedAdmins = new ArrayList<>();
      for (Administrator admin:admins) {
        if(admin == null){
          logger.warn("this user is null !!!");
          throw new NoValidUserException("redifine your user's list!", "the list of users is empty, has no element or is null");
        }
        else {
          Administrator savedAdmin = repository.save(admin);
          savedAdmins.add(admin);
        }
      }
      responseEntity = new ResponseEntity<>(savedAdmins, HttpStatus.OK);
    }
    return responseEntity;
  }

  @Transactional
  public ResponseEntity<List<Administrator>> parseCSVFile(final MultipartFile file) throws Exception{
    ResponseEntity<List<Administrator>> responseEntity = new ResponseEntity<>(HttpStatus.OK);
    List<Administrator>savedAdmins = new ArrayList<>();
    try(final BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
      String line;
      while((line= br.readLine())!= null){
        String [] data = line.split(",");
        Administrator adminToSave = new Administrator();
        adminToSave.setAdminName(data[0]);
        adminToSave.setMail(data[1]);
        savedAdmins.add(adminToSave);
      }

    } catch (Exception e) {
      e.printStackTrace();
      logger.error("Failed to parse CSV file {}", e);
      throw new Exception("Failed to parse CSV file {}", e);
    }
    responseEntity = new ResponseEntity<>(savedAdmins, HttpStatus.CREATED);
    return  responseEntity;
  }

  @Transactional
  @Async
  public CompletableFuture<List<Administrator>> saveCSVadmins(MultipartFile file) throws Exception{
    ResponseEntity<List<Administrator>> responseEntity = parseCSVFile(file);
    List<Administrator> admins = responseEntity.getBody();
    ResponseEntity<List<Administrator>> responseEntityOfUsersTosave = saveAdmins(admins);
    List<Administrator>savedAdmins = responseEntityOfUsersTosave.getBody();
    return  CompletableFuture.completedFuture(savedAdmins);
  }

  @Transactional
  public ResponseEntity<List<Administrator>> getAllAdmins() throws Exception{
    List<Administrator>admins = repository.findAll();
    ResponseEntity<List<Administrator>>responseEntity= new ResponseEntity<>(HttpStatus.OK);
    if(admins.isEmpty()){
      throw new NoValidListException("the list of users is empty");
    }
    else {
      responseEntity = new ResponseEntity<>(admins, HttpStatus.OK);
    }
    return responseEntity;
  }

  @Transactional
  public ResponseEntity<Optional<Administrator>> getAdminWithID(Long userId) throws Exception{
    Optional<Administrator>optionalAdmin = repository.findById(userId);
    if(!optionalAdmin.isPresent()){
      throw new NoValidUserException("the user is not present!");
    }
    else {
      return new ResponseEntity<>(optionalAdmin, HttpStatus.FOUND);
    }
  }

  @Transactional
  public ResponseEntity<Administrator> updateAdminWithID(Administrator admin, Long AdminId) throws Exception{
    Optional<Administrator>optionalAdmin = repository.findById(AdminId);
    if(!optionalAdmin.isPresent()){
      return  new ResponseEntity<>(optionalAdmin.get(), HttpStatus.NOT_FOUND);
    }
    else {
      optionalAdmin.get().setAdminName(admin.getAdminName());
      optionalAdmin.get().setMail(admin.getMail());
      Administrator savedAdmin = repository.save(optionalAdmin.get());
      return new ResponseEntity<>(savedAdmin, HttpStatus.OK);
    }
  }
  @Transactional
  public void deleteAdminWithID(Long adminId) throws Exception{
    Optional<Administrator>optionalAdmin = repository.findById(adminId);
    if(optionalAdmin.isPresent()){
      repository.deleteById(adminId);
    }
    else throw new UserNotFoundException("the user with the given id doesn't exist !!!");
  }
}
