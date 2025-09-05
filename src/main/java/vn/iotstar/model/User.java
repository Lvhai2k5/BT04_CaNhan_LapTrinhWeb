package vn.iotstar.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")  //bang users se duoc truy cap
public class User
{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;   //khai bao khoa chinh

    @Column(nullable = false, unique = true, length = 50)
    private String username;   //khai bao ten

    @Column(nullable = false, length = 100)
    private String password;   // khai bao mk

    @Column(length = 100)
    private String fullname;  //khai bao ten

    @Column(length = 20)
    private String role; // "ADMIN", "STAFF", "CUSTOMER"

    // ===== Constructors =====
    public User() 
    {
    	//khong co j het nha
    }

    public User(String username, String password, String fullname, String role) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.role = role;
    }

    // ===== Getter & Setter =====
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // ===== toString() =====
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
