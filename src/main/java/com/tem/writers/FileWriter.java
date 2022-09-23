package com.tem.writers;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.tem.mywiter.Writer;

public class FileWriter implements Writer {

	java.io.FileWriter fileWriter;
	private boolean closed;
	Path path;

	public FileWriter(String file) throws IOException {
		fileWriter = new java.io.FileWriter(file);
		path = Paths.get(file);
	}

	public void write(String string) throws IOException {
		if (closed == false) {
			fileWriter.write(string);
			fileWriter.flush();
		}
	}

	public void close() {
		closed = true;
	}

}
