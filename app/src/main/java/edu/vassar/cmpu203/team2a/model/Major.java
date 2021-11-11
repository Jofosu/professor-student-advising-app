package edu.vassar.cmpu203.team2a.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Major {

    // A Hashmap that contains the pools of a major and the different courses in each pool.
    private static final HashMap<String, List> major = new HashMap<>();

    /**
     * Creates a Pool in a Major
     * @param poolName A course that is added to a pool in a major
     * @return true/false if the the Pool was added to a Major
     */
    public boolean  createPool(String poolName){
        major.put(poolName, new ArrayList());
        return major.containsKey(poolName);
    }
    /**
     * Adds courses to a Pool in a Major
     * @param courseToAdd A course that is added to a pool in a major
     * @param pool A list of courses that are either optional or required for a major
     * @return true/false if the the course was added to an existing pool
     */
    public boolean addCourse(Course courseToAdd, String pool){
        List poolOfCourses = major.get(pool);
        poolOfCourses.add(courseToAdd);
        major.put(pool,poolOfCourses);
        return major.containsKey(pool) && Objects.requireNonNull(major.get(pool)).contains(courseToAdd);
    }
    /**
     *
     * @return The major as a Hashmap of Pools and List of courses in each pool.
     */
    public HashMap getMajor(){
        return major;
    }



}
