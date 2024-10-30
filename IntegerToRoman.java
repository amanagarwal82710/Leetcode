package leetcodeProblems;

public class IntegerToRoman {

    public String intToRoman(int num) {
        int[] numbers = {1000,900,500,400,100,90,50,40,10,9,5,4,1 };
        String[] s = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int i=0;
        StringBuilder newS = new StringBuilder();
        while (num >0){
            if(num >= numbers[i]){
                newS.append(s[i]);
                num = num-numbers[i];
            }
            else {
                i++;
            }
        }

        return newS.toString();
    }


}
