
package javaapplication26;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author Roshan Amble
 */
public class VirtualPin {
public static String v[]=new String[100000];
    public static void main(String[] args)throws IOException {
        final String u = "https://siliconvalley.basisindependent.com/";
        int count = 0;
        File myFile = new File("file.txt");
        PrintWriter pw = new PrintWriter(myFile);
        try{
            Document doc = Jsoup.connect(u).get();
            pw.println(doc.outerHtml());
            Scanner in = new Scanner(System.in);
            System.out.print("Would you like to print the html?(Y/N): ");
            String html = in.next();
            in.close();
            if(html.equalsIgnoreCase("Y")){
                System.out.println(doc.outerHtml());
            }
            else if(html.equalsIgnoreCase("N")){
                System.out.println("compiling ...");
            }
            in.close();
        }   
        catch(IOException e){
            System.out.println("Something went wrong");
        }
        Scanner sc = new Scanner(myFile);
        while(sc.hasNextLine()){
            v[count]=sc.nextLine();
            count++;
        }
        pw.close();
        int places[] = new int[100000];
        int pcount = 0;
        int fcount = 0;
        int total = 0;
        for(int x = 0;x<count;x++){     //change this for word length
            for(int i=0;i<(v[x].length()-(3));i++){
                if(v[x].substring(i,i+(3)).equals("var")){
                    total++;        //this num should be same as first
                    places[pcount]=x;
                    pcount++;
                }
            }
        }
        int []  ind = new int[count];
        int indcount = 0;
        for(int p = 0;p<(count);p++){
            boolean o = String.valueOf(places[p]).substring(0,String.valueOf(places[p]).length()-1).equals(String.valueOf(places[p+1]).substring(0,String.valueOf(places[p+1]).length()-1));
            boolean o2 = String.valueOf(places[p]).substring(0,String.valueOf(places[p+1]).length()-1).equals(String.valueOf(places[p+1]).substring(0,String.valueOf(places[p+2]).length()-1));
            if(o && o2){
                if(places[p]!=0){
                    System.out.println("High Density at: "+places[p]);
                    ind[indcount] = places[p];
                    indcount++;
                    p+=3;
                    fcount++;
                }
            }
            
        }
        // count = num lines
        // pcount = num lines w/ var
        // indcount = num lines w/ high density
        String[]fp = new String[indcount];
        for(int i = 0;i< indcount;i++){
            fp[i] = v[ind[i]];
        }
        System.out.println(fcount+" high density points");
        System.out.println(total+ " access points");
        sc.close();
        System.out.println("Calculating additional breaching syntax...");
        Bypass bp = new Bypass(fp,ind);
        
    }   
}
// epic parser #html