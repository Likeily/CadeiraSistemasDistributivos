package aula_servidores;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {
	public static void main(String args[]) throws Exception {

		DatagramSocket servidorSocket = new DatagramSocket(2787);

		byte[] recebeDados = new byte[1024];
		byte[] enviaDados = new byte[1024];

		while (true) {

			DatagramPacket recebePacoteInfo = new DatagramPacket(recebeDados, recebeDados.length);
			servidorSocket.receive(recebePacoteInfo);
			String sentenca = new String(recebePacoteInfo.getData());

			InetAddress enderecoIP = recebePacoteInfo.getAddress();

			int port = recebePacoteInfo.getPort();

			String capitalizedSentence = sentenca.toUpperCase();
			enviaDados = capitalizedSentence.getBytes();

			DatagramPacket sendPacket = new DatagramPacket(enviaDados, enviaDados.length, enderecoIP, port);

			servidorSocket.send(sendPacket);
		}
	}
}