
package fileserver;

/**
 *
 * @author Msi
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import sendFile.SendFile;

public class FileServer {
    public static void main(String[] args) throws IOException 
    {        
        SocketOne socketSingleton = new SocketOne();
        ServerSocket serversocket = socketSingleton.getSocket();
        
        SendFile sendFile = null;
        
        int i = 0;      
        while(true)
        {
            Socket socket = null;
            ObjectInputStream in = null;
            FileOutputStream out = null;
            try 
            {
                socket = serversocket.accept();
            }
            catch (IOException ex) 
            {
                System.out.println("bağlantı başarısız");
            }
            
            try 
            {
                in = new ObjectInputStream(socket.getInputStream());
                sendFile = (SendFile) in.readObject();
                System.out.println(sendFile.getName());                
            }
            
            catch(ClassNotFoundException ex)
            {
                System.out.println(ex);
            }
            catch (IOException ex) 
            {
                System.out.println("KKKKKKKKKKKKKKKKKKKKKKKKK ");
            }
            
            
            if(sendFile.getName().equals("jpg"))
            {
                ExtensionFactory jpgFactory =new JpgFactory();
                Extension jpg = jpgFactory.createFile();
                jpg.uploadFile(sendFile.getByte());
            }
            else if(sendFile.getName().equals("png"))
            {
                ExtensionFactory pngFactory = new PngFactory();
                Extension png = pngFactory.createFile();
                png.uploadFile(sendFile.getByte());
            }
            else if(sendFile.getName().equals("webp"))
            {
                ExtensionFactory webpFactory = new WebpFactory();
                Extension webp = webpFactory.createFile();
                webp.uploadFile(sendFile.getByte());
            }
            else
            {
                System.out.print("yüklenemedi");
            }
            in.close();
            i+=1;
        }
    }
}