package javaapplication26;
/**
 *
 * @author bobbodude
 */
public class Bypass {
    Bypass(String [] lines,int [] indexes){
        for(int i = 0;i<lines.length;i++){
            String s="";
            for(int k = 0;k<lines[i].length();k++){
                double ans = 2*Math.sqrt((int)(lines[i].charAt(k)));
                double c = 5.0/3.0;
                double an = c*Math.pow(ans, 1.5);
                int answ = (int)(an/2);
                char ch = (char)(answ+10);
                String ss = String.valueOf(ch);
                s+=ss;
            }
            System.out.println("line "+indexes[i]+" : "+s);
        }
    }
    
}
