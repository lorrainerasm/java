package javacourse;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class whatever{
        public static String filterString(String str) {
                String s = Normalizer.normalize(str, Form.NFKC);
                //validate input
                Pattern pattern = Pattern.compile("<script>");
                Matcher matcher = pattern.matcher(s);
                if(matcher.find()) {
                        throw new IllegalArgumentException("Invalid input");
                }
                //Deletes non character code points
                s= s.replaceAll("[^\\p{L}\\p{N}\\p{Z}\\p{Sm}\\p{Sc}\\p{Sk}\\p{Pi}\\p{Pf}\\p{Pc}\\p{Mc}]", "");
                s = s.replaceAll("[\\uD83D\\uFFFD\\uFE0F\\u203C\\u3010]", "");
                
                return s;
                
        }
         
        public static void Main(String[] args){
        
                //"\uFDEF" is a noncharacter code point
                String maliciousInput  = "<scr" + "\uFDEF" + "ipt>";
                
                String sb = filterString(maliciousInput);
                //sb = "<script>"
                System.out.print(sb);
        }
}
