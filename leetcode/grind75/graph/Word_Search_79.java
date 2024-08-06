package graph;

public class Word_Search_79 {
    public static void main(String[] args) {
        Word_Search_79 ss = new Word_Search_79();
        Word_Search_79.Solution solution = ss.new Solution();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "ABCCE";
        boolean result = solution.exist(board, word);
        System.out.println(result);
    }

    /**
     * 使用 dfs 當找到第一個單字一樣的時候，上下左右開始找下一個
     * 如果沒有找到就要回溯，找過的就要標記
     */
    class Solution {
        int rows, cols, wordLen;
        char[] wordChars;

        public boolean exist(char[][] board, String word) {
            rows = board.length;
            cols = board[0].length;
            wordChars = word.toCharArray();
            wordLen = wordChars.length;

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (board[row][col] == wordChars[0]) {
                        if (exist_dfs(board, 1, row, col )) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        private boolean exist_dfs(char[][] board, int index, int row, int col) {
            if (index == wordLen && board[row][col] == wordChars[index - 1]) {
                return true;
            }
            char tmp = board[row][col];
            board[row][col] = '#';
            char nextChar = wordChars[index];

            if (row > 0 && board[row - 1][col] == nextChar && exist_dfs(board, index + 1, row - 1, col))
                return true;
            if (col > 0 && board[row][col - 1] == nextChar && exist_dfs(board, index + 1, row, col - 1))
                return true;
            if (row < board.length - 1 && board[row + 1][col] == nextChar && exist_dfs(board, index + 1, row + 1, col))
                return true;
            if (col < board[0].length - 1 && board[row][col + 1] == nextChar && exist_dfs(board, index + 1, row, col + 1))
                return true;

            board[row][col] = tmp;
            return false;

            // 下面的寫法是之前的，雖然也會先判斷 bound 再繼續 dfs 但上面這樣寫會更快，可能是因為都把各自的邊界獨立出來判斷
            // 比起寫一長串 還要好，且兩者走進 recursive 的次數都一樣，所以之後可以改成 上面 這樣寫
//            char tmp = board[row][col];
//            board[row][col] = '#';
//            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//
//            for (int[] direction : directions) {
//                int newRow = row + direction[0];
//                int newCol = col + direction[1];
//                if (index == wordLen - 1) return true;
//                // bound case and char check
//                if (newRow < 0 || newRow == rows || newCol < 0 || newCol == cols || board[newRow][newCol] != wordChars[index + 1]) {
//                    continue;
//                }
//
//                if (exist_dfs(board, newRow, newCol, index + 1)) {
//                    return true;
//                }
//            }
//            // 如果沒有找到就要改回來
//            board[row][col] = tmp;
//            return false;
        }
    }
}
