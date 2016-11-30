import java.util.Arrays;
/**
 * Write a description of class TriangleArray here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TriangleArray
{
    // instance variables - replace the example below with your own
    private int[][] array;
    private int height;
    private int base;

    /**
     * Constructor for objects of class TriangleArray
     */
    public TriangleArray(String tStr) {
        height = countLines(tStr);
        base = height;
        array = new int[height][];
        array = parseString(tStr, height, base);
        //System.out.println(Arrays.deepToString(array));
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getItemAtCoordinate(int row, int column) {
        if(row < 0 || row > height - 1 || column > row || column < 0)
            return -1;
        return array[row][column];
    }
    
    public boolean increaseItemAtCoordinate(int row, int column, int value) {
        if(row < 0 || row > height - 1 || column > row || column < 0)
            return false;
        array[row][column] += value;
        return true;
    }
    
    public void deleteLastRow() {
        this.height--;
        this.base--;
    }
    
    private static int countLines(String str){
        String[] lines = str.split("\r\n|\r|\n");
        return lines.length;
    }

    private int[][] parseString(String str, int height, int base) {
        int[][] a = new int[height][];
        String[] b = str.split("\n");
        for(int i = 0; i < height; i++) {
            for(int c = 0; c < base; c++) {
                String[] strRow = b[c].split(" ");
                int[] row = new int[strRow.length];
                for(int j = 0; j < row.length; j++) {
                    row[j] = (int) Double.parseDouble(strRow[j]);
                }
                a[c] = row;
            }
        }
        return a;
    }
    
    public int findGreatestSum() {
        return this.reduceTriangleArray().getItemAtCoordinate(0, 0);
    }
    
    private TriangleArray reduceTriangleArray() {
        TriangleArray collapsedArray = this.collapseBottomLayer();
        if(collapsedArray.getHeight() == 1)
            return collapsedArray;
        return collapsedArray.reduceTriangleArray();
    }
    
    private TriangleArray collapseBottomLayer() {
        TriangleArray collapsed = this;
        for(int i = 0; i < collapsed.base; i++) {
            int v1 = collapsed.getItemAtCoordinate(height - 1, i);
            int v2 = collapsed.getItemAtCoordinate(height - 1, i + 1);
            if(v1 > v2)
                collapsed.increaseItemAtCoordinate(height - 2, i, v1);
            else
                collapsed.increaseItemAtCoordinate(height - 2, i, v2);
        }
        collapsed.deleteLastRow();
        return collapsed;
    }
}
