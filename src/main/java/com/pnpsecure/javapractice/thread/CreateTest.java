package com.pnpsecure.javapractice.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Slf4j
@Component
public class CreateTest {
    public static Runnable runnable = () -> {
        log.info("Hello World.");
    };

    public static void startWithThread() {
        List<Thread> threads = IntStream.range(0, 1_000_000)
            .mapToObj(i -> new Thread(runnable))
            .toList();

        threads.forEach(Thread::start);
    }

    /**
     * HELLO
     *
     * @param args
     *  hello
     */
    public static void main(String[] args) {
        startWithVirtualThread();
    }

    public static void startWithVirtualThread() {
        List<Thread> threads = IntStream.range(0, 1_000_000)
            .mapToObj(i -> Thread.ofVirtual().unstarted(runnable))
            .toList();

        threads.forEach(Thread::start);
    }
}
