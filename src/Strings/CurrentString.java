package Strings;

public class CurrentString {

    public String str;
    public int lastRowIndex;
    public int lastColumnIndex;
    public boolean[][] visited;

    public CurrentString(String str, int lastRowIndex, int lastColumnIndex, boolean[][] visited) {
        this.str = str;
        this.lastRowIndex = lastRowIndex;
        this.lastColumnIndex = lastColumnIndex;

        this.visited = new boolean[visited.length][visited[0].length];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                this.visited[i][j] = visited[i][j];
            }
        }
    }

}
