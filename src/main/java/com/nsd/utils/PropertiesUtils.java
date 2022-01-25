package com.nsd.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
	
	public static Properties loadProperties(InputStream fileStream) {
		Properties properties = new Properties();
		try {
			properties.load(fileStream);
		} catch (IOException e) {
			throw new RuntimeException("Issue on loading the properties file");
		}
		return properties;
	}
	
	public static Properties loadProperties(String propertiesFileName) {
		Properties properties = new Properties();
		String absFilePath = FileUtils.getAbsolutePath(propertiesFileName);
		
		try(FileInputStream fis = new FileInputStream(absFilePath);) {
			properties.load(fis);
		}
		catch (FileNotFoundException e) {
			throw new RuntimeException("File is not availabe in the provided path -"+absFilePath);
		}
		catch (IOException e) {
			throw new RuntimeException("Issue on loading the properties file -"+absFilePath);
		}
		return properties;
	}
	
	public static String getPropValue(InputStream fileStream, String key) {
		String value = loadProperties(fileStream).getProperty(key);
		if(value == null)
			throw new RuntimeException("Property key '"+key+", not present in properties file");
		return value;
	}
	
	public static String getPropValue(String propertiesFileName, String key) {
		String value = loadProperties(propertiesFileName).getProperty(key);
		if(value == null)
			throw new RuntimeException("Property key '"+key+"' not present in properties file");
		return value;
	}
	

}
