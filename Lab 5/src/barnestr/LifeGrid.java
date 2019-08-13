/*
 * SE1021
 * Winter 2017
 * Lab Game Of Life
 * Name: Derek Riley (edits by Chris Taylor)
 * Created 11/25/2016
 */

package barnestr;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the grid of cells used to model Conway's Game of Life.
 */
public class LifeGrid {

    /**
     * This instance variable stores the grid of Cells
     */
    private List<List<Cell>> cells;


    /**
     * This instance variable stores the width of the cell grid
     */
    private final int numberOfCellsWide;

    /**
     * This instance variable stores the height of the cell grid
     */
    private final int numberOfCellsHigh;

    /**
     * The amount of dead cells in the LifeGrid
     */
    public int deadCells;
    /**
     * The amount of alive cells in the LifeGrid
     */
    public int aliveCells;

    /**
     * This constructor builds a LifeGrid using the size of the Pane passed and the scale of the cells
     *
     * @param gamePane viewing pane
     */
    public LifeGrid(Pane gamePane) {
        this.numberOfCellsWide = (int) gamePane.getPrefWidth() / Cell.SCALE;
        this.numberOfCellsHigh = (int) gamePane.getPrefHeight() / Cell.SCALE;
        cells = new ArrayList<>();

        //initialize the two dimensional ArrayList
        for (int i = 0; i < numberOfCellsHigh; i++) {
            cells.add(new ArrayList<>());
        }

        //create cells
        for (int i = 0; i < numberOfCellsHigh; i++) {     // yPosition
            for (int j = 0; j < numberOfCellsWide; j++) { // xPosition
                cells.get(i).add(new Cell(j, i));
            }
        }

        //set neighbors for all cells
        for (int i = 0; i < numberOfCellsHigh; i++) {     // yPosition
            for (int j = 0; j < numberOfCellsWide; j++) { // xPosition
                if (i > 0) {
                    if (j > 0) {
                        cells.get(i).get(j).setNeighborAboveLeft(cells.get(i - 1).get(j - 1));
                    }
                    cells.get(i).get(j).setNeighborAboveCenter(cells.get(i - 1).get(j));
                    if (j < numberOfCellsWide - 1) {
                        cells.get(i).get(j).setNeighborAboveRight(cells.get(i - 1).get(j + 1));
                    }
                }
                if (j > 0) {
                    cells.get(i).get(j).setNeighborMiddleLeft(cells.get(i).get(j - 1));
                }
                if (j < numberOfCellsWide - 1) {
                    cells.get(i).get(j).setNeighborMiddleRight(cells.get(i).get(j + 1));
                }
                if (i < numberOfCellsHigh - 1) { // bottom boarder elements
                    if (j > 0) {
                        cells.get(i).get(j).setNeighborBelowLeft(cells.get(i + 1).get(j - 1));
                    }
                    cells.get(i).get(j).setNeighborBelowCenter(cells.get(i + 1).get(j));
                    if (j < numberOfCellsWide - 1) {
                        cells.get(i).get(j).setNeighborBelowRight(cells.get(i + 1).get(j + 1));
                    }
                }
            }
        }
        initialize(gamePane);
    }

    /**
     * This method randomizes the life and death attributes of all cells in the cells.
     * Cells have a 50% chance of being alive or dead.
     */
    public void randomize() {
        aliveCells = 0;
        deadCells = 0;
        final double HALF_CHANCE = .5;
        for (List<Cell> row : cells) {
            for (Cell cell : row) {
                cell.setAlive(Math.random() < HALF_CHANCE);
                if (cell.isAlive()) {
                    aliveCells++;
                } else {
                    deadCells++;
                }


                cell.updateColors();
            }
        }
    }

    /**
     * This method triggers one iteration (tick) of the game of life rules for the entire grid.
     */
    public void iterate() {
        aliveCells = 0;
        deadCells = 0;
        for (List<Cell> row : cells) {
            for (Cell cell : row) {
                cell.determineNextTick();
                if (cell.isAlive()) {
                    aliveCells++;
                } else {
                    deadCells++;
                }
            }
        }
        for (List<Cell> row : cells) {
            for (Cell cell : row) {
                cell.updateTick();
            }
        }
    }

    /**
     * This method adds all the cell rectangles to the Pane
     */
    private void initialize(Pane gamePane) {
        for (List<Cell> row : cells) {
            for (Cell cell : row) {
                gamePane.getChildren().add(cell);
            }
        }
    }

    /**
     * This method takes the location of a mouse click and sets the state of that cell to dead or alive.
     *
     * @param location the point where the user clicked
     */
    public void setState(MouseEvent location) {

        final int CELL_SIZE = 10;
        for (int i = 0; i < cells.size() * CELL_SIZE; i += CELL_SIZE) {
            if (location.getX() < i + CELL_SIZE && location.getX() > i) {
                for (int j = 0; j < cells.size() * CELL_SIZE; j += CELL_SIZE) {
                    if (location.getY() < j + CELL_SIZE && location.getY() > j) {
                        if (cells.get(j / CELL_SIZE).get(i / CELL_SIZE).isAlive()) {
                            cells.get(j / CELL_SIZE).get(i / CELL_SIZE).setAlive(false);
                            cells.get(j / CELL_SIZE).get(i / CELL_SIZE).updateColors();
                            deadCells++;
                            aliveCells--;
                        } else {
                            cells.get(j / CELL_SIZE).get(i / CELL_SIZE).setAlive(true);
                            cells.get(j / CELL_SIZE).get(i / CELL_SIZE).updateColors();
                            aliveCells++;
                            if (deadCells > 0) {
                                deadCells--;
                            }
                        }
                    }
                }
            }
        }
    }
}