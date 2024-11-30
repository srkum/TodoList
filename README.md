---Acceptance criteria for this user story----
1. Opening the chrome browser and requesting to open the given URL
2. Checking the page title and page header
3. Adding the todo list in the text box one by one
4. Editing the todo list by double clicking the text box and adding text
5. Selecting radio button to mark the todo list as completed
6. viewing all the todo list
7. viewing only active todo list
8. viewing only completed todo list
9. clearing only the completed todo list
10.checking the maximum number of todo list can be added in the page
11.clicking the Todo MVC hyperlink and navigate to https://todomvc.com/ page
12.Going back to main page
13.closing the chrome browser  

----Test Automation covers the following scenarios-----
1. Opening the chrome browser and requesting to open the given URL
2. Checking the page title and page header
3. Adding the todo list in the text box one by one
4. Editing the todo list by double clicking the text box and adding text
5. Selecting radio button to mark the todo list as completed
6. closing the chrome browser  

------How to run the test -----
1. Select pageFunctionsTestng.xml
2. Right click and run as TestNg.suite

------Overview of project implementation ------
- Created Maven project with Selenium and TestNG as dependencies. 
- All the acceptance criteria test cases are created under folder src/main/java under the package todo.pages
 in TodoPageFunctions.Java . 
- The test automation cases are created under folder src/test/java under the package todo.pages.test in 
  TodoPageFunctionsTest.java. 
- After execution of the TestNG Suite the output can be viewed from test-output folder.
