public class Matrix {
    private int rows;
    private int columns;
    private int[][] matrix;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new int[rows][columns];
    }

    public Matrix(int[][] A){
        this.rows = A.length;
        this.columns = A[0].length;
        this.matrix = A;
    }

    public Matrix() {
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int getEntry(int r, int c){
        if(r > this.rows || r < 0 || c > this.columns || c < 0){
            throw new IllegalArgumentException("invalid input");
        }
        return this.matrix[r][c];
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public void setEntry(int r, int c, int entry){
        if(r > this.rows || r < 0 || c > this.columns || c < 0){
            throw new IllegalArgumentException("invalid input");
        }
        this.matrix[r][c] = entry;
    }

    public void print(){
        for(int i = 0; i < this.getRows(); i++){
            System.out.println();
            for(int j = 0; j < this.getColumns(); j++){
                if(this.getMatrix()[i][j] < 10){
                    System.out.print(" " + this.getMatrix()[i][j] + " ");
                }
                else{
                    System.out.print(this.getMatrix()[i][j] + " ");
                }

            }
        }
    }
    public void randomFill(int upperRange, int lowerRange){
        int r = this.rows;
        int c = this.columns;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                this.setEntry(i,j,(int)(Math.random()* (upperRange - lowerRange)
                        + lowerRange));
            }
        }
    }

    public boolean isSquare(){
        if(this.rows == this.columns){
            return true;
        }
        else{
            return false;
        }
    }

    public void multiplyMatrices(Matrix A, Matrix B){
        if(A.getColumns() != B.getRows()){
            throw new IllegalMatrixOperationException("");
        }
        int[][] product = new int[A.rows][B.columns];
        int[][] a = A.getMatrix();
        int[][] b = B.getMatrix();
        for(int i = 0; i < A.rows; i++) {
            for (int j = 0; j < B.columns; j++) {
                for (int k = 0; k < A.columns; k++) {
                    product[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        this.setMatrix(product);
        this.setRows(A.rows);
        this.setColumns(B.columns);
    }

    public void addMatrices(Matrix A, Matrix B){
        if(A.getRows() != B.getRows()){
            throw new IllegalMatrixOperationException("");
        }
        else if(A.getColumns() != B.getColumns()){
            throw new IllegalMatrixOperationException("");
        }
        int[][] sum = new int[A.rows][B.columns];
        int[][] a = A.getMatrix();
        int[][] b = B.getMatrix();
        for(int i = 0; i < A.rows; i++) {
            for (int j = 0; j < B.columns; j++) {
                sum[i][j] = a[i][j] + b[i][j];
            }
        }
        this.setMatrix(sum);
        this.setRows(A.rows);
        this.setColumns(B.columns);
    }

    public void subtractMatrices(Matrix A, Matrix B){
        if(A.getRows() != B.getRows()){
            throw new IllegalMatrixOperationException("");
        }
        else if(A.getColumns() != B.getColumns()){
            throw new IllegalMatrixOperationException("");
        }
        int[][] diff = new int[A.rows][B.columns];
        int[][] a = A.getMatrix();
        int[][] b = B.getMatrix();
        for(int i = 0; i < A.rows; i++) {
            for (int j = 0; j < B.columns; j++) {
                diff[i][j] = a[i][j] - b[i][j];
            }
        }
        this.setMatrix(diff);
        this.setRows(A.rows);
        this.setColumns(B.columns);
    }

    public String toString() {
        StringBuffer data = new StringBuffer();
        for(int i = 0; i < this.rows; i++){
            if(i > 0){
                data.append("\r\n");
            }
            for(int j = 0; j < this.getColumns(); j++){
                    data.append(this.getMatrix()[i][j]);
                    data.append(" ");
            }
        }
        return data.toString();
    }
}
