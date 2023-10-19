import java.util.ListIterator;
import java.util.concurrent.locks.ReentrantLock;

class Site {

/* Constantes communes à tous les sites */

static final int STOCK_INIT = 5;
static final int STOCK_MAX = 10;
static final int BORNE_SUP = 8;
static final int BORNE_INF = 2;
private int numero ;
public boolean truckOnsite ;
public boolean busy;
private int numberOfBikes ;
     public Site (int numero){
     this.numero = numero ;
     this.numberOfBikes = STOCK_INIT;

}


public   synchronized void stocker(){
     while(this.numberOfBikes >= STOCK_MAX) {
         try {
             wait();
             System.out.println("Waiting no place ");
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         }
     }
    this.numberOfBikes++ ;
    notifyAll();
}
public  synchronized void deSotcker(){
        while ( this.numberOfBikes == 0 ){
            try {
                wait();
                System.out.println("Waiting no bike ");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.numberOfBikes--;

        notifyAll();;

}
    public synchronized int work(int numberOfBikesInTruck) {

        if (numberOfBikes > Site.BORNE_SUP) {
            int surplusBikes = getNumberOfBikes() - Site.STOCK_INIT;
            numberOfBikesInTruck += surplusBikes;
            numberOfBikes=numberOfBikes - surplusBikes;
            System.out.println("[TRUCK] dropped " + surplusBikes + " to the site " + getNumero());
        }

        if (numberOfBikes < Site.BORNE_INF) {
            int bikesToAdd = Site.STOCK_INIT - numberOfBikes;
            if (bikesToAdd > numberOfBikesInTruck) {
                numberOfBikes =numberOfBikes + numberOfBikesInTruck;
                System.out.println("[TRUCK] dropped  " + numberOfBikesInTruck + " on site " + getNumero());
            } else {
                numberOfBikes=numberOfBikes+ bikesToAdd;
                numberOfBikesInTruck -= bikesToAdd;
                System.out.println("[TRUCK] has just loaded up on site   " + getNumero());
            }
        }



        return numberOfBikesInTruck;
    }



     public int getNumberOfBikes() {
          return numberOfBikes;
     }
     public void setNumberOfBikes(int bike){ this.numberOfBikes = bike; }
     public int getNumero(){ return this.numero ;}
}
