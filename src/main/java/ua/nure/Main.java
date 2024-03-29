package ua.nure;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        RailwayTunnel tunnel = new RailwayTunnelBySemaphore(2);
        Random rand = new Random();
        long lowerBound = 500L, upperBound = 2000L, randomLong;
        int trainsAmount = 10;

        for (int i = 0; i < trainsAmount; ++i) {
            randomLong = lowerBound + ((long) (rand.nextDouble() * (upperBound - lowerBound)));
            new Thread(new Train("Train " + i, tunnel, randomLong)).start();
        }
    }
}