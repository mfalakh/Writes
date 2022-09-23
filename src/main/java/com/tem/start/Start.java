package com.tem.start;

import java.io.File;

public class Start {

	public static void main(String[] args) {
		System.out.println("Hellooo");
		deleteFileIfExists();

	}
	
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
