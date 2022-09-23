package com.tem.converters;

import java.io.IOException;

import com.tem.mywiter.Writer;

public class LowerCaseConverter implements Writer {
    private Writer writer;

    public LowerCaseConverter(Writer writerInterface){
        writer = writerInterface;
    }

    public String convert(String string){
        return string.toLowerCase();
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
