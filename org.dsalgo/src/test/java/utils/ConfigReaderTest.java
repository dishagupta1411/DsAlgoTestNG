package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReaderTest {
	
	private Properties prop;
	
	public Properties readConfig() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("src/test/resources/propertiesFiles/config.properties");
	    prop.load(fis);
	    return prop;

	}
	

}  
