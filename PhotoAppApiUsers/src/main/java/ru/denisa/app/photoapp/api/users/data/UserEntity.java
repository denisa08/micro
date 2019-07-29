package ru.denisa.app.photoapp.api.users.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="users")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 5L;


    @Id
    @GeneratedValue
    @Getter
    @Setter
    private long id;

    @Column(nullable = false , length = 50)
    @Getter @Setter
    private String firstName;

    @Column(nullable = false , length = 50)
    @Getter @Setter
    private String lastName;

    @Column(nullable = false , length = 120,unique = true)
    @Getter @Setter
    private String email;

    @Column(nullable = false ,unique = true)
    @Getter @Setter
    private String userId;

    @Column(nullable = false ,unique = true)
    @Getter @Setter
    private String encryptedPassword;






}
