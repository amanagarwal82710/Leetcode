package leetcodeProblems;

public class GasStation {

    public int canCompleteCircuit1(int[] gas, int[] cost) {
        for(int i=0; i<gas.length; i++){
            int stepCount =0;
            int j=i;
            int total = 0;
            while (stepCount < gas.length){
                total = gas[j] - cost[j];
                if(total < 0){
                    break;
                }
                j++;
                stepCount ++;
            }

            if(stepCount == gas.length & total >=0){
                return i;
            }
        }

        return -1;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int indx =0;
        int total =0;
        int tank =0;
        for(int i=0; i<gas.length; i++){
            int consume = gas[i] - cost[i];
            tank += consume;
            if(consume<0){
                indx = i+1;
                tank =0;
            }
            total += consume;
        }
        return total == 0? indx: -1;

    }


}
