/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hrcrud.dao;

/**
 *
 * @author giovanni
 */
public class SQLUtils {
    
    public static String queryAllDepartmentsSQL() {
        
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("SELECT * ");
        sqlBuilder.append("FROM DEPARTMENTS");
        
        return sqlBuilder.toString();
    }
    
    public static String queryAllEmployeesSQL() {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("SELECT * ");
        sqlBuilder.append("FROM EMPLOYEES");
        
        return sqlBuilder.toString();
    }
    
    public static String insertDepartmentSQL() {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("INSERT INTO DEPARTMENTS VALUES(?, ?, ?, ?)");
        
        return sqlBuilder.toString();
    }
    
    public static String queryAllLocationsSQL() {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("SELECT * ");
        sqlBuilder.append("FROM LOCATIONS");
        
        return sqlBuilder.toString();
    }

    static String updateDepartmentSQL() {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("UPDATE DEPARTMENTS SET DEPARTMENT_NAME=?, MANAGER_ID=?, LOCATION_ID=? WHERE DEPARTMENT_ID=?");
        
        return sqlBuilder.toString();
    }
    
}
