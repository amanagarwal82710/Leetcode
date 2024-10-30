package leetcodeProblems;

public class RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int rec1X1 = rec1[0];
        int rec1y1 = rec1[1];
        int rec1X2 = rec1[2];
        int rec1y2 = rec1[3];

        int rec2X1 = rec2[0];
        int rec2y1 = rec2[1];
        int rec2X2 = rec2[2];
        int rec2y2 = rec2[3];
        if(rec2X1 < rec1X2 && rec2y1 < rec1y2 && rec2X2 > rec1X1 && rec2y2 > rec1y1){
            return true;
        }


        return false;
    }
}
