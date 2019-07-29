package ru.denisa.app.photoapp.api.users.ui.controller;

import com.netflix.discovery.converters.Auto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.denisa.app.photoapp.api.users.data.UserEntity;
import ru.denisa.app.photoapp.api.users.service.UsersService;
import ru.denisa.app.photoapp.api.users.shared.UserDto;
import ru.denisa.app.photoapp.api.users.ui.model.CreateUserRequestModel;
import ru.denisa.app.photoapp.api.users.ui.model.CreateUserResponseModel;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private Environment environment;

    @Autowired
    private UsersService usersService;


    @GetMapping("/status/check")
    public String check(){
        return "working on port = "+environment.getProperty("local.server.port");
    }




    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}
            )
    public ResponseEntity<CreateUserResponseModel> createUser(@Valid  @RequestBody CreateUserRequestModel userDetails){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto=  modelMapper.map(userDetails, UserDto.class);
        UserDto createdUser  = usersService.createUser(userDto);

        CreateUserResponseModel returnValue =modelMapper.map(createdUser, CreateUserResponseModel.class);

        return   ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
    }



}
