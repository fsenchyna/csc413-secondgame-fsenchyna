# csc413-SecondGame

## Student Name  : Fiona Senchyna
## Student ID    : 920005473


## src folder is to be used to store source code only.

## resources folder is to be used to store the resources for your project only. This includes images, sounds, map text files, etc.

## jar folder is used to store the built jar of your term-project. NO SOURCE CODE SHOULD BE IN THIS FOLDER. DOING SO WILL CAUSE POINTS TO BE DEDUCTED

Version of Java used: 1.8

Current working directory of the game:csc413-secondgame-fsenchyna-master

Importing the game into IntelliJ:

To set up project correctly in IntelliJ, go to File -> Project Structure -> Project and check the following is correct:

•Project Name: csc413-secondgame-fsenchyna-master

•	Project SDK: 1.8

•	Project language level: 8 - lambdas, type annotations etc.

•	Project compiler output: ~/ csc413-secondgame-fsenchyna-master/out

Under File -> Project Structure -> Modules

•	Name/Root: csc413-secondgame-fsenchyna

•	Sources: src folder

•	Resources: resources folder

•	Excluded: out folder

When the project is set up correctly in the Project Structure, go to Run -> Edit Configurations:

•	Click + button in the top left corner and add an application

•	Under 'Name' type pyramid.PyramidPanicUI and under the 'main class' type 'pyramid.gui.PyramidPanicUI'


##Running the jar:

From the command line: go to the csc413-secondgame-fsenchyna-master/jar folder and type: java -jar csc413-secondgame-fsenchyna-master.jar

From IntelliJ: current working directory for the game is 'csc413-secondgame-fsenchyna-master'.

Controls to play game:

Explorer Controls: Up arrow key = move forwards, Down arrow key = move backwards, Left arrow key = rotate left, Right arrow key = rotate right.

To collect treasure just walk over the treasure piece. Scarabs cause the mummies to become disabled as soon as they are picked up.
The explorer starts off with 3 lives. Potions increase the health of the explorer; and mummies, scorpions, and beetles decrease the explorers health.
The game ends when the explorer either dies or picks up the Sword of Ra.

General game Description:

Use the arrow keys to navigate your explorer around the maze like pyramid.
Beware of the dangerous scorpions, beetles and mummies wandering around, they are hungry!
Look out for treasure and potions to up your score and give you more life. The most valuable of these treasures is the ‘Sword of Ra’, however don’t pick it up too early, because as soon as you do the game will be over, and you don’t want to leave until every last piece of treasure is yours!
P.S. pick up a scarab and hunt the mummies for some extra points.
