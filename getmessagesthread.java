import java.net.*;
import java.text.*;
import java.util.Date;
import java.io.*;
import java.nio.*;
import java.io.Console;

public class getmessagesthread extends Thread {

    private volatile boolean exit = false;
    private Conn connection = null;

    public getmessagesthread(Conn conn) {
        this.connection = conn;
        start();
    }

    public void stopThread() {
        exit = true;
    }

    public void startThread() {
        start();
    }

    public void sendMsg() {
    }

    public void run() {
        if (connection.socket != null && connection.in != null) {
            System.out.println("Reciving messages");
            while (this.isAlive()) {
                if (!exit) {
                    try {
                        Thread.sleep(1000);
                        try {

                            String inputLine;
                            while ((inputLine = connection.in.readLine()) != null)
                                System.out.println(inputLine);
                        } catch (IOException ioe) {
                            System.out.println(ioe.getMessage());
                        }

                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
}
