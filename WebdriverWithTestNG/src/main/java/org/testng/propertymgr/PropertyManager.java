package org.testng.propertymgr;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class PropertyManager {

	private Properties property;

	public PropertyManager() {
		property = new Properties();
	}

	public Properties loadPropertyFile(String propertyToLoad) {
		try {
			property.load(new FileInputStream(new File(System
					.getProperty("user.dir")
					+ "\\src\\test\\java\\org\\properties\\"
					+ propertyToLoad)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return property;
	}
}
