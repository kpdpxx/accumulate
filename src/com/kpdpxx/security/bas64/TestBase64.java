package com.kpdpxx.security.bas64;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class TestBase64 {

	public static void main(String[] args) throws IOException {
		String orgStr="base64ԭ��";
		System.out.println("ԭ�ģ�"+orgStr+",����Ϊ��"+orgStr.length());
		
		BASE64Encoder encoder =new BASE64Encoder();
		String enStr=encoder.encode(orgStr.getBytes());
		System.out.println("���ܺ�����Ϊ��"+enStr+",����Ϊ��"+enStr.length());
		
		BASE64Decoder decoder=new 		BASE64Decoder();
		byte[] outStr=decoder.decodeBuffer(enStr);
		System.out.println("���ܺ�����Ϊ��"+new String(outStr)+",����Ϊ��"+new String(outStr).length());
		
	}

}
