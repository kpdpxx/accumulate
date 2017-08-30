package com.kpdpxx.nio.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Service  {

	
	public static void main(String[] args) throws Exception{
		try{
			ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
			Selector selector=Selector.open();
			ServerSocketChannel  ssc=ServerSocketChannel.open();
			InetSocketAddress inetSocketAddress=new InetSocketAddress("127.0.0.1",8080);
			ssc.socket().bind(inetSocketAddress);
	
			ssc.configureBlocking(false);
			ssc.register(selector, SelectionKey.OP_ACCEPT);
			
			
			System.out.println("������ˡ��������");
			Iterator<SelectionKey> iterator=selector.keys().iterator();
	
			while(true){
				int intSelect=selector.select();
				System.out.println("select():"+intSelect);
				Iterator selectorKeys = selector.selectedKeys().iterator();  
				
		        while (selectorKeys.hasNext()) {  
		            System.out.println("running2 ... ");  
		            //�����ҵ���ǰ��ѡ���     
		            SelectionKey key = (SelectionKey) selectorKeys.next();  
		            //Ȼ�����ӷ��ؼ�������ɾ��     
		            selectorKeys.remove();  
		            if (!key.isValid()) { // ѡ�����Ч  
		                continue;  
		            }  
		            if (key.isAcceptable()) {  
		                //�������������ô����Ӧ     
		            	ServerSocketChannel server = (ServerSocketChannel) key.channel();  
		            	SocketChannel clientchannel1 = server.accept();  
		                    clientchannel1.configureBlocking(false);  
		                    //OP_READ���ڶ�ȡ�����Ĳ�����λ     
		                    clientchannel1.register(selector, SelectionKey.OP_READ);  
		                System.out.println("isAcceptable");
		            } else if (key.isReadable()) {  
		                //��ȡ�ͻ��˵�����     
		               System.out.println("isReadable");
		               SocketChannel socketChannel = (SocketChannel) key.channel(); 
		               byteBuffer.clear();
		               socketChannel.read(byteBuffer);
		               System.out.println("�յ��ͻ�������Ϊ��"+ new String(byteBuffer.array()));
		            }  
		        }  
	        }
		}catch(Exception e){
			e.printStackTrace();
		}
		/*while(true){
			SocketChannel clientSocket=ssc.accept();
			if(clientSocket!=null){
				clientSocket.configureBlocking(false);
				clientSocket.register(selector, SelectionKey.OP_READ);
				System.out.println("�ѹ����ͻ��ˣ�"+clientSocket.toString());
			}
			Set<SelectionKey> keys=selector.selectedKeys();
			if(keys!=null&&keys.size()>0){
				System.out.println("");
			}
			
		}*/
		
		/*while(true){
			if(iterator.hasNext()){
				SelectionKey selectionKey=iterator.next();
				System.out.println("hasNext");
			}
		}*/
		/*while(true){
			Set<SelectionKey> keys=selector.selectedKeys();
			if(keys!=null&&keys.size()>0){
				
				for(SelectionKey selectionKey:keys){
					if(true){
						System.out.println("���յ�����~~~~~~~");
						ServerSocketChannel socketChannel=(ServerSocketChannel)selectionKey.channel();
						socketChannel.accept().read(byteBuffer);
						System.out.println("������յ����ݣ�"+byteBuffer.toString());
					}
				}
			}
		}*/
	
		
	}
	
	
}
