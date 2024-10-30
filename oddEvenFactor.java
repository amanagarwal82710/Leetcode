package leetcodeProblems;

import java.util.ArrayList;
import java.util.List;

public class oddEvenFactor {

    public String oddOrEven(int n){
        double x = Math.sqrt(n);
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<= x; i++){
            if(i%n == 0){
                if(i != n/i) {
                    list.add(i, n / i);
                }
                else {
                    list.add(i);
                }
            }
        }
        return (list.size()) % 2 == 0? "odd": "even";
    }

    public List<Integer> prime(int n){
        List<Integer> list = new ArrayList<>();
        for(int i=2; i<= n; i++){
            list.add(i);
        }

        for(int i=0; i<list.size(); i++){
            for(int j= i+1; j<list.size(); j++){
                if(list.get(i) % list.get(j) == 0){
                    list.remove(list.get(j));
                }
            }
        }
        return list;
    }
}
