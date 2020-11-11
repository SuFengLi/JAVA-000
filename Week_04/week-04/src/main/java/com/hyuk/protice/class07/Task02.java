package com.hyuk.protice.class07;

import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;

/**
 * @author : Hyuk
 * @description : Task02
 * @date : 2020/11/11 6:54 下午
 */
public class Task02 {

    public static void main(String[] args) throws ExecutionException, InterruptedException, BrokenBarrierException {

        long start=System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法

        // 方法1， FutureTask
//        FutureTask<Integer> futureTask = new FutureTask<>(Task02::sum);
//        new Thread(futureTask).start();
//        int result = futureTask.get();

        // 方法2， 线程池
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        Future<Integer> future = executorService.submit(Task02::sum);
//        int result = future.get();
//        executorService.shutdown();

        // 方法3， CompletableFuture
//        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(Task02::sum);
//        int result = completableFuture.get();

        // 方法4，Thread.join
//        final int[] arr = new int[1];
//        Thread thread = new Thread(() -> arr[0] = sum());
//        thread.start();
//        thread.join();
//        int result = arr[0];

        // 方法5， CountDownLatch
//        final int[] arr = new int[1];
//        CountDownLatch countDownLatch = new CountDownLatch(1);
//        new Thread(() -> {
//            arr[0] = sum();
//            countDownLatch.countDown();
//        }).start();
//        countDownLatch.await();
//        int result = arr[0];

        // 方法6，CyclicBarrier
//        final int[] arr = new int[1];
//        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
//        new Thread(() -> {
//            arr[0] = sum();
//            try {
//                cyclicBarrier.await();
//            } catch (InterruptedException | BrokenBarrierException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        cyclicBarrier.await();
//        int result = arr[0];

        // 方法7， LockSupport.park() unpark()
        Task task = new Task(Thread.currentThread());
        new Thread(task).start();
        LockSupport.park();
        int result = task.arr[0];

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }

    static class Task implements Runnable {

        int[] arr;
        Thread thread;

        Task(Thread thread) {
            arr = new int[1];
            this.thread = thread;
        }

        @Override
        public void run() {
            arr[0] = sum();
            LockSupport.unpark(thread);
        }
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}
