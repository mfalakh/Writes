package com.tem.writer.test;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.tem.mywiter.Writer;
import com.tem.writers.FileWriter;

public class FileWriterTest extends WriterTest{

    String filepath = "myfile.bat";

    public String readFile() throws IOException {
    	return new String(Files.readAllBytes(Paths.get(filepath)), StandardCharsets.UTF_8);
    }

    @Override
    protected Writer createWriter() throws IOException {
        return new FileWriter(filepath);
    }

    @Override
    protected String getContent() throws IOException {
    	return new String(Files.readAllBytes(Paths.get(filepath)), StandardCharsets.UTF_8);
    }
}