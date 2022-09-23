package com.tem.removers;

import java.io.IOException;

import com.tem.mywiter.Writer;

public class StupidRemover implements Writer{

    private  Writer writer;
    StupidRemover(){};

    public StupidRemover(Writer writerInterface)
    {
        writer = writerInterface;
    }

    public String remove(String string) {
        return string.replaceAll("stupid", "s*****");
    }

   
    public void write(String content) throws IOException {
        writer.write(remove(content));
    }

    public void close() throws IOException {
        writer.close();
    }

    
    public String toString(){
        return writer.toString();
    }
}