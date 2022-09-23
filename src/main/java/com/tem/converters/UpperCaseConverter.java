package com.tem.converters;

import java.io.IOException;

import com.tem.mywiter.Writer;

public class UpperCaseConverter implements Writer{
    private Writer writer;

    public String convert(String string)
    {
        return string.toUpperCase();
    }

    public UpperCaseConverter(Writer writerInterface)
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
}
