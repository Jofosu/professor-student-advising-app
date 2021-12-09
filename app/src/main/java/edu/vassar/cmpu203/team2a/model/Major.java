package edu.vassar.cmpu203.team2a.model;

import com.google.firebase.firestore.Exclude;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Major implements Serializable {

    // A Hashmap that contains the pools of a major and the different courses in each pool.
    private Map<String, Pool> major = new HashMap<>();

    public Major(){}

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
     * Remove a Pool in a Major
     * @param poolName the name of the pool being removed
     * @return true/false if the the Pool was removed from a Major
     */
    public boolean removePool(String poolName){
        major.remove(poolName);
        return !major.containsKey(poolName);
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
    public Map<String, Pool> getMajor(){
        return major;
    }
    /**
     * Set the number of required courses of a Pool in a Major
     * @param numOfRequiredCourses  number of? course that is added to a pool in a major
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
         if(pool == null)
             return false;
         return pool.poolList.remove(courseToRemove);
//         return !pool.poolList.contains(courseToRemove);
    }

    @Exclude
    public Set<String> getPools(){return major.keySet();}
    /**
     * An inner class that represents the list of courses group into one category called a Pool.
     */
    public class Pool implements Serializable{


        private int numOfRequiredCourses;
        private List<Course> poolList = new ArrayList<>();
        private String poolName;

        public Pool(){}

        public Pool(String poolName){
            this.poolName = poolName; }

        public int getNumOfRequiredCourses(){
            return numOfRequiredCourses;
        }
        public List<Course> getpoolList(){return this.poolList;}
        public String getpoolName(){return poolName;}

    }

}
