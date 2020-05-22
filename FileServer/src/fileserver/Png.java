/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileserver;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Msi
 */
public class Png implements Extension 
{
    static int i = 0;
    public void uploadFile(byte[] bytes)
    {
        FileOutputStream out = null;
        try 
        {
            out = new FileOutputStream("D:\\Png\\"+i+".png");
        }
        catch (FileNotFoundException ex) 
        {
            System.out.println("Dosya bulunamadı ");
        }
        i +=1;
        try {
            out.write(bytes);
        } catch (IOException ex) {
            Logger.getLogger(Png.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(Png.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

