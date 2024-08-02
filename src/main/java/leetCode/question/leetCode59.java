package leetCode.question;

public class leetCode59 {
    public static int[][] generateMatrix(int n) {
        int maxnum = n * n, curnum = 1;
        int[][] matrix = new int [n][n];
        int row = 0, col = 0;
        int[][] directions = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
        int directionflag = 0;
        while (curnum <= maxnum){
            matrix[row][col] = curnum;
            curnum++;
            int nexRow = row + directions[directionflag][0],nextCol = col +directions[directionflag][1];
            if (nexRow < 0|| nexRow >= n || nextCol < 0 || nextCol >= n || matrix[nexRow][nextCol] != 0){
                directionflag =(directionflag + 1) % 4;
            }
            row = row + directions[directionflag][0];
            col = col +directions[directionflag][1];
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(3);
        for(int x=0;x<matrix.length;x++){
            for(int y=0;y<matrix[x].length;y++){
                System.out.print(matrix[x][y]);
            }
            System.out.println();
        }
    }
}
