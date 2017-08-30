package com.kpdpxx.zipTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class ZipTest {
	public static int buffer=2048;
	
	public static void main(String[] args) throws Exception {
//		FileInputStream in=new FileInputStream("C:\\\\Users\\\\Kevinyan\\\\Desktop\\\\16\\\\kqWriteCard\\\\kqWriteCard.gz");
//		ZipFile zipFile=new ZipFile("C:\\\\Users\\\\Kevinyan\\\\Desktop\\\\16\\\\kqWriteCard\\\\kqWriteCard.gz");
//		
		compress();
		

	}
	public static void compress() throws Exception{
//		File inFile =new File("C:\\Users\\Kevinyan\\Desktop\\16\\kqWriteCard\\QQ图片20170526110305 - 副本.png");

		File inFile =new File("C:\\Users\\Kevinyan\\Desktop\\16\\kqWriteCard");
		File outFile =new File("C:\\Users\\Kevinyan\\Desktop\\16\\kqWriteCard\\QQ图片20170526110305.gz");
		FileOutputStream fos=new FileOutputStream(outFile);
		GZIPOutputStream gzip=new GZIPOutputStream(fos);

		for(File f:inFile.listFiles()){
			FileInputStream fin=new FileInputStream(f);
			byte[] bytes=new byte[2048];
			while(fin.read(bytes)>0){
				gzip.write(bytes, 0, 2048);
			}
			fin.close();
			gzip.flush();
		}
		
		
		gzip.close();
		
		System.out.println("处理结束");
	}
	public static void deCompress(){
		
	}

}
