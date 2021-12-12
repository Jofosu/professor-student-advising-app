package edu.vassar.cmpu203.team2a.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A class that represents the list of courses group into one category called a Pool.
 */
public class Pool implements Serializable {


    int numOfRequiredCourses;
    ArrayList<Course> poolList = new ArrayList<>();
    String poolName;

    /**
     * Empty pool constructor
     */
    public Pool() {
    }

    public Pool(String poolName) {
        this.poolName = poolName;
    }


    /**
     * gets number of required courses in a pool
     *
     * @return int value of number of required courses in a pool
     */
    public int getNumOfRequiredCourses() {
        return numOfRequiredCourses;
    }

    /**
     * gets list of all pools
     *
     * @return array list of all pools
     */
    public ArrayList<Course> getpoolList() {
        return this.poolList;
    }

    /**
     * gets a pools name
     *
     * @return string value of pools name
     */
    public String getpoolName() {
        return poolName;
    }

    /**
     * Adds a course to a pool using course
     *
     * @param course course class
     */
    public void addPoolCourse(Course course) {
        this.poolList.add(course);
    }

    /**
     * Removes a course to a pool using course
     *
     * @param course course class
     */
    public void removePoolCourse(Course course) {
        this.poolList.remove(course);

    }

}

