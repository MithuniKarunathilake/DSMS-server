package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {
    private Integer id;
    private String name;
    private String address;
    private String email;
    private String password;
    private LocalDate dob;
    private String contactNumber;
    private Integer experiencedYears;
    private Boolean availability;
    private String imageName;
    private String imagePath;
}
