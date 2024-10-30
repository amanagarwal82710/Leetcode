package leetcodeProblems;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> kList = new ArrayList<>();
        func(1,n,k,list,kList);
        return list;

    }

    public static void func(int indx, int n, int k, List<List<Integer>> list, List<Integer> kList){
        if(k == 0){
            list.add(new ArrayList<>(kList));
            return;
        }
        if(indx >= n){
            return;
        }
        kList.add(indx);
        func(indx+1,n,k-1,list,kList);
        kList.remove(kList.size()-1);
        func(indx+1,n,k,list,kList);
    }

    public void solve(int indx, int n, int k, List<List<Integer>> list, List<Integer> kList ){
        if(k == 0){
            list.add(new ArrayList<>(kList));
        }

        if(indx > n){
            return;
        }
        for(int i= indx; i<=n; i++){
            kList.add(i);
            solve(i+1,n,k-1,list,kList);
            kList.remove(kList.size()-1);
        }
    }

    public static void main(String[] args){
        int n = 4;
        int k =2;
        List<List<Integer>> list = combine(n,k);
        System.out.println(list);
    }
}
