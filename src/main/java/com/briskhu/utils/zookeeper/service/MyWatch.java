package com.briskhu.utils.zookeeper.service;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p/>
 *
 * @author Brisk Hu
 * created on 2019-01-12
 **/
public class MyWatch implements Watcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyWatch.class);

    public void process(WatchedEvent watchedEvent) {

    }
}
