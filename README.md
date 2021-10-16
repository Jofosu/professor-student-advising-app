#Team 2A


This prototype implements the managing advisee functionality
from the advisor's perspective. Currently, this aspect only allows the 
advisor to create and delete students and enter primitive identifying 
information as well as print a list of current advisees. Other information
such as classes taken will be added in a later iteration.

This prototype also implements the add courses functionality from the 
perspective of the Department Chair. Currently, the courses are just 
stored in the course catalog collection with basic information such as 
course code (id) and the time of the class. Other information such as 
prerequisites and whether it fulfills a major requirement will be added
in a later iteration. 

The TextInterface class contains the main() method. By selecting that you are a 
department chair, you will be able to edit the course catalog until you 
select quit, which will then terminate the program. By selecting that 
you are an advisor, you will be able to edit your list of advisees until 
you select quit, which will then terminate the program
