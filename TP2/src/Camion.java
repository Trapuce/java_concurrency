public class Camion extends Thread{

    private Site site [] ;
    private int bikeCamion =  5;
    public Camion(Site[] site){
        this.site = new Site[site.length];
       for (int i = 0 ; i< site.length ; i++){
           this.site[i] = site[i];
       }
    }

    public Site [] getSites() {
        return site.clone();
    }
    public Site getSite(int i){
        return  site[i] ;
    }

    public void work ( Site site){
        //System.out.println("===================camion  " + this.getName());
        System.out.println("===================it stays "+ site.getCurrentBike() + " to the site "+ site.getNumero());
        System.out.println("====================it stays :"+ bikeCamion  + " on the truck");
        if(site.getCurrentBike() > Site.BORNE_SUP){
             int res = site.getCurrentBike() - Site.STOCK_INIT;
             this.bikeCamion +=res ;
             while (res>0){
                 site.deSotcker();
                 res--;
             }
        } else if (site.getCurrentBike()< Site.BORNE_INF) {
                    while(bikeCamion > 0 && site.getCurrentBike() <= Site.STOCK_INIT ){
                        site.stocker();
                        this.bikeCamion--;
                    }
        }

        System.out.println("================it stays :"+ bikeCamion  + " on the truck");
        System.out.println("================it stays "+ site.getCurrentBike() + " to the site "+ site.getNumero());


    }
    public void run(){
        for (int i = 0 ; i< site.length ; i++){
            work(site[i]);
        }

    }

}
