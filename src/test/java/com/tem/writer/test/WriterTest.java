package com.tem.writer.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.tem.mywiter.Writer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

public abstract class WriterTest {

	private Writer writer;

	@BeforeEach
	public void setup() throws IOException {
		writer = createWriter();
	}

	public Writer getWriter() {
		return writer;
	}

	@Test
	public void callWriteOnceWhenFileExists() throws IOException {
		writer.write("Hello");
		assertEquals("Hello", getContent());
	}

	@Test
	public void callWriteTwice() throws IOException {
		writer.write("Hello");
		writer.write("Java");
		assertEquals("HelloJava", getContent());
	}

	@Test
	public void verifyClose() throws IOException {
		writer.write("Hello");
		writer.write("World");
		writer.close();
		writer.write("Hello");
		assertEquals("HelloWorld", getContent());
	}

	protected abstract Writer createWriter() throws IOException;

	protected abstract String getContent() throws IOException;
}
