/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hrcrud.jsf.model;

import edu.hrcrud.dao.HRDao;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author giovanni
 */
@ManagedBean
@RequestScoped
public class Department implements Serializable {
    
    private int departmentId;
    private String departmentName;
    
    private int managerId;
    private int locationId;
    
    @PostConstruct
    private void initBean() {
        Department dep = (Department) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getFlash()
                .get("department");
        
        if(dep != null) {
            System.out.println("Dep transferido");
            this.setDepartmentId(dep.getDepartmentId());
            this.setDepartmentName(dep.getDepartmentName());
            this.setManagerId(dep.getManagerId());
            this.setLocationId(dep.getLocationId());
        }
        else {
            System.out.println("Dep NOT transfered");
        }
    }
    
    /**
     * Inserts this department to the database
     * and returns the index page or department
     * 
     * @return 
     */
    public String insert() {
        HRDao hrDao = new HRDao();
        hrDao.insertDepartment(this);
        
        return "index";
    }
    
    public String update() {
        HRDao hrDao = new HRDao();
        hrDao.updateDepartment(this);
        
        return "index";
    }
    
    public String loadAndEdit() {
        HRDao hrDao = new HRDao();
        System.out.println("Preparing for edit");
        return "edit";
    }

    /**
     * @return the departmentId
     */
    public int getDepartmentId() {
        return departmentId;
    }

    /**
     * @param departmentId the departmentId to set
     */
    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * @return the departmentName
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * @param departmentName the departmentName to set
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * @return the managerId
     */
    public int getManagerId() {
        return managerId;
    }

    /**
     * @param managerId the managerId to set
     */
    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    /**
     * @return the locationId
     */
    public int getLocationId() {
        return locationId;
    }

    /**
     * @param locationId the locationId to set
     */
    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }
    
    
    
}
