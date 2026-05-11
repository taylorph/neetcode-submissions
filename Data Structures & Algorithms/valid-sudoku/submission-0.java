class Solution {
    public boolean isValidSudoku(char[][] board) {

        // One set for each row
        HashSet<Character>[] rows = new HashSet[9];
        // One set for each column
        HashSet<Character>[] cols = new HashSet[9];
        // One set for each 3x3 square
        HashSet<Character>[] squares = new HashSet[9];

        // Initialize all sets
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            squares[i] = new HashSet<>();
        }

        // Traverse board
        for (int r = 0; r < 9; r++) {

            for (int c = 0; c < 9; c++) {

                char current = board[r][c];

                // Ignore empty cells
                if (current == '.') {
                    continue;
                }

                // Determine which 3x3 square this belongs to
                int squareIndex = (r / 3) * 3 + (c / 3);

                // Duplicate check
                if (rows[r].contains(current) ||
                    cols[c].contains(current) ||
                    squares[squareIndex].contains(current)) {

                    return false;
                }

                // add value into tracking sets
                rows[r].add(current);
                cols[c].add(current);
                squares[squareIndex].add(current);
            }
        }

        return true;
    }
}