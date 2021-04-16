package practice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class RateLimitProcessor {

    static Integer MAX_REQUEST = 5;
    static Long MAX_EXPIRY_TIME = 2000l;
    private final Map<Integer, Queue<Long>> custReqCache;

    public RateLimitProcessor() {
        this.custReqCache = new HashMap<>();
    }

    boolean rateLimit(int customerId) {

        Long timeStamp = System.currentTimeMillis();
        if(custReqCache.containsKey(customerId)) {
            Queue<Long> timeStamps = custReqCache.get(customerId);
            while(!timeStamps.isEmpty() && timeStamp - timeStamps.peek() >= MAX_EXPIRY_TIME) {
                timeStamps.poll();
            }
            if(timeStamps.size() >= MAX_REQUEST) {
                return false;
            } else {
                timeStamps.add(timeStamp);
                return true;
            }
        } else {
            Queue<Long> timeStamps = new LinkedList<>();
            timeStamps.add(timeStamp);
            custReqCache.put(customerId, timeStamps);
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello");
        RateLimitProcessor rateLimitProcessor = new RateLimitProcessor();
        System.out.println(rateLimitProcessor.rateLimit(1));
        System.out.println(rateLimitProcessor.rateLimit(2));
        System.out.println(rateLimitProcessor.rateLimit(3));
        System.out.println(rateLimitProcessor.rateLimit(4));
        System.out.println(rateLimitProcessor.rateLimit(5));
        System.out.println(rateLimitProcessor.rateLimit(1));
        System.out.println(rateLimitProcessor.rateLimit(1));
        System.out.println(rateLimitProcessor.rateLimit(1));
        System.out.println(rateLimitProcessor.rateLimit(1));

        try {
            Thread.sleep(2000l);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println(rateLimitProcessor.rateLimit(1));
        System.out.println(rateLimitProcessor.rateLimit(1));
        System.out.println(rateLimitProcessor.rateLimit(1));
        System.out.println(rateLimitProcessor.rateLimit(1));
        System.out.println(rateLimitProcessor.rateLimit(1));

    }
}
