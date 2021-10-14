1. Create a directory for result of compile
mkdir target && mkdir target/edu.school21.printer && mkdir target/resources
2. Specify where to place generated class files and compile
javac -d target/edu.school21.printer src/java/edu.school21.printer/app/* src/java/edu.school21.printer/logic/*

3. Execute with parameters
java -classpath target/edu.school21.printer Program <1> <2> <3>
    1 - Symbol for white color
    2 - Symbol for black color
    3 - Path to file
Example:
    java -classpath target/edu.school21.printer Program . 0 it.bmp