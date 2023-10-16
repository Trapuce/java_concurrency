import java.util.ListIterator;
import java.util.concurrent.locks.ReentrantLock;

class Site {

/* Constantes communes à tous les sites */

static final int STOCK_INIT = 5;
static final int STOCK_MAX = 10;
static final int BORNE_SUP = 8;
static final int BORNE_INF = 2;
private int numero ;
private int currentBike ;
private ReentrantLock re;
     public Site (int numero){
     this.numero = numero ;
     this.currentBike = STOCK_INIT;
      this.re = new ReentrantLock();
}


public   synchronized void stocker(){
     while(this.currentBike >= STOCK_MAX) {
         try {
             System.out.println("===================Attente  no place available==================");
             wait();
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         }
     }
    this.currentBike++ ;
    notifyAll();
}
public  synchronized void deSotcker(){

        while ( this.currentBike == 0){
            try {
                System.out.println("================Attente  no bike  available========================  " + Thread.currentThread().getName());
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.currentBike--;
        notifyAll();;

}


     public int getCurrentBike() {
          return currentBike;
     }
     public void setCurrentBike(int bike){ this.currentBike = bike; }
     public int getNumero(){ return this.numero ;}
}
