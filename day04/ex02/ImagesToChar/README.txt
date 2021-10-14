1. Create a directory for library, result of compile and resources
    mkdir lib && mkdir target && mkdir target/resources
2. Download library
    cd lib && curl -O https://repo1.maven.org/maven2/com/beust/jcommander/1.81/jcommander-1.81.jar -O https://repo1.maven.org/maven2/com/diogonunes/JColor/5.0.1/JColor-5.0.1.jar && cd ..
3. Specify where to place generated class files and compile
    javac -d target  -cp lib/\* src/java/edu.school21.printer/app/* src/java/edu.school21.printer/logic/Convert.java
4. Copy resources:
    cp src/resources/* target/resources
5. Unzip library to target/com
    cd target && jar xf ../lib/jcommander-1.81.jar com && jar xf ../lib/JColor-5.0.1.jar com && cd .. 
6. Make Jar:
    jar cfm target/images-to-chars-printer.jar  src/manifest.txt -C target/ .
7. Execute with parameters:
    java -jar ./target/images-to-chars-printer.jar --white=GREEN --black=WHITE
