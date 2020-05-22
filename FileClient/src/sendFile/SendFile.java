
package sendFile;

import java.io.File;
import java.io.Serializable;


public class SendFile implements Serializable
{
    private String name;
    private byte bytes[];
    
    public SendFile(String name)
    {
        this.name = name;
    }
    public void setByte(byte bytes[])
    {
        this.bytes = bytes;
    }
    public byte[] getByte()
    {
        return (this.bytes);
    }
    public String getName()
    {
        return (this.name);
    }
}
