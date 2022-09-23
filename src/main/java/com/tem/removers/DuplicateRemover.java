package com.tem.removers;

import java.io.IOException;
import java.util.StringTokenizer;

import com.tem.mywiter.Writer;

public class DuplicateRemover implements Writer{
    public String convert(String string)
    {
        return remove(string);
    }

    private Writer writer;

    public DuplicateRemover(Writer writerInterface)
    {
        writer = writerInterface;
    }

    
    public void write(String content) throws IOException {
        writer.write(convert(content));
    }

    
    public void close() throws IOException {
        writer.close();
    }

    
    public String toString(){
        return writer.toString();
    }

    public String remove(String string)
    {
        StringTokenizer tokens = new StringTokenizer(string);
        StringBuilder stringBuilder = new StringBuilder();
        String current = "";

        while(tokens.hasMoreElements()){
            String next = tokens.nextToken();
            if(!current.equals(next)){
                stringBuilder.append(next + " ");
                current = next;
            }
        }
        return stringBuilder.toString().trim();
    }
}
