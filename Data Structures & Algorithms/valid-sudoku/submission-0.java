class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> columns = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Map.Entry<Integer, Integer>, Set<Character>> subBoxes = new HashMap<>();

        // For ease of use, just pre-populate
        for(int i = 0; i < board.length; i++) {
            columns.put(i, new HashSet<Character>());
            rows.put(i, new HashSet<Character>());
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                subBoxes.put(Map.entry(i, j), new HashSet<Character>());
            }
        }

        // Violation if already exist when adding
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                char val = board[row][col];
                if(val == '.') continue;
                if(rows.get(row).contains(val)) return false;
                if(columns.get(col).contains(val)) return false;
                if(subBoxes.get(Map.entry(row / 3, col / 3)).contains(val)) return false;
                rows.get(row).add(val);
                columns.get(col).add(val);
                subBoxes.get(Map.entry(row / 3, col / 3)).add(val);
            }
        }

        return true;
    }
}
