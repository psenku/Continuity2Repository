package VRS.DemoLMS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
       
        /*
        ArrayList al = new ArrayList(12);
        List list = Collections.synchronizedList(al);
        System.out.println( "ArrayList size : " + al.size());
        System.out.println( "ArrayList ? : " + al.isEmpty());
        al.add("Venkat");
        al.add("Ragavan");
        al.add("Srinivasn");
        al.add("VM");
        al.add(null);
        al.add(null);
        al.add(null);
        al.add(null);
        System.out.println( "ArrayList size : " + al.size());
        System.out.println( "ArrayList ? : " + al.isEmpty());
          
        System.out.println( "ArrayList size : " + al.size());
        list.add("Sundar");
        
        synchronized(list) {
        	Iterator itr = al.iterator();
        	while (itr.hasNext()) {
        		System.out.println(itr.next());
        	
        	}	
        	for(int i=0;i<al.size();i++) {
        		System.out.println(al.get(i));
        	}
        }
        
        System.out.println( "ArrayList size : " + al.size());
        */
        /*
        HashMap <Integer,String> ht = new HashMap();
        ht.put(1,"Venkat");
        ht.put(1,"Venkat");
        ht.put(null,null);
        ht.put(null,null);
        ht.put(4,"Vasan");
        
        for (Map.Entry m:ht.entrySet()) {
        	System.out.println(m.getKey() + " " + m.getValue());
        }
        */
        /*
        
        String str = "Venkatragavan Srinivasan";
        StringBuilder strb = new StringBuilder("Sundar Rajan");
        StringBuffer strbf = new StringBuffer("Dwarak Srini");
        System.out.println(strbf.reverse().toString());
        
        for (int i=str.length()-1;i>0;i--) {
        	System.out.print(str.charAt(i));
        }
        
        String sent = "I am Venkatragavan Srinivasan and am an MCA!, living in Perumbakkam, Chennai";
        String[] words = sent.split("\\s+");
        System.out.println(words.length);
        
        for(int i=0;i<words.length;i++) {
        	words[i] = words[i].replace(".","").replace("?","").replace(",","").replace("!","").replace(" ","");
        	System.out.println(words[i]);
        	
        		
        }
        */
        /*
        String kasamusa = "I'm very punctual. No need: to worry, and no problem !!";
        
        String[] splits = kasamusa.split("[,]* | [:] | [,]* | [!]*");
        
        for(int i=0;i<splits.length;i++) {
        	System.out.println(splits[i]);
        }
        */
        App2 ap2 = new App2();
        ap2.iamAnInterfaceMethod();
        int j = ap2.i+10;
        System.out.println(j + ap2.name);
        ap2.displayName();
        ap2.findOnlyNonDigit("27/06/1976 */%34");
        ap2.findOnlyDigit("Venkat is a 5* and born on 27/06/1976");
        System.out.println(ap2.extractDigits("venkat271176@gmail.com"));
        
        String str2="venkat is a gentleman and is an MCA and born in the year 1976".replaceAll("[a-zA-Z]", "");
        System.out.println(str2+ " " +str2.length());
        System.out.println("445.4kg".replaceAll("[^0-9?!\\.]",""));
        
        String s = "12345.6789";
        System.out.println(s.indexOf('.'));
        System.out.println(Integer.parseInt(s.substring(5+1)));
    }
}
