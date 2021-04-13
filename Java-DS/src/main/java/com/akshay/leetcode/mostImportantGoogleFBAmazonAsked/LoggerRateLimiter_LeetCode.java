package com.akshay.leetcode.mostImportantGoogleFBAmazonAsked;

import java.util.HashMap;
import java.util.Map;

/****
 *
 * https://tenderleo.gitbooks.io/leetcode-solutions-/content/GoogleEasy/359.html
 *
 * Design a logger system that receive stream of messages along with its timestamps, each message should be printed if and only if it is not printed in the last 10 seconds.
 *
 * Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, otherwise returns false.
 *
 * It is possible that several messages arrive roughly at the same time.
 *
 *
 * Logger logger = new Logger();
 *
 * // logging string "foo" at timestamp 1
 * logger.shouldPrintMessage(1, "foo"); returns true;
 *
 * // logging string "bar" at timestamp 2
 * logger.shouldPrintMessage(2,"bar"); returns true;
 *
 * // logging string "foo" at timestamp 3
 * logger.shouldPrintMessage(3,"foo"); returns false;
 *
 * // logging string "bar" at timestamp 8
 * logger.shouldPrintMessage(8,"bar"); returns false;
 *
 * // logging string "foo" at timestamp 10
 * logger.shouldPrintMessage(10,"foo"); returns false;
 *
 * // logging string "foo" at timestamp 11
 * logger.shouldPrintMessage(11,"foo"); returns true;
 *
 * ****/
public class LoggerRateLimiter_LeetCode {
    public Map<String, Integer> cache = null;
    public static int MAX_CACHE_TIME_STAMP = 10;
    public LoggerRateLimiter_LeetCode() {
        cache = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timeStamp, String message) {
        if(cache.containsKey(message)) {
            Integer oldTimeStamp = cache.get(message);
            if(timeStamp - oldTimeStamp >= MAX_CACHE_TIME_STAMP) {
                cache.put(message, timeStamp);
                return true;
            } else {
                return false;
            }
        } else {
            cache.put(message, timeStamp);
            return true;
        }
    }

    public static void main(String[] args) {
        LoggerRateLimiter_LeetCode logger = new LoggerRateLimiter_LeetCode();

        System.out.println(logger.shouldPrintMessage(1, "foo"));
        System.out.println(logger.shouldPrintMessage(2,"bar"));
        System.out.println(logger.shouldPrintMessage(3,"foo"));
        System.out.println(logger.shouldPrintMessage(8,"bar"));
        System.out.println(logger.shouldPrintMessage(10,"foo"));
        System.out.println(logger.shouldPrintMessage(11,"foo"));
    }
}
