package edu.vassar.cmpu203.team2a.model;

import java.util.HashMap;
import java.util.List;

public class Major {

    // A Hashmap that contains the pools of a major and the different courses in each pool.
    private static final HashMap<String, Pool> major = new HashMap<>();

    /**
     * Creates a Pool in a Major
     * @param poolName A course that is added to a pool in a major
     * @return true/false if the the Pool was added to a Major
     */
    public boolean createPool(String poolName){
        Pool newPool = new Pool(poolName);
        major.put(poolName, newPool);
        return major.containsKey(poolName);
    }
    /**
     * Adds courses to a Pool in a Major
     * @param courseToAdd A course that is added to a pool in a major
     * @param poolName The name of a pool in a major
     * @return true/false if the the course was added to an existing pool
     */
    public boolean addCourse(Course courseToAdd, String poolName){
        Pool pool = major.get(poolName);
        pool.poolList.add(courseToAdd);
        major.put(poolName,pool);
        return major.get(poolName).poolList.contains(courseToAdd);
    }
    /**
     *
     * @return The major as a Hashmap of Pools and List of courses in each pool.
     */
    public HashMap getMajor(){
        return major;
    }
    /**
     * Set the number of required courses of a Pool in a Major
     * @param numOfRequiredCourses  course that is added to a pool in a major
     * @param  poolName The name of a pool in a major
     *
     */
    public void setRequiredPoolCourses(int numOfRequiredCourses,String poolName){
        major.get(poolName).numOfRequiredCourses = numOfRequiredCourses;
    }
    /**
     * Remove a course in a Pool in a Major
     * @param courseToRemove A course that is suppose to be removed from a pool in a major
     * @param poolName The name of a pool in a major
     * @return true/false if the the course was removed from a existing pool
     */
    public boolean removeCourse(Course courseToRemove, String poolName){
         Pool pool = major.get(poolName);
         pool.poolList.remove(courseToRemove);
         return !pool.poolList.contains(courseToRemove);
    }
    /**
     * An inner class that represents the list of courses group into one category called a Pool.
     */
    public class Pool{

        private int numOfRequiredCourses;
        private List<Course> poolList;
        private String poolName;
        public Pool(String poolName){
            this.poolName = poolName;
        }

    }


}
