package com.akshay.rateLimit;

public class TokenBucketAlgorithm {
    private final long refillRate;
    private final long maxBucketSize;

    private double currentBucketSize;
    private long lastRefillTimeStamp;


    public TokenBucketAlgorithm(long refillRate, long maxBucketSize) {
        this.refillRate = refillRate;
        this.maxBucketSize = maxBucketSize;

        currentBucketSize = maxBucketSize;
        lastRefillTimeStamp = System.nanoTime();
    }

    public synchronized boolean allowRequest(int tokens) {
        refill();
        if(currentBucketSize > tokens) {
            currentBucketSize = currentBucketSize - tokens;
            return true;
        }
        return false;
    }

    private void refill() {
        long now = System.nanoTime();
        double needToAdd = (now - lastRefillTimeStamp) * refillRate/1e9;
        currentBucketSize = Math.min(currentBucketSize + needToAdd, maxBucketSize);
        lastRefillTimeStamp = now;
    }

    @Override
    public String toString() {
        return "TokenBucketAlgorithm {" +
                "refillRate=" + refillRate +
                ", maxBucketSize=" + maxBucketSize +
                ", currentBucketSize=" + currentBucketSize +
                ", lastRefillTimeStamp=" + lastRefillTimeStamp +
                '}';
    }

    public static void main(String[] args) {
        TokenBucketAlgorithm tokenBucketAlgorithm = new TokenBucketAlgorithm(50l, 1000);
        System.out.println(tokenBucketAlgorithm);

        System.out.println(tokenBucketAlgorithm.allowRequest(100));
        System.out.println(tokenBucketAlgorithm);

        System.out.println(tokenBucketAlgorithm.allowRequest(200));
        System.out.println(tokenBucketAlgorithm);

        System.out.println(tokenBucketAlgorithm.allowRequest(300));
        System.out.println(tokenBucketAlgorithm);

        System.out.println(tokenBucketAlgorithm.allowRequest(700));
        System.out.println(tokenBucketAlgorithm);

        System.out.println(tokenBucketAlgorithm.allowRequest(20000));
        System.out.println(tokenBucketAlgorithm);

        System.out.println(tokenBucketAlgorithm.allowRequest(700));
        System.out.println(tokenBucketAlgorithm);

        System.out.println(tokenBucketAlgorithm.allowRequest(100));
        System.out.println(tokenBucketAlgorithm);

        System.out.println(tokenBucketAlgorithm.allowRequest(100));
        System.out.println(tokenBucketAlgorithm);

        System.out.println(tokenBucketAlgorithm.allowRequest(100));
        System.out.println(tokenBucketAlgorithm);

        System.out.println(tokenBucketAlgorithm.allowRequest(100));
        System.out.println(tokenBucketAlgorithm);

        System.out.println(tokenBucketAlgorithm.allowRequest(100));
        System.out.println(tokenBucketAlgorithm);

        System.out.println(tokenBucketAlgorithm.allowRequest(10));
        System.out.println(tokenBucketAlgorithm);
    }
}
