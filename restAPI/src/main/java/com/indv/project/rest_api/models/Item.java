package com.indv.project.rest_api.models;

import javax.persistence.*;


@Entity
public class Item {

    private String id;

    public Item() {

    }


    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }

    public Item(String id){
        this.setId(id);
    }

    @Override
    public String toString() {
        return "Item{ " +
                "id = '" + this.getId() + '\'' +
                '}';
    }
}

//
//@Entity
//@Table(name = "users")
//public class User {
//
//    @Id
//    @Column(name = "ID", nullable = false)
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    public int id;
//
//    @Column(name = "Email",nullable = false)
//    public String email;
//
//    @Column(name = "Username",nullable = false)
//    public String username;
//
//    @Column(name = "Password",nullable = false)
//    public String password;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    @ManyToMany(
//            fetch = FetchType.LAZY
//    )
//    @JoinTable(
//            name = "user_roles",
//            joinColumns = {@JoinColumn(
//                    name = "user_id"
//            )},
//            inverseJoinColumns = {@JoinColumn(
//                    name = "role_id"
//            )}
//    )
//    public Set<Role> roles = new HashSet();
//
//    public User()
//    {
//
//    }
//
//    public User(String username,String mail, String password)
//    {
//        this.email = mail;
//        this.username = username;
//        this.password = password;
//    }
//
//
//    public void setEmail(String mail) {
//        this.email = mail;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    @Override
//    public String toString() {
//        return "User: \n" +
//                "id=" + id +
//                ", email='" + email + '\'' +
//                ", Username='" + username + '\'' +
//                ", Password='"+ password + '\'';
//    }
//}

