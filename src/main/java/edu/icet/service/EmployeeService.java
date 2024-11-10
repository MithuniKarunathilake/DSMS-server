package edu.icet.service;

import edu.icet.dto.Employee;
import edu.icet.dto.Login;
import edu.icet.response.LoginResponse;

public interface EmployeeService {
    String addEmployee(Employee employee);

    LoginResponse loginEmployee(Login login);
}
