package leetcodeProblems.Greedy;

public class NmeetingsInOneRoom {
    public int maxMeetings(int start[], int end[]) {
        int n = start.length;
        int j=0;
        int cnt = 1;
        for(int i=1; i<n; i++){
            if(start[i] < end[j]){
                cnt++;
                j=i;
            }
        }
        // add your code here
        return cnt;
    }
}
