package middle.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午11:18 2020/12/29
 */
public class Queens {


    /**
     * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     * <p>
     * 上图为 8 皇后问题的一种解法。
     * <p>
     * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
     * <p>
     * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
     * <p>
     * 提示：
     * <p>
     * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
     *
     * @param n
     * @return
     */

    List<List<String>> res = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        List<char[]> board = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            char[] arr = new char[n];
            Arrays.fill(arr, '.');
            board.add(arr);
        }

        backtrack(board, 0);
        return res;
    }

    void backtrack(List<char[]> board, int row) {
        if(row == board.size()){ //触发结束条件
            res.add(transform(board));
        }

        int n = board.size();
        for(int col = 0; col < n; col++){ //遍历所有选择
            if(!isValid(board, row, col)){ //剪枝
                continue;
            }

            board.get(row)[col] = 'Q'; //做出选择
            backtrack(board, row + 1); //进入下一行决策
            board.get(row)[col] = '.'; //撤销选择
        }
    }

    List<String> transform(List<char[]> board){
        List<String> newBoard = new LinkedList<>();
        for(char[] row : board){
            newBoard.add(new String(row));
        }
        return newBoard;
    }

    Boolean isValid(List<char[]> board, int row, int col) {
        int n = board.size();
        for(int i = 0; i < n; i++) { // 检查列是否有皇后互相冲突
            if(board.get(i)[col] == 'Q'){
                return false;
            }
        }

        // 检查右上方是否有皇后互相冲突
        for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--,j++){
            if(board.get(i)[j] == 'Q'){
                return false;
            }
        }

        // 检查左上方是否有皇后互相冲突
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if(board.get(i)[j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Queens queens = new Queens();
        queens.solveNQueens(4);

        System.out.println(queens.solveNQueens(1));
        System.out.println(queens.solveNQueens(4));
//        String[] aa = new String[4];
//        String init = "";
//        for (int i = 0; i < 4; i++) {
//            init += '.';
//        }
//        Arrays.fill(aa, init);
//
//        char[] bb = aa[0].toCharArray();
//        bb[0] = 'Q';
//        aa[0] = new String(bb);
//        System.out.println(aa[0].charAt(0));


    }

}
