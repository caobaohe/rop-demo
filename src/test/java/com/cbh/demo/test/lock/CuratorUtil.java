package com.cbh.demo.test.lock;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * https://my.oschina.net/52love/blog/1921097
 * 基于curator的zookeeper分布式锁
 */
public class CuratorUtil {
    private static String address = "119.29.178.37:2181";

    public static void main(String[] args) {
        //1、重试策略：初试时间为1s 重试3次
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        //2、通过工厂创建连接
        CuratorFramework client = CuratorFrameworkFactory.newClient(address, retryPolicy);
        //3、开启连接
        client.start();
        //4 分布式锁
        final InterProcessMutex mutex = new InterProcessMutex(client, "/curator/lock");
        //读写锁
        //InterProcessReadWriteLock readWriteLock = new InterProcessReadWriteLock(client, "/readwriter");

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            fixedThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    boolean flag = false;
                    try {
                        //尝试获取锁，最多等待5秒
                        flag = mutex.acquire(5, TimeUnit.SECONDS);
                        Thread currentThread = Thread.currentThread();
                        System.out.println(flag);
                        if (flag) {
                            System.out.println("线程" + currentThread.getId() + "获取锁成功");
                        } else {
                            System.out.println("线程" + currentThread.getId() + "获取锁失败");
                        }
                        //模拟业务逻辑，延时4秒
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        if (flag) {
                            try {
                                mutex.release();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });
        }
    }
}