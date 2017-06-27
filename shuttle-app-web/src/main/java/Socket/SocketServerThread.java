/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author negre
 * @param <T>
 */
public class SocketServerThread<T> extends Thread{
    
    private T activity;
    
    private ServerSocket serverSocket;
    
    public T getActivity() {
        return activity;
    }

    public void setActivity(T activity) {
        this.activity = activity;
    }
    
    int count = 0;
    
    String message = "";
    
    private final int socketSocketPORT = 8080;
    @Override
    public void run(){
    
        //Create ServerSocket using specifies port
        
        try{
        
        serverSocket = new ServerSocket(socketSocketPORT);
        
        while(true){
        
            Socket socket = serverSocket.accept();
            
            count ++;
            
            message += "#"+count+" from "+socket.getInetAddress()
            +":"+socket.getPort()+"\n";
            
            
        }
        
        }
        catch(IOException ex){
        
            ex.printStackTrace(System.out);
        
        }
    }
    
}
