/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tragaperras;

import java.util.ArrayList;


public class Premios {
    public enum fruta{
        Fresa,Sandia,Platano,Melocoton,Pera
    }
    int cantidad;
    public ArrayList <fruta> combinacio;

    public Premios(int cantidad, fruta f1,fruta f2,fruta f3) {
        this.cantidad = cantidad;
        this.combinacio=new ArrayList<>(3);
        this.combinacio.add(0,f1);
        this.combinacio.add(1,f2);
        this.combinacio.add(2,f3);
    }
    public int getCantidad() {
        return cantidad;
    }   
}
