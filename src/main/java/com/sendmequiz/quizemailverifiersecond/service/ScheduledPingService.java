package com.sendmequiz.quizemailverifiersecond.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * PingService exists to ping google.com every 15 mins to keep Heroku instance from
 * putting it in sleeping mode.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ScheduledPingService {

    private final PingSender sender;

    //    cron expression = 0 0/15 0-2,5-23 15-31 * ?
    //    every 15 min, from 0 to 2 o'clock and from 5 to 23, from 15st to 31st day of every month
    @Scheduled(cron = "0 0/15 0-2,5-23 15-31 * ?", zone = "Europe/Moscow")
    public void ping() {
        log.info("Ping is working...");
        sender.google();
    }
}