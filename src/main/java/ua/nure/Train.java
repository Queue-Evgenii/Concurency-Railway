package ua.nure;

public class Train implements Runnable {
    private final String name;
    private final RailwayTunnel tunnel;
    private final long time;

    public Train(String name, RailwayTunnel tunnel, long time) {
        this.name = name;
        this.tunnel = tunnel;
        this.time = time;
    }

    @Override
    public void run() {
        System.out.println(this.name + " is waiting in line.");
        try {
            this.tunnel.enterTunnel(this.name);
            Thread.sleep(this.time);
            this.tunnel.exitTunnel(this.name);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


