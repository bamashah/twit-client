**** CODING CHALLENGE ****

Create a tool that will query the 'status' page on 1000 servers and produce a report based on data within the status page.  Each server has a ‘status’ endpoint that returns json data.  The details of that json data will be provided below.

Your tool should produce the following reports:
-	Human readable report output to stdout.
-	Computer parseable report output to a file on local disk.

Task Details:
-	Input:
	-	Servers:
		-	The file ‘servers.txt’ will include a list of fictitious servers.  Your solution should read this file for it’s list of endpoints.
		-	Please implement the code required to call the endpoint (as an HTTP request) and retrieve the data.
	-	Response from endpoint:
		-	The file ‘responses.txt’ will provide example json data that you should reference for this exercise.
		-	Please DO NOT read the ‘responses.txt’ file in your code.  This is just example data so you can see what could be returned from the endpoints.  Each endpoint can be considered to reply with a single entry from the list in ‘responses.txt’.
-	Output:
	-	Your tool should scan each endpoint and produce a report that aggregates:
		Success rate by Application by Version
	-	Your tool should write it’s output to standard out in human readable format.
	-	Your tool should also write output to a local file that is easily computer parsable (plan for this to be consumed by a downstream application).
 

**** RUNNING THE CODE ****
What you need: Java 11 (Java 8 should also work)

Unzip the file. Everything is in the nshah-sub directory. cd into this directory.
My server.txt file is in there. Please replace with yours. 

LINUX 
First compile the code:  javac -cp gson-2.9.0.jar:. Tool.java
Then run the code:  java -cp gson-2.9.0.jar:. Tool

WINDOWS
Compile code:  javac -cp gson-2.9.0.jar;. Tool.java
Run code:  java -cp gson-2.9.0.jar;. Tool

Output will be printed to stdout and also to the output.txt file. 


**** DESCRIPTION ****
The Tools class is the main orchestrator. From here calls are made to:
- FileReader class to read the server.txt file.
- Client class to hit the server end points and get the JSON responses and parse the responses.
- OutputWriter class to write the output to stdout and to the output.txt file. 