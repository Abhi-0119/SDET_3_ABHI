package com.Vtiger.genericUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtil {

	private FileUtil() {

	}

	public static FileUtil objforFileUtil()
	{
		FileUtil prop = new FileUtil();
		return prop;
	}
	/**
	 * @author sunny
	 * Description :if the prop file path is in constants we can directly give key
	 * @param key
	 * @return value from prop file
	 * @throws IOException 
	 */
	public String readPropData(String key) throws IOException {
		FileInputStream fis = new FileInputStream(IAutoConstants.propfilepath);
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);

	}
	/**
	 * @author sunny
	 * Description :if the prop file path is not in constants we want to give externally we use path
	 * @param key
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public String readPropData(String key, String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);

	}

	
}


