package leetcodeProblems;

import java.util.ArrayList;
import java.util.List;

public class fizzBuzz {

    public static void test(List<String> strings){
        for(int i=0; i<strings.size(); i++){
            if(i%3 == 0 && strings.get(i) != "FIZZ"){
                System.out.println("failed case fizz");
            }
            else {
                System.out.println("Passed case FIZZ");
            }
        }
    }

    public void test1(List<String> strings){
        for(int i=0; i<strings.size(); i++){
            if(i%5 == 0 && strings.get(i) != "BUZZ"){
                System.out.println("failed case BUZZ");
            }
            else {
                System.out.println("Passed case FIZZ");
            }
        }
    }

    public void test3(List<String> strings){
        for(int i=0; i<strings.size(); i++){
            if(i%3 == 0 && i%5 == 0 && strings.get(i) != "FIZZBUZZ"){
                System.out.println("failed case FIZZBUZZ");
            }
        }
    }

    public void test4(List<String> strings){
        for(int i=0; i<strings.size(); i++){
            if(i%3 != 0  && i%5 !=0 && (strings.get(i) == "FIZZBUZZ" || strings.get(i) == "FIZZ" || strings.get(i) == "BUZZ")){
                System.out.println("should not contain fizz buzz");
            }
        }
    }

    public List<String> fizzBuzz(int n) {
        List<String> arr = new ArrayList<>();
        for(int i=1; i<=15; i++){
            if((i%3) == 0){
                arr.add("FIZZ");
            } else if ((i%5) == 0) {
                arr.add("BUZZ");
            } else if ((i%3) == 0 && (i%5) == 0) {
                arr.add("FIZZBUZZ");
            }
            else {
                arr.add(String.valueOf(i));
            }
        }

        return arr;
    }

    public static void main(String [] args){
        List<String> strings = new ArrayList<>();
        strings.add(0, String.valueOf(1));
        strings.add(1, "2");
        strings.add(2, "FIZZ");
        test(strings);

    }
}
