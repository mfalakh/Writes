package com.tem.writer.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.tem.converters.LowerCaseConverter;
import com.tem.converters.UpperCaseConverter;
import com.tem.mywiter.Writer;
import com.tem.removers.DuplicateRemover;
import com.tem.removers.StupidRemover;
import com.tem.writers.FileWriter;
import com.tem.writers.StringWriter;

public class CombinedTests {

	// example:in question
	@Test
	public void DuplicateRemoverAndStupidRemover() throws IOException {

		FileWriter fileWriter = new FileWriter("myfile.bat");
		DuplicateRemover duplicateRemover = new DuplicateRemover(fileWriter);
		Writer combinedWriter = new StupidRemover(duplicateRemover);
		combinedWriter.write("This is really really stupid!!!");

		assertEquals("This is really s*****!!!", readFile());

	}

	@Test
	public void DuplicateRemoverAndStupidRemoverLowerCase() throws IOException {
		StringWriter stringWriter = new StringWriter();
		LowerCaseConverter lowerCaseConverter = new LowerCaseConverter(stringWriter);
		StupidRemover stupidRemover = new StupidRemover(lowerCaseConverter);
		Writer combinedWriter = new DuplicateRemover(stupidRemover);
		combinedWriter.write("HELLO STUPID WORLD WORLD");
		assertEquals("hello stupid world", combinedWriter.toString());
	}

	@Test
	public void DuplicateRemoverAndStupidRemoverUpperCase() throws IOException {
		StringWriter stringWriter = new StringWriter();
		UpperCaseConverter upperCaseConverter = new UpperCaseConverter(stringWriter);
		StupidRemover stupidRemover = new StupidRemover(upperCaseConverter);
		Writer combinedWriter = new DuplicateRemover(stupidRemover);
		combinedWriter.write("hello stupid world world");
		assertEquals("HELLO S***** WORLD", combinedWriter.toString());
	}

	@Test
	public void stupidRemoverOnUpperCase() throws IOException {
		StringWriter stringWriter = new StringWriter();
		UpperCaseConverter upperCaseConverter = new UpperCaseConverter(stringWriter);
		StupidRemover combinedWriter = new StupidRemover(upperCaseConverter);
		combinedWriter.write("hello stupid world");
		assertEquals("HELLO S***** WORLD", combinedWriter.toString());
	}

	@Test
	public void stupidRemoverAndLowerWithFileWriter() throws IOException, URISyntaxException {
		FileWriter fileWriter = new FileWriter("myfile.bat");
		LowerCaseConverter lowerCaseConverter = new LowerCaseConverter(fileWriter);
		StupidRemover stupidRemover = new StupidRemover(lowerCaseConverter);
		Writer combinedWriter = new DuplicateRemover(stupidRemover);
		combinedWriter.write("hello stupid stupid world");

		assertEquals("hello s***** world", readFile());
	}

	@Test
	public void duplicateRemoverOnLowerCase() throws IOException {
		StringWriter stringWriter = new StringWriter();
		LowerCaseConverter lowerCaseConverter = new LowerCaseConverter(stringWriter);
		DuplicateRemover combinedWriter = new DuplicateRemover(lowerCaseConverter);
		combinedWriter.write("HELLO STUPID STUPID WORLD");
		assertEquals("hello stupid world", combinedWriter.toString());
	}

	@Test
	public void duplicateRemoverAndStupidRemover() throws IOException {
		StringWriter stringWriter = new StringWriter();
		StupidRemover stupidRemover = new StupidRemover(stringWriter);
		DuplicateRemover combinedWriter = new DuplicateRemover(stupidRemover);
		combinedWriter.write("Hello stupid world world");
		assertEquals("Hello s***** world", combinedWriter.toString());
	}

	public static String readFile() throws IOException {
		return new String(Files.readAllBytes(Paths.get("myfile.bat")), StandardCharsets.UTF_8);
	}

	@BeforeAll
	public static void deleteFileIfExists() {
		File file = new File("myfile.bat");
		try {
			if (file.delete()) {
				System.out.println("File deleted successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
