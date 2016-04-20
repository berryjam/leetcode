package com.berryjam.alibaba;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 使用JDK原生API模拟HDFS
 *
 * @author huangjinkun.
 * @date 16/4/20
 * @time 下午9:02
 */
public class HdfsSystem {

    /**
     * 保存文件
     *
     * @param savedFilePath 待写入的文件路径
     * @param data          要存储的文件数据
     */
    public void saveFile(String savedFilePath, byte[] data) throws FileNotFoundException {
        int aLength = data.length / 3;
        int bLength = 2 * data.length / 3;
        File file = new File(savedFilePath);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(savedFilePath)));
        //TODO 时间不够
    }


    /**
     * 读文件
     *
     * @param filePath
     * @return
     */
    public byte[] readFile(String filePath) {
        //TODO 时间不够
        return null;
    }
}
