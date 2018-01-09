/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package327a1;

/**
 *
 * @author Asus
 */
public class Course {
    String id=new String();
    String title=new String();
    int credit;
    int tuitionPerCredit;
    
    Course()//constructor
    {
        this.id = "";
        this.title = "";
        this.credit = 0;
        this.tuitionPerCredit = 0;
    }
    
    Course(String a, String b, int c, int d)//constructor
    {
        this.id = a;
        this.title = b;
        this.credit = c;
        this.tuitionPerCredit = d;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getTuitionPerCredit() {
        return tuitionPerCredit;
    }

    public void setTuitionPerCredit(int tuitionPerCredit) {
        this.tuitionPerCredit = tuitionPerCredit;
    }
    
    public int getSubTotal(){
        return (this.credit*this.tuitionPerCredit);
    }
    
}
