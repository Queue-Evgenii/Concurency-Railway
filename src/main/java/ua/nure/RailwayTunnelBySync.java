package ua.nure;

public class RailwayTunnelBySync extends RailwayTunnel {
    private final int permits;
    private int occupiedPermits = 0;

    public RailwayTunnelBySync(int permits) {
        this.permits = permits;
    }

    @Override
    public synchronized void enterTunnel(String name) throws InterruptedException {
        while (this.occupiedPermits >= this.permits) {
            this.wait();
        }
        occupiedPermits++;
        System.out.println(name + " is traveling through the tunnel.");
    }

    @Override
    public synchronized void exitTunnel(String name) {
        this.occupiedPermits--;
        System.out.println(name + " has exited the tunnel.");
        this.notifyAll();
    }
    @Override
    public int getOccupiedPermits() {
        return this.occupiedPermits;
    }
}