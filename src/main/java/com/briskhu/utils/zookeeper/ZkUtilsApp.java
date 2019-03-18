package com.briskhu.utils.zookeeper;

import com.briskhu.utils.zookeeper.service.ZookeeperUtils;
import org.apache.zookeeper.KeeperException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * <p/>
 *
 * @author Brisk Hu
 * created on 2019-01-18
 **/
public class ZkUtilsApp {
    private static final Logger LOGGER = LoggerFactory.getLogger(ZkUtilsApp.class);

    public static void main(String[] args) {
        try {
            new ZookeeperUtils().delNotEmptyNode(args[0]);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
