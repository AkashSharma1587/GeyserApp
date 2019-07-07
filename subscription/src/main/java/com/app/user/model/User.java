package com.app.user.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "users")
@NamedQuery(name = "User.findAll", query = "select x from User x")

public class User {
    @Id
    @GeneratedValue
    int id;

    String userId;

    String name;

    String contactNumber;

    String emailId;
}
