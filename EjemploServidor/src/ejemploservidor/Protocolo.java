package ejemploservidor;

import java.io.*;
import java.net.*;
import javax.swing.JTextArea;

/**
 * Se encarga de despachar la solicitud del cliente basado a un protocolo
 *
 * @author javargas
 */
public class Protocolo extends Thread {
    JTextArea cajaSalida;
    Socket cliente;
    Servidor servidor;

    public Protocolo(JTextArea cajaSalida, Socket cliente, Servidor s) {
        super();
        this.cajaSalida = cajaSalida;
        this.cliente = cliente;
        servidor = s;
    }

    @Override
    public void run() {

        try{
            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(cliente.getInputStream()));

            String mensaje;
            String[] aux;
            
            while ((mensaje = entrada.readLine()) != null) {
                
                aux = mensaje.split("~");
                Socket nuevoCliente = new Socket("localhost", Integer.parseInt(aux[2]));
                PrintWriter salida = new PrintWriter(nuevoCliente.getOutputStream());
                
                if (mensaje.equals("exit")) {
                    break;
                }

                cajaSalida.append(mensaje + "\n");
                salida.println(mensaje);
                mensaje = servidor.adicionar(mensaje);
                salida.flush();
                salida.println("next");
                salida.flush();
                salida.close();
                nuevoCliente.close();
            }

            entrada.close();
            cliente.close();
        } catch (Exception e) {
            System.out.println("Error2: " + e.getMessage());
        }
    }

}
