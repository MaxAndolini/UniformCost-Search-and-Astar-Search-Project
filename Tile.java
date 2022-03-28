/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author *
 */
public class Tile {

    int value;
    int cost_right_left;
    int cost_up_down;
    int row;
    int column;

    public Tile(int value, int row, int column, int cost_right_left, int cost_up_down) {
        this.value = value;
        this.cost_right_left = cost_right_left;
        this.cost_up_down = cost_up_down;
        this.row = row;
        this.column = column;
    }

    public int moveRight() {
        column++;
        return cost_right_left;
    }

    public int moveLeft() {
        column--;
        return cost_right_left;
    }

    public int moveUp() {
        row--;
        return cost_up_down;
    }

    public int moveDown() {
        row++;
        return cost_up_down;
    }
}
