package net.javaguides.ems.controller;




import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.javaguides.ems.entity.Employee;

@Controller // Controller Layer holds all Spring MVC Controllers
public class EmployeeController {
	
	@Autowired
	EmployeeDao employeeDao;
	

	/*
	 * @GetMapping("/") //from this method will call findPaginated method -> this
	 * will return paginated Employees. public String viewHomePage(Model model) {
	 * return findPaginated(1, model); }
	 */


	//handler method to handle list employees and return mode and view
	/*
	 * @GetMapping("/employees") public String listEmployees(Model model) {
	 * model.addAttribute("employees", employeeDao.getAllEmployees()); return
	 * "employees"; }
	 */
	
	 @RequestMapping("/employees")    
	    public String listEmployees(Model m){    
	        List<Employee> list=employeeDao.getAllEmployees(); 
	       
	        System.out.println("Size" + list.size());
	        m.addAttribute("list",list);
	        m.addAttribute("employees",list);
	        
	        
	        return "employees";    
	    }    
	
		/*
		 * @GetMapping("/employees/new") public String createEmployeeForm(Model model) {
		 * //Create empty employee object to hold employee form data Employee employee =
		 * new Employee(); model.addAttribute("employee", employee); return
		 * "create_employee"; }
		 */
	
	 @RequestMapping("/employees/new")    
	    public String createEmployeeForm(Model m){   
		 List<Map<String,Object>> data = employeeDao.getWorkAt(); 
	        m.addAttribute("employee", new Employee()); 
	        m.addAttribute("workatdropdown",data);
	        //System.out.println("Name :"+data.size()+"::"+data.get(0).get("id")+"::"+data.get(0).get("CompanyName"));
	        
	        
	        return "create_employee";   
	    }    
	
		/*
		 * @PostMapping("/employees") public String
		 * saveEmployee(@ModelAttribute("employee") Employee employee, BindingResult
		 * bindingResult) { //Here, we r using ModelAttribute to directly bind form data
		 * to the employee object.
		 * 
		 * if (bindingResult.hasErrors()) { return "create_employee"; } else {
		 * employeeDao.saveEmployee(employee); return "redirect:/employees"; } }
		 */
	
	@RequestMapping(value="/employees",method = RequestMethod.POST)    
    public String saveEmployee(@ModelAttribute("employee")  Employee employee){    
		employeeDao.saveEmployee(employee);    
        return "redirect:/employees";    
    }    
	
	/*
	 * @GetMapping("/employees/edit/{id}") public String
	 * editEmployeeForm(@PathVariable Long id, Model model) //PathVariable
	 * Annotation is to get the id. { model.addAttribute("employee",
	 * employeeDao.getEmployeeById(id)); return "edit_employee"; }
	 */
	
	@RequestMapping(value="/employees/edit/{id}")    
    public String editEmployeeForm(@PathVariable Long id, Model m){    
		//Long id = Long.parseLong(id);
		Employee employee = employeeDao.getEmployeeById(id);   
        m.addAttribute("command",employee);  
        m.addAttribute("employee",employee);  
        
        List<Map<String,Object>> data = employeeDao.getWorkAt(); 
       // m.addAttribute("employee", new Employee()); 
        m.addAttribute("workatdropdown",data);
        
        return "edit_employee";    
    }    
	
	@RequestMapping(value="/employees/department/{id}")    
    public String getDepartment(@PathVariable Long id, Model m){    
		 List<Map<String,Object>> data1 = employeeDao.getWorkAt(); 
	        m.addAttribute("employee", new Employee()); 
	        m.addAttribute("workatdropdown",data1);
		 List<Map<String,Object>> data = employeeDao.getDepartment(id); 
		 System.out.println("Name :"+data.size()+"::"+data.get(0).get("id")+"::"+data.get(0).get("departmentname"));
        return "create_employee";   
    }   
	@RequestMapping(value="/employees/departments/{id}")   
	@ResponseBody
    public List<Map<String,Object>> getDepartments(@PathVariable Long id, Model m){    
		
		 List<Map<String,Object>> data = employeeDao.getDepartment(id); 
		 System.out.println("Name :"+data.size()+"::"+data.get(0).get("id")+"::"+data.get(0).get("departmentname"));
        return data;   
    }   
	
	/*  @PostMapping("/employees/{id}") 
	  public String updateEmployee(@PathVariable  Long id,  @ModelAttribute("employee") 
	  Employee employee, BindingResult bindingResult,  Model model) {
	  // save updated employee object 
		  if  (bindingResult.hasErrors()) 
		  { 
			  return  "create_employee"; 
	  } 
	else 
	  { // get employee from database by id Employee
	  existingEmployee = employeeDao.getEmployeeById(id);
	  existingEmployee.setId(id);
	  existingEmployee.setFirstName(employee.getFirstName());
	  existingEmployee.setLastName(employee.getLastName());
	  existingEmployee.setEmail(employee.getEmail());
	  existingEmployee.setGender(employee.getGender());
	  existingEmployee.setMarriage(employee.getMarriage());
	  existingEmployee.setBirthday(employee.getBirthday());
	  existingEmployee.setWorkat(employee.getWorkat());
	  existingEmployee.setDepartment(employee.getDepartment());
	  
	  employeeDao.updateEmployee(existingEmployee); 
	  return "redirect:/employees"; 
	  }
	  
	  } */
	 
	
	@RequestMapping(value="/employees/{id}",method = RequestMethod.POST)    
    public String updateEmployee(@PathVariable("id") Long id, @ModelAttribute("employee") Employee employee)
    		
	{ 
		//Long id = Long.parseLong(id);
		employee.setId(id);
	  employeeDao.updateEmployee(employee); 
	  return "redirect:/employees"; 
	}
       
        
	
	// handler method to handle delete employee request
	
	/*
	 * @GetMapping("/employees/{id}") public String deleteEmployee(@PathVariable
	 * Long id) { employeeDao.deleteEmployeeById(id); return "redirect:/employees";
	 * }
	 */
	
	@RequestMapping(value="/employees/{id}",method = RequestMethod.GET)    
    public String deleteEmployee(@PathVariable Long id){    
        employeeDao.deleteEmployeeById(id);    
        return "redirect:/employees";    
    }     
	
	/*
	 * @GetMapping("/page/{pageNo}") public String findPaginated(@PathVariable
	 * (value = "pageNo") int pageNo, Model model) { int pageSize = 5;
	 * 
	 * Page<Employee> page = employeeService.findPaginated(pageNo, pageSize);
	 * List<Employee> listEmployees = page.getContent();
	 * 
	 * model.addAttribute("currentPage", pageNo); model.addAttribute("totalPages",
	 * page.getTotalPages()); model.addAttribute("totalItems",
	 * page.getTotalElements()); model.addAttribute("listEmployees", listEmployees);
	 * 
	 * return "index";
	 * 
	 * 
	 * }
	 */
	
	/*
	 * @GetMapping("/employees/export/") public void exportToPDF(HttpServletResponse
	 * response) throws DocumentException, IOException {
	 * response.setContentType("application/pdf");
	 * 
	 * DateFormat dateFormatter = new SimpleDateFormat("yyyy-mm-dd_HH:mm:ss");
	 * String currentDateTime = dateFormatter.format(new Date());
	 * 
	 * String headerKey = "Content-Disposition"; String headerValue =
	 * "attachment; filename=employees_" + currentDateTime + ".pdf";
	 * 
	 * response.setHeader(headerKey, headerValue);
	 * 
	 * List<Employee> listEmployees = employeeService.getAllEmployees();
	 * 
	 * EmployeesPDFExporter exporter = new EmployeesPDFExporter(listEmployees);
	 * exporter.export(response); }
	 * 
	 * 
	 * @GetMapping("/employee/export/{id}") public void
	 * exportemployeeToPDF(@PathVariable(name = "id") long id,HttpServletResponse
	 * response) throws DocumentException, IOException {
	 * response.setContentType("application/pdf");
	 * 
	 * DateFormat dateFormatter = new SimpleDateFormat("yyyy-mm-dd_HH:mm:ss");
	 * String currentDateTime = dateFormatter.format(new Date());
	 * 
	 * String headerKey = "Content-Disposition"; String headerValue =
	 * "attachment; filename=employees_" + currentDateTime + ".pdf";
	 * 
	 * response.setHeader(headerKey, headerValue);
	 * 
	 * Employee employee = employeeService.getEmployeeById(id);
	 * 
	 * EmployeePDFExporter exporter = new EmployeePDFExporter(employee);
	 * exporter.export(response); }
	 * 
	 */
	
	
	



}
