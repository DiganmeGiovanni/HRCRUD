/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hrcrud.jsf.model;

import edu.hrcrud.dao.HRDao;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author giovanni
 */
@ManagedBean(name = "departments")
@SessionScoped
public class Departments implements Serializable {

    private final HRDao hrDao = new HRDao();
    
    public Departments() { }
    
    public List<Department> getAllDepartments() {
        return hrDao.listAllDepartments();
    }
    
}
