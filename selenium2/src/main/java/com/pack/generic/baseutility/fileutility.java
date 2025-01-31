package com.pack.generic.baseutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class fileutility {
public String getdatafromfile(String key) throws Throwable
{
	FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.properties");
	Properties p=new Properties(); 
	p.load(fis);
	String data=p.getProperty(key);
	return data;
	
}
}
