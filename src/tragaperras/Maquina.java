package tragaperras;
import java.util.ArrayList;
import java.util.Random;

public class Maquina {
    ArrayList<Premios> premios;
    int numcasillas;
    int precioJugada;
    int credito;

    public Maquina(ArrayList<Premios> premios, int numcasillas, int pjugada) {
        this.premios = premios;
        if(numcasillas<3)
            this.numcasillas = 3;
        else
            this.numcasillas=numcasillas;
        this.precioJugada = pjugada;
    }

    public int getPrecioJugada() {
        return precioJugada;
    }

    public void setPrecioJugada(int precioJugada) {
        this.precioJugada = precioJugada;
    }

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }
    
    private ArrayList<Premios.fruta> generarCombinacion() {
        ArrayList<Premios.fruta> combinacion =  new ArrayList<Premios.fruta>(this.numcasillas);
        Random random = new Random();Premios.fruta[] todas=Premios.fruta.values();
        for (int i = 0; i < this.numcasillas; i++){
            Premios.fruta aux=todas[random.nextInt(this.numcasillas)];
            combinacion.add(aux);
        }      
        return combinacion;
    }
    public ArrayList<Premios.fruta> jugar() throws InterruptedException{
        ArrayList<Premios.fruta> aux=generarCombinacion();
            this.comprobar(aux);
        return aux;
    }
    public void incrementarCredito(int credito) {
       this.credito=credito;
    }
    public boolean comprobar(ArrayList<Premios.fruta> generado) throws InterruptedException{

        if(generado.size()<=this.numcasillas){
            for (int i = 0; i < this.premios.size(); i++) {
                for (int j = 0; j+3 < generado.size(); j++) {
                    ArrayList<Premios.fruta> aux=new ArrayList<>(3);
                    aux.add(generado.get(j));
                    aux.add(generado.get(j+1));
                    aux.add(generado.get(j+2));
                    if(aux.toString().equals(this.premios.get(i).combinacio.toString())){
                        this.credito=this.credito+this.premios.get(i).getCantidad();
                        System.out.println("Ganastes "+this.premios.get(i).getCantidad());
                        Thread.sleep(1000);
                    }
                }
            }
        }
        this.credito=this.credito-this.precioJugada;
        System.out.println("perdistes :"+this.precioJugada);
        return false;
    }
    
}
