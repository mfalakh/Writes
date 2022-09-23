package com.tem.writers;

import com.tem.mywiter.Writer;

public class StringWriter implements Writer {
    private StringBuilder content = new StringBuilder();
    private boolean open = true;

    public void write(String string){
        if (open){
            content = content.append(string);
        }
    }

    public String toString()
    {
        return content.toString();
    }

    public void close() {
        open = false;
    }
}