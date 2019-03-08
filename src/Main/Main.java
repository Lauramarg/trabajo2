package Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import tragaperras.Maquina;
import tragaperras.Premios;


public class Main {
    
    public static void main(String[] args) throws InterruptedException {
        Premios p1=new Premios(50,  Premios.fruta.Fresa, Premios.fruta.Melocoton, Premios.fruta.Platano);
        Premios p2=new Premios(150,  Premios.fruta.Fresa, Premios.fruta.Fresa, Premios.fruta.Fresa);
        Premios p3=new Premios(100,  Premios.fruta.Pera, Premios.fruta.Platano, Premios.fruta.Melocoton);
        
        ArrayList<Premios> listp=new ArrayList<>();
        Collections.addAll(listp, p1,p2,p3); 
        Maquina m=new Maquina(listp, 5,25 );
        
        System.out.println("Introduzca el crédito: ");
        Scanner teclado = new Scanner(System.in);
        int credito = teclado.nextInt();
        teclado.nextLine();
      
        m.incrementarCredito(credito);
        
         while (m.getCredito() > 0){
            
            ArrayList<Premios.fruta> combinacion = m.jugar();
            System.out.println(combinacion.toString()  + " --- " + m.getCredito()); 
            System.out.println("Pulse Intro para volver a jugar"); 
             System.out.println("---------------------------------------------------");
            teclado.nextLine();  
         } 

        teclado.close();
    }
}
