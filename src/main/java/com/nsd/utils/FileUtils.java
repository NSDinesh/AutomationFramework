package com.nsd.utils;

import java.io.File;
import java.io.FilenameFilter;

public class FileUtils {
	
	private FileUtils() {
		
	}
	
	public static boolean isFileExists(String filePath) {
		File file = new File(filePath);
		return file.exists();
	}
	
	public static boolean isFile(String filePath) {
		File file = new File(filePath);
		return file.isFile();
	}
	
	public static boolean isDirectory(String filePath) {
		File file = new File(filePath);
		return file.isDirectory();
	}
	
	public static String getAbsolutePath(String filePath) {
		File file = new File(filePath);
		return file.getAbsolutePath();
	}
	
	public static String[] getFileWithExtension(String directory, String extension) {
		if(!isDirectory(directory))
			return new String[0];
		 
		
		File file = new File(getAbsolutePath(directory));
		FilenameFilter fileNameFilter = (e,e1) -> e1.contains(extension);
		
		return file.list(fileNameFilter);
	}
	
}
