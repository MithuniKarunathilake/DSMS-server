package edu.icet.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private String address;
    private String email;
    private String password;
    private LocalDate dob;
    private String contactNumber;
    @Lob
    @Column(name = "image", columnDefinition = "LONGBLOB",length = 1000000)
    private byte[] image;
}
