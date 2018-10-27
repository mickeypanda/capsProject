package com.dev.caps;

import java.util.Scanner;

import com.dev.caps.beans.Person;
import com.dev.caps.model.HibernateImpl;
import com.dev.caps.model.JdbcImpl;
import com.dev.caps.model.PersonDAO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       System.out.println("Enter person details...");
       System.out.println("------------------------");
       Scanner in=new Scanner(System.in);
       Person person=new Person();
       
       System.out.println("Enter the id: ");
       person.setPerId(Integer.parseInt(in.nextLine()));
       
       System.out.println("Enter the name: ");
       person.setName(in.nextLine());
       
       System.out.println("Enter the email: ");
       person.setEmail(in.nextLine());
       
       System.out.println("Enter the age: ");
       person.setAge(Integer.parseInt(in.nextLine()));
       
       System.out.println("Enter the address: ");
       person.setAddress(in.nextLine());
       
       PersonDAO pd=new JdbcImpl();
       //PersonDAO pd=new HibernateImpl();
       pd.create(person);
    }
}
