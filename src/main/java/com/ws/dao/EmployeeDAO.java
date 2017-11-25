package com.ws.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ws.entity.Employee;
import com.ws.repository.EmployeeRepository;

@Repository
@Transactional(propagation=Propagation.REQUIRED)
public class EmployeeDAO extends GenericDAO<Employee> implements EmployeeRepository {

	public List<Employee> listAll() {
		Criteria criteria = super.getCurrentSession().createCriteria(Employee.class);
        List<Employee> result = (List<Employee>) criteria.list();
        return result;
	}
	
	public Employee findById(int id){
		Employee employee = (Employee) super.getCurrentSession().get(Employee.class, id);
		return employee;
	}

}
