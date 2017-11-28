/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class Mapa {
    private int x;
    private int y;
    private Image foto;
    private Rectangle[] bordescajas;
    private Rectangle[] bordesmonedas;
    private Caja[] cajas;
    private Spikes[] chuzos;
    private Rectangle[] bordeschuzos;
    private Moneda[] monedas;
    private Pasto[] piso;
    private Rectangle bordebandera;
    private Bandera bandera;
    public Mapa() {
        this.x=0;
        this.y=0;
        this.bordebandera=new Rectangle(0,0);
        this.bandera= new Bandera(2500,560);
        this.chuzos= new Spikes[7];
        this.bordeschuzos= new Rectangle[7];
        this.foto = Toolkit.getDefaultToolkit().getImage("layer-1.png");
        this.bordescajas = new Rectangle[44];
        this.bordesmonedas= new Rectangle[20];
        this.cajas= new Caja[43];
        this.piso= new Pasto[60];
        this.monedas= new Moneda[20];
        cajas();
        monedas();
        pasto();
        chuzos();
        bordes();
    }

    public void bordes(){
        for (int i = 0; i < this.chuzos.length; i++) {
            this.bordeschuzos[i]=new Rectangle(this.chuzos[i].getX()+this.x,this.chuzos[i].getY(),60,60);
        }
        for (int i = 0; i < this.monedas.length; i++) {
            this.bordesmonedas[i]=new Rectangle(this.monedas[i].getX()+this.x,this.monedas[i].getY(),32,32);
        }
        for (int i = 0; i < this.bordescajas.length-1; i++) {
            this.bordescajas[i]=new Rectangle(this.cajas[i].getX()+this.x,this.cajas[i].getY(),60,60);
        }
        this.bordescajas[this.bordescajas.length-1]=new Rectangle(0,725,1920,1);
    }
    public void cajas(){
        this.cajas[0]=new Caja(258+this.x,661);
        this.cajas[1]=new Caja(318+this.x,601);
        this.cajas[2]=new Caja(378+this.x,541);
        this.cajas[3]=new Caja(542+this.x,660);
        this.cajas[4]=new Caja(902+this.x,660);
        this.cajas[5]=new Caja(1022+this.x,660);
        this.cajas[6]=new Caja(602+this.x,660);
        this.cajas[7]=new Caja(662+this.x,660);
        this.cajas[8]=new Caja(722+this.x,660);
        this.cajas[9]=new Caja(722+this.x,600);
        this.cajas[10]=new Caja(602+this.x,600);
        this.cajas[11]=new Caja(662+this.x,600);
        this.cajas[12]=new Caja(662+this.x,540);
        this.cajas[13]=new Caja(782+this.x,660);
        this.cajas[14]=new Caja(962+this.x,660);
        this.cajas[41]=new Caja(1082+this.x,660);
        this.cajas[42]=new Caja(1082+this.x,600);
        this.cajas[15]=new Caja(1022+this.x,600);
        this.cajas[16]=new Caja(1082+this.x,540);
        this.cajas[17]=new Caja(1142+this.x,480);
        this.cajas[18]=new Caja(1142+this.x,540);
        this.cajas[19]=new Caja(1142+this.x,600);
        this.cajas[20]=new Caja(1142+this.x,660);
        this.cajas[21]=new Caja(1322+this.x,480);
        this.cajas[22]=new Caja(1442+this.x,480);
        this.cajas[23]=new Caja(1562+this.x,480);
        this.cajas[24]=new Caja(1742+this.x,480);
        this.cajas[25]=new Caja(1982+this.x,480);
        this.cajas[26]=new Caja(1322+this.x,540);
        this.cajas[27]=new Caja(1322+this.x,600);
        this.cajas[28]=new Caja(1322+this.x,660);
        this.cajas[29]=new Caja(1442+this.x,540);
        this.cajas[30]=new Caja(1442+this.x,600);
        this.cajas[31]=new Caja(1442+this.x,660);
        this.cajas[32]=new Caja(1562+this.x,540);
        this.cajas[33]=new Caja(1562+this.x,600);
        this.cajas[34]=new Caja(1562+this.x,660);
        this.cajas[35]=new Caja(1742+this.x,540);
        this.cajas[36]=new Caja(1742+this.x,600);
        this.cajas[37]=new Caja(1742+this.x,660);
        this.cajas[38]=new Caja(1982+this.x,540);
        this.cajas[39]=new Caja(1982+this.x,600);
        this.cajas[40]=new Caja(1982+this.x,660);
    }
    public void monedas(){
        this.monedas[0]= new Moneda(625,550);
        this.monedas[1]= new Moneda(550,600);
        this.monedas[2]= new Moneda(400,500);
        this.monedas[3]= new Moneda(340,560);
        this.monedas[4]= new Moneda(280,620);
        this.monedas[5]= new Moneda(400,680);
        this.monedas[6]= new Moneda(432,680);
        this.monedas[7]= new Moneda(464,680);
        this.monedas[8]= new Moneda(496,680);
        this.monedas[9]= new Moneda(680,500);
        this.monedas[10]= new Moneda(735,560);
        this.monedas[11]= new Moneda(960,620);
        this.monedas[12]= new Moneda(1040,560);
        this.monedas[13]= new Moneda(1400,400);
        this.monedas[14]= new Moneda(1520,400);
        this.monedas[15]= new Moneda(1640,400);
        this.monedas[16]= new Moneda(1672,400);
        this.monedas[17]= new Moneda(1694,400);
        this.monedas[18]= new Moneda(1726,400);
        this.monedas[19]= new Moneda(1825,400);
    
    }
    public void pasto(){
        int xauxiliar=0;
        int yaux=720;
        for (int i = 0; i < (this.piso.length/2); i++) {
            this.piso[i]=new Pasto(xauxiliar,yaux);
            xauxiliar+=128;
        }
        xauxiliar=0;
        yaux=847;
        for (int i = (this.piso.length/2); i < this.piso.length; i++) {
            this.piso[i]=new Pasto(xauxiliar,yaux);
            xauxiliar+=128;
        }
    }
    public void chuzos(){
        this.chuzos[0]=new Spikes(1383,670);
        this.chuzos[1]=new Spikes(1503,670);
        this.chuzos[2]=new Spikes(1623,670);
        this.chuzos[3]=new Spikes(1683,670);
        this.chuzos[4]=new Spikes(1803,670);
        this.chuzos[5]=new Spikes(1863,670);
        this.chuzos[6]=new Spikes(1923,670);
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public Caja[] getCajas() {
        return cajas;
    }

    public void setCajas(Caja[] cajas) {
        this.cajas = cajas;
    }

    public Rectangle[] getBordescajas() {
        return bordescajas;
    }

    public void setBordescajas(Rectangle[] bordescajas) {
        this.bordescajas = bordescajas;
    }

    public Rectangle[] getBordesmonedas() {
        return bordesmonedas;
    }

    public void setBordesmonedas(Rectangle[] bordesmonedas) {
        this.bordesmonedas = bordesmonedas;
    }

    public Moneda[] getMonedas() {
        return monedas;
    }

    public void setMonedas(Moneda[] monedas) {
        this.monedas = monedas;
    }

    public Pasto[] getPiso() {
        return piso;
    }

    public void setPiso(Pasto[] piso) {
        this.piso = piso;
    }

    public Spikes[] getChuzos() {
        return chuzos;
    }

    public void setChuzos(Spikes[] chuzos) {
        this.chuzos = chuzos;
    }

    public Rectangle[] getBordeschuzos() {
        return bordeschuzos;
    }

    public void setBordeschuzos(Rectangle[] bordeschuzos) {
        this.bordeschuzos = bordeschuzos;
    }

    public Bandera getBandera() {
        return bandera;
    }

    public void setBandera(Bandera bandera) {
        this.bandera = bandera;
    }

    public Rectangle getBordebandera() {
        return bordebandera;
    }

    public void setBordebandera(Rectangle bordebandera) {
        this.bordebandera = bordebandera;
    }
    
}
