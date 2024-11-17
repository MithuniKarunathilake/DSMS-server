package edu.icet.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class StudentEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String address;
    private String email;
    private String password;
    private LocalDate dob;
    private String contactNumber;
    @Lob
    @Column(length = 1000000,name = "image")
    private byte[] picture;

    //private UserRole userRole;

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of(new SimpleGrantedAuthority(userRole.name()));
//    }
//
//    @Override
//    public String getUsername() {
//        return email;
//    }
}
