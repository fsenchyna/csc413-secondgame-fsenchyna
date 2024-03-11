# csc413-SecondGame

## Student Name  : Fiona Senchyna
## Student ID    :


## src folder is to be used to store source code only.

## resources folder is to be used to store the resources for your project only. This includes images, sounds, map text files, etc.

## jar folder is used to store the built jar of your term-project. NO SOURCE CODE SHOULD BE IN THIS FOLDER. DOING SO WILL CAUSE POINTS TO BE DEDUCTED

## Game description (per instructor)

You play an explorer who has become trapped while investigating a large pyramid complex. All around lie the treasures of an ancient pharaoh, but pyramids are haz- ardous places and danger lurks around every corner. Deadly scorpions and beetles will block your progress and mummies will hunt you down. Only by keeping your wits about you can you hope to unravel the secrets of the great pyramid and escape as a rich man.
You control the explorer using the arrow keys. Many obstacles will block your path, keeping you from taking the treasures and eventually escaping to freedom. Beetles will only move vertically while scorpions only move horizontally. Mummies move in all directions. These enemies are clever and will react when they see you by trying to catch you and end your explorations. Some wall segments can be pushed, allowing you to reach other areas or hide from enemies. The pyramid also contains scarabs that you can use to make the mummies temporarily vulnerable— allowing you to hunt them for extra points.
Deep within the center of the pyramid lies its greatest treasure, the fabled sword of the sun god Ra. It is this great treasure that casts the unnatural light which reaches throughout the pyramid and allows you to see your way so clearly. It is precious beyond measure, but in taking it you will upset that delicate system and the pyramid will be plunged into eerie darkness.
Only the small glow remaining in the sword will light your way now, and formerly simple puzzles will seem new and challenging. All is not lost, however, for the sword has a second function. When wielding the sword you will be able to press and hold the spacebar to temporarily reactivate its glow. The sword transmutes gold into pure light, lighting your way but reducing your score. When the sword is active, the mummies will flee as they do when a scarab is active, making your journey easier, but draining your wealth.

## General game Description (per Fiona):

Use the arrow keys to navigate your explorer around the maze like pyramid.
Beware of the dangerous scorpions, beetles and mummies wandering around, they are hungry!
Look out for treasure and potions to up your score and give you more life. The most valuable of these treasures is the ‘Sword of Ra’, however don’t pick it up too early, because as soon as you do the game will be over, and you don’t want to leave until every last piece of treasure is yours!
P.S. pick up a scarab and hunt the mummies for some extra points.

Version of Java used: 1.8

Current working directory of the game:csc413-secondgame-fsenchyna-master

## Importing the game into IntelliJ:

To set up project correctly in IntelliJ, go to File -> Project Structure -> Project and check the following is correct:

•Project Name: csc413-secondgame-fsenchyna-master

•	Project SDK: 1.8

•	Project language level: 8 - lambdas, type annotations etc.

•	Project compiler output: ~/ csc413-secondgame-fsenchyna-master/out

Under File -> Project Structure -> Modules

•	Name/Root: csc413-secondgame-fsenchyna-master

•	Sources: src folder

•	Resources: resources folder

•	Excluded: out folder

When the project is set up correctly in the Project Structure, go to Run -> Edit Configurations:

•	Click + button in the top left corner and add an application

•	Under 'Name' type pyramid.PyramidPanicUI and under the 'main class' type 'pyramid.gui.PyramidPanicUI'


## Running the jar:

From the command line: go to the csc413-secondgame-fsenchyna-master/jar folder and type: java -jar csc413-secondgame-fsenchyna-master.jar

From IntelliJ: current working directory for the game is 'csc413-secondgame-fsenchyna-master'.

## Controls to play game:

Explorer Controls: Up arrow key = move forwards, Down arrow key = move backwards, Left arrow key = rotate left, Right arrow key = rotate right.

To collect treasure just walk over the treasure piece. Scarabs cause the mummies to become disabled as soon as they are picked up.
The explorer starts off with 3 lives. Potions increase the health of the explorer; and mummies, scorpions, and beetles decrease the explorers health.
The game ends when the explorer either dies or picks up the Sword of Ra.

