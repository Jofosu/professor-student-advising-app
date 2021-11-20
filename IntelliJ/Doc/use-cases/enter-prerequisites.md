##Use Case Name: Enter Prerequisites
####Scope: Advising app

####Level: User Goal

####Primary Actor: Department Head

###Stakeholder/Interests:

Department Chair- Update the course catalog to accurately reflect the prerequisites for each course int eh department

####Preconditions:
department chair is logged in/authenticated

Department courses have already been added to the course catalog

####Post Conditions:
major requirements are updated

prints list to confirm

###Main Success:
1. Dept Chair opens course editor
2. System prints list of all department courses
3. Chair selects course to assign prerequisites to
4. System prints all other department courses
5. Chair selects a course that is a prerequisite for the desired course
6. Repeat steps 4 and 5 until advisor signals done

####Extensions:

2a. System is unable to print list of courses

    System signals communication error with CourseCatalog
    System reconstructs from prior state

4a. System is unable to print list of courses

    System signals communication error with CourseCatalog
    System reconstructs from prior state

5a. System is unable to add course as prerequisite

    System signals error 
    reconstructs from prior state
    prompts the user to try again
