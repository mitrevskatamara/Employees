package com.example.employees.web;

import com.example.employees.model.Employee;
import com.example.employees.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Controller
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public String showEmployees(Model model) {
        List<Employee> employees = employeeService.listAll();
        model.addAttribute("employees", employees);
        return "list";
    }

    @GetMapping("/employees/showAdd")
    public String showAdd(Model model) {
        List<String> types = new ArrayList<String>(2);
        types.add("MANAGER");
        types.add("VRABOTEN");
        model.addAttribute("types",types);
        return "form";
    }

    @GetMapping("/employees/{id}/edit")
    public String showEdit(@PathVariable String id,
                           Model model) {
        model.addAttribute("employees",this.employeeService.findById(id));
        return "form";
    }

    @PostMapping("/employees")
    public String createEmployee(@RequestParam String name,
                                 @RequestParam String email,
                                 @RequestParam String type,
                                 @RequestParam String employmentDate) {
        employeeService.create(name,email,type,LocalDate.parse(employmentDate));

        return "redirect:/employees";
    }

    @PostMapping("/employees/{id}")
    public String editEmployee(@PathVariable String id,
                               @RequestParam String name,
                               @RequestParam String email,
                               @RequestParam String type,
                               @RequestParam String employmentDate) {
        employeeService.update(id,name,email,type,LocalDate.parse(employmentDate));

        return "redirect:/employees";
    }

    @PostMapping("/employees/{id}/delete")
    public String deleteEmployee(@PathVariable String id) {
        employeeService.delete(id);

        return "redirect:/employees";
    }
}