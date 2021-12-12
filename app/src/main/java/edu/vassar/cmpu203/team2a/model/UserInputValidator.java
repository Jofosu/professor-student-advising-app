package edu.vassar.cmpu203.team2a.model;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInputValidator {

    static final int seniorYear = 2022;
    static final int freshmanYear = 2025;
    /**
     * @param firstname
     * @return returns true if a valid first name is given as input else return false.
     */
    public static boolean isFirstName(String firstname){
        final String firstNamepattern = "[a-zA-Z.-]{1,}";
        Pattern pattern = Pattern.compile(firstNamepattern);
        Matcher matcher = pattern.matcher(firstname);
        return firstname.length() > 0 && matcher.matches();
    }
    /**
     * @param middlename
     * @return returns true if a valid middle name is given as input else return false.
     */
    public static boolean isMiddleName(String middlename){
        final String middleNamepattern = "[a-zA-Z.-]{1,}";
        Pattern pattern = Pattern.compile(middleNamepattern);
        Matcher matcher = pattern.matcher(middlename);
        return matcher.matches() || middlename.length() == 0;
    }

    /**
     * @param lastname
     * @return returns true if a valid last name is given as input else return false.
     */
    public static boolean isLastName(String lastname){
        final String lastNamepattern = "[a-zA-Z]{1,}";
        Pattern pattern = Pattern.compile(lastNamepattern);
        Matcher matcher = pattern.matcher(lastname);
        return lastname.length() > 0 && matcher.matches();
    }

    /**
     * @param classYearInput
     * @return returns true if a valid class year is given. Class year should be between freshman year and senior year else return false.
     */
    public static boolean isValidClassYear(String classYearInput){
        if(classYearInput.length() < 4) return false;
        int classYear = Integer.parseInt(classYearInput);
        return classYear >= seniorYear && classYear <= freshmanYear;

    }

    /**
     * @param idInput
     * @return returns true if a valid student id is given. Valid id should start with 999 else return false.
     */
    public static boolean isValidStudentId(String idInput) {
        return idInput.startsWith("999") && idInput.length() == 9;
    }

    public static boolean isValidMajor(String major, CourseCatalogue catalogue) {
        final String majorPattern = "[a-zA-Z]{1,}";
        Pattern pattern = Pattern.compile(majorPattern);
        Matcher matcher = pattern.matcher(major);
        return matcher.matches() && majorPattern.length() > 0;
    }
}
