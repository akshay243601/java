package com.akshay.array;

public class FindWordIn2DArrayHorizontalyAndVertically {

    private static boolean isExist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(word.charAt(0) == board[i][j] && isExist(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isExist(char[][] board, int i, int j, String word, int index) {
        if( i < 0 || j < 0 ||  i >= board.length || j >= board[0].length || index >= word.length() || board[i][j] != word.charAt(index)) {
            return false;
        }
        if(word.length() == index + 1) {
            return true;
        }

        char temp = board[i][j];
        board[i][j] = '#';
        boolean isFound =  isExist(board, i+1, j, word, index+1)
                        || isExist(board, i-1, j, word, index+1)
                        || isExist(board, i, j+1, word, index+1)
                        || isExist(board, i, j-1, word, index+1);
        board[i][j] = temp;
        return isFound;
    }


    public static void main(String[] args) {
        char board[][] =
                {
                        {'a', 's', 'a', 'k'},
                        {'k', 's', 'l', 'm'},
                        {'b', 'h', 'c', 'n'},
                        {'y', 'a', 's', 'p'},
                };
        System.out.println(isExist(board, "akshay"));
        System.out.println(isExist(board, "akshayb"));
        System.out.println(isExist(board, "asakmnpsaybkslch"));
        System.out.println(isExist(board, "asaka"));


    }
}
