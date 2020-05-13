The program is compiled with maven from /BowlingSum-master/TSH_Bowling_Sum 
with the command: mvn compile
The program is then run with: mvn exec:java -Dexec.mainClass=Main
Or with: mvn exec:java -Dexec.mainClass=Main -Dexec.args="1"
for the test program. 

The test program is rather simple and just runs the entire program 10 times and counts and reports the number failures.
Tests on specific inputs would have been nice but i didn't have time to implement more test cases. 
