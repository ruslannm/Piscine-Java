1. Create a directory for result of compile and resources
    mkdir target && mkdir target/resources
2. Specify where to place generated class files and compile
    javac -d target src/java/edu.school21.printer/app/Program.java src/java/edu.school21.printer/logic/Convert.java
3. Copy resources:
    cp src/resources/* target/resources
4. Make Jar:
    jar cfm target/images-to-chars-printer.jar  src/manifest.txt -C target/ .
5. Execute with parameters:
    java -jar target/images-to-chars-printer.jar <1> <2>
    1 - Symbol for white color
    2 - Symbol for black color
Example:
    java -jar target/images-to-chars-printer.jar . 0