package com.tem.writer.test;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;

import com.tem.mywiter.Writer;
import com.tem.writers.StringWriter;

public class StringWriterTest extends WriterTest {
	private StringWriter stringWriter;

	@BeforeEach
	public void setUp() {
		stringWriter = new StringWriter();
	}

	@Override
	protected Writer createWriter() throws IOException {
		return new StringWriter();
	}

	@Override
	protected String getContent() {
		return getWriter().toString();
	}
}