/*
 * Send command to VLC web interface.
 */
package javaapplication1;

/**
 *
 * @author Rocco Musolino
 */

import java.net.*;
import java.io.*;

public class web_vlc {
    
public static void comando(String z) throws Exception{
web_vlc.connessione(z);
}

public static void comando(String z, Integer k) throws Exception{
web_vlc.connessione(z+"&val="+k);
}

public static void connessione(String x) throws Exception{
        URL pagina = new URL("http://localhost:8080/requests/status.xml?command="+x);
        URLConnection yc = pagina.openConnection();
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) 
            System.out.println(inputLine);
            in.close();
        }
        catch (Exception e){
            System.out.println("Interfaccia Web VLC non attiva.");
        }


}

public static void main(String args[]){
try{
web_vlc.comando("pl_play"); //comando VLC per mandare in play
web_vlc.comando("volume", 250); // il volume va da 0 a 500 mappato su vlc da 0 a 200.
}catch (Exception e){
    System.out.println(e);
}

}

}
