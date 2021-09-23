
Use case name:  Check Major requirement

Scope: Academic Advising

Level: User goal

Primary Actor : Advisor

Stakeholders and Interest:
– Advisor: Wants easily visible accurate data displaying all students’ completed courses, planned courses, and the remainder of courses needed for completion of major. Data should also include grades,total units taken and time courses are taken.

–Student: Wants updated data of courses already taken, courses needed for completion of major.

Pre-conditions:
- Student is identified and authenticated as an advisee.
- Professor is identified and authenticated as advisor.

Post-conditions:
- A check sign is generated
- List of courses needed for major requirement is generated.

Main success scenario:
1. Advisor logs onto the system to check if an advisee is on track to graduate.
2. Advisor is authenticated by the system and sees a list of students.
3. Advisor selected a particular advisee from the list.
4. System displays a list of courses the advisee has taken, the advisee’s major, courses  needed to complete major, courses under major student has taken and courses under major the student needs to take.
5. System generates a check sign showing the student is on track to complete the major.

Extensions:
1) Invalid Credential:

   -System signals error and rejects entry.

   -System reconstructs from prior state.
2) No list of students generated or missing advisee on list generated:

   -System detects communication failure with REGISTRAR.

   -System reconstructs from prior state.
3) System fails to recognize or add courses:

   -System signals error and suggests advisor adds course.

Special requirements:

-Internationalization of displayed text

-Courses shown are under the vassar curriculum or approved by advisor

Technology and data variations :

-Credentials entered by keyboard.

