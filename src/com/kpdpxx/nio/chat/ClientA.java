package com.kpdpxx.nio.chat;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class ClientA {

	public static void main(String[] args)throws Exception{
		SocketChannel socketChannel=SocketChannel.open();
		InetSocketAddress inetSocketAddress=new InetSocketAddress("127.0.0.1",8080);
		boolean  isConnect=socketChannel.connect(inetSocketAddress);

		socketChannel.configureBlocking(false);
		ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
		Selector selector=Selector.open();
		socketChannel.register(selector, SelectionKey.OP_CONNECT);
		Scanner scanner=new Scanner(System.in);
		
		if(isConnect){
			System.out.println("√===>客户端启动完毕，且连接成功！");
		}else{
			System.out.println("× 无法连接到服务端！");
			return ;
		}
		while(true){
			if(scanner.hasNextLine()){
				String src=scanner.nextLine();
				byteBuffer.put(src.getBytes());
				byteBuffer.flip();
				socketChannel.write(byteBuffer);
				System.out.println("即将发送："+src);
				byteBuffer.clear();
				
			}	
		}
	}
}
