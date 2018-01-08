public class Solution60{
    public String ReverseSentence(String str) {
        if(str == null || str.length() == 0) return "";
        if(str.trim().equals("")) return str;
        StringBuilder sb = new StringBuilder();
        String[] s = str.split(" ");     
        for(int i = s.length - 1; i > 0; i--) {
            sb.append(s[i] + " ");
        }
        if(s.length >= 1) sb.append(s[0]);
         
        return sb.toString();
    }
        
}