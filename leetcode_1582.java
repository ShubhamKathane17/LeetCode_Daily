// brute force - keeping the before, after, above, below indexes of ones at the index in the matrix
// tc - O(n ^ 2)
// sc - O(m + n)

class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] before = new int[m];
        int[] after = new int[m];
        int[] above = new int[n];
        int[] below = new int[n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j<n; j++){
                if(mat[i][j] == 1){
                    before[i] = j;
                    break;
                }
            }
        }
        for(int j = 0; j < n; j++){
            for(int i = 0; i < m; i++){
                if(mat[i][j] == 1){
                    above[j] = i; 
                    break;
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j<n; j++){
                if(mat[i][j] == 1){
                    after[i] = j;
                    below[j] = i;
                }
            }
        }

        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j<n; j++){
                if(mat[i][j] == 1 && above[j] == i &&  below[j] == i && before[i] == j && after[i] == j){
                    count++;
                    break;
                }
            }
        }


        return count;
    }
}


// better - storing the count of ones in rows and columns if the index is at one and the count of ones in row and column is one then the one at the index is the special 
// tc - O(n ^ 2)
// sc - O(m + n)

class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] row = new int[n];
        int[] col = new int[m];

        for(int i = 0; i < m; i++){
            for(int j = 0; j<n; j++){
                if(mat[i][j] == 1){
                    row[j]++;
                    col[i]++;
                }
            }
        }
        

        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j<n; j++){
                if(mat[i][j] == 1 && row[j] == 1 &&  col[i] == 1){
                    count++;
                    break;
                }
            }
        }


        return count;
    }
}
