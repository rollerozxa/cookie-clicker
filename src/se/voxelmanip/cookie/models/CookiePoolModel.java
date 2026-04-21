package se.voxelmanip.cookie.models;

import se.voxelmanip.cookie.interfaces.ResourcePoolInterface;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Model for an atomic cookie pool which can be safely modified by multiple threads.
 * @author ROllerozxa
 */
public class CookiePoolModel implements ResourcePoolInterface {
    private final AtomicLong cookies;
    private final AtomicLong cookiesAllTime;

    /**
     * Constructor method taking arguments for initial values of the cookie pool
     * @param initialCookies Initial cookie amount
     * @param initialCookiesAllTime Initial cookie all time amount
     */
    public CookiePoolModel(long initialCookies, long initialCookiesAllTime) {
        this.cookies = new AtomicLong(initialCookies);
        this.cookiesAllTime = new AtomicLong(initialCookiesAllTime);
    }

    /**
     * Constructor method taking no arguments, initialising the cookie pool to zero.
     */
    public CookiePoolModel() {
        this.cookies = new AtomicLong();
        this.cookiesAllTime = new AtomicLong();
    }

    /**
     * Get current amount of cookies
     * @return Current amount of cookies
     */
    public long get() {
        return cookies.get();
    }

    /**
     * Get all time amount of cookies, i.e. an accumulated total of cookies
     * @return All time amount of cookies
     */
    public long getAllTime() {
        return cookiesAllTime.get();
    }

    /**
     * Add one cookie
     */
    public void increment() {
        add(1);
    }

    /**
     * Remove one cookie
     */
    public void decrement() {
        remove(1);
    }

    /**
     * Add an arbitrary amount of cookies
     * @param value Amount to add
     */
    public void add(long value) {
        cookies.addAndGet(value);
        cookiesAllTime.addAndGet(value);
    }

    /**
     * Remove an arbitrary amount of cookies
     * @param value Amount to remove
     */
    public void remove(long value) {
        cookies.addAndGet(-value);
    }
}
