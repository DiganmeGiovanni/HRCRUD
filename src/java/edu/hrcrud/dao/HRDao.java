/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hrcrud.dao;

import edu.hrcrud.db.DBConnection;
import edu.hrcrud.jsf.model.Department;
import edu.hrcrud.jsf.model.Employee;
import edu.hrcrud.jsf.model.Location;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author giovanni
 */
public class HRDao {
    
    private final Connection conn = DBConnection.getConnection();
    
    public List<Department> listAllDepartments() {
        List<Department> departments = new ArrayList<>();
        
        try {
        
            PreparedStatement ps = conn.prepareStatement(SQLUtils.queryAllDepartmentsSQL());
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                int departmentId = rs.getInt(1);
                String departmentName = rs.getString(2);
                int managerId = rs.getInt(3);
                int locationId = rs.getInt(4);

                Department department = new Department();
                department.setDepartmentId(departmentId);
                department.setDepartmentName(departmentName);
                department.setManagerId(managerId);
                department.setLocationId(locationId);
                
                departments.add(department);
            }
        }
        catch(SQLException e) {
            System.err.println("Fatal querying departments");
            System.err.println(e.getMessage());
        }
        
        return departments;
        
    }
    
    public void insertDepartment(Department department) {
        try {
            
            PreparedStatement ps = conn.prepareCall(SQLUtils.insertDepartmentSQL());
            ps.setInt(1, department.getDepartmentId());
            ps.setString(2, department.getDepartmentName());
            ps.setInt(3, department.getManagerId());
            ps.setInt(4, department.getLocationId());
            
            ps.executeUpdate();
        }
        catch(SQLException e) {
            System.err.println("Fatal inserting department");
            System.err.println(e.getMessage());
        }
    }
    
    public void loadDepartment(Department department) {
        
    }
    
    public List<Employee> listAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        
        try {
        
            PreparedStatement ps = conn.prepareStatement(SQLUtils.queryAllEmployeesSQL());
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                int employeeId = rs.getInt(1);
                String employeeFirstName = rs.getString(2);
                String employeeLastName = rs.getString(3);

                Employee employee = new Employee();
                employee.setEmployeeId(employeeId);
                employee.setFirstName(employeeFirstName);
                employee.setLastName(employeeLastName);
                
                employees.add(employee);
            }
        }
        catch(SQLException e) {
            System.err.println("Fatal querying employees");
            System.err.println(e.getMessage());
        }
        
        return employees;
        
    }
    
    public List<Location> listAllLocation() {
        List<Location> locations = new ArrayList<>();
        
        try {
        
            PreparedStatement ps = conn.prepareStatement(SQLUtils.queryAllLocationsSQL());
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Location loc = new Location();
                loc.setLocationId(rs.getInt(1));
                loc.setAddress(rs.getString(2));
                loc.setPostalCode(rs.getString(3));
                loc.setCity(rs.getString(4));
                loc.setState(rs.getString(5));

                locations.add(loc);
            }
        }
        catch(SQLException e) {
            System.err.println("Fatal querying locations");
            System.err.println(e.getMessage());
        }
        
        return locations;
        
    }

    public void updateDepartment(Department department) {
        try {
            
            PreparedStatement ps = conn.prepareCall(SQLUtils.updateDepartmentSQL());
            ps.setString(1, department.getDepartmentName());
            ps.setInt(2, department.getManagerId());
            ps.setInt(3, department.getLocationId());
            
            ps.setInt(4, department.getDepartmentId());
            
            ps.executeUpdate();
        }
        catch(SQLException e) {
            System.err.println("Fatal updating department");
            System.err.println(e.getMessage());
        }
    }
    
}
