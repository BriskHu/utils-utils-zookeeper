package com.briskhu.utils.zookeeper.api;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;

/**
 * Zookeeper 常用工具<p/>
 *
 * @author Brisk Hu
 * created on 2019-01-18
 **/
public interface IZookeeperUtils {


    /**
     * 删除非空节点
     * @param nodeName
     * @return
     */
    boolean delNotEmptyNode(String nodeName) throws IOException, KeeperException, InterruptedException;

}
