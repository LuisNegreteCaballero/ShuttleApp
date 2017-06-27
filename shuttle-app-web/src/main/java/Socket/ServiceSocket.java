/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Socket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.PathParam;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.atmosphere.config.service.Message;
import org.json.JSONObject;

/**
 *
 * @author luis
 */
@ServerEndpoint(value="/orderservice/{clientId}")
public class ServiceSocket {
     
    @Inject
    private SessioController.SessionController _sessionController;
    
    private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());
    @OnOpen
    public void init(Session session, @PathParam("clientId")  String clientId) throws IOException {
        
         System.out.print("CLIENTID: "+clientId);
         
         peers.add(session);
         
         EJBClasses.Session ses = new  EJBClasses.Session();
         
         ses.setUsername(clientId);
         
         ses.setSession(session);
         
         this._sessionController.addSession(ses);
         
         System.out.print("SESSIONS: "+this._sessionController.getSessions().size());
         
    }

    @OnMessage
    public String echo(String message) {
        
        return message + " (from your server)";
    }

    @OnError
    public void onError(Throwable t) {
        t.printStackTrace();
    }
    
    public void sendMessageToSession(){
    
    }
    
    public static void sendMessageToAll(JSONObject object){
    
        //et<Session> allSessions  = session.getOpenSessions();
        
        //System.out.print("NUMBER OF SESSIONS: "+peers.size());
        
     for (Session sess:peers){          
        try{   
          sess.getBasicRemote().sendText(object.toString());
          } catch (IOException ioe) {        
              System.out.println(ioe.getMessage());         
          }   
     }   
    
    }
    
    public static  void sendMessageToUser(JSONObject object, Session sess){
    
        if(sess != null){
        
        try {
            sess.getBasicRemote().sendText(object.toString());
        } catch (IOException ex) {
            Logger.getLogger(ServiceSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
    
    }

    @OnClose
    public void onClose(Session session) {
        peers.remove(session);
        for(EJBClasses.Session aux: this._sessionController.getSessions()){
        
            if(aux.getSession().equals(session)){
            
                this._sessionController.getSessions().remove(aux);
                
                break;
            
            }
        
        }
    }
    
    
}
