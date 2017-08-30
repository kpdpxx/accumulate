package com.kpdpxx.security.bas64;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class TestBase64 {

	public static void main(String[] args) throws IOException {
		String orgStr="base64原文";
		System.out.println("原文："+orgStr+",长度为："+orgStr.length());
		
		BASE64Encoder encoder =new BASE64Encoder();
		String enStr=encoder.encode(orgStr.getBytes());
		System.out.println("加密后内容为；"+enStr+",长度为："+enStr.length());
		
		BASE64Decoder decoder=new 		BASE64Decoder();
		byte[] outStr=decoder.decodeBuffer(enStr);
		System.out.println("解密后内容为："+new String(outStr)+",长度为："+new String(outStr).length());
		
	}

}
