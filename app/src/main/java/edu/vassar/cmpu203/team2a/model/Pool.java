package edu.vassar.cmpu203.team2a.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * An inner class that represents the list of courses group into one category called a Pool.
 */
public class Pool implements Serializable {


    public int numOfRequiredCourses;
    public List<Course> poolList = new ArrayList<>();
    public String poolName;

    public Pool(){}

    public Pool(String poolName){
        this.poolName = poolName;
    }

    public int getNumOfRequiredCourses(){
        return numOfRequiredCourses;
    }
    public List<Course> getpoolList(){return this.poolList;}
    public String getpoolName(){return poolName;}

}

