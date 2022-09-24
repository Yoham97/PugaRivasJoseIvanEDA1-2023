package eda1.practica01;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class User{
	private static int numUsers = 0;
	private String userId = "";
	private ArrayList<Device> devices = null;
	
	
	public static void initializeNumUsers() {
		numUsers = 0;
	}
	
	public User(String name) {
		if(name==null || name=="") throw new RuntimeException("El atributo name no puede ser ni nulo ni vacio");
		numUsers++;
		userId= (numUsers) +".- "+name.trim();
		this.devices = new ArrayList<Device>();
		//3 lineas
		//...
	}
	
	public void clear() {
		/*if(devices.indexOf(this.devices)) {
		/	for(Device d : devices) {
			d.clear();
			}
			
		}*/
		//1 for()
		//...
		if(devices!=null) devices.clear();
	}
	
	
	public boolean addDevices(Device... devs) {
		if (devs == null) return false;
		for( Device d : devs) {
			/*if(this.devices.isEmpty()) {
				this.devices.add(d);
				continue;
			}*/
			if(this.devices.contains(d)) continue;
			this.devices.add(d);
		}
		//1 for()
		//...
		return true;
	}
	
	public int getNumDevices() {
		return this.devices.size();
	}

	public boolean loadMessages(Device dev, String fileName) {
		//Importante que tengas muy claro los pasos que seguimos para leer un archivo de texto...
		//Si no lo tienes claro, pregunta...
		Scanner scan = null;
		String line; 
		if (!this.devices.contains(dev)) return false;
		try {
			scan = new Scanner(new File(fileName));
		}catch(Exception e) {
			System.out.println("Error: no encuentra el archivo");
			return false;
		}
		while (scan.hasNextLine()) {
			line = scan.nextLine();
			if (line.isEmpty()) continue; 
			//1 linea
			//...
		}
		scan.close();
		return true;
	}
	
	public boolean sendMessage(Device dev, String msg) {
		
		if(dev== null || !devices.contains(dev)) return false;
		else dev.sendMessage(msg);
		//Si dev es nulo o el contenedor no contiene al dispositivo dev se devuelve false
		//En caso contrario se envia el mensaje...
		//2 lineas
		//...
		return true;
	}
	
	public void substitute(String word1, String word2) {
		if (word1 == null || word2 == null) return;
		//1 for()
		//...
	}
	
	public void remove(String word) {
		if (word == null) return;
		//1 for()
		//...
	}
	
	public boolean contains(String word) {
		//1 for()
		for () {
			//1 linea
		}
		return false;
	}
	
	public String getWords() {
		String result = "";
		//Tened en cuenta que los dispositivos pueden no contener ninguna palabra; si ocurre este caso, lo ignoramos
		//2 for()
		//...
		return result;
	}
	
	public ArrayList<String> getOrderedWords() {
		ArrayList<String> result = new ArrayList<String>();
		//2 for()
		//...
		
		//Recuerda: orden ascencente (de menor a mayor)
		return result;
	}
	
	@Override
	public String toString() {
		return this.userId;
	}
}