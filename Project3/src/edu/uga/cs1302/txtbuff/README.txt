To run this program, you need to first compile all the java files designated at Project3/src/edu/uga/cs1302/txtbuff. You also need to put the tester file in Project3/src/edu/uga/cs1302/test 
You can compile by doing the command javac ./*.java . This command compiles all the files ending in .java
You can choose to put the class files in another directory if you do javac -d if you want. Next you need to set-up your classpath
so you can run YOUR tester.class file. You can open your .bash_profile in your home directory and edit your classpath there.
Once you do that navigate back to the Tester.class file you created and do java Tester. Once you have done that you will
have successfully ran the program and you can look and mess with my sentence builder.
To run my JUnit Tester go into Project3/src/edu/uga/cs1302/test and open  the test file located there. You can also edit it (using emacs or VI) to see if there are things you want to test out.
Make sure to properly import or setup your JUnit path to test. Since you are using your own JUnit you would do it by java org.junit.runner.JUnitCore (Tester class). Make sure your bash profile is set up to run my tester file.
