package com.oopsconcepts;

import java.util.ArrayList;
import java.util.List;

class College
{
    String name;
    private List<Teacher> teacher;
    public College(String name,List<Teacher> teacher)
    {
        this.name=name;
        this.teacher=teacher;
    }
    public List<Teacher> getTeachers()
    {
        return teacher;
    }
}
class Teacher
{
    String name;
    String subject;
    public Teacher(String name,String subject)
    {
        this.name=name;
        this.subject=subject;
    }

    @Override
    public String toString() {
        return "[Teacher :"+name+" ,subject : "+subject+"]";
    }
}
public class AggregationDemo {
    public static void main(String[] args) {
        List<Teacher> teachers=new ArrayList<Teacher>();
        teachers.add(new Teacher("Thilak","Java"));
        teachers.add(new Teacher("Nani","Python"));
        College college=new College("GRIET",teachers);
        System.out.println(college.getTeachers()) ;
    }
}
