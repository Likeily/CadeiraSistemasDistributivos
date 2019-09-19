package aula_servidores;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) 
                    throws UnknownHostException, IOException {
        Socket cliente = new Socket("127.0.0.1", 2787);
        System.out.println("Cliente conectado!");

        Scanner teclado = new Scanner(System.in);
        PrintStream out = new PrintStream(cliente.getOutputStream());

        while (teclado.hasNextLine()) {
        	out.println(teclado.nextLine());
        }

        out.close();
        teclado.close();
        cliente.close();
    }
}
