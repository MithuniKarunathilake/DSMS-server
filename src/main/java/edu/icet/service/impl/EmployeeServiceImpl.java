package edu.icet.service.impl;

import edu.icet.dto.Employee;
import edu.icet.dto.Login;
import edu.icet.entity.EmployeeEntity;
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
        EmployeeEntity employeeEntity = new EmployeeEntity(
                employeeDto.getEmployeeId(),
                employeeDto.getEmployeeName(),
                employeeDto.getEmail(),
                this.passwordEncoder.encode(employeeDto.getPassword())
        );
        employeeRepository.save(employeeEntity);
        return employeeEntity.getEmployeeName();
    }

    @Override
    public LoginResponse loginEmployee(Login login) {
        String msg = "";
        EmployeeEntity employeeEntity1 = employeeRepository.findByEmail(login.getEmail());
        if (employeeEntity1 != null) {
            String password = login.getPassword();
            String encodedPassword = employeeEntity1.getPassword();
            Boolean isPasswordRight = passwordEncoder.matches(password, encodedPassword);
            if (isPasswordRight) {
                Optional<EmployeeEntity> employee = employeeRepository.findOneByEmailAndPassword(login.getEmail(), encodedPassword);
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
