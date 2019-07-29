package ru.denisa.app.photoapp.api.users.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.denisa.app.photoapp.api.users.data.UserEntity;
import ru.denisa.app.photoapp.api.users.data.UsersRepository;
import ru.denisa.app.photoapp.api.users.shared.UserDto;

import java.util.ArrayList;
import java.util.UUID;


@Service
public class UsersServiceImpl implements UsersService {

    UsersRepository  usersRepository;

    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usersRepository = usersRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }



    @Override
    public UserDto createUser(UserDto userDetails) {
        userDetails.setUserId(UUID.randomUUID().toString());
        userDetails.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));


        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserEntity userEntity=  modelMapper.map(userDetails, UserEntity.class);
        usersRepository.save(userEntity);


        UserDto returnValue=  modelMapper.map(userEntity, UserDto.class);
        return returnValue;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity =  usersRepository.findByEmail(userName);
        if (userEntity==null) throw  new UsernameNotFoundException(userName);

        return new User(userEntity.getEmail(),userEntity.getEncryptedPassword(),true,true,
                true,true,new ArrayList<>());
    }
}