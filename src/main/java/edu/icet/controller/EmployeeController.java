package edu.icet.controller;

import edu.icet.dto.Employee;
import edu.icet.dto.Login;
import edu.icet.response.LoginResponse;
import edu.icet.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping(path = "/save")
    public String saveEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody Login login)
    {
        LoginResponse loginResponse = employeeService.loginEmployee(login);
        return ResponseEntity.ok(loginResponse);
    }

}
