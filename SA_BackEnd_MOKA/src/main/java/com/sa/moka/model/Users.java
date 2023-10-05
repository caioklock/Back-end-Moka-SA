package com.sa.moka.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Users {
    @Id
    private Long Cpf_users;
    private String Name_users;
    private Long Tel_users;

}



