1. Create a directory for library, result of compile and resources
    mkdir lib && mkdir target && mkdir target/resources

https://repo1.maven.org/maven2/com/beust/jcommander/1.81/jcommander-1.81.jar


2. Specify where to place generated class files and compile
    javac -d target src/java/edu.school21.printer/app/Program.java src/java/edu.school21.printer/logic/Convert.java
3. Copy resources:
    cp src/resources/* target/resources
4. Make Jar:
    jar cfm target/images-to-chars-printer.jar  src/manifest.txt -C target edu/  -C target resources/
5. Execute with parameters:
    java -jar target/images-to-chars-printer.jar <1> <2>
    1 - Symbol for white color
    2 - Symbol for black color
Example:
    java -jar images-to-chars-printer.jar . 0