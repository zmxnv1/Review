public class Solution59{
    int[] dir = {1, 0, -1, 0, 0, 1, 0, -1};
    int cols = 0;
    int rows = 0;
    char[] str;

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        this.rows = rows;
        this.cols = cols;
        this.str = str;
        int index = 0;
        if(str ==  null || str.length == 0) return true;
        if(matrix.length < str.length) return false;
        int[] vis = new int[matrix.length];
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i] == str[index]) {
                vis[i] = 1;
                if(search(matrix, index + 1, i / cols, i - i / cols * cols, vis)) return true;
                vis[i] = 0;
            }
        }

        return false;
    }
    public boolean search(char[] matrix, int index, int x, int y, int[] vis) {
        if(index == str.length) return true;
        for(int i = 0; i < 4; i++) {
            int a = x + dir[i * 2], b = y + dir[i * 2 + 1];
            if(!judge(a, b) || vis[a * cols + b] == 1) continue;
            if(matrix[a * cols + b] == str[index]) {
                vis[a * cols + b] = 1;
                if(search(matrix, index + 1, a, b, vis)) return true;
                vis[a * cols + b] = 0;
            }
        }
        return false;
    }

    public boolean judge(int x, int y) {
        if(x < rows && x >= 0 && y < cols && y >= 0  ) return true;
        return false;
    }

}
