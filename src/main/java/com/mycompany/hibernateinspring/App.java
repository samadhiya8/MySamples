package com.mycompany.hibernateinspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        ApplicationContext ctx = new AnnotationConfigApplicationContext(DataSourceConfig.class);
        //Employee e= (Employee)ctx.getBean("Ramesh");
        //BetterEmployeeDAO Edao=  ctx.getBean(BetterEmployeeDAO.class);
        //Edao.addEmployee(e);
        //Employee e1=Edao.getEmployeeById(110);
        //System.out.println(e1);
        //Employee hEmp=(Employee)ctx.getBean(Employee.class);
        System.out.println("Step 1");
        //EmployeeDAO dao=(EmployeeDAO)ctx.getBean("eDAO");
        EmployeeDAO hdao = ctx.getBean(EmployeeDAO.class);
        System.out.println("Step 2");
        System.out.println(hdao.getEmployeeById(500));
        //hdao.insertEmployee(hEmp);
        System.out.println("Step 3");
        int i=0;
        for(Employee e: hdao.getEmployeeList()){
        	System.out.println(++i +" "+ e);
        }
        //com.umc.HibernateEx.Employee e1= hdao.getEmployeeByNumer(110);
        //System.out.println(e1);
    }
}
