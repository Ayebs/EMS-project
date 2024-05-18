package kowri.java.emsbackend.service;

import kowri.java.emsbackend.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeById(Long employeeId);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updatedEmployeeDetails);

//    EmployeeDTO updateEmployeeField(Long employeeId, String field, String value);

    void deleteEmployee(Long employeeId);
}
