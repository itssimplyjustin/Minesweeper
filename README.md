# Minesweeper

## Overview
 
### Description

Welcome to the Minesweeper repository! This is a command-line based implementation of the classic game, built in Java.

In this version of Minesweeper, the player is presented with a grid of tiles, some of which contain hidden mines. The goal of the game is to uncover all of the tiles that do not contain mines, while avoiding the ones that do.

## Features

- Classic Minesweeper gameplay, with the ability to flag tiles that are suspected to contain mines.
- Tiles are numbered from 1 to the number of tiles on the board, and the player enters the number of the tile they wish to uncover or flag.
- Three difficulty levels to choose from: Easy (81 tiles), Medium (256 tiles), and Hard (480 tiles).

## Local Installation

### Step 1: Prerequisites

To run the game locally on your computer, you will need to have the Java Development Kit (JDK) installed. You can download the JDK from the [Oracle website](https://www.oracle.com/java/technologies/javase-downloads.html).

### Step 2: Clone Repository

Once you have the JDK installed, you can compile and run the Minesweeper.java file from the command line:

```bash
$ git clone https://github.com/justinmbaltazar/Minesweeper.git
```

### Step 3: Run Application

Compile and run the `Minesweeper.java` file using the following commands below or click the Build/Run on the IDE of your choice.

```bash
javac Minesweeper.java
java Minesweeper
```

## Usage

To play the game, simply follow the prompts on the command line.

- To uncover a tile, enter the number of the tile you wish to uncover. If the tile contains a mine, the game will end. If the tile does not contain a mine, it will be revealed and a number will be displayed indicating how many mines are adjacent to that tile.
- To flag a tile as containing a mine, enter the number of the tile followed by `F`. This will place a flag on the tile, which can be helpful in keeping track of which tiles you suspect contain mines.
- To select a difficulty level, enter `1` for Easy `(9 * 9)` , `2` for Medium `(16 * 16)`, or `3` for Hard `(16 * 30)`.
The game ends when all of the non-mine tiles have been uncovered, or when a mine tile has been uncovered. Good luck!
