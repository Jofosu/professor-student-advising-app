# Academic Advisor
##Use Case Name: Schedule classes

####Scope: Academic Advising

#####Level: User goal

#####Primary Actor: Student

###Stakeholders and Interest:
Student: Wants an intuitive way to enter classes and change classes since they will be new to the system. They want to be able to identify scheduling conflicts and schedule classes so that they can finish their major.

Advisor: Wants to ensure students are finishing their classes on time

Vassar: Wants to ensure students are finishing their classes on time

Precondition:
-User is logged in

-Classes are entered into the Academic advising app

-Major requirements are already entered

###Postcondition:

-Classes are saved onto a timeslot

-Classes are checked off major requirement list

-Advisor is also able to see changes in the student’s schedule

###Main Success Scenario:
-Student has identified a required course that is offered and wants to enter it into Academic Advising

-Student goes to a blank schedule and enters their identified class and semester they want to take it in

-Their class gets added onto the schedule and removed from their checklist and into a “progress/done” list

-Student keeps adding classes until major requirements are filled

###Extensions:
4a. Their course is not offered this semester

    The system either tells them when it’s offered or just say it’s not offered

4b. They do not have the prerequisites for their course

    The system tells them the necessary prerequisites or special permission option

4c. They do not enter a valid course

    The system asks the user if this is actually a valid course, and they can manually add it if it is.

    They can manually remove items from the progress checklist

###Special requirements:
Must use Vassar’s class codes for classes

#####Technology: Should be able to run on an android device
