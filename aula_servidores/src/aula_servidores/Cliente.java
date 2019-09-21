package aula_servidores;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {

	public static void main(String args[]) throws Exception {

		BufferedReader doUsusario = new BufferedReader(new InputStreamReader(System.in));

		DatagramSocket clienteSocket = new DatagramSocket();

		InetAddress enderecoIP = InetAddress.getByName("hostname");

		byte[] enviaDados = new byte[1024];
		byte[] recebeDados = new byte[1024];

		String sentence = doUsusario.readLine();
		enviaDados = sentence.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(enviaDados, enviaDados.length, enderecoIP, 2787);

		clienteSocket.send(sendPacket);

		DatagramPacket receivePacket = new DatagramPacket(recebeDados, recebeDados.length);

		clienteSocket.receive(receivePacket);

		String modifiedSentence = new String(receivePacket.getData());

		System.out.println("Servidor Chamando:" + modifiedSentence);
		clienteSocket.close();
	}
}
