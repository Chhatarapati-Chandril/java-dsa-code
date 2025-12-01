public class Leetcode {

    public static boolean isAlphaNum(char ch){
        if(
            (ch >= '0' && ch <= '9') ||
            (ch >= 'a' && ch <= 'z') ||
            (ch >= 'A' && ch <= 'Z')
        ){
            return true;
        }
        return false;
    }

    public static boolean isPalindrome(String s){
        int n = s.length();
        int start = 0, end = n - 1;
        while(start < end){
            if(!isAlphaNum(s.charAt(start))){
                start++;
                continue;
            }
            if(!isAlphaNum(s.charAt(end))){
                end--;
                continue;
            }
            if(s.toLowerCase().charAt(start)  != s.toLowerCase().charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}