import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MatrixCalculatorGUI extends JFrame {

    public MatrixCalculatorGUI(String title, int x, int y) {
        setTitle(title);
        setSize(x, y);
        setLocation(400, 50);
        setResizable(false);
        createFileMenu();
        openScreen();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createFileMenu() {
        JMenuBar menuBar = new JMenuBar();

        setJMenuBar(menuBar);
        MenuHandler mh = new MenuHandler(this);

        JMenu fileMenu = new JMenu("File");
        JMenuItem itemQuit = new JMenuItem("Quit");
        itemQuit.addActionListener(mh);
        fileMenu.add(itemQuit);

        JMenu info = new JMenu("Info");

        menuBar.add(fileMenu);
        menuBar.add(info);
    }

    private void openScreen() {
        /*Panel Added to JFrame*/
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.DARK_GRAY);
        this.add(panel);

        /*Label Titles*/
        JLabel openScreen = new JLabel("Meg Dev's Matrix Calculator");
        JLabel matrixA = new JLabel("Matrix A");
        JLabel matrixB = new JLabel("Matrix B");
        JLabel matrixAnswer = new JLabel("Answer");
        JLabel history = new JLabel("History");

        /*Label Bounds*/
        openScreen.setBounds(215, 0, 700, 60);
        matrixA.setBounds(100, 50, 500, 50);
        matrixB.setBounds(450, 50, 500, 50);
        matrixAnswer.setBounds(810, 50, 500, 50);
        history.setBounds(700, 420, 500, 50);

        /*Label Font*/
        Font titleFont = new Font("Monospaced", Font.BOLD, 40);
        openScreen.setFont(titleFont);
        Font labFont = new Font("Monospaced", Font.BOLD, 30);
        matrixA.setFont(labFont);
        matrixB.setFont(labFont);
        matrixAnswer.setFont(labFont);
        history.setFont(labFont);

        /*Label Foreground Color*/
        openScreen.setForeground(Color.white);
        matrixA.setForeground(Color.CYAN);
        matrixB.setForeground(Color.CYAN);
        matrixAnswer.setForeground(Color.CYAN);
        history.setForeground(Color.CYAN);

        /*Labels Added To Panel*/
        panel.add(openScreen);
        panel.add(matrixA);
        panel.add(matrixB);
        panel.add(matrixAnswer);
        panel.add(history);

        /*Matrix TextAreas*/
        TextArea taA = new TextArea();
        TextArea taB = new TextArea();
        TextArea taAnswer = new TextArea();
        taAnswer.setEditable(false);
        TextArea taHistory = new TextArea();
        taHistory.setEditable(false);
        JScrollPane jScrollPane =
                new JScrollPane(taHistory,
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        panel.add(jScrollPane);


        /*TextArea Bounds*/
        taA.setBounds(60, 100, 250, 250);
        taB.setBounds(400, 100, 250, 250);
        taAnswer.setBounds(740, 100, 250, 250);
        taHistory.setBounds(570, 480, 400, 300);

        /*TextArea Font*/
        Font taFont = new Font("Monospaced", Font.BOLD, 40);
        taA.setFont(taFont);
        taB.setFont(taFont);
        taAnswer.setFont(taFont);
        Font histFont = new Font("Monospaced", Font.BOLD, 25);
        taHistory.setFont(histFont);

        /*TextArea Foreground Color*/
        taA.setForeground(Color.DARK_GRAY);
        taB.setForeground(Color.DARK_GRAY);
        taAnswer.setForeground(Color.DARK_GRAY);
        taHistory.setForeground(Color.DARK_GRAY);

        /*TextArea Added To Panel*/
        panel.add(taA);
        panel.add(taB);
        panel.add(taAnswer);
        panel.add(taHistory);

        /*TextArea Buttons*/
        /*Clear Button A and Action*/
        Button clearMatA = new Button("Clear A");
        clearMatA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent clearMatA) {
                taA.setForeground(Color.DARK_GRAY);
                if (!taA.getText().equals("")) {
                    taA.setText("");
                } else {
                    taA.setText("");
                }
            }
        });

        /*Rand Button A and Action*/
        Button randA = new Button("A = RAND");
        randA.addActionListener((new ActionListener() {
            public void actionPerformed(ActionEvent randA) {
                String userInput = JOptionPane.showInputDialog
                        (null, "Please enter rows and columns" +
                                " in proper format", "rows,columns");
                String userInput2 = JOptionPane.showInputDialog
                        (null, "Please enter entry range" +
                                " in proper format", "upperbound" +
                                ",lowerbound");

                try {
                    String[] input = userInput.split(",");
                    int rows = Integer.parseInt(input[0]);
                    int columns = Integer.parseInt(input[1]);

                    String[] input2 = userInput2.split(",");
                    int upper = Integer.parseInt(input2[0]);
                    int lower = Integer.parseInt(input2[1]);

                    Matrix rand = new Matrix(rows, columns);
                    rand.randomFill(upper, lower);
                    taA.setText(rand.toString());

                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null,
                            "Input is invalid" +
                            "\n Try again with valid input");
                }
            }
        }));

        /*Clear Button B and Action*/
        Button clearMatB = new Button("Clear B");
        clearMatB.addActionListener((new ActionListener() {
            public void actionPerformed(ActionEvent clearMatB) {
                taB.setForeground(Color.DARK_GRAY);
                if (!taB.getText().equals("")) {
                    taB.setText("");
                } else {
                    taB.setText("");
                }
            }
        }));

        /*Rand Button B and Action*/
        Button randB = new Button("B = RAND");
        randB.addActionListener((new ActionListener() {
            public void actionPerformed(ActionEvent randB) {
                String userInput = JOptionPane.showInputDialog
                        (null, "Please enter rows and columns" +
                                " in proper format", "rows,columns");
                String userInput2 = JOptionPane.showInputDialog
                        (null, "Please enter entry range" +
                                " in proper format", "upperbound" +
                                ",lowerbound");

                try {
                    String[] input = userInput.split(",");
                    int rows = Integer.parseInt(input[0]);
                    int columns = Integer.parseInt(input[1]);

                    String[] input2 = userInput2.split(",");
                    int upper = Integer.parseInt(input2[0]);
                    int lower = Integer.parseInt(input2[1]);

                    Matrix rand = new Matrix(rows, columns);
                    rand.randomFill(upper, lower);
                    taB.setText(rand.toString());

                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null,
                            "Input is invalid" +
                            "\n Try again with valid input");
                }
            }
        }));

        /*Reverse Button and Action*/
        Button reverseMatrix = new Button("\u21C4");
        reverseMatrix.addActionListener((new ActionListener() {
            public void actionPerformed(ActionEvent reverseMatrix) {
                String temp = taA.getText();
                taA.setText(taB.getText());
                taB.setText(temp);
            }
        }));

        /*Clear Button Answer and Action*/
        Button clearMatAns = new Button("Clear");
        clearMatAns.addActionListener((new ActionListener() {
            public void actionPerformed(ActionEvent clearMatAnswer) {
                if (!taAnswer.getText().equals("")) {
                    taAnswer.setText("");
                } else {
                    taAnswer.setText("");
                }

            }
        }));

        /*Set to A Button and Action*/
        Button setToA = new Button("Set to A");
        setToA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ansEqualsA) {
                if (!taAnswer.getText().equals("")) {
                    taA.setText(taAnswer.getText());

                }
            }
        });

        /*TextArea Button Bounds*/
        clearMatA.setBounds(70, 360, 100, 40);
        randA.setBounds(200, 360, 100, 40);
        clearMatB.setBounds(410, 360, 100, 40);
        randB.setBounds(540, 360, 100, 40);
        reverseMatrix.setBounds(335, 200, 40, 40);
        clearMatAns.setBounds(750, 360, 100, 40);
        setToA.setBounds(880, 360, 100, 40);

        /*TextArea Button Background Color*/
        clearMatA.setBackground(Color.CYAN);
        randA.setBackground(Color.CYAN);
        clearMatB.setBackground(Color.CYAN);
        randB.setBackground(Color.CYAN);
        reverseMatrix.setBackground(Color.CYAN);
        clearMatAns.setBackground(Color.CYAN);
        setToA.setBackground(Color.CYAN);

        /*TextArea Button Foreground Color*/
        clearMatA.setForeground(Color.DARK_GRAY);
        randA.setForeground(Color.DARK_GRAY);
        clearMatB.setForeground(Color.DARK_GRAY);
        randB.setForeground(Color.DARK_GRAY);
        reverseMatrix.setForeground(Color.DARK_GRAY);
        clearMatAns.setForeground(Color.DARK_GRAY);
        setToA.setForeground(Color.DARK_GRAY);

        /*TextArea Button Font*/
        Font buttonFont = new Font("Monospaced", Font.BOLD, 15);
        clearMatA.setFont(buttonFont);
        randA.setFont(buttonFont);
        clearMatB.setFont(buttonFont);
        randB.setFont(buttonFont);
        reverseMatrix.setFont(buttonFont);
        clearMatAns.setFont(buttonFont);
        setToA.setFont(buttonFont);

        /*Add TextArea Button*/
        panel.add(clearMatA);
        panel.add(randA);
        panel.add(clearMatB);
        panel.add(randB);
        panel.add(reverseMatrix);
        panel.add(clearMatAns);
        panel.add(setToA);

        /*Operator Buttons*/
        /*aMULTb Button and Action*/
        Button aMULTb = new Button("A * B");
        // A * B action
        aMULTb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent aMULTb) {
                String matrixAdata = taA.getText();
                String matrixBdata = taB.getText();
                try {
                    int[][] matrixA = readTextArea(matrixAdata);
                    int[][] matrixB = readTextArea(matrixBdata);
                    Matrix A = new Matrix(matrixA);
                    Matrix B = new Matrix(matrixB);
                    Matrix product = new Matrix();
                    product.multiplyMatrices(A, B);
                    taAnswer.setText(product.toString());
                    taHistory.setText(operatorHistLogFormat(A, B, product, "*") + "\n" +
                            taHistory.getText());
                } catch (IllegalMatrixOperationException e) {
                    JOptionPane.showMessageDialog(null,
                            "The number of columns in matrix A must be " +
                                    "equal to the rows in Matrix B in order" +
                                    " to perform action A * B");
                } catch (IllegalArgumentException e) {
                    if (taA.getText().equals("")) {
                        JOptionPane.showMessageDialog(null,
                                "Matrix A has no input");
                    } else if (taB.getText().equals("")) {
                        JOptionPane.showMessageDialog(null,
                                "Matrix B has no input");
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Matrix A and/or B have invalid input");
                    }
                    setErrorRed(taA);
                    setErrorRed(taB);
                }
            }
        });

        /*bMULTa Button and Action*/
        Button bMULTa = new Button("B * A");
        // B * A Action
        bMULTa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent bMULTa) {
                String matrixAdata = taA.getText();
                String matrixBdata = taB.getText();
                try {
                    int[][] matrixA = readTextArea(matrixAdata);
                    int[][] matrixB = readTextArea(matrixBdata);
                    Matrix A = new Matrix(matrixA);
                    Matrix B = new Matrix(matrixB);
                    Matrix product = new Matrix();
                    product.multiplyMatrices(B, A);
                    taAnswer.setText(product.toString());
                    taHistory.setText(operatorHistLogFormat(B, A, product, "*") + "\n" +
                            taHistory.getText());
                } catch (IllegalMatrixOperationException e) {
                    JOptionPane.showMessageDialog(null,
                            "The number of columns in matrix B must be equal to the" +
                                    " rows in Matrix A in order to perform action " +
                                    "B * A");
                } catch (IllegalArgumentException e) {
                    if (taA.getText().equals("")) {
                        JOptionPane.showMessageDialog(null,
                                "Matrix A has no input");
                    } else if (taB.getText().equals("")) {
                        JOptionPane.showMessageDialog(null,
                                "Matrix B has no input");
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Matrix A and/or B have invalid input");
                    }
                    setErrorRed(taA);
                    setErrorRed(taB);
                }

            }
        });

        /*aADDb Button and Action*/
        Button aADDb = new Button("A + B");
        // A + B Action
        aADDb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent aADDb) {
                String matrixAdata = taA.getText();
                String matrixBdata = taB.getText();
                try {
                    int[][] matrixA = readTextArea(matrixAdata);
                    int[][] matrixB = readTextArea(matrixBdata);
                    Matrix A = new Matrix(matrixA);
                    Matrix B = new Matrix(matrixB);
                    Matrix sum = new Matrix();
                    sum.addMatrices(A, B);
                    taAnswer.setText(sum.toString());
                    taHistory.setText(operatorHistLogFormat(A, B, sum, "+") + "\n" +
                            taHistory.getText());
                } catch (IllegalMatrixOperationException e) {
                    JOptionPane.showMessageDialog(null,
                            "The rows and columns in Matrix A and B " +
                                    "must be equal in" +
                                    " order to calculate A + B");
                } catch (IllegalArgumentException e) {
                    if (taA.getText().equals("")) {
                        JOptionPane.showMessageDialog(null,
                                "Matrix A has no input");
                    } else if (taB.getText().equals("")) {
                        JOptionPane.showMessageDialog(null,
                                "Matrix B has no input");
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Matrix A and/or B have invalid input");
                    }
                    setErrorRed(taA);
                    setErrorRed(taB);
                }

            }
        });

        /*bADDa Button and Action*/
        Button bADDa = new Button("B + A");
        bADDa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent aADDb) {
                String matrixAdata = taA.getText();
                String matrixBdata = taB.getText();
                try {
                    int[][] matrixA = readTextArea(matrixAdata);
                    int[][] matrixB = readTextArea(matrixBdata);
                    Matrix A = new Matrix(matrixA);
                    Matrix B = new Matrix(matrixB);
                    Matrix sum = new Matrix();
                    sum.addMatrices(B, A);
                    taAnswer.setText(sum.toString());
                    taHistory.setText(operatorHistLogFormat(B, A, sum, "+") + "\n" +
                            taHistory.getText());
                } catch (IllegalMatrixOperationException e) {
                    JOptionPane.showMessageDialog(null,
                            "The rows and columns in Matrix A and B must be equal in" +
                                    " order to calculate A + B");
                } catch (IllegalArgumentException e) {
                    if (taA.getText().equals("")) {
                        JOptionPane.showMessageDialog(null,
                                "Matrix A has no input");
                    } else if (taB.getText().equals("")) {
                        JOptionPane.showMessageDialog(null,
                                "Matrix B has no input");
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Matrix A and/or B have invalid input");
                    }
                    setErrorRed(taA);
                    setErrorRed(taB);
                }

            }
        });

        /*sqA Button and Action*/
        Button sqA = new Button("A^2");
        sqA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent sqA) {
                taB.setText("");
                String matrixAdata = taA.getText();
                try {
                    int[][] matrixA = readTextArea(matrixAdata);
                    Matrix A = new Matrix(matrixA);
                    if (A.isSquare()) {
                        Matrix product = new Matrix();
                        product.multiplyMatrices(A, A);
                        taAnswer.setText(product.toString());
                        taHistory.setText(squaredMatrixHistLog(A,product) + "\n" +
                                taHistory.getText());
                    }
                    else {
                        throw new IllegalMatrixOperationException("");
                    }
                } catch (IllegalMatrixOperationException e) {
                    JOptionPane.showMessageDialog(null,
                            "Matrix A must be square in order to perform action " +
                                    "A^2");
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null,
                            "Matrix A has invalid input");
                    setErrorRed(taA);
                }
            }
        });

        /*sqB Button and Action*/
        Button sqB = new Button("B^2");
        sqB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent sqB) {
                taA.setText("");
                String matrixBdata = taB.getText();
                try {
                    int[][] matrixB = readTextArea(matrixBdata);
                    Matrix B = new Matrix(matrixB);
                    if (B.isSquare()) {
                        Matrix product = new Matrix();
                        product.multiplyMatrices(B, B);
                        taAnswer.setText(product.toString());
                        taHistory.setText(squaredMatrixHistLog(B,product) + "\n" +
                                taHistory.getText());
                    } else {
                        throw new IllegalMatrixOperationException("");
                    }
                } catch (IllegalMatrixOperationException e) {
                    JOptionPane.showMessageDialog(null,
                            "Matrix B must be square in order to perform action " +
                                    "B^2");
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null,
                            "Matrix B has invalid input");
                    setErrorRed(taB);
                }
            }
        });

        /*detA Button and Action*/
        Button aSUBb = new Button("A - B");
        aSUBb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent aSUBb) {
                String matrixAdata = taA.getText();
                String matrixBdata = taB.getText();
                try {
                    int[][] matrixA = readTextArea(matrixAdata);
                    int[][] matrixB = readTextArea(matrixBdata);
                    Matrix A = new Matrix(matrixA);
                    Matrix B = new Matrix(matrixB);
                    Matrix difference = new Matrix();
                    difference.subtractMatrices(A,B);
                    taAnswer.setText(difference.toString());
                    taHistory.setText(operatorHistLogFormat(A,B, difference, "-")
                            + "\n" + taHistory.getText());
                } catch (IllegalMatrixOperationException e) {
                    JOptionPane.showMessageDialog(null,
                            "The rows and columns in Matrix A and B " +
                                    "must be equal in order to calculate A - B");
                } catch (IllegalArgumentException e) {
                    if (taA.getText().equals("")) {
                        JOptionPane.showMessageDialog(null,
                                "Matrix A has no input");
                    } else if (taB.getText().equals("")) {
                        JOptionPane.showMessageDialog(null,
                                "Matrix B has no input");
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Matrix A and/or B have invalid input");
                    }
                    setErrorRed(taA);
                    setErrorRed(taB);
                }
            }
        });

        /*detB Button and Action*/
        Button bSUBa = new Button("B - A");
        bSUBa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent aSUBb) {
                String matrixAdata = taA.getText();
                String matrixBdata = taB.getText();
                try {
                    int[][] matrixA = readTextArea(matrixAdata);
                    int[][] matrixB = readTextArea(matrixBdata);
                    Matrix A = new Matrix(matrixA);
                    Matrix B = new Matrix(matrixB);
                    Matrix difference = new Matrix();
                    difference.subtractMatrices(B,A);
                    taAnswer.setText(difference.toString());
                    taHistory.setText(operatorHistLogFormat(B, A, difference, "-")
                            + "\n" +
                            taHistory.getText());
                } catch (IllegalMatrixOperationException e) {
                    JOptionPane.showMessageDialog(null,
                            "The rows and columns in Matrix A and B must be " +
                                    "equal in order to calculate A - B");
                } catch (IllegalArgumentException e) {
                    if (taA.getText().equals("")) {
                        JOptionPane.showMessageDialog(null,
                                "Matrix A has no input");
                    } else if (taB.getText().equals("")) {
                        JOptionPane.showMessageDialog(null,
                                "Matrix B has no input");
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Matrix A and/or B have invalid input");
                    }
                    setErrorRed(taA);
                    setErrorRed(taB);
                }
            }
        });

        /*Operator Button Bounds*/
        aMULTb.setBounds(60, 480, 100, 100);
        bMULTa.setBounds(170, 480, 100, 100);
        aADDb.setBounds(280, 480, 100, 100);
        bADDa.setBounds(390, 480, 100, 100);
        sqA.setBounds(60, 600, 100, 100);
        sqB.setBounds(170, 600, 100, 100);
        aSUBb.setBounds(280, 600, 100, 100);
        bSUBa.setBounds(390, 600, 100, 100);

        /*Operator Button Background Color*/
        aMULTb.setBackground(Color.CYAN);
        bMULTa.setBackground(Color.CYAN);
        aADDb.setBackground(Color.CYAN);
        bADDa.setBackground(Color.CYAN);
        sqA.setBackground(Color.CYAN);
        sqB.setBackground(Color.CYAN);
        aSUBb.setBackground(Color.CYAN);
        bSUBa.setBackground(Color.CYAN);

        /*TextArea Button Foreground Color*/
        aMULTb.setForeground(Color.DARK_GRAY);
        bMULTa.setForeground(Color.DARK_GRAY);
        aADDb.setForeground(Color.DARK_GRAY);
        bADDa.setForeground(Color.DARK_GRAY);
        sqA.setForeground(Color.DARK_GRAY);
        sqB.setForeground(Color.DARK_GRAY);
        aSUBb.setForeground(Color.DARK_GRAY);
        bSUBa.setForeground(Color.DARK_GRAY);

        /*TextArea Button Font*/
        Font opFont = new Font("Monospaced", Font.BOLD, 22);
        aMULTb.setFont(opFont);
        bMULTa.setFont(opFont);
        aADDb.setFont(opFont);
        bADDa.setFont(opFont);
        sqA.setFont(opFont);
        sqB.setFont(opFont);
        aSUBb.setFont(opFont);
        bSUBa.setFont(opFont);

        /*Add Operator Buttons*/
        panel.add(aMULTb);
        panel.add(aADDb);
        panel.add(bMULTa);
        panel.add(bADDa);
        panel.add(sqA);
        panel.add(sqB);
        panel.add(aSUBb);
        panel.add(bSUBa);

    }

    public static int[][] readTextArea(String data) {
        String[] dataRow = data.split("\r\n");
        int rows = dataRow.length;
        int columns = dataRow[0].split(" ").length;
        int[][] matrix2Darray = new int[rows][columns];
        if (inputValid(data)) {
            for (int i = 0; i < rows; i++) {
                String[] entries = dataRow[i].split(" ");
                for (int j = 0; j < entries.length; j++) {
                    matrix2Darray[i][j] = Integer.parseInt(entries[j]);
                }
            }
        } else {
            throw new IllegalArgumentException("invalid input");
        }
        return matrix2Darray;
    }

    public static boolean inputValid(String data) {
        boolean valid = true;
        String[] dataRow = data.split("\r\n");
        int rows = dataRow.length;
        int columns = dataRow[0].split(" ").length;
        for (int i = 0; i < rows; i++) {
            String[] entries = dataRow[i].split(" ");
            if (entries.length != columns) {
                valid = false;
            }
        }
        return valid;
    }

    public void setErrorRed(TextArea area){
        String areaText = area.getText();
        for(int i = 0; i < areaText.length(); i++){
            if(!Character.isDigit(areaText.charAt(i))) {
                if (areaText.charAt(i) != ' ') {
                    if (areaText.charAt(i) != '\n') {
                        if (areaText.charAt(i) != '\r') {
                            area.setForeground(Color.RED);
                        }
                    }
                }
            }
        }
    }

    public String operatorHistLogFormat(Matrix first, Matrix sec, Matrix ans, String op) {
        String hist = "";
        String[] firstString;
        String[] secString;
        int range;
        if (first.getRows() > sec.getRows()) {
            range = first.getRows();
            firstString = first.toString().split("\r\n");
            String[] temp = sec.toString().split("\r\n");
            secString = new String[range];
            for (int i = 0; i < temp.length; i++) {
                secString[i] = temp[i];
            }
            for (int i = 0; i < secString.length; i++) {
                if (secString[i] == null) {
                    int count = 0;
                    String blanks = "";
                    while (count < secString[0].length()) {
                        blanks += " ";
                        count++;
                    }
                    secString[i] = blanks;
                }
            }
        } else {
            range = sec.getRows();
            secString = sec.toString().split("\r\n");
            String[] temp = first.toString().split("\r\n");
            firstString = new String[range];
            for (int i = 0; i < temp.length; i++) {
                firstString[i] = temp[i];
            }
            for (int i = 0; i < firstString.length; i++) {
                if (firstString[i] == null) {
                    int count = 0;
                    String blanks = "";
                    while (count < firstString[0].length()) {
                        blanks += " ";
                        count++;
                    }
                    firstString[i] = blanks;
                }
            }
        }
        for (int i = 0; i < range; i++) {
            if (i + 1 == range / 2) {
                hist += firstString[i] + " " + op + " " + secString[i] + " =\n";
            } else {
                hist += firstString[i] + "   " + secString[i] + '\n';
            }
        }
        hist += "\n" + ans.toString() + "\n";
        return hist;
    }

    public String squaredMatrixHistLog(Matrix m, Matrix ans){
        String hist = "";
        String [] mat = m.toString().split("\r\n");
        for(int i = 0; i < m.getRows(); i++){
            if(i == 0){
                hist += mat[i] + "^2\n";
            }
            else if(i+1 == m.getRows()){
                hist += mat[i] + "      =\n";
            }
            else{
                hist += mat[i] + "\n";
            }
        }
        hist += "\n" + ans.toString() + "\n";
        return hist;
    }
}
