package edu.vassar.cmpu203.team2a.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Major {

    // A Hashmap that contains the pools of a major and the different courses in each pool.
    public static HashMap<String, List> major = new HashMap<>();

    public Major(){

    }
    //
    public void  createPool(String name){
        List pool = new ArrayList();
        major.put(name, pool);
    }

    public static boolean addCourse(Course courseToAdd, String pool){
        List poolOfCourses = major.get(pool);
        poolOfCourses.add(courseToAdd);
        major.put(pool,poolOfCourses);
        return major.containsKey(pool) && major.get(pool).contains(courseToAdd);
    }


}
