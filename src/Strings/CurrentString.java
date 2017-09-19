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
        this.visited = visited;
    }

}
