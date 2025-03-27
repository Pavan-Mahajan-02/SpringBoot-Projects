package com.pm.OrganizationWorkFlow.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import com.pm.OrganizationWorkFlow.Dao.Dao;
import com.pm.OrganizationWorkFlow.entity.Country;
import com.pm.OrganizationWorkFlow.entity.Employee;

@org.springframework.stereotype.Service
public class Service {

	@Autowired
	Dao dao;

	public String addcountry(Country c) {
		String msg = dao.addcountry(c);
		if (Objects.isNull(msg)) {
			msg="Country Not Added...";
			
		}
		
		return msg;
	}

	public String updatecountry(Country c, int id) {
		String msg = dao.updatecountry(c, id);
		if (Objects.isNull(msg)) {
			msg="Country Not Updated...";
		}
		return msg;
	}

	public String deletecountry(int id) {
		String msg = dao.deletecountry(id);
		if (Objects.isNull(msg)) {
			msg="Country Not Deleted...";
		}

		return msg;
	}

	public List<Country> getallcountry() {
		List<Country> clist = dao.getallcountry();
		return clist;
		
		
	}

	public Country getpartucularrecordbyid(int id) {
		Country msg = dao.getpartucularrecordbyid(id);
		return msg;
	}

	public String addemployee(Employee e) {
		String msg = dao.addemployee(e);
		if (Objects.isNull(msg)) {
			msg="Employee Not Added...";
		}
		return msg;
	}

	public String updateemployee(Employee e, int id) {
		String msg = dao.updateemployee(e,id);
		if (Objects.isNull(msg)) {
			msg="Employee Not Updated...";
		}
		return msg;
	}

	public String deleteemployee(int id) {
		String msg = dao.deleteemployee(id);
		if (Objects.isNull(msg)) {
			msg="Employee Not Deleted...";
		}
		return msg;
	}

	public List<Employee> getallemployee() {
	List<Employee> elist =dao.getallemployee();
	
		return elist;
	}

	public Employee getparticularemployeeByid(int id) {
		Employee msg = dao.getparticularemployeeByid(id);
		
		return msg;
	}

	public Map login(Employee emp) {
	 Employee obj = dao.login(emp);
	 Map map = new HashMap();
	 if (Objects.isNull(obj)) {
		 map.put("msg", "InValid User");
		 map.put("user", obj);
		
	}else {
		map.put("msg", "Valid User");
		 map.put("user", obj);

	}
		return map;
	}

	public List<Employee> salaryrange(double startsal, double endsal) {
		List<Employee> list = dao.salaryrange(startsal,endsal);
		return list;
	}

}
