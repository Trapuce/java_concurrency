public class Client extends Thread {
    private final Site siteStart;
    private final Site siteEnd;
    private int bike;

    public Client(Site siteStart, Site siteEnd) {
        this.siteStart = siteStart;
        this.siteEnd = siteEnd;
        this.bike = 0;
    }


    /**
     * this method take bike to the site start if there is
     */
    public void takeBike() {

        this.siteStart.deSotcker();
        this.bike = 1;
        System.out.println("I take a bike to site " + siteStart.getNumero() + " " + this.getName() );
        System.out.println("it stays " + siteStart.getCurrentBike() + " bikes to site " + siteStart.getNumero());

    }

    /**
     * this method put down the bike to the site End if
     * he stays to the place
     */
    public void putDownBike() {

        this.bike = 0;
        this.siteEnd.stocker();
        System.out.println("I put down a bike to site " + siteEnd.getNumero());
        System.out.println("it stays " + siteEnd.getCurrentBike() + " bikes to site " + siteEnd.getNumero());

    }

    public void simulation() {
        //System.out.println("client :"+ this.getName());
        takeBike();

        try {
            Thread.sleep(100L * Math.abs(siteEnd.getNumero() - siteStart.getNumero()));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        putDownBike();


    }

    public Site getSiteStart() {
        return this.siteStart;
    }

    public Site getSiteEnd() {
        return this.siteEnd;
    }

    @Override
    public void run() {
        simulation();
    }
}
