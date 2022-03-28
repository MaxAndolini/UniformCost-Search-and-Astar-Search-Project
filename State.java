/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author *
 */
public class State {

    Tile tile1;
    Tile tile2;
    Tile tile3;
    int parentTileNo;
    int move_cost = 0;
    int manhattan_cost = 0;
    int total_cost = 0;
    int[][] array = {{0, 0, 0},
    {0, 0, 0},
    {0, 0, 0}};

    public State(Tile tile1, Tile tile2, Tile tile3, int parentTileNo) {
        this.parentTileNo = parentTileNo;
        this.tile1 = tile1;
        this.tile2 = tile2;
        this.tile3 = tile3;
        this.array[tile1.row][tile1.column] = tile1.value;
        this.array[tile2.row][tile2.column] = tile2.value;
        this.array[tile3.row][tile3.column] = tile3.value;
    }

    public boolean isRightEmpty(Tile tile) {
        try {
            if (array[tile.row][tile.column + 1] == 0) {

                return true;
            } else {
                return false;
            }

        } catch (Exception exception) {
            return false;
        }
    }

    public boolean isLeftEmpty(Tile tile) {
        try {
            if (array[tile.row][tile.column - 1] == 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception exception) {
            return false;
        }

    }

    public boolean isUpEmpty(Tile tile) {
        try {
            if (array[tile.row - 1][tile.column] == 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception exception) {
            return false;
        }

    }

    public boolean isDownEmpty(Tile tile) {
        try {
            if (array[tile.row + 1][tile.column] == 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception exception) {
            return false;
        }

    }

    public int getTotal_cost() {
        return total_cost;
    }
}
