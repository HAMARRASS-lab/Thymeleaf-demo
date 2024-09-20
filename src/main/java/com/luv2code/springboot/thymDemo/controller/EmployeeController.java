package com.luv2code.springboot.thymDemo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.luv2code.springboot.thymDemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymDemo.entity.Employee;
import com.luv2code.springboot.thymDemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeService theEmployeeService,
                              EmployeeRepository employeeRepository) {
        employeeService = theEmployeeService;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        List<Employee> theEmployees = employeeService.findAll();
        // add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee", theEmployee);
        return "employees/employee-form";
    }
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel){

		Employee theEmployee = employeeService.findById(theId);

		// Add the employee to the model
		theModel.addAttribute("employee", theEmployee);
//		Map<String, Object> attributes = new HashMap<>();
//		attributes.put("employee", theEmployee);
//		theModel.mergeAttributes(attributes);
		return "employees/employee-form";
	}
    @GetMapping("/showFormForDelete")
    public String showFormForDelete(@RequestParam("employeeId") int theId){

        employeeRepository.deleteById(theId);
        return "redirect:/employees/list";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmp) {
        // No need to re-set the employee attributes here, as @ModelAttribute already binds form data to the object
        employeeRepository.save(theEmp);
        return "redirect:/employees/list";  // Redirect to the employees list or a success page
    }

    // load employee data

//	private List<Employee> theEmployees;
//
//	@PostConstruct
//	private void loadData() {
//
//		// create employees
//		Employee emp1 = new Employee(1, "Leslie", "Andrews", "leslie@luv2code.com");
//		Employee emp2 = new Employee(2, "Emma", "Baumgarten", "emma@luv2code.com");
//		Employee emp3 = new Employee(3, "Avani", "Gupta", "avani@luv2code.com");
//
//		// create the list
//		theEmployees = new ArrayList<>();
//
//		// add to the list
//		theEmployees.add(emp1);
//		theEmployees.add(emp2);
//		theEmployees.add(emp3);
//
//	}

    // add mapping for "/list"


}









