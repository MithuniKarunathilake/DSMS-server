package edu.icet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name="employee_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employeeId;
    @Column(name="employee_name", length = 255)
    private String employeeName;
    @Column(name="email", length = 255)
    private String email;
    @Column(name="password", length = 255)
    private String password;
}
