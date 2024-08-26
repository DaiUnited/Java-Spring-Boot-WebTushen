package com.tushenshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_id", unique = true, nullable = false)
    private Integer id;

    @NotNull
    @NotEmpty(message = "Username must not be empty")
    @Size(max = 50)
    @Column(name = "Username", unique = true, nullable = false)
    private String username;

    @NotNull
    @NotEmpty(message = "Password must not be empty")
    @Size(max = 255)
    @Column(name = "Password", nullable = false)
    private String password;

    @NotNull
    @Email(message = "Email is not valid")
    @Size(max = 100)
    @Column(name = "Email", unique = true, nullable = false)
    private String email;

    @Size(max = 100)
    @Column(name = "Full_name")
    private String fullName;

    @Size(max = 20)
    @Column(name = "Phone_number")
    private String phoneNumber;

    @Size(max = 255)
    @Column(name = "Address")
    private String address;

    @Size(max = 20)
    @Column(name = "Role")
    private String role;

    public User() {
    }


    // Getters and Setters

    public int getUserId() {
        return id;
    }

    public void setUserId(int Id) {
        this.id = Id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Users [userId=" + id + ", username=" + username + ", email=" + email
                + ", fullName=" + fullName + ", phoneNumber=" + phoneNumber
                + ", address=" + address + ", role=" + role + "]";
    }

}


