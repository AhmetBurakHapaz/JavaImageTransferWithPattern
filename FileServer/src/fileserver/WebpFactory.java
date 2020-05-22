/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileserver;

public class WebpFactory extends ExtensionFactory 
{
    public Extension createFile() 
    {
        return new Webp();
    } 
}