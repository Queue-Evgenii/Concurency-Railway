package ua.nure;

public abstract class RailwayTunnel {
    protected int permits = 0;
    public abstract void enterTunnel(String name) throws InterruptedException;
    public abstract void exitTunnel(String name);
    public abstract int getOccupiedPermits();
}
