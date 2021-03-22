package hu.nive.ujratervezes.zarovizsga.words;

public class Words {

    public boolean hasMoreDigits(String s){
        int count = 0;
        char[] arr = s.toCharArray();
        for(char item :arr){
            if(isEnglishChar(item)){
                count++;
            }
        }if(count < arr.length-count){
            return true;
        }
        return false;

    }

    private boolean isEnglishChar(char c) {
        return (c >= 'a' && c <= 'z');
    }
}
