/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class SonidoMoneda implements Runnable{

 private URL url = null;

    @Override
    public void run() {

       try {
           url = new URL("file:sonidomoneda.wav");
       } catch (MalformedURLException ex) {
           Logger.getLogger(SonidoMoneda.class.getName()).log(Level.SEVERE, null, ex);
       }
         AudioClip ac = Applet.newAudioClip(url);
         ac.play();
    }
    
}
