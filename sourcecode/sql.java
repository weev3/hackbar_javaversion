/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiweb;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Arrays;
import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 
/**
 *
 * @author kyawmt
 */
public class sql {
    public static String mysqlchar(String value) {
            try {
                String ascii = "";
                String mysqlcharoutput = "";
                char[] stringToCharArray = value.toCharArray();
                for (char output : stringToCharArray) {
			ascii += (int) output;
                        ascii += ",";
		} 
                mysqlcharoutput = "CHAR("+ascii.substring(0, ascii.length() - 1)+")";
                return mysqlcharoutput;
            } catch (Exception ex) {
                throw new RuntimeException(ex.getCause());
            }
        }
    public static String mssqlchar(String value) {
            try {
                String ascii = "";
                String mssqlcharoutput = "";
                char[] stringToCharArray = value.toCharArray();
                for (char output : stringToCharArray) {
			ascii += "CHAR("+(int) output+")+";
                       
		} 
                mssqlcharoutput = ascii.substring(0, ascii.length() - 1);
                return mssqlcharoutput;
            } catch (Exception ex) {
                throw new RuntimeException(ex.getCause());
            }
        }
        public static String oraclesqlchar(String value) {
            try {
                String ascii = "";
                String oraclesqlcharoutput = "";
                char[] stringToCharArray = value.toCharArray();
                for (char output : stringToCharArray) {
			ascii += "CHAR("+(int) output+")||";
                       
		} 
                oraclesqlcharoutput = ascii.substring(0, ascii.length() - 2);
                return oraclesqlcharoutput;
            } catch (Exception ex) {
                throw new RuntimeException(ex.getCause());
            }
        }
        public static String union(int value) {
            try {
                String ascii = "UNION SELECT ";
                String unionsqlcharoutput = "";
                for(int i=1;i<value+1;i++){
                    ascii += i+",";
                }
                unionsqlcharoutput = ascii.substring(0, ascii.length() - 1);
                return unionsqlcharoutput;
            } catch (Exception ex) {
                throw new RuntimeException(ex.getCause());
            }
        }
        public static String spacetoinline(String value) {
            try {
                String ascii = "";
                String unionsqlcharoutput = "";
                return value.replace(" ", "/**/");
            } catch (Exception ex) {
                throw new RuntimeException(ex.getCause());
            }
        }
}
