package chapter7;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;


public class Question7 {

	public static void main(String[] args) {
		
		ChatServer chatServer = new ChatServer();
		chatServer.runServer();

	}

}

class ChatServer {
	public void runServer() {
		Scanner scanner = new Scanner(System.in);
		ServerSocketChannel serverSocketChannel = null;
		boolean work = true;
		System.out.println("���� ����");
		System.out.println("��븦 ��ٸ��� �ֽ��ϴ�.");
		try {
			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.configureBlocking(true);
			serverSocketChannel.bind(new InetSocketAddress(300));
			SocketChannel socketChannel = serverSocketChannel.accept();
			//InetSocketAddress isa = (InetSocketAddress) socketChannel.getRemoteAddress();
			while (work) {
				//SocketChannel socketChannel = serverSocketChannel.accept();
				InetSocketAddress isa = (InetSocketAddress) socketChannel.getRemoteAddress();
				
				ByteBuffer byteBuffer = null;
				Charset charset = Charset.forName("UTF-8");
				
				byteBuffer = ByteBuffer.allocate(150);
				int byteCount = socketChannel.read(byteBuffer);
				byteBuffer.flip();
				String init = charset.decode(byteBuffer).toString();
				
				System.out.println("��� : " + init);
				
				System.out.println("�޽����� �Է��ϼ��� : ");
				
				String output = scanner.nextLine();
				
				byteBuffer = charset.encode(output);
				socketChannel.write(byteBuffer);
	
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if (serverSocketChannel.isOpen()) {
			try {
				serverSocketChannel.close();
			} catch (IOException e1) {}
		}
	}
}

class ChatClient {
	public void runClient() {
		Scanner scanner = new Scanner(System.in);
		SocketChannel socketChannel = null;
		boolean work = true;
		try {
			socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(true);
			socketChannel.connect(new InetSocketAddress("localhost", 300));
			System.out.println("ä���� �����մϴ�.");
			while (work) {
				//SocketChannel socketChannel = serverSocketChannel.accept();
				InetSocketAddress isa = (InetSocketAddress) socketChannel.getRemoteAddress();
				
				System.out.println("�޽����� �Է��ϼ��� : ");
				
				String msg = scanner.nextLine();
				
				ByteBuffer byteBuffer = null;
				Charset charset = Charset.forName("UTF-8");
				
				byteBuffer = charset.encode(msg);
				socketChannel.write(byteBuffer);
				
				byteBuffer = ByteBuffer.allocate(150);
				int byteCount = socketChannel.read(byteBuffer);
				byteBuffer.flip();
				msg = charset.decode(byteBuffer).toString();
				
				System.out.println("��� : "+ msg);
				
				String output = scanner.nextLine();
				
				
	
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if (socketChannel.isOpen()) {
			try {
				socketChannel.close();
			} catch (IOException e1) {}
		}
	}
}