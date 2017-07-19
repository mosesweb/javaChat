import java.net.*;
import java.text.*;
import java.util.Date;
import java.io.*;
import java.nio.*;
import java.io.Console;

public class typeMsgThread extends Thread{

    private volatile boolean exit = false;
    private Conn connection = null;

    public typeMsgThread(Conn conn) {
        this.connection = conn;
        start();
    }

    public void stopThread() {
        exit = true;
    }

    public void run() {
        if(connection.socket.isConnected())
        {
            System.out.println("-- You can send a message any time in the console and press enter --");
            while (isAlive()) {
                String input = System.console().readLine();
                connection.out.println(input);
            }
        }
    }
}
