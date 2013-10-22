/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernateinspring;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Samadhiya
 */
@Entity
@Table(name="employee")
public class Employee implements Serializable {
    //private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int empNo;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "deptId")
    private int deptId;
    @Column(name = "post")
    private String post;
    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.empNo;
        hash = 79 * hash + this.age;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (this.empNo != other.empNo) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        return true;
    }

   
    

    
    @Override
    public String toString() {
        return "Employee{" + "empNo=" + empNo + ", name=" + name + ", age=" + age + ", deptId=" + deptId + ", post=" + post + '}';
    }

    

    
    
}
