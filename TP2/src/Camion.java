public class Camion extends Thread{

    private Site site [] ;
    private int numberofBikesInTruck ;
    private boolean  stop ;
    public Camion(Site[] site){
        this.site = new Site[site.length];
       for (int i = 0 ; i< site.length ; i++){
           this.site[i] = site[i];
       }
       this.stop = false;
       this.numberofBikesInTruck  =5 ;
    }
    public void run(){
        while (!stop) {
            int i = 0;
            for (; i < site.length; i++) {
              this.numberofBikesInTruck=  site[i].work(this.numberofBikesInTruck);
                //System.out.println(i);
            }
        }

    }/*

    public   void retrieveSurplusBikes(Site site){
        int surplusBikes = site.getNumberOfBikes() - Site.STOCK_INIT;
        this.numberofBikesInTruck +=surplusBikes ;
        site.setNumberOfBikes(site.getNumberOfBikes()-surplusBikes);
        System.out.println("[TRUCK] dropped "+ site.getNumberOfBikes() + " to the site "+ site.getNumero());
    }
    public   void rechargeBikeStock(Site site){
            int bikesToAdd = Site.STOCK_INIT -site.getNumberOfBikes() ;
            if(bikesToAdd > numberofBikesInTruck){
                  site.setNumberOfBikes(site.getNumberOfBikes()+numberofBikesInTruck);
                  System.out.println("[TRUCK] dropped  "+numberofBikesInTruck + " on site "+ site.getNumero());

            }else {
                 site.setNumberOfBikes(site.getNumberOfBikes()+bikesToAdd);
                 numberofBikesInTruck -= bikesToAdd;
                System.out.println("[TRUCK] has just loaded up on site   "+ site.getNumero());

            }


    }


    public  synchronized   void work ( Site site){

         site.truckOnsite = true ;


        if(site.busy){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if(site.getNumberOfBikes() > Site.BORNE_SUP){
            retrieveSurplusBikes( site);
        }
        if (site.getNumberOfBikes()< Site.BORNE_INF) {
            rechargeBikeStock(site)  ;
        }

        site.truckOnsite = false;
        notifyAll();
    }
*/



    public Site [] getSites() {
        return site.clone();
    }
    public Site getSite(int i){
        return  site[i] ;
    }


    public void setStop(boolean b) {
        this.stop = b ;
    }
}
