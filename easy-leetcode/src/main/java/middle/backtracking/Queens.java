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
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new LinkedList<>();
        String[] board = new String[n];
        String init = "";
        for (int i = 0; i < n; i++) {
            init += '.';
        }
        Arrays.fill(board, init);
        backtrack(res, board, 0);
        return res;
    }

    public static void backtrack(List<List<String>> res, String[] board, int row) {
        if (row == board.length) {
            res.add(Arrays.asList(board));
            return;
        }
        int n = board.length;
        for (int col = 0; col < n; col++) {

            if (!isValid(board, row, col)) {
                continue;
            }
            char[] aa = board[row].toCharArray();
            aa[col] = 'Q';
            board[row] = new String(aa);
            backtrack(res, board, row + 1);
            aa[col] = '.';
            board[row] = new String(aa);
        }
    }

    public static boolean isValid(String[] board, int row, int col) {
        int n = board.length;
        for (int i = 0; i < row; i++) {
            if (board[i].charAt(col) == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i].charAt(j) == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - i; i >= 0 && j >= 0; i--, j--) {
            if (board[i].charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
//        Queens queens = new Queens();
//        queens.solveNQueens(4);

        System.out.println(solveNQueens(1));
        System.out.println(solveNQueens(4));
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
