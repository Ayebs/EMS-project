package kowri.java.emsbackend.service.impl;

import kowri.java.emsbackend.dto.EmployeeDTO;
import kowri.java.emsbackend.entity.Employee;
import kowri.java.emsbackend.exceptions.ResourceNotFoundException;
import kowri.java.emsbackend.mapper.EmployeeMapper;
import kowri.java.emsbackend.repository.EmployeeRepository;
import kowri.java.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with given id, " + employeeId + "does not exist"));

        return EmployeeMapper.mapToEmployeeDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDTO(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updatedEmployeeDetails) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Employee with given id, " + employeeId + ", does not exist"));

        employee.setFirstName(updatedEmployeeDetails.getFirstName());
        employee.setLastName(updatedEmployeeDetails.getLastName());
        employee.setEmail(updatedEmployeeDetails.getEmail());

        Employee updatedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDTO(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with given id, " + employeeId + ", does not exist"));

        employeeRepository.deleteById(employeeId);
    }

//    @Override
//    public EmployeeDTO updateEmployeeField(Long employeeId, String field, String value) {
//        Employee employee = employeeRepository.findById(employeeId)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee with given id, " + employeeId + "does not exist"));
//
//        switch (field) {
//            case "firstName":
//                employee.setFirstName(value);
//                break;
//            case "lastName":
//                employee.setLastName(value);
//                break;
//            default:
//                throw new ResourceNotFoundException("Invalid field:" + field);
//        }
//
//        Employee updatedField = employeeRepository.save(employee);
//
//        return EmployeeMapper.mapToEmployeeDTO(updatedField);
//    }
//}


}

