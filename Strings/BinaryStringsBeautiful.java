package leetcodeProblems.Strings;

public class BinaryStringsBeautiful {

    public int minChanges(String s) {
        if(s.length() == 2 && s.charAt(0) != s.charAt(1)){
            return 1;
        }

        if(s.length() == 2 && s.charAt(0) == s.charAt(1)){
            return 0;
        }
        int count =0;
        for(int i=1; i<s.length(); i+= 2){
            if(s.charAt(i) != s.charAt(i-1)){
                count++;
            }
        }

        return count;
    }
}
