package edu.icet.service.impl;

import edu.icet.dto.Employee;
import edu.icet.dto.Login;
import edu.icet.repository.EmployeeRepository;
import edu.icet.response.LoginResponse;
import edu.icet.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public String addEmployee(Employee employeeDto) {
        edu.icet.entity.Employee employee = new edu.icet.entity.Employee(
                employeeDto.getEmployeeId(),
                employeeDto.getEmployeeName(),
                employeeDto.getEmail(),
                this.passwordEncoder.encode(employeeDto.getPassword())
        );
        employeeRepository.save(employee);
        return employee.getEmployeeName();
    }

    @Override
    public LoginResponse loginEmployee(Login login) {
        String msg = "";
        edu.icet.entity.Employee employee1 = employeeRepository.findByEmail(login.getEmail());
        if (employee1 != null) {
            String password = login.getPassword();
            String encodedPassword = employee1.getPassword();
            Boolean isPasswordRight = passwordEncoder.matches(password, encodedPassword);
            if (isPasswordRight) {
                Optional<edu.icet.entity.Employee> employee = employeeRepository.findOneByEmailAndPassword(login.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginResponse("Login Success!", true);
                } else {
                    return new LoginResponse("Login Failed!", false);
                }
            } else {
                return new LoginResponse("Password does not match", false);
            }
        }else {
            return new LoginResponse("Email does not exit", false);
        }
    }
}
