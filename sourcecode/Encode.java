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
public class Encode {
    public static String urlencodeValue(String value) {
            try {
                return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
            } catch (UnsupportedEncodingException ex) {
                throw new RuntimeException(ex.getCause());
            }
        }
    public static String urldecodeValue(String value) {
            try {
                return URLDecoder.decode(value, StandardCharsets.UTF_8.toString());
            } catch (UnsupportedEncodingException ex) {
                throw new RuntimeException(ex.getCause());
            }
        }
    public static String base64encodeValue(String value) {
            try {
                Base64.Encoder encoder = Base64.getEncoder(); 
                return encoder.encodeToString(value.getBytes()); 
            } catch (Exception ex) {
                throw new RuntimeException(ex.getCause());
            }
        }
    public static String base64decodeValue(String value) {
            try {
                Base64.Decoder decoder = Base64.getDecoder();
                byte[] bytes = decoder.decode(value);
                String decodedString = new String(bytes);
                return decodedString; 
            } catch (Exception ex) {
                throw new RuntimeException(ex.getCause());
            }
        }
    public static String hexencodeValue(String value) {
            try {
                String hexencodeValue = "";
                char[] stringToCharArray = value.toCharArray();
                for (char output : stringToCharArray) {
			hexencodeValue += Integer.toHexString((int) output);
                        
		} 
                return hexencodeValue;
            } catch (Exception ex) {
                throw new RuntimeException(ex.getCause());
            }
        }
    public static String hexdecodeValue(String value) {
            try {
                StringBuilder sb = new StringBuilder();
                StringBuilder temp = new StringBuilder();
	  
	  //49204c6f7665204a617661 split into two characters 49, 20, 4c...
                for( int i=0; i<value.length()-1; i+=2 ){

                    //grab the hex in pairs
                    String output = value.substring(i, (i + 2));
                    //convert hex to decimal
                    int decimal = Integer.parseInt(output, 16);
                    //convert the decimal to character
                    sb.append((char)decimal);
                }

                return sb.toString();
            } catch (Exception ex) {
                throw new RuntimeException(ex.getCause());
            }
        }
    public static String binaryencodeValue(String value) {
            try {
                String binencodeValue = "";
                char[] stringToCharArray = value.toCharArray();
                for (char output : stringToCharArray) {
			binencodeValue += Integer.toBinaryString((int) output);
                        binencodeValue += " ";
		} 
                return binencodeValue;
            } catch (Exception ex) {
                throw new RuntimeException(ex.getCause());
            }
        }
    public static String binarydecodeValue(String value) {
            try {
                  String binString = "";
                  String bintostr = "";
                  binString = value.trim();
                  String[] arrOfStr = binString.split(" ");
                  for(int i=0; i< arrOfStr.length; i++)
                  {
                      bintostr += (char)Integer.parseInt(arrOfStr[i], 2);
                  }
                  return bintostr;
            } catch (Exception ex) {
                throw new RuntimeException(ex.getCause());
            }
        }
    public static String md5encodeValue(String value) {
            try { 
  
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
  
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(value.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        }  
  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
        }
    public static String sha1encodeValue(String value) {
            try { 
            // getInstance() method is called with algorithm SHA-1 
            MessageDigest md = MessageDigest.getInstance("SHA-1"); 
  
            // digest() method is called 
            // to calculate message digest of the input string 
            // returned as array of byte 
            byte[] messageDigest = md.digest(value.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
  
            // Add preceding 0s to make it 32 bit 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
  
            // return the HashText 
            return hashtext; 
        } 
  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
        }
    
        public static String sha256encodeValue(String value) {
            try { 
            // getInstance() method is called with algorithm SHA-1 
            MessageDigest md = MessageDigest.getInstance("SHA-256"); 
  
            // digest() method is called 
            // to calculate message digest of the input string 
            // returned as array of byte 
            byte[] messageDigest = md.digest(value.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
  
            // Add preceding 0s to make it 32 bit 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
  
            // return the HashText 
            return hashtext; 
        } 
  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
        }
        public static String rot13(String input) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if       (c >= 'a' && c <= 'm') c += 13;
                else if  (c >= 'A' && c <= 'M') c += 13;
                else if  (c >= 'n' && c <= 'z') c -= 13;
                else if  (c >= 'N' && c <= 'Z') c -= 13;
                sb.append(c);
            }
            return sb.toString();
            }
        public static String rot13encodeValue(String value) {
            try { 
            // getInstance() method is called with algorithm SHA-1 
            return rot13(value);
        } 
  
        // For specifying wrong message digest algorithms 
        catch (Exception e) { 
            throw new RuntimeException(e); 
        } 
        }
}
