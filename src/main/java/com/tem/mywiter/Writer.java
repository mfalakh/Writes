package com.tem.mywiter;
import java.io.IOException;

public interface Writer{
    void write(String content) throws IOException;
    void close() throws IOException;
}

