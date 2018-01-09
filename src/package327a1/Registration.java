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
public class Registration {
    int total = 0;
    LinkedList<Course> courseList=new LinkedList<Course>();
    
    public LinkedList<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(LinkedList<Course> courseList) {
        this.courseList = courseList;
    }
    
    public void addCourse(Course ci)
    {
        
        System.out.println(ci.getSubTotal());
        
        courseList.add(ci);
        total += ci.getSubTotal();
        //System.out.println(courseList.get(0).credit);
    }
    
    public int getTotal()
    {
        
        //for(int i=0;i<courseList.size();i++)
        //{
            //System.out.println(courseList.size());
            //total += courseList.get(i).getSubTotal();
            //System.out.println(total);
        //}
        return total;
    }
        
}
    

