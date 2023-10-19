public class Client extends Thread {
    private final Site siteStart;
    private final Site siteEnd;

    public Client(Site siteStart, Site siteEnd) {
        this.siteStart = siteStart;
        this.siteEnd = siteEnd;

    }


    /**
     * this method take bike to the site start if there is
     */
    public void bikeTaken() {
        this.siteStart.deSotcker();
        System.out.println("[CLIENT] " + this.getName()  +" took a bike to site " + siteStart.getNumero()  );
        System.out.println("[CLIENT] stays " + siteStart.getNumberOfBikes() + " bikes to site " + siteStart.getNumero());

    }

    /**
     * this method put down the bike to the site End if
     * he stays to the place
     */
    public void bikeReturned() {
        this.siteEnd.stocker();
        System.out.println("[CLIENT] " + this.getName()  +" returned a bike to site " + siteStart.getNumero()  );
        System.out.println("[CLIENT] stays " + siteStart.getNumberOfBikes() + " bikes to site " + siteStart.getNumero());

    }


    /**
     * this method Simulates a client's journey from a starting point to a destination.
     */
    public void simulateJourney() {
        //System.out.println("client :"+ this.getName());
        bikeTaken();

        try {
            Thread.sleep(100L * Math.abs(siteEnd.getNumero() - siteStart.getNumero()));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        bikeReturned();


    }

    public Site getSiteStart() {
        return this.siteStart;
    }

    public Site getSiteEnd() {
        return this.siteEnd;
    }

    @Override
    public void run() {
        simulateJourney();
    }
}
