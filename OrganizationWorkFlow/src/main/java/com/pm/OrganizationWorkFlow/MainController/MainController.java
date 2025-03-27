package com.pm.OrganizationWorkFlow.MainController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pm.OrganizationWorkFlow.Service.Service;
import com.pm.OrganizationWorkFlow.entity.Country;
import com.pm.OrganizationWorkFlow.entity.Employee;

@RestController
@RequestMapping("admin")
public class MainController {
	@Autowired
	Service service;
	
	
	@PostMapping("addcountry")
	public ResponseEntity<String> addcountry(@RequestBody Country c) {
		String msg = service.addcountry(c);
		return ResponseEntity.ok(msg);
	}
	
	@PutMapping("updatecountry/{id}")
	public ResponseEntity<String> updatecountry(@RequestBody Country c, @PathVariable int id) {
		String msg = service.updatecountry(c, id);
		return ResponseEntity.ok(msg);
	}

	@DeleteMapping("deletecountry/{id}")
	public ResponseEntity<String> deletecountry(@PathVariable int id) {
		String msg =service.deletecountry(id);
		return ResponseEntity.ok(msg);
	}
	
	@GetMapping("getallcountry")
	public ResponseEntity<List<Country>> getallcountry() {
		List<Country> clist = service.getallcountry();
		return ResponseEntity.ok(clist);	
	}
	
	@GetMapping("getpartucularrecordbyid/{id}")
	public ResponseEntity<Country> getpartucularrecordbyid(@PathVariable int id){
		Country msg =service.getpartucularrecordbyid(id);
		return ResponseEntity.ok(msg);	
		
	}
	
	@PostMapping("addemployee")
	public ResponseEntity<String> addemployee(@RequestBody Employee e){
		String msg = service.addemployee(e);
		
		return ResponseEntity.ok(msg);	
	}
	@PutMapping("updateemployee/{id}")
	public ResponseEntity<String> updateemployee(@RequestBody Employee e, @PathVariable int id){
		String msg = service.updateemployee(e,id);
		return ResponseEntity.ok(msg);
	}
	@DeleteMapping("deleteemployee/{id}")
	public ResponseEntity<String> deleteemployee(@PathVariable int id){
		String msg = service.deleteemployee(id);
		return ResponseEntity.ok(msg);	
	}
	
	@GetMapping("getallemployee")
	public ResponseEntity<List<Employee>> getallemployee(){
		List<Employee> elist = service.getallemployee();
		return ResponseEntity.ok(elist);	
	}
	
	@GetMapping("getparticularemployeeByid/{id}")
	public ResponseEntity<Employee> getparticularemployeeByid(@PathVariable int id){
		Employee msg = service.getparticularemployeeByid(id);
		return ResponseEntity.ok(msg);
		
	}
	
	@PostMapping("login")
	public ResponseEntity<Map> login(@RequestBody Employee emp){
		Map map = service.login(emp);
		return ResponseEntity.ok(map);
		
	}
	
	@GetMapping("salaryrange/{startsal}/{endsal}")
	public ResponseEntity<List<Employee>> salaryrange(@PathVariable double startsal, @PathVariable double endsal ){
		List<Employee> list = service.salaryrange(startsal,endsal);
		return ResponseEntity.ok(list);
	}
}
		

