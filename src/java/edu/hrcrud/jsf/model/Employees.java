/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hrcrud.jsf.model;

import edu.hrcrud.dao.HRDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author giovanni
 */
@ManagedBean
@SessionScoped
public class Employees {
    
    private final HRDao hrDao = new HRDao();
    
    public Employees() { }
    
    public List<Employee> getAllEmployees() {
        return hrDao.listAllEmployees();
    }
    
}
