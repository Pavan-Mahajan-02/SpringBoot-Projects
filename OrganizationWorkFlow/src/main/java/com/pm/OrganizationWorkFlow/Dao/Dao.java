package com.pm.OrganizationWorkFlow.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pm.OrganizationWorkFlow.entity.Country;
import com.pm.OrganizationWorkFlow.entity.Employee;

@Repository
public class Dao {

	@Autowired
	SessionFactory factory;

	public String addcountry(Country c) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {

			session = factory.openSession();
			tx = session.beginTransaction();
			session.persist(c);
			tx.commit();
			msg = "Country Added Successfully...";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public String updatecountry(Country c, int id) {
		Session session = null;
		Transaction tx = null;
		Country country = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			country = session.get(Country.class, id);
			country.setCname(c.getCname());
			session.merge(country);
			tx.commit();
			msg = "Country Updated Successfully...";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();

			}
		}
		return msg;
	}

	public String deletecountry(int id) {
		Session session = null;
		Transaction tx = null;
		Country country = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			country = session.get(Country.class, id);
			session.remove(country);
			tx.commit();
			msg = "Country Deleted...";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			session.close();
		}
		return msg;

	}

	public List<Country> getallcountry() {
		Session session = null;
		Transaction tx = null;
		List<Country> clist = null;
		String hqlquery = "from Country";
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Query<Country> query = session.createQuery(hqlquery, Country.class);
			clist = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			session.close();
		}
		return clist;
	}

	public Country getpartucularrecordbyid(int id) {
		Session session = null;
		Transaction tx = null;
		Country country = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			country = session.get(Country.class, id);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return country;
	}

	public String addemployee(Employee e) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.persist(e);
			tx.commit();
			msg = "Employee Added Successfully...";
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;

	}

	public String updateemployee(Employee e, int id) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		Employee emp = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			emp = session.get(Employee.class, id);
			emp.setName(e.getName());
			emp.setStatus(e.getStatus());
			emp.setDepartment(e.getDepartment());
			emp.setMobileno(e.getMobileno());
			emp.setEmailid(e.getEmailid());
			emp.setCreatedBy(e.getCreatedBy());
			emp.setCreatedDate(e.getCreatedDate());
			emp.setUpdatedBy(e.getUpdatedBy());
			emp.setUpdatedDate(e.getUpdatedDate());
			emp.setSalary(e.getSalary());
			session.merge(emp);
			tx.commit();
			msg = "Employee Updated Successfully...";
		} catch (Exception e2) {
			if (tx != null) {
				tx.rollback();
			}
			e2.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public String deleteemployee(int id) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Employee emp = session.get(Employee.class, id);
			session.remove(emp);
			tx.commit();
			msg = "Employee Is Deleted...";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
	}

	public List<Employee> getallemployee() {
		Session session = null;
		Transaction tx = null;
		List<Employee> elist = null;
		String hqlquery = "from Employee";
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Query<Employee> query = session.createQuery(hqlquery, Employee.class);
			elist = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			session.close();
		}
		return elist;
	}

	public Employee getparticularemployeeByid(int id) {
		Session session = null;
		Transaction tx = null;
		Employee employee = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			employee = session.get(Employee.class, id);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			session.close();
		}
		return employee;
	}

	public Employee login(Employee emp) {
		Session session = null;
		Transaction tx = null;
		Employee employee = null;
		String hqlquery = "from Employee where emailid=:emailid and mobileno=:mobileno ";
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Query<Employee> query = session.createQuery(hqlquery,Employee.class);
			query.setParameter("emailid", emp.getEmailid());
			query.setParameter("mobileno", emp.getMobileno());
			employee = query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return employee;
	}

	public List<Employee> salaryrange(double startsal, double endsal) {
		Session session = null;
		Transaction tx = null;
		List<Employee> list= null;
		String hqlquery = "from Employee where salary between :startsal and :endsal";
		try {

			session = factory.openSession();
			tx = session.beginTransaction();
			Query<Employee> query = session.createQuery(hqlquery, Employee.class);
			query.setParameter("startsal", startsal);
			query.setParameter("endsal", endsal);
			list=query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	
	}

}
