import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SalvarLer {
	Venda p;
	
	
	public void salvar(String nome, Venda venda)
	{
	try
	{
		this.p = venda;
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nome));
	
			oos.writeObject(p);
			oos.close();
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
			
		}
	}
	
	//RETORNA
	public Venda ler(String nome)
	{
		
		try 
		{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nome));
			p = (Venda) ois.readObject();
			
			
			ois.close();
			
			
		} 
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	
				

		
}
