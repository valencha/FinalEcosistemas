package Comunicacion;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class Comunicacion extends Thread{

    private boolean conectado;
    static int PUERTO;
    MulticastSocket socket;
    InetAddress grupo;
String myIP;
    OnMessage observer;


    public Comunicacion() {
        conectado = false;
    }

    public void inicializar(){

        try {
            if (!conectado) {
                PUERTO = 5000;
                grupo = InetAddress.getByName("224.0.0.0");
                myIP = InetAddress.getLocalHost().getHostAddress();
                socket = new MulticastSocket(PUERTO);
                System.out.println("Intentando unirse al grupo");

                socket.joinGroup(grupo);
                System.out.println("Te uniste al grupo!");

                conectado = true;

            }else{

            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {

        inicializar();

            while(true) {
        recibirDatos();
            }

    }

    private void recibirDatos() {
        try {
            byte[] buffer = new byte[1000];
            DatagramPacket datagrama = new DatagramPacket(buffer, buffer.length);
            System.out.println("Esperando mensaje...");
            socket.receive(datagrama);
            System.out.println("Mensaje recibido:");
            String mensaje = new String(datagrama.getData()).trim();
            observer.onReceived(mensaje);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public interface OnMessage{
        public void onReceived(String input);
    }

    public void setObserver(OnMessage observer) {
        this.observer = observer;
    }

    public void enviar(final String punto){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    DatagramPacket datagram= new DatagramPacket(punto.getBytes(),punto.getBytes().length,grupo,5000);

                    socket.send(datagram);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }


}



