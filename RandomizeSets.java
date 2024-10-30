package leetcodeProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizeSets {

   private List<Integer> list;
   private Map<Integer, Integer> map;

    public void RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();

    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        list.add(val);
        map.put(val, list.size()-1);

        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }

        int indx = map.get(val);
        list.set(indx, list.get(list.size()-1));
        map.put(list.get(indx), indx);
        list.remove(list.size()-1);
        map.remove(val);


        return true;
    }

    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(list.size()%2));

    }
}
