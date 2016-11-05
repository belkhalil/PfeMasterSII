package com.empsi.temp.beans;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class CryptingTool {

	
	private static  String calc(InputStream is) {
	    String output;
	    int read;
	    byte[] buffer = new byte[8192];

	    try {
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        while ((read = is.read(buffer)) > 0) {
	            digest.update(buffer, 0, read);
	        }
	        byte[] hash = digest.digest();
	        BigInteger bigInt = new BigInteger(1, hash);
	        output = bigInt.toString(16);
	        while ( output.length() < 32 ) {
	            output = "0"+output;
	        }
	    } 
	    catch (Exception e) {
	        e.printStackTrace(System.err);
	        return null;
	    }

	    return output;
	}
	public static String sha256(String base){
		String output ;
		InputStream stream = new ByteArrayInputStream(base.getBytes(StandardCharsets.UTF_8));
		output =calc(stream);
		return output;
		
	}
}
