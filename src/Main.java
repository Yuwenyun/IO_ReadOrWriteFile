import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class Main {

	public static void main(String[] args)
	{
		Main main = new Main();
		
		File file = new File("Owen.txt");
		main.readFileOneByteEachTime(file);
		main.readMultiByteEachTime(file);
		main.readFileByLine(file);
	}
	
	/**
	 * read file one byte each time
	 * @param file
	 */
	private void readFileOneByteEachTime(File file)
	{
		InputStream is = null;
		try 
		{
			is = new FileInputStream(file);
			
			int content = 0;
			while((content = is.read()) > 0)
			{
				//what we are supposed to do with this int returned by read()?
				System.out.println((char)content);
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(is != null)
			{
				try 
				{
					is.close();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * read byte array with FileInputStream
	 * @param file
	 */
	private void readMultiByteEachTime(File file)
	{
		InputStream is = null;
		try 
		{
			is = new FileInputStream(file);
			byte[] buffer = new byte[1024];
			int countByte = 0;
			while((countByte = is.read(buffer)) > 0)
			{
				//what we are supposed to do with this int returned by read()?
				System.out.println(new String(buffer));
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(is != null)
			{
				try 
				{
					is.close();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * read file with buffer, one line a time
	 * @param file
	 */
	private void readFileByLine(File file)
	{
		BufferedReader reader = null;
		try 
		{
			reader = new BufferedReader(new FileReader(file));
			String tempLine = null;
			while((tempLine = reader.readLine()) != null)
			{
				System.out.println(tempLine);
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(reader != null)
			{
				try 
				{
					reader.close();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
}
