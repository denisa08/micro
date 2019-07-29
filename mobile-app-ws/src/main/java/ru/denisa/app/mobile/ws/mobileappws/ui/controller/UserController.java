package ru.denisa.app.mobile.ws.mobileappws.ui.controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.denisa.app.mobile.ws.mobileappws.exceptions.UserServiceException;
import ru.denisa.app.mobile.ws.mobileappws.ui.model.request.UpdateUserDetailsRequestModel;
import ru.denisa.app.mobile.ws.mobileappws.ui.model.request.UserDetailsRequestModel;
import ru.denisa.app.mobile.ws.mobileappws.ui.model.response.UserRest;
import ru.denisa.app.mobile.ws.mobileappws.userservice.UserService;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("users")
public class UserController {


    Map<String, UserRest> users;

    @Autowired
    UserService userService;


    @GetMapping
    public String getUser(@RequestParam(value = "page", required = false) int page,
                          @RequestParam(value = "limit", defaultValue = "1") int limit,
                          @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {

        return "getUser was called " + page + limit;

    }


    @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
         if (true) throw  new UserServiceException("user custom exception is throw");




        if (users.containsKey(userId)) {
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }



    @PostMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
        UserRest returnValue = userService.createUser(userDetails);
        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
    }


    @PutMapping(path = "/{userId}",produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserRest updateUser(@PathVariable String userId,@Valid @RequestBody UpdateUserDetailsRequestModel userDetails) {


        UserRest storedUserDetails = users.get(userId);
        storedUserDetails.setLastName(userDetails.getLastName());
        storedUserDetails.setFirstName(userDetails.getFirstName());
        users.put(userId,storedUserDetails);


        return storedUserDetails;
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        users.remove(id);


        return  ResponseEntity.noContent().build();


    }


}
