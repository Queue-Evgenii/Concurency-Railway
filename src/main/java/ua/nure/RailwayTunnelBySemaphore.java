package ua.nure;

import java.util.concurrent.Semaphore;

public class RailwayTunnelBySemaphore extends RailwayTunnel {
    private final Semaphore semaphore;

    public RailwayTunnelBySemaphore(int permits) {
        this.semaphore = new Semaphore(permits);
        this.permits = permits;
    }

    @Override
    public void enterTunnel(String name) throws InterruptedException {
        this.semaphore.acquire();
        System.out.println(name + " is traveling through the tunnel.");
    }

    @Override
    public void exitTunnel(String name) {
        System.out.println(name + " has exited the tunnel.");
        this.semaphore.release();
    }

    @Override
    public int getOccupiedPermits() {
        return this.permits - this.semaphore.availablePermits();
    }
}
