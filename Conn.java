import java.net.*;
import java.text.*;
import java.util.Date;
import java.io.*;
import java.nio.*;
import java.io.Console;

public class Conn {
    public Socket socket = null;
    public BufferedReader in = null;
    public PrintWriter out = null;
    //socket = new Socket("atlas.dsv.su.se", 9494);
    private String adress = "172.0.0.1";
    private int portnum = 2000;

    public void ExitProgram() {
        try {
            System.out.println("Failed. Quitting the program in 5 seconds");
            Thread.sleep(5000);
            System.exit(1);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
    public Conn(String theadress, int theportnum) {

        adress = theadress;
        portnum = theportnum;
        System.out.println("Attempting to connect to " + adress);

        try {
            socket = new Socket(adress, portnum);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            if (socket.isConnected()) {
                System.out.println("Connection successful");
                System.out.println(socket.getInetAddress());
                System.out.println(socket.getPort());
            } else {
                System.out.println("Not connected");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            ExitProgram();
        }
    }

    public Conn(String theadress) {

        adress = theadress;
        System.out.println("Attempting to connect to " + adress);

        try {
            socket = new Socket(adress, portnum);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            if (socket.isConnected()) {
                System.out.println("Connection successful");
                System.out.println(socket.getInetAddress());
                System.out.println(socket.getPort());
            } else {
                System.out.println("Not connected");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            ExitProgram();
        }
    }

    // Default connection [localhost]
    public Conn() {
        System.out.println("Attempting to connect to " + adress);
        try {
            socket = new Socket(adress, portnum);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            if (socket.isConnected()) {
                System.out.println("Connection successful");
                System.out.println(socket.getInetAddress());
                System.out.println(socket.getPort());
            } else {
                System.out.println("Not connected");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            ExitProgram();
        }
    }
}