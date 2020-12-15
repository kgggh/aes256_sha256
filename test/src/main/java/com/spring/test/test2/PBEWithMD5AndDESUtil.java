package com.spring.test.test2;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.stereotype.Service;

@Service
public class PBEWithMD5AndDESUtil{
	
	//암호화
	public static String encStr(String key)throws Exception {
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword("test"); 
		encryptor.setAlgorithm("PBEWithMD5AndDES");
		String encKey = encryptor.encrypt(key);
		return encKey;
		
	}
	//복호화
	public static String decStr(String encStr)throws Exception {
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword("test");
		encryptor.setAlgorithm("PBEWithMD5AndDES");
		String decStr = encryptor.decrypt(encStr);
		return decStr;
	}

}
