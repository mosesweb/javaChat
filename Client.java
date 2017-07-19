import java.net.*;
import java.text.*;
import java.util.Date;
import java.io.*;

public class Client {
    /**
     * Available server for testing
     * Host: atlas.dsv.su.se
     * Port: 9494
     */
    private static Conn connection;
    private static getmessagesthread getmessagesthreadThread;
    private static typeMsgThread typemessagethread;

    public static void main(String[] args) {

        if (args.length == 1) {
            // Only host
            connection = new Conn(args[0]);
        }
        if (args.length == 2) {
            // Host and port number
            connection = new Conn(args[0], Integer.parseInt(args[1]));
        }
        if (args.length == 0 || args.length > 2) {
            System.out.println("Standard socket settings");
            // Default (no parameters)
            connection = new Conn();
        }
        getmessagesthreadThread = new getmessagesthread(connection);
        typemessagethread = new typeMsgThread(connection);
    }

    public Client() {

    }
}