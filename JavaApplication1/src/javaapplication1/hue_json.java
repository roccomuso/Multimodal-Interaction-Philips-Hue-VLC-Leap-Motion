/*
 * Interaction with Philips Hue Bridge.
 * 
 * Before you start with encoding and decoding JSON using Java, you will need to install any of the JSON modules available.
 * For this application I downloaded and installed JSON.simple and add the location of json-simple-1.1.1.jar file to environment variable CLASSPATH.
 * 
 */
package javaapplication1;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.*; //lib json-simple-1.1.1.jar
import org.json.simple.parser.*;


public class hue_json {
    
    static String hue_bridge_ip = null;
    
    public void set_bridge_ip(String z){
        hue_json.hue_bridge_ip = z;
    }
    
    public static void all_off() throws Exception{ // to turn off all the light we can call the method all_off() or directly turn_light(false, 0);
      turn_light(false, 0); //light 0 means all the lights in the system. (better, the groups 0 contains all the lights registered on the bridge)
    }
    
    public static void all_on() throws Exception{ // to turn on all the light we can call the method all_on() or directly turn_light(true, 0);
      turn_light(true, 0); //light 0 means all the lights in the system.
    }
    
    public static int turn_light(boolean x, Integer n_luce) throws Exception{
        URL url;
        
        try{ // get Hue bridge local IP address if not specified
            if (hue_bridge_ip == null){ //the ip address is not specified, we'll try to get it automatically
            
            // try to get ip from meethue website.
                String r = url_reader.address("http://www.meethue.com/api/nupnp");
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(r);
                JSONArray array = (JSONArray) obj;
                JSONObject obj2 = (JSONObject)array.get(0);
               
                hue_bridge_ip = (obj2.get("internalipaddress")).toString();
            
            }

        }
        catch (Exception e){
            System.out.println(e);
        }
        
        
        if (n_luce == 0){ url = new URL("http://"+hue_bridge_ip+"/api/newdeveloper/groups/0/action/");}
            else
        { url = new URL("http://"+hue_bridge_ip+"/api/newdeveloper/lights/"+n_luce+"/state/");}
        
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("PUT");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
        
      JSONObject payload = new JSONObject();

      /* // data types:
      payload.put("name", "foo");
      payload.put("num", new Integer(100));
      payload.put("balance", new Double(1000.21));
      payload.put("is_vip", new Boolean(true));
      */
      payload.put("on", x);
      //System.out.print(payload);
      
        osw.write(payload.toString());
        
        osw.flush();
        osw.close();
         return connection.getResponseCode(); // 200 - richiesta ricevuta con successo
        
    }
    
    public static void main(String[] args) throws Exception {
        
        //all_off();    
        //all_on();
        
        //turn_light(true, 1);
        
    }
    
}
