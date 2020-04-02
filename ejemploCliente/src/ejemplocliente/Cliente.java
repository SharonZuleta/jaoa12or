
package ejemplocliente;
import java.net.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.JTextArea;

public class Cliente{
    private JTextArea cajaSalida;
    public Cliente()
    {
//        
//        try{
//            Socket cliente = new Socket("localhost", 1234);
//            
//            BufferedReader entrada = new BufferedReader(
//                                new InputStreamReader(cliente.getInputStream()));
//            
//            PrintWriter salida = new PrintWriter(cliente.getOutputStream());
//            
//
//        }catch (Exception e) {
//           System.out.println("Error3: " + e.getMessage());
//        }
//        Scanner lector = new Scanner(System.in);
//        try {
//            Socket cliente = new Socket("localhost", 1234);            
//            
//            BufferedReader entrada = new BufferedReader(
//                                new InputStreamReader(cliente.getInputStream()));
//            PrintWriter salida = new PrintWriter(cliente.getOutputStream());
//            String mensaje ;       
//            do {
//                System.out.print("> ");
//                mensaje = lector.nextLine();
//                salida.println(mensaje);
//                salida.flush();   
//
//                String respuesta;
//                while ((respuesta = entrada.readLine()) != null) {
//                    System.out.println(respuesta);
//
//                    if (respuesta.equals("next")) {
//                        break;
//                    }
//                }
//            } while (false);
//            
//            entrada.close();
//            salida.close();
//            cliente.close();
//            
//        } catch (Exception e) {
//            System.out.println("Error3: " + e.getMessage());
//        }
    }
    public void setSalida(JTextArea salida) {
        this.cajaSalida = salida;
    }
    
}
