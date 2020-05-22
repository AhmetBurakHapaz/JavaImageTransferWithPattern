/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileclient;

/**
 *
 * @author Msi
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import sendFile.SendFile;
import javax.swing.JOptionPane;

public class FileClient {
    
    private static String getFileExtension(File file) 
    {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
    
    private static File imagePicker() 
    {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Sadece jpg png ve webp", "jpg", "png","webp");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        
        if(returnVal == JFileChooser.APPROVE_OPTION) 
        {
            System.out.println("Seçilen Dosya: " +
            chooser.getSelectedFile().getName());
        }
        return chooser.getSelectedFile();
    }
    
    public static void main(String[] args) throws IOException 
    {
        while(true)
        {
        //singleton yapilabilir.
        Socket socket = null;
        String host = "127.0.0.1";
        socket = new Socket(host, 4444);
        
        //file picker
        File file = imagePicker();

        String extension = getFileExtension(imagePicker());
        
        SendFile sendFile = new SendFile(extension);
        ObjectInputStream in = null;
        ObjectOutputStream out = null;

        out = new ObjectOutputStream(socket.getOutputStream());
        //in = new ObjectInputStream(socket.getInputStream());
        
        if(extension != null && !extension.trim().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Veri alındı");
        }
        
        FileInputStream input = new FileInputStream(file); 

        byte[] bytes = new byte[(int) file.length()];

        input.read(bytes);
        
        sendFile.setByte(bytes);
        out.writeObject(sendFile);
        System.out.println(sendFile.getName());
        out.flush();
        out.close();
        }

    }
}