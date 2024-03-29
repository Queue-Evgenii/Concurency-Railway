import org.junit.Assert;
import org.junit.Test;
import ua.nure.RailwayTunnelBySemaphore;
import ua.nure.RailwayTunnelBySync;

public class RailwayTunnelBySemaphoreTest {
    @Test
    public void testEnterAndExitTunnel() throws InterruptedException {
        RailwayTunnelBySemaphore tunnel = new RailwayTunnelBySemaphore(2);

        Assert.assertEquals(0, tunnel.getOccupiedPermits());

        tunnel.enterTunnel("Train 1");
        Assert.assertEquals(1, tunnel.getOccupiedPermits());

        tunnel.exitTunnel("Train 1");
        Assert.assertEquals(0, tunnel.getOccupiedPermits());
    }

    @Test
    public void testMultipleTrains() throws InterruptedException {
        RailwayTunnelBySemaphore tunnel = new RailwayTunnelBySemaphore(2);

        tunnel.enterTunnel("Train 1");
        tunnel.enterTunnel("Train 2");
        Assert.assertEquals(2, tunnel.getOccupiedPermits());

        new Thread(() -> {
            try {
                tunnel.enterTunnel("Train 3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(1000);
        Assert.assertEquals(2, tunnel.getOccupiedPermits());
    }
}
