### Developing
`cd src`

`javac *.java`

`java ChessApp`

### Versioning
change version in
- .fxml file name
- .fxml gui label (scenebuilder)
- ChessApp.java
    - windows title
    - link to fxml file

---

### Building Artifacts
##### Jar Compilation
`jar -cvfm Chess-<version>-<java version>.jar manifest.txt *.class *.fxml assets chesspresso`

##### Java Compilation (Specific Build)
`javac -target 1.8 -source 1.8 *.java`

---

### Chesspresso Testing
`javac -cp .:Chesspresso-lib.jar Main.java`

`java -cp .:Chesspresso-lib.jar Main`
