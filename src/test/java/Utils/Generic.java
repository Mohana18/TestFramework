package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Generic {
	
	public static String GetPropertyValue(String v) throws IOException
	{
		Properties p=new Properties();
		FileInputStream fis=new FileInputStream("./src/test/java/com/testdata/Testdata.properties");
		p.load(fis);
		String s=p.getProperty(v);
		return s;
		
		
	}

}
