
package ejemploservidor;
import java.io.*;
import java.net.*;
import javax.swing.JTextArea;

public class Servidor extends Thread {
    private int puerto = 1234;  // Puerto donde escucha el servidor
    private JTextArea cajaSalida;   
    private String[] datos = new String[100];
    private int cant = 0;
    
    @Override
    public void run()
    {
        try {
            ServerSocket server = new ServerSocket(puerto, 10);
            while (true) {
                Socket cliente = server.accept();
                Protocolo hilo = new Protocolo(cajaSalida, cliente, this);
                hilo.start();
            }     
            
        }catch (Exception e) {
            System.out.println("Error1: " + e.getMessage());
        }        
    }

    public void setSalida(JTextArea salida) {
        this.cajaSalida = salida;
    }
    
    public String adicionar(String i) {
        
        datos[cant++] = i;
        String res = "";
        
        for (int x = 0; x < cant; x++)
        {
            if (x == cant - 1) {
                res +=datos[x];
            }else{
                res +=datos[x]+ ",";
            }
           
        }
        return res;
    }
}
