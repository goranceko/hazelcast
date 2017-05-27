package com.gceko.hazelcast;

import java.util.concurrent.TimeUnit;

/**
 * Created by anonymous on 5/27/17.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        BigWideWorld theWorld = new BigWideWorld();
        MyApplication application = new MyApplication();

        while (true) {
            String username = theWorld.nextUser();
            if (application.isLoggedOn(username)) {
                application.logout(username);
            } else {
                application.logon(username);
            }
            application.displayUsers();
            TimeUnit.SECONDS.sleep(2);
        }
    }

}
