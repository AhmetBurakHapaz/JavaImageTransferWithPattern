/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileserver;
import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author Msi
 */
public class SocketOne {
    private ServerSocket s=null;
    public SocketOne() {}
    
    public ServerSocket getSocket() throws IOException{
        if(s == null){
             this.s = new ServerSocket(4444);
            return this.s;
        }else{
            return  this.s;
        }
    }
}
