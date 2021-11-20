##Use Case Name: Enter Major Requirements
####Scope: Advising app

####Level: User Goal

####Primary Actor: Department Head

###Stakeholder/Interests:

Department Head- wants to quickly/easily populate major requirements

Advisor- Wants all requirements/classes listed out advisee

Advisee- Wants all requirements/classes listed out advisee

####Precondition: 
department head is logged in/authenticated

classes are already in the system

####Postcondition:
major requirements are updated

prints list to confirm

####Main Success:
1. Advisor opens major requirements editor
2. Advisor creates a pool of classes and specifies how many are required from that group 
3. System prints a list of all department courses
4. Advisor selects a course to add to the pool from step 2
5. Repeat steps 3 and 4 until advisor signals done
6. Repeat steps 2-5 until advisor signals done
7. System prints list of pools and classes within each

####Extensions:
2a. System is unable to create pool 

    system signals error
    reconstructs from prior state
    prompts user to try again

3a. System is unable to print list of courses 
    
    System signals communication error with CourseCatalog
    System reconstructs from prior state

4a. System is unable to add course to pool

    System signals error 
    reconstructs from prior state
    prompts the user to try again

7a. System is unable to print final list of pools and courses

    System signals error
    reconstructs from prior state






