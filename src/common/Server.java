package common;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.HashMap;
import java.rmi.Remote;
import java.rmi.Naming;
import java.rmi.NotBoundException;


public class Server extends Thread {
    AddClass obj = null;
    DatagramSocket socket = null;
    private String city;
    private int port;
    private Registry registry;

    private int sock;

    public Server(String city, int port, int s) {
        try {
            AddClass obj = new AddClass();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        this.city = city;
        this.port = port;
        sock = s;
    }

    public void run() {
        try {
            Registry registry = LocateRegistry.createRegistry(port);
            registry.bind(city, obj);
            DatagramSocket socket = new DatagramSocket(sock);
            byte[] buffer = new byte[1000];
            while (true) {
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                socket.receive(request);
                String count_s = Integer.toString(obj.getRecordsCount());
                byte[] count_b = count_s.getBytes();
                DatagramPacket reply = new DatagramPacket(count_b, count_b.length, request.getAddress(), request.getPort());
                socket.send(reply);
            }
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

// 		AddClass obj = new AddClass(); 
// 		Registry registry = LocateRegistry.createRegistry(2964); 
// 		registry.bind("Addition", obj);
// 		System.out.println("Server is started");

        // TODO
        // read these parameters from args
        String city = "MTL";
        Integer port = 2270;
        int s = 20;
        Server instance = new Server(city, port, 0);
        instance.run();

    }
}