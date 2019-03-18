package com.briskhu.utils.zookeeper.service;

import com.briskhu.utils.zookeeper.api.IZookeeperUtils;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * Zookeeper 常用工具<p/>
 *
 * @author Brisk Hu
 * created on 2019-01-12
 **/
public class ZookeeperUtils implements IZookeeperUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(ZookeeperUtils.class);


    /* ---------------------------------------- fileds ---------------------------------------- */
    private static final String connectString = "localhost:2181";

    private static final int sessionTimeout = 50000;

    private static ZooKeeper zookeeper = null;


    /* ---------------------------------------- methods ---------------------------------------- */

    /**
     * 删除非空节点
     *
     * @param nodeName
     * @return
     */
    public boolean delNotEmptyNode(String nodeName) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zk = getZookeeper();
        //获取路径下的节点
        List<String> children = zk.getChildren(nodeName, false);
        for (String pathCd : children) {
            //获取父节点下面的子节点路径
            String newPath = "";
            //递归调用,判断是否是根节点
            if (nodeName.equals("/")) {
                newPath = "/" + pathCd;
            } else {
                newPath = nodeName + "/" + pathCd;
            }
            delNotEmptyNode(newPath);
        }
        //删除节点,并过滤zookeeper节点和 /节点
        if (nodeName != null && !nodeName.trim().startsWith("/zookeeper") && !nodeName.trim().equals("/")) {
            zk.delete(nodeName, -1);
            //打印删除的节点路径
            System.out.println("被删除的节点为：" + nodeName);
        }


        return false;
    }

    /**
     * 获取Zookeeper实例
     *
     * @return
     * @throws IOException
     */
    public static ZooKeeper getZookeeper() throws IOException {
        zookeeper = new ZooKeeper(connectString, sessionTimeout, new MyWatch());
        return zookeeper;
    }

}


