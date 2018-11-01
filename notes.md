### Developing
cd src
javac *.java
java ChessApp



### Jar Compilation
jar -cvfm Chess-<version>-<java version>.jar manifest.txt *.class *.fxml assets chesspresso

### Java Compilation
javac -target 1.8 -source 1.8 *.java



### Chesspresso Testing
javac -cp .:Chesspresso-lib.jar Main.java

### Chesspresso Testing
java -cp .:Chesspresso-lib.jar Main
