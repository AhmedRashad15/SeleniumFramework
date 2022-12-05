package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties 
{
	//Load the properties file from folder
	public static Properties userData= properties(System.getProperty("user.dir") +"\\src\\main\\java\\properties\\userData.properties");
	private static Properties properties(String Path) {
		Properties pro = new Properties();
		//stream for reading file
		try {
		FileInputStream stream=new FileInputStream(Path);	
		pro.load(stream);
		}catch(FileNotFoundException e) {
			System.out.println("Error occured"+ e.getMessage());
		} catch (IOException e) {
			System.out.println("Error occured"+ e.getMessage());

			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("Error occured"+ e.getMessage());

		}
		
		return pro;
		}
}
