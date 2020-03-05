# Chess Visualizer
Open source chess program devised to create a psuedo heat map of a chess board with color representation of attack and defense values of each square. Program is written is `javafx` and release files of the program can be found in the `release` folder or under **Releases** on Github.

[More Info](http://tlee753.com/chess-visualizer/)

### Quickstart
1. Install java if you haven't already: [Oracle JDK/JRE](https://java.com/en/)
2. Download the lastest `jar` file from **Releases**
3. Double click on the `jar` file to run

### Demo
![Demo](/assets/screenshots/frontend-1.9.png)

### Long Term Vision
I really hope that far more mainstream chess programs will implement the ideas I have presented on this project within their chess platforms. This is really just a feature I was keen to explore and happened to have the programming know how to try it out. Long term it will be hard to maintain as an individual and therefore I hope the merits of teaching chess visually will be realized.

### Installation
- You must use the [Oracle JDK/JRE](https://java.com/en/) to develop/run
    - **That means no `sudo apt install openjdk` debian-based Linux users**
    - currently the focus is on the JDK 8, but 10/11 will someday be the only supported platform

### Repository Layout
- `src` : the in development source code
- `release` : jar files containing the program releases in the format `Chess-<PROGAM VERSION>-<JAVA RELEASE>.jar`
- `assets` : various assets used to design/develop/test the program (includes some example .pgn games)

### Design Layout
![Design](/assets/chess-app-design-1.jpg)

### TODO
- [x] about/instruction pop up boxes
- [x] neutral tension squares in yellow
- [x] svg pieces :) & image views
- [x] logo
- [x] error detection with FEN strings
- [x] score 
- [x] further analytics
- [x] .pgn imports
- [x] keyboard navigation
- [x] file chooser
- [x] white and black toggle heatmap
- [x] dark mode
- [ ] small scale game database
- [ ] moveable piece implementation
- [ ] valid position checking
- [ ] highlighted fen strings (clickable to position)
- [ ] toggle piece view
- [ ] total piece mobility (sum of piece movement throughout game) analytic
- [ ] only show tension squares view
- [ ] notepad text show game moves (clickable view)
- [ ] highlight last piece movement (outline square)
- [ ] notation arrows/highlighting
