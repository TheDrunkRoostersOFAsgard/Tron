package Game;

import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
    	
    	Thread hilo = new Process("Moto");
    	
    	hilo.start();
    	
    	String plain = "{'key':'value'}";
    	
    	JSONObject json_plain = new JSONObject(plain);
    	
    	
    	
    	
    	
    	System.out.println(json_plain.get("key"));
    	
    	
    }
}
