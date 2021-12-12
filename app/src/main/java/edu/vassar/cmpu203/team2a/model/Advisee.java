package edu.vassar.cmpu203.team2a.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Contains a constructor with the adviseeattributes name, Vassar "999 ID", and graduating class year
 */
public class Advisee implements Serializable {
    private String advisor;
    private String name;
    private int id;
    private int classYear;
    private List<Course> classesTaken;
    private String major;


    /**
     * Empty constructor for Advisee class, returns internal components
     */
    Advisee() {
    }

    /**
     * Constructor for Advisee class
     *
     * @param name         name of student
     * @param id           students 999 number
     * @param classYear    graduation year
     * @param classesTaken what classes have been taken
     */
    Advisee(String name, int id, int classYear, List<Course> classesTaken, String advisor, String major) {
        this.name = name;
        this.id = id;
        this.classYear = classYear;
        this.classesTaken = classesTaken;
        this.advisor = advisor;
        this.major = major;
    }

    /**
     * Getter for student's name
     *
     * @return student's name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for student's id
     *
     * @return student's id
     */
    public int getId() {
        return id;
    }

    /**
     * Getter for student's class year
     *
     * @return student's id
     */
    public int getClassYear() {
        return classYear;
    }

    /**
     * Getter for classes taken
     *
     * @return list of classes taken
     */
    public List<Course> getClassesTaken() {
        return classesTaken;
    }


    /**
     * Returns what classes someone needs to take from a major
     * @param catalogue course catalogue
     * @return list of courses still needed to take
     */
    public List<Course> getClassesNeeded(CourseCatalogue catalogue) {
        List<Course> courses = new ArrayList<>();

        Set<String> keys = catalogue.getCourseCatalogue().keySet();
        String s = getMajor();
        Predicate<String> byCourse = course -> course.startsWith(getMajor());

        List<String> result = keys.stream().filter(byCourse).collect(Collectors.toList());
        for (String course : result) {
            if (!getClassesTaken().contains(catalogue.get(course)))
                courses.add(catalogue.get(course));
        }
        return courses;
    }

    /**
     * getter for an advisee's major
     * @return majors name
     */
    public String getMajor() {
        return major;
    }

    /**
     *getter for advisee's advisor
     * @return advisor's username
     */
    public String getAdvisor() {
        return advisor;
    }
}
