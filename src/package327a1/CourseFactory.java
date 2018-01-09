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
public class CourseFactory {
    LinkedList<Course> cList=new LinkedList<Course>();
    
    public CourseFactory(){
        
        Course c1=new Course();
        c1.setId("CSE327");
        c1.setTitle("Soft. Eng.");
        c1.setCredit(3);
        c1.setTuitionPerCredit(1500);
        cList.add(c1);
    
        Course c2 = new Course();
        c2.setId("CSE311");
        c2.setTitle("Database Management Systems");
        c2.setCredit(3);
        c2.setTuitionPerCredit(1500);
        cList.add(c2);
        
        Course c3 = new Course();
        c3.setId("CSE323");
        c3.setTitle("Operating Systems Design");
        c3.setCredit(3);
        c3.setTuitionPerCredit(1500);
        cList.add(c3);
        
        Course c4 = new Course();
        c4.setId("CSE331");
        c4.setTitle("Microprocessors");
        c4.setCredit(3);
        c4.setTuitionPerCredit(1500);
        cList.add(c4);
        
        Course c5 = new Course();
        c5.setId("CSE338");
        c5.setTitle("Computer Networks");
        c5.setCredit(3);
        c5.setTuitionPerCredit(1500);
        cList.add(c5);
        
        Course c6 = new Course();
        c6.setId("CSE440");
        c6.setTitle("Articial Intelligence");
        c6.setCredit(3);
        c6.setTuitionPerCredit(1500);
        cList.add(c6);
        
        Course c7 = new Course();
        c6.setId("CSE419");
        c6.setTitle("Data Mining");
        c6.setCredit(3);
        c6.setTuitionPerCredit(1500);
        cList.add(c6);
    
    }
    
    public Course getCourse(String id)
    {
        Course c=new Course();
        for(int i=0;i<cList.size();i++)
        {
            if(cList.get(i).getId().equals(id))
                c=cList.get(i);
        }
        return c;
        
    }
}
