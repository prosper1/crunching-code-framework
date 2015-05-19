package com.mobilebulletin.local.utils;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;



import org.apache.log4j.Logger;

import com.common.type.TypeHierarchy;


public class FreshHelper {

	private static final Logger log = Logger.getLogger(FreshHelper.class.getName());
	
	public static String getSqlFromIdList(List<Long> idList, String sql){
		sql += "( :param0";
		for(int i = 1;i < idList.size();i++){
			sql += ", :param"+i;
		}
		sql += " )";
		return sql; 
	}

	public static String getSqlFromDescriptionList(List<String> descriptionList, String sql){
		sql += "( :param0";
		for(int i = 1;i < descriptionList.size();i++){
			sql += ", :param"+i;
		}
		sql += " )";
		return sql; 
	}
	

	
	public static String decryptBytes(String password) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		byte[] key = hexStringToByteArray("edcbaf8deaa18382c5975816fb11abc"); 
		
		byte[] raw1 = hexStringToByteArray(password); 
		
			
		String result;
		
		
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		kgen.init(128); // 192 and 256 bits may not be available
		SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");

		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, skeySpec);
		byte[] decrypted = cipher.doFinal(raw1);
		result = new String(decrypted);
		return result;

	}
	
	public static String encryptBytes(String password) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		if(password != null){
			byte[] key = hexStringToByteArray("edcbaf8deaa18382c5975816fb11abc"); 
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(128); // 192 and 256 bits may not be available
			SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
	
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			String idToString = null;
			idToString = password;
			
			byte[] ecrypted = cipher.doFinal(idToString.getBytes());
			try{
				decryptPrimaryKeyBytes(byteArrayToHexString(ecrypted));
				return byteArrayToHexString(ecrypted);
			}catch (Exception e){
				idToString = password+" ";
				ecrypted = cipher.doFinal(idToString.getBytes());
				return byteArrayToHexString(ecrypted);
			}
		}else
			return null;

	}
	public static String byteArrayToHexString(byte[] passwordArray){
		// Create a BigInteger using the byte array
		BigInteger bi = new BigInteger(passwordArray);
		
		// Format to hexadecimal
		String passwordToString = bi.toString(16);
		
		return passwordToString;
	} 
	private static byte[] hexStringToByteArray(String s) {
		byte[] strBytes = new BigInteger(s, 16).toByteArray(); 
		
		byte[] raw1 = new byte[16];
		try{
		for (int i=0; i<strBytes.length; i++) {
			raw1[i] = (byte)(0x000000FF & (int) strBytes[i]);
		 //  log.info("Byte[" + i + "]" + (0x000000FF & (int) strBytes[i]) );
		}
		}catch(Exception e){
			raw1 = new byte[32];
			
			for (int i=0; i<strBytes.length; i++) {
				raw1[i] = (byte)(0x000000FF & (int) strBytes[i]);
			}
		}
		return raw1;
	}
	public static Long decryptPrimaryKeyBytes(String id) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		if(id != null){
			byte[] key = hexStringToByteArray("edcbaf8d12322282c5975816fb11abc"); 
			
			byte[] raw1 = hexStringToByteArray(id); 
			
				
			String result;
			
			
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(128); // 192 and 256 bits may not be available
			SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
	
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			byte[] decrypted = cipher.doFinal(raw1);
			result = new String(decrypted);
			return Long.parseLong(result.trim());
		}else
			return 0L;

	}
	public static String encryptPrimaryKeyBytes(long id) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		if(id > 0){
			byte[] key = hexStringToByteArray("edcbaf8d12322282c5975816fb11abc"); 
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(128); // 192 and 256 bits may not be available
			SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
	
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			String idToString = null;
			idToString = Long.toString(id);
			
			byte[] ecrypted = cipher.doFinal(idToString.getBytes());
			try{
				decryptPrimaryKeyBytes(byteArrayToHexString(ecrypted));
				return byteArrayToHexString(ecrypted);
			}catch (Exception e){
				idToString = Long.toString(id)+" ";
				ecrypted = cipher.doFinal(idToString.getBytes());
				return byteArrayToHexString(ecrypted);
			}
		}else
			return null;

	}
public static void main(String[] args) {
			
		
		try {
			System.out.println(FreshHelper.encryptPrimaryKeyBytes(6));
			//System.out.println(FreshHelper.byteArrayToHexString(FreshHelper.encryptBytes("password")));
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//getCountry(null, null);
	}

public String retrievePassword(String bytePassword) throws Exception{
	String password = null;
	
	
		password = FreshHelper.decryptBytes(bytePassword);
		
	
	return password;
}

	public static String getCountry(String laguage,String region){
		Locale locale = new Locale(laguage, region);
		String iso = locale.getISO3Country();
	      String code = locale.getCountry();
	      String name = locale.getDisplayCountry();
	      log.info(iso);
	      log.info(code);
	      log.info(name);
		return null;
	}
	
	public static TypeHierarchy populateParentType(String code, List<TypeFields> fields)
	{
		TypeHierarchy parentEnumHierarchy = new TypeHierarchy();
		parentEnumHierarchy.setCode(code);
		parentEnumHierarchy.setDescription(code);
		
		List<TypeHierarchy> list = new ArrayList<TypeHierarchy>();
		
		for(TypeFields typeFields:fields)
		{
			TypeHierarchy childEnumHierarchy = new TypeHierarchy();
			childEnumHierarchy.setCode(typeFields.getChildCode());
			childEnumHierarchy.setDescription(typeFields.getChildDescription());
			childEnumHierarchy.setOrdinal(typeFields.getOrdinal());
			childEnumHierarchy.setParent(parentEnumHierarchy);
			list.add(childEnumHierarchy);
		}
		parentEnumHierarchy.setChildren(list);
		
		return parentEnumHierarchy;
	}

}
