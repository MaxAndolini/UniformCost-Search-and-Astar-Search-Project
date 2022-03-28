/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import javax.swing.JOptionPane;

/**
 *
 * @author *
 */
public class Main extends javax.swing.JFrame {

    static ArrayList<State> expandOrder = new ArrayList<>();
    static PriorityQueue<State> stateQueue = new PriorityQueue<>((Comparator<State>) (i, j) -> {
        if (i.total_cost < j.total_cost) {
            return -1;
        } else {
            return 1;
        }
    });
    static int counter = 0;

    enum Move {
        UP, DOWN, LEFT, RIGHT
    }

    enum TileType {
        Tile1, Tile2, Tile3
    }

    int insidePanel = 0;

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        getContentPane().requestFocusInWindow();
    }

    public static void ExpandTiles(Tile goaltile1, Tile goaltile2, Tile goaltile3, int searchingType) {
        int tilenumber = 1;
        while (counter < 99999921) {
            State newState = stateQueue.poll();  // Expand the node and save it on newState
            if (newState == null) {
                System.out.println("STACK STAYED EMPTY");
                return;
            }
            counter++;
            expandOrder.add(newState);

            if (hasReachedGoal(newState.tile1, newState.tile2, newState.tile3, goaltile1, goaltile2, goaltile3)) {
                System.out.println("WE HAVE REACHED THE GOAL");
                return;
            }

            if (newState.parentTileNo == 1) {
                tilenumber = 2;
            } else if (newState.parentTileNo == 2) {
                tilenumber = 3;
            } else if (newState.parentTileNo == 3) {
                tilenumber = 1;
            } else {
                System.out.println("There is error about tilenumber!");
            }

            switch (tilenumber) {
                case 1: {
                    boolean isStuck = true;
                    if (newState.isUpEmpty(newState.tile1)) {
                        State newNodeFromExpended = move(Move.UP, newState, TileType.Tile1, newState.tile1, newState.tile2, newState.tile3, goaltile1, goaltile2, goaltile3, searchingType);
                        stateQueue.add(newNodeFromExpended);
                        isStuck = false;
                    }
                    if (newState.isDownEmpty(newState.tile1)) {
                        State newNodeFromExpended = move(Move.DOWN, newState, TileType.Tile1, newState.tile1, newState.tile2, newState.tile3, goaltile1, goaltile2, goaltile3, searchingType);
                        stateQueue.add(newNodeFromExpended);
                        isStuck = false;
                    }
                    if (newState.isRightEmpty(newState.tile1)) {
                        State newNodeFromExpended = move(Move.RIGHT, newState, TileType.Tile1, newState.tile1, newState.tile2, newState.tile3, goaltile1, goaltile2, goaltile3, searchingType);
                        stateQueue.add(newNodeFromExpended);
                        isStuck = false;
                    }
                    if (newState.isLeftEmpty(newState.tile1)) {
                        State newNodeFromExpended = move(Move.LEFT, newState, TileType.Tile1, newState.tile1, newState.tile2, newState.tile3, goaltile1, goaltile2, goaltile3, searchingType);
                        stateQueue.add(newNodeFromExpended);
                        isStuck = false;
                    }
                    if (isStuck) {
                        newState.parentTileNo = 1;
                        stateQueue.add(newState);
                    }

                    break;
                }
                case 2: {
                    boolean isStuck = true;
                    if (newState.isUpEmpty(newState.tile2)) {
                        State newNodeFromExpended = move(Move.UP, newState, TileType.Tile2, newState.tile1, newState.tile2, newState.tile3, goaltile1, goaltile2, goaltile3, searchingType);
                        stateQueue.add(newNodeFromExpended);
                        isStuck = false;
                    }
                    if (newState.isRightEmpty(newState.tile2)) {

                        State newNodeFromExpended = move(Move.RIGHT, newState, TileType.Tile2, newState.tile1, newState.tile2, newState.tile3, goaltile1, goaltile2, goaltile3, searchingType);
                        stateQueue.add(newNodeFromExpended);
                        isStuck = false;
                    }
                    if (newState.isDownEmpty(newState.tile2)) {

                        State newNodeFromExpended = move(Move.DOWN, newState, TileType.Tile2, newState.tile1, newState.tile2, newState.tile3, goaltile1, goaltile2, goaltile3, searchingType);
                        stateQueue.add(newNodeFromExpended);
                        isStuck = false;
                    }
                    if (newState.isLeftEmpty(newState.tile2)) {

                        State newNodeFromExpended = move(Move.LEFT, newState, TileType.Tile2, newState.tile1, newState.tile2, newState.tile3, goaltile1, goaltile2, goaltile3, searchingType);
                        stateQueue.add(newNodeFromExpended);
                        isStuck = false;
                    }
                    if (isStuck) {
                        newState.parentTileNo = 2;
                        stateQueue.add(newState);
                    }

                    break;
                }
                case 3: {
                    boolean isStuck = true;
                    if (newState.isUpEmpty(newState.tile3)) {
                        State newNodeFromExpended = move(Move.UP, newState, TileType.Tile3, newState.tile1, newState.tile2, newState.tile3, goaltile1, goaltile2, goaltile3, searchingType);
                        stateQueue.add(newNodeFromExpended);
                        isStuck = false;
                    }
                    if (newState.isDownEmpty(newState.tile3)) {
                        State newNodeFromExpended = move(Move.DOWN, newState, TileType.Tile3, newState.tile1, newState.tile2, newState.tile3, goaltile1, goaltile2, goaltile3, searchingType);
                        stateQueue.add(newNodeFromExpended);
                        isStuck = false;
                    }
                    if (newState.isRightEmpty(newState.tile3)) {
                        State newNodeFromExpended = move(Move.RIGHT, newState, TileType.Tile3, newState.tile1, newState.tile2, newState.tile3, goaltile1, goaltile2, goaltile3, searchingType);
                        stateQueue.add(newNodeFromExpended);
                        isStuck = false;
                    }
                    if (newState.isLeftEmpty(newState.tile3)) {
                        State newNodeFromExpended = move(Move.LEFT, newState, TileType.Tile3, newState.tile1, newState.tile2, newState.tile3, goaltile1, goaltile2, goaltile3, searchingType);
                        stateQueue.add(newNodeFromExpended);
                        isStuck = false;
                    }
                    if (isStuck) {
                        newState.parentTileNo = 3;
                        stateQueue.add(newState);
                    }

                    break;
                }
                default:
                    System.out.println("UNKNOWN TILE NUMBER ERROR");
            }
        }
    }

    private static State move(Move direction, State root, TileType tile, Tile tile1, Tile tile2, Tile tile3, Tile goaltile1, Tile goaltile2, Tile goaltile3, int searchingType) {
        Tile selected;
        int parentTileType;
        switch (tile) {
            case Tile1: {
                selected = tile1;
                parentTileType = 1;
                break;
            }
            case Tile2: {
                selected = tile2;
                parentTileType = 2;
                break;
            }
            case Tile3: {
                selected = tile3;
                parentTileType = 3;
                break;
            }
            default: {
                selected = null;
                parentTileType = 1;
                break;
            }
        }

        Tile newTile = new Tile(selected.value, selected.row, selected.column, selected.cost_right_left, selected.cost_up_down);
        switch (direction) {
            case UP:
                newTile.moveUp();
                break;
            case DOWN:
                newTile.moveDown();
                break;
            case LEFT:
                newTile.moveLeft();
                break;
            case RIGHT:
                newTile.moveRight();
                break;
        }

        State newState = new State((tile == TileType.Tile1) ? (newTile) : (tile1),
                (tile == TileType.Tile2) ? (newTile) : (tile2),
                (tile == TileType.Tile3) ? (newTile) : (tile3),
                parentTileType);

        int cost = 0;
        if (direction == Move.UP || direction == Move.DOWN) {
            cost = newTile.cost_up_down;
        } else if (direction == Move.LEFT || direction == Move.RIGHT) {
            cost = newTile.cost_right_left;
        }

        int manhattan = 0;

        if (searchingType == 0) { // Uni

        } else { // A* search
            manhattan = Math.abs(goaltile1.row - newState.tile1.row) + Math.abs(goaltile1.column - newState.tile1.column)
                    + Math.abs(goaltile2.row - newState.tile2.row) + Math.abs(goaltile2.column - newState.tile2.column)
                    + Math.abs(goaltile3.row - newState.tile3.row) + Math.abs(goaltile3.column - newState.tile3.column);
        }
        newState.manhattan_cost = manhattan;
        newState.move_cost = root.move_cost + cost;
        newState.total_cost = newState.move_cost + newState.manhattan_cost;

        return newState;
    }

    public static boolean hasReachedGoal(Tile tile1, Tile tile2, Tile tile3, Tile goaltile1, Tile goaltile2, Tile goaltile3) {
        return tile1.row == goaltile1.row && tile1.column == goaltile1.column && tile2.row == goaltile2.row && tile2.column == goaltile2.column && tile3.row == goaltile3.row && tile3.column == goaltile3.column;
    }

    private void createMatrix(int order, int[][] arr, int cost, boolean last) {
        int increase = 180 * (order - 1);
        int[][] pos = {
            // Title
            {388, 90, 248, 29},
            // Matrix Line 1
            {388, 132, 32, 28},
            {427, 132, 32, 28},
            {466, 132, 32, 28},
            // Matrix Line 2
            {388, 167, 32, 28},
            {426, 167, 32, 28},
            {465, 167, 32, 28},
            // Matrix Line 3
            {388, 201, 32, 28},
            {427, 201, 32, 28},
            {466, 201, 32, 28},
            // Cost
            {528, 136, 52, 20},
            {591, 132, 45, 28},
            // Line
            {0, 247, 1024, 19}};

        javax.swing.JLabel title = new javax.swing.JLabel();
        title.setFont(new java.awt.Font("Tahoma", 1, 24));
        title.setForeground(new java.awt.Color(0, 0, 153));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText((!last) ? ("Order #" + order) : ("Goal!"));
        title.setBounds(pos[0][0], pos[0][1] + increase, pos[0][2], pos[0][3]);
        jPanel2.add(title);

        int count = 1;
        javax.swing.JTextField[][] matrix = new javax.swing.JTextField[3][3];
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                matrix[row][col] = new javax.swing.JTextField();
                matrix[row][col].setEditable(false);
                matrix[row][col].setBackground(new java.awt.Color(225, 225, 225));
                matrix[row][col].setFont(new java.awt.Font("Tahoma", 1, 16));
                matrix[row][col].setForeground(new java.awt.Color(153, 0, 51));
                matrix[row][col].setHorizontalAlignment(javax.swing.JTextField.CENTER);
                matrix[row][col].setText(String.valueOf(arr[row][col]));
                matrix[row][col].setBounds(pos[count][0], pos[count][1] + increase, pos[count][2], pos[count][3]);
                jPanel2.add(matrix[row][col]);
                count++;
            }
        }

        javax.swing.JLabel costTitle = new javax.swing.JLabel();
        costTitle.setFont(new java.awt.Font("Tahoma", 1, 16));
        costTitle.setForeground(new java.awt.Color(0, 0, 153));
        costTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        costTitle.setText("Cost:");
        costTitle.setBounds(pos[10][0], pos[10][1] + increase, pos[10][2], pos[10][3]);
        jPanel2.add(costTitle);

        javax.swing.JTextField costField = new javax.swing.JTextField();
        costField.setEditable(false);
        costField.setBackground(new java.awt.Color(225, 225, 225));
        costField.setFont(new java.awt.Font("Tahoma", 1, 16));
        costField.setForeground(new java.awt.Color(153, 0, 51));
        costField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        costField.setText(String.valueOf(cost));
        costField.setBounds(pos[11][0], pos[11][1] + increase, pos[11][2], pos[11][3]);
        jPanel2.add(costField);

        javax.swing.JLabel line = new javax.swing.JLabel();
        line.setFont(new java.awt.Font("Tahoma", 1, 15));
        line.setForeground(new java.awt.Color(102, 153, 0));
        line.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        line.setText("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        line.setBounds(pos[12][0], pos[12][1] + increase, pos[12][2], pos[12][3]);
        jPanel2.add(line);
        insidePanel++;
        if (insidePanel > 2) {
            jPanel2.setPreferredSize(new Dimension(1024, jPanel2.getPreferredSize().height + ((insidePanel == 3) ? (110) : (180))));
        }
    }

    private void cleanPanel() {
        expandOrder.clear();
        stateQueue.clear();
        counter = 0;

        jPanel2.setPreferredSize(new Dimension(1024, 512));
        jPanel2.removeAll();

        javax.swing.JLabel results = new javax.swing.JLabel();
        results.setFont(new java.awt.Font("Tahoma", 1, 32));
        results.setForeground(new java.awt.Color(0, 0, 153));
        results.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        results.setText("Results");
        results.setBounds(388, 22, 248, 39);
        jPanel2.add(results);

        jPanel2.repaint();
        jScrollPane2.revalidate();
        jScrollPane2.repaint();
        insidePanel = 0;
    }

    private void error(String message) {
        JOptionPane.showMessageDialog(this, message, "3x3 Board Game", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField12 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("3x3 Board Game");

        jPanel1.setBackground(new java.awt.Color(255, 204, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(1024, 256));

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(153, 0, 51));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("0");
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(153, 0, 51));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("0");
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField2FocusLost(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(153, 0, 51));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("0");
        jTextField3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField3FocusLost(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });

        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(153, 0, 51));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setText("0");
        jTextField4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField4FocusLost(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });

        jTextField5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(153, 0, 51));
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setText("0");
        jTextField5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField5FocusLost(evt);
            }
        });
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });

        jTextField6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(153, 0, 51));
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setText("0");
        jTextField6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField6FocusLost(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });

        jTextField7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(153, 0, 51));
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setText("0");
        jTextField7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField7FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField7FocusLost(evt);
            }
        });
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7KeyTyped(evt);
            }
        });

        jTextField8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(153, 0, 51));
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setText("0");
        jTextField8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField8FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField8FocusLost(evt);
            }
        });
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField8KeyTyped(evt);
            }
        });

        jTextField9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(153, 0, 51));
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.setText("0");
        jTextField9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField9FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField9FocusLost(evt);
            }
        });
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField9KeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Initial");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Right or Left Move Cost:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Up or Down Move Cost:");

        jTextField10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextField10.setForeground(new java.awt.Color(153, 0, 51));
        jTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField10.setText("0");
        jTextField10.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField10FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField10FocusLost(evt);
            }
        });
        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField10KeyTyped(evt);
            }
        });

        jTextField11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextField11.setForeground(new java.awt.Color(153, 0, 51));
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField11.setText("0");
        jTextField11.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField11FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField11FocusLost(evt);
            }
        });
        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField11KeyTyped(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(153, 0, 51));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Uniform Cost Search", "A* Search" }));

        jTextField12.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextField12.setForeground(new java.awt.Color(153, 0, 51));
        jTextField12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField12.setText("0");
        jTextField12.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField12FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField12FocusLost(evt);
            }
        });
        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField12KeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Goal");

        jTextField13.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextField13.setForeground(new java.awt.Color(153, 0, 51));
        jTextField13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField13.setText("0");
        jTextField13.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField13FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField13FocusLost(evt);
            }
        });
        jTextField13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField13KeyTyped(evt);
            }
        });

        jTextField14.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextField14.setForeground(new java.awt.Color(153, 0, 51));
        jTextField14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField14.setText("0");
        jTextField14.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField14FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField14FocusLost(evt);
            }
        });
        jTextField14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField14KeyTyped(evt);
            }
        });

        jTextField15.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextField15.setForeground(new java.awt.Color(153, 0, 51));
        jTextField15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField15.setText("0");
        jTextField15.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField15FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField15FocusLost(evt);
            }
        });
        jTextField15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField15KeyTyped(evt);
            }
        });

        jTextField16.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextField16.setForeground(new java.awt.Color(153, 0, 51));
        jTextField16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField16.setText("0");
        jTextField16.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField16FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField16FocusLost(evt);
            }
        });
        jTextField16.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField16KeyTyped(evt);
            }
        });

        jTextField17.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextField17.setForeground(new java.awt.Color(153, 0, 51));
        jTextField17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField17.setText("0");
        jTextField17.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField17FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField17FocusLost(evt);
            }
        });
        jTextField17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField17KeyTyped(evt);
            }
        });

        jTextField18.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextField18.setForeground(new java.awt.Color(153, 0, 51));
        jTextField18.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField18.setText("0");
        jTextField18.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField18FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField18FocusLost(evt);
            }
        });
        jTextField18.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField18KeyTyped(evt);
            }
        });

        jTextField19.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextField19.setForeground(new java.awt.Color(153, 0, 51));
        jTextField19.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField19.setText("0");
        jTextField19.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField19FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField19FocusLost(evt);
            }
        });
        jTextField19.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField19KeyTyped(evt);
            }
        });

        jTextField20.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextField20.setForeground(new java.awt.Color(153, 0, 51));
        jTextField20.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField20.setText("0");
        jTextField20.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField20FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField20FocusLost(evt);
            }
        });
        jTextField20.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField20KeyTyped(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 0, 51));
        jButton1.setText("Calculate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(153, 0, 51));
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 153));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("#1");

        jTextField21.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextField21.setForeground(new java.awt.Color(153, 0, 51));
        jTextField21.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField21.setText("0");
        jTextField21.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField21FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField21FocusLost(evt);
            }
        });
        jTextField21.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField21KeyTyped(evt);
            }
        });

        jTextField22.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextField22.setForeground(new java.awt.Color(153, 0, 51));
        jTextField22.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField22.setText("0");
        jTextField22.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField22FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField22FocusLost(evt);
            }
        });
        jTextField22.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField22KeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 153));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("#2");

        jTextField23.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextField23.setForeground(new java.awt.Color(153, 0, 51));
        jTextField23.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField23.setText("0");
        jTextField23.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField23FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField23FocusLost(evt);
            }
        });
        jTextField23.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField23KeyTyped(evt);
            }
        });

        jTextField24.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextField24.setForeground(new java.awt.Color(153, 0, 51));
        jTextField24.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField24.setText("0");
        jTextField24.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField24FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField24FocusLost(evt);
            }
        });
        jTextField24.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField24KeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 153));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("#3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField10, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(jTextField11, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField21)
                            .addComponent(jTextField22)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField23)
                            .addComponent(jTextField24)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(208, 208, 208))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(355, 355, 355)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(355, 355, 355))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(31, 31, 31))
        );

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel2.setBackground(new java.awt.Color(255, 220, 55));
        jPanel2.setPreferredSize(new java.awt.Dimension(1024, 512));
        jPanel2.setRequestFocusEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Results");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(388, 388, 388)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(388, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel5)
                .addGap(451, 451, 451))
        );

        jScrollPane2.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int[][] initial = new int[3][3];
        initial[0][0] = Integer.parseInt(jTextField1.getText());
        initial[0][1] = Integer.parseInt(jTextField2.getText());
        initial[0][2] = Integer.parseInt(jTextField3.getText());

        initial[1][0] = Integer.parseInt(jTextField4.getText());
        initial[1][1] = Integer.parseInt(jTextField5.getText());
        initial[1][2] = Integer.parseInt(jTextField6.getText());

        initial[2][0] = Integer.parseInt(jTextField7.getText());
        initial[2][1] = Integer.parseInt(jTextField8.getText());
        initial[2][2] = Integer.parseInt(jTextField9.getText());

        int[][] goal = new int[3][3];
        goal[0][0] = Integer.parseInt(jTextField17.getText());
        goal[0][1] = Integer.parseInt(jTextField18.getText());
        goal[0][2] = Integer.parseInt(jTextField19.getText());

        goal[1][0] = Integer.parseInt(jTextField20.getText());
        goal[1][1] = Integer.parseInt(jTextField12.getText());
        goal[1][2] = Integer.parseInt(jTextField13.getText());

        goal[2][0] = Integer.parseInt(jTextField14.getText());
        goal[2][1] = Integer.parseInt(jTextField15.getText());
        goal[2][2] = Integer.parseInt(jTextField16.getText());

        int rightLeftTile1 = Integer.parseInt(jTextField10.getText());
        int upDownTile1 = Integer.parseInt(jTextField11.getText());

        int rightLeftTile2 = Integer.parseInt(jTextField21.getText());
        int upDownTile2 = Integer.parseInt(jTextField22.getText());

        int rightLeftTile3 = Integer.parseInt(jTextField23.getText());
        int upDownTile3 = Integer.parseInt(jTextField24.getText());

        int process = jComboBox1.getSelectedIndex();

        if (insidePanel > 0) {
            cleanPanel();
        } else {
            expandOrder.clear();
            stateQueue.clear();
            counter = 0;
        }

        Tile tile1 = null, tile2 = null, tile3 = null;

        for (int row = 0; row < initial.length; row++) {
            for (int col = 0; col < initial[row].length; col++) {
                switch (initial[row][col]) {
                    case 1: {
                        if (tile1 != null) {
                            error("1 can't be more than 1 in initial!");
                            return;
                        }

                        tile1 = new Tile(1, row, col, rightLeftTile1, upDownTile1);
                        break;
                    }
                    case 2: {
                        if (tile2 != null) {
                            error("2 can't be more than 1 in initial!");
                            return;
                        }

                        tile2 = new Tile(2, row, col, rightLeftTile2, upDownTile2);
                        break;
                    }
                    case 3: {
                        if (tile3 != null) {
                            error("3 can't be more than 1 in initial!");
                            return;
                        }

                        tile3 = new Tile(3, row, col, rightLeftTile3, upDownTile3);
                        break;
                    }
                }
            }
        }

        if (tile1 == null) {
            error("1 not found in initial!");
            return;
        }

        if (tile2 == null) {
            error("2 not found in initial!");
            return;
        }

        if (tile3 == null) {
            error("3 not found in initial!");
            return;
        }

        Tile goaltile1 = null, goaltile2 = null, goaltile3 = null;

        for (int row = 0; row < goal.length; row++) {
            for (int col = 0; col < goal[row].length; col++) {
                switch (goal[row][col]) {
                    case 1: {
                        if (goaltile1 != null) {
                            error("1 can't be more than 1 in goal!");
                            return;
                        }

                        goaltile1 = new Tile(1, row, col, rightLeftTile1, upDownTile1);
                        break;
                    }
                    case 2: {
                        if (goaltile2 != null) {
                            error("2 can't be more than 1 in goal!");
                            return;
                        }

                        goaltile2 = new Tile(2, row, col, rightLeftTile2, upDownTile2);
                        break;
                    }
                    case 3: {
                        if (goaltile3 != null) {
                            error("3 can't be more than 1 in goal!");
                            return;
                        }

                        goaltile3 = new Tile(3, row, col, rightLeftTile3, upDownTile3);
                        break;
                    }
                }
            }
        }

        if (goaltile1 == null) {
            error("1 not found in goal!");
            return;
        }

        if (goaltile2 == null) {
            error("2 not found in goal!");
            return;
        }

        if (goaltile3 == null) {
            error("3 not found in goal!");
            return;
        }

        State root = new State(tile1, tile2, tile3, 3);

        int manhattan = 0;
        if (process != 0) {
            manhattan = Math.abs(tile1.row - goaltile1.row) + Math.abs(tile1.column - goaltile1.column)
                    + Math.abs(tile2.row - goaltile2.row) + Math.abs(tile2.column - goaltile2.column)
                    + Math.abs(tile3.row - goaltile3.row) + Math.abs(tile3.column - goaltile3.column);
            root.total_cost = manhattan;
        }

        stateQueue.add(root);

        ExpandTiles(goaltile1, goaltile2, goaltile3, process); // SEARCHING TYPE 0 for unicost, 1 for A*
        for (int i = 0; i < counter; i++) {
            createMatrix(i + 1, expandOrder.get(i).array, expandOrder.get(i).total_cost, (i == counter - 1));
        }

        jPanel2.repaint();
        jScrollPane2.revalidate();
        jScrollPane2.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        cleanPanel();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        char c = evt.getKeyChar();
        System.out.println(jTextField1.getText().length());
        if (!Character.isDigit(c) || (c != '0' && c != '1' && c != '2' && c != '3') || jTextField1.getText().length() >= 1)
            evt.consume();
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || (c != '0' && c != '1' && c != '2' && c != '3') || jTextField2.getText().length() >= 1)
            evt.consume();
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || (c != '0' && c != '1' && c != '2' && c != '3') || jTextField3.getText().length() >= 1)
            evt.consume();
    }//GEN-LAST:event_jTextField3KeyTyped

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || (c != '0' && c != '1' && c != '2' && c != '3') || jTextField4.getText().length() >= 1)
            evt.consume();
    }//GEN-LAST:event_jTextField4KeyTyped

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || (c != '0' && c != '1' && c != '2' && c != '3') || jTextField5.getText().length() >= 1)
            evt.consume();
    }//GEN-LAST:event_jTextField5KeyTyped

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || (c != '0' && c != '1' && c != '2' && c != '3') || jTextField6.getText().length() >= 1)
            evt.consume();
    }//GEN-LAST:event_jTextField6KeyTyped

    private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || (c != '0' && c != '1' && c != '2' && c != '3') || jTextField7.getText().length() >= 1)
            evt.consume();
    }//GEN-LAST:event_jTextField7KeyTyped

    private void jTextField8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || (c != '0' && c != '1' && c != '2' && c != '3') || jTextField8.getText().length() >= 1)
            evt.consume();
    }//GEN-LAST:event_jTextField8KeyTyped

    private void jTextField9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || (c != '0' && c != '1' && c != '2' && c != '3') || jTextField9.getText().length() >= 1)
            evt.consume();
    }//GEN-LAST:event_jTextField9KeyTyped

    private void jTextField17KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField17KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || (c != '0' && c != '1' && c != '2' && c != '3') || jTextField17.getText().length() >= 1)
            evt.consume();
    }//GEN-LAST:event_jTextField17KeyTyped

    private void jTextField18KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField18KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || (c != '0' && c != '1' && c != '2' && c != '3') || jTextField18.getText().length() >= 1)
            evt.consume();
    }//GEN-LAST:event_jTextField18KeyTyped

    private void jTextField19KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField19KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || (c != '0' && c != '1' && c != '2' && c != '3') || jTextField19.getText().length() >= 1)
            evt.consume();
    }//GEN-LAST:event_jTextField19KeyTyped

    private void jTextField20KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField20KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || (c != '0' && c != '1' && c != '2' && c != '3') || jTextField20.getText().length() >= 1)
            evt.consume();
    }//GEN-LAST:event_jTextField20KeyTyped

    private void jTextField12KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || (c != '0' && c != '1' && c != '2' && c != '3') || jTextField12.getText().length() >= 1)
            evt.consume();
    }//GEN-LAST:event_jTextField12KeyTyped

    private void jTextField13KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField13KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || (c != '0' && c != '1' && c != '2' && c != '3') || jTextField13.getText().length() >= 1)
            evt.consume();
    }//GEN-LAST:event_jTextField13KeyTyped

    private void jTextField14KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField14KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || (c != '0' && c != '1' && c != '2' && c != '3') || jTextField14.getText().length() >= 1)
            evt.consume();
    }//GEN-LAST:event_jTextField14KeyTyped

    private void jTextField15KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField15KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || (c != '0' && c != '1' && c != '2' && c != '3') || jTextField15.getText().length() >= 1)
            evt.consume();
    }//GEN-LAST:event_jTextField15KeyTyped

    private void jTextField16KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField16KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || (c != '0' && c != '1' && c != '2' && c != '3') || jTextField16.getText().length() >= 1)
            evt.consume();
    }//GEN-LAST:event_jTextField16KeyTyped

    private void jTextField10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || jTextField10.getText().length() >= 3)
            evt.consume();
    }//GEN-LAST:event_jTextField10KeyTyped

    private void jTextField11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || jTextField11.getText().length() >= 3)
            evt.consume();
    }//GEN-LAST:event_jTextField11KeyTyped

    private void jTextField21KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField21KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || jTextField21.getText().length() >= 3)
            evt.consume();
    }//GEN-LAST:event_jTextField21KeyTyped

    private void jTextField22KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField22KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || jTextField22.getText().length() >= 3)
            evt.consume();
    }//GEN-LAST:event_jTextField22KeyTyped

    private void jTextField23KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField23KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || jTextField23.getText().length() >= 3)
            evt.consume();
    }//GEN-LAST:event_jTextField23KeyTyped

    private void jTextField24KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField24KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || jTextField24.getText().length() >= 3)
            evt.consume();
    }//GEN-LAST:event_jTextField24KeyTyped

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
        if (jTextField1.getText().equals("0"))
            jTextField1.setText("");
    }//GEN-LAST:event_jTextField1FocusGained

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        if (jTextField1.getText().equals(""))
            jTextField1.setText("0");
    }//GEN-LAST:event_jTextField1FocusLost

    private void jTextField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusGained
        if (jTextField2.getText().equals("0"))
            jTextField2.setText("");
    }//GEN-LAST:event_jTextField2FocusGained

    private void jTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusLost
        if (jTextField2.getText().equals(""))
            jTextField2.setText("0");
    }//GEN-LAST:event_jTextField2FocusLost

    private void jTextField3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusGained
        if (jTextField3.getText().equals("0"))
            jTextField3.setText("");
    }//GEN-LAST:event_jTextField3FocusGained

    private void jTextField3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusLost
        if (jTextField3.getText().equals(""))
            jTextField3.setText("0");
    }//GEN-LAST:event_jTextField3FocusLost

    private void jTextField4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField4FocusGained
        if (jTextField4.getText().equals("0"))
            jTextField4.setText("");
    }//GEN-LAST:event_jTextField4FocusGained

    private void jTextField4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField4FocusLost
        if (jTextField4.getText().equals(""))
            jTextField4.setText("0");
    }//GEN-LAST:event_jTextField4FocusLost

    private void jTextField5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField5FocusGained
        if (jTextField5.getText().equals("0"))
            jTextField5.setText("");
    }//GEN-LAST:event_jTextField5FocusGained

    private void jTextField5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField5FocusLost
        if (jTextField5.getText().equals(""))
            jTextField5.setText("0");
    }//GEN-LAST:event_jTextField5FocusLost

    private void jTextField6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField6FocusGained
        if (jTextField6.getText().equals("0"))
            jTextField6.setText("");
    }//GEN-LAST:event_jTextField6FocusGained

    private void jTextField6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField6FocusLost
        if (jTextField6.getText().equals(""))
            jTextField6.setText("0");
    }//GEN-LAST:event_jTextField6FocusLost

    private void jTextField7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField7FocusGained
        if (jTextField7.getText().equals("0"))
            jTextField7.setText("");
    }//GEN-LAST:event_jTextField7FocusGained

    private void jTextField7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField7FocusLost
        if (jTextField7.getText().equals(""))
            jTextField7.setText("0");
    }//GEN-LAST:event_jTextField7FocusLost

    private void jTextField8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField8FocusGained
        if (jTextField8.getText().equals("0"))
            jTextField8.setText("");
    }//GEN-LAST:event_jTextField8FocusGained

    private void jTextField8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField8FocusLost
        if (jTextField8.getText().equals(""))
            jTextField8.setText("0");
    }//GEN-LAST:event_jTextField8FocusLost

    private void jTextField9FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField9FocusGained
        if (jTextField9.getText().equals("0"))
            jTextField9.setText("");
    }//GEN-LAST:event_jTextField9FocusGained

    private void jTextField9FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField9FocusLost
        if (jTextField9.getText().equals(""))
            jTextField9.setText("0");
    }//GEN-LAST:event_jTextField9FocusLost

    private void jTextField17FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField17FocusGained
        if (jTextField17.getText().equals("0"))
            jTextField17.setText("");
    }//GEN-LAST:event_jTextField17FocusGained

    private void jTextField17FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField17FocusLost
        if (jTextField17.getText().equals(""))
            jTextField17.setText("0");
    }//GEN-LAST:event_jTextField17FocusLost

    private void jTextField18FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField18FocusGained
        if (jTextField18.getText().equals("0"))
            jTextField18.setText("");
    }//GEN-LAST:event_jTextField18FocusGained

    private void jTextField18FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField18FocusLost
        if (jTextField18.getText().equals(""))
            jTextField18.setText("0");
    }//GEN-LAST:event_jTextField18FocusLost

    private void jTextField19FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField19FocusGained
        if (jTextField19.getText().equals("0"))
            jTextField19.setText("");
    }//GEN-LAST:event_jTextField19FocusGained

    private void jTextField19FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField19FocusLost
        if (jTextField19.getText().equals(""))
            jTextField19.setText("0");
    }//GEN-LAST:event_jTextField19FocusLost

    private void jTextField20FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField20FocusGained
        if (jTextField20.getText().equals("0"))
            jTextField20.setText("");
    }//GEN-LAST:event_jTextField20FocusGained

    private void jTextField20FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField20FocusLost
        if (jTextField20.getText().equals(""))
            jTextField20.setText("0");
    }//GEN-LAST:event_jTextField20FocusLost

    private void jTextField12FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField12FocusGained
        if (jTextField12.getText().equals("0"))
            jTextField12.setText("");
    }//GEN-LAST:event_jTextField12FocusGained

    private void jTextField12FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField12FocusLost
        if (jTextField12.getText().equals(""))
            jTextField12.setText("0");
    }//GEN-LAST:event_jTextField12FocusLost

    private void jTextField13FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField13FocusGained
        if (jTextField13.getText().equals("0"))
            jTextField13.setText("");
    }//GEN-LAST:event_jTextField13FocusGained

    private void jTextField13FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField13FocusLost
        if (jTextField13.getText().equals(""))
            jTextField13.setText("0");
    }//GEN-LAST:event_jTextField13FocusLost

    private void jTextField14FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField14FocusGained
        if (jTextField14.getText().equals("0"))
            jTextField14.setText("");
    }//GEN-LAST:event_jTextField14FocusGained

    private void jTextField14FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField14FocusLost
        if (jTextField14.getText().equals(""))
            jTextField14.setText("0");
    }//GEN-LAST:event_jTextField14FocusLost

    private void jTextField15FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField15FocusGained
        if (jTextField15.getText().equals("0"))
            jTextField15.setText("");
    }//GEN-LAST:event_jTextField15FocusGained

    private void jTextField15FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField15FocusLost
        if (jTextField15.getText().equals(""))
            jTextField15.setText("0");
    }//GEN-LAST:event_jTextField15FocusLost

    private void jTextField16FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField16FocusGained
        if (jTextField16.getText().equals("0"))
            jTextField16.setText("");
    }//GEN-LAST:event_jTextField16FocusGained

    private void jTextField16FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField16FocusLost
        if (jTextField16.getText().equals(""))
            jTextField16.setText("0");
    }//GEN-LAST:event_jTextField16FocusLost

    private void jTextField10FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField10FocusGained
        if (jTextField10.getText().equals("0"))
            jTextField10.setText("");
    }//GEN-LAST:event_jTextField10FocusGained

    private void jTextField10FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField10FocusLost
        if (jTextField10.getText().equals(""))
            jTextField10.setText("0");
    }//GEN-LAST:event_jTextField10FocusLost

    private void jTextField11FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField11FocusGained
        if (jTextField11.getText().equals("0"))
            jTextField11.setText("");
    }//GEN-LAST:event_jTextField11FocusGained

    private void jTextField11FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField11FocusLost
        if (jTextField11.getText().equals(""))
            jTextField11.setText("0");
    }//GEN-LAST:event_jTextField11FocusLost

    private void jTextField21FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField21FocusGained
        if (jTextField21.getText().equals("0"))
            jTextField21.setText("");
    }//GEN-LAST:event_jTextField21FocusGained

    private void jTextField21FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField21FocusLost
        if (jTextField21.getText().equals(""))
            jTextField21.setText("0");
    }//GEN-LAST:event_jTextField21FocusLost

    private void jTextField22FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField22FocusGained
        if (jTextField22.getText().equals("0"))
            jTextField22.setText("");
    }//GEN-LAST:event_jTextField22FocusGained

    private void jTextField22FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField22FocusLost
        if (jTextField22.getText().equals(""))
            jTextField22.setText("0");
    }//GEN-LAST:event_jTextField22FocusLost

    private void jTextField23FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField23FocusGained
        if (jTextField23.getText().equals("0"))
            jTextField23.setText("");
    }//GEN-LAST:event_jTextField23FocusGained

    private void jTextField23FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField23FocusLost
        if (jTextField23.getText().equals(""))
            jTextField23.setText("0");
    }//GEN-LAST:event_jTextField23FocusLost

    private void jTextField24FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField24FocusGained
        if (jTextField24.getText().equals("0"))
            jTextField24.setText("");
    }//GEN-LAST:event_jTextField24FocusGained

    private void jTextField24FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField24FocusLost
        if (jTextField24.getText().equals(""))
            jTextField24.setText("0");
    }//GEN-LAST:event_jTextField24FocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
