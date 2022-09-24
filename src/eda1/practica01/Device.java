package eda1.practica01;

import java.util.Iterator;
import java.util.LinkedList;

public class Device implements Iterable<String>{
	private static int numDevices=0; //contador de dispositivos...atributo estatico
	private String deviceId = "";
	private LinkedList<String> words = null; 
		
	public static void initializeNumDevices() {
		numDevices = 0;
	}
	
	public Device(String name) {
		
		if( name==null) {
			throw new RuntimeException("El atributo name no puede ser nulo");
		}
		if(name.equals("")) {
			numDevices++;
			this.deviceId=numDevices+".- "+"noName";
			this.words= new LinkedList<>();
		}else {
			numDevices++;
			this.deviceId=numDevices+".- "+name.trim();
			this.words= new LinkedList<>();
		}
		
		//Si name == null --> excepcion
		//Si name es vacio, el nombre del dispositivo sera "noName"
		//this.deviceID = id + ".- " + name
		//3 lineas...
		//...
	}
	
	public void clear() {
		this.words.clear();
	}
	
	public int size() {
		return this.words.size();
	}
	
	public void sendMessage(String msg) {
		
		if (msg == null) return;
		/*String s1 = msg.toLowerCase();
		String[] trozos = s1.split(" ");
		
		for(int i=0; i<trozos.length; i++ ) {
			int act=i;
			for(int n=0; n<trozos.length; n++) {
				if(trozos[act].equals(trozos[i])) {
					
				}
			}
			
			
		}*/
		
		
		for(String text : msg.toLowerCase().split(" ")) {
			if(text.isEmpty()) continue;
			if(words.contains(text)) continue;
			words.add(text);
		}
		//Haz uso del metodo split(" ") para "trocear" la cadena y acceder a cada palabra de forma independiente
		//Un mensaje es un conjunto de palabras separadas por el caracter " " (un espacio en blanco)
		//Ten en cuenta que no queremos palabra repetidas
		//1 for()
		//...
	}
	
	public boolean contains(String word) {
		return this.words.contains(word.toLowerCase());
	}
	
	public boolean substitute(String word1, String word2) {
		//if(word1.toLowerCase().equals(null) || word2.toLowerCase().equals(null)) return false;
		if(word1==null || word2==null) return false;
		if(!words.contains(word1)) return false;
		else {
			words.set(this.words.indexOf(word1.toLowerCase()), word2.toLowerCase());
		}
		
		//Prohibido hacer uso de ListIterator<>
		//Si word1 o word2 es igual a null salimos del metodo (false)
		//Si no se encuentra la palabra word1 en el contenedor words, salimos del metodo (false)
		//En caso contrario se sustituye word1 por word2 y salimos del metodo (true)
		//...
		return true;
	}
	
	public boolean remove(String word) {
		
		if(word==null) return false;
		else {
			int temp = this.words.indexOf(word.toLowerCase());
			words.remove(temp);
		}return true;
		//Si word es nulo se rompe la ejecucion del metodo devolviendo false (precondicion)
		//2 lineas
		//...
		
	}
	
	@Override
	public String toString() {
		return this.deviceId;
	}
	
	@Override
	public boolean equals(Object o) {
		return this.deviceId.equals(((Device)o).deviceId);
	}

	@Override
	public Iterator<String> iterator() {
		return this.words.iterator();
		//Iterar sobre Device equivale a iterar sobre la estructura LinkedList<String> words
		//1 unica linea
		//return; //...
	}
}