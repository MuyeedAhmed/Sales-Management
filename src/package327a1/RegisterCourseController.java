/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package327a1;
import java.util.*;
/**
 *
 * @author Asus
 */
public class RegisterCourseController {
    Registration reg;
    CourseFactory cfact;
    public RegisterCourseController()
    {
        this.reg = new Registration();
        this.cfact = new CourseFactory();
    }
    
    public void makeNewRegistration()
    {
        this.reg=new Registration();
        this.cfact=new CourseFactory();
    }
    
    public void addCourse(String id)
    {
        reg.addCourse(cfact.getCourse(id));
        
    }
    
    public Registration getRegistration()
    {
        return this.reg;
    }
    
    public Course getCourse(String id)
    {
        return this.cfact.getCourse(id);
    }
    
    
}
