package com.berryjam.alibaba;

import com.google.common.collect.Lists;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

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
        int offset = data.length / 3;
        byte[][] blocks = new byte[3][];
        for (int i = 0; i < 3; i++) {
            blocks[i] = Arrays.copyOfRange(data, i * offset, (i + 1) * offset - 1);
        }
        NameNode nameNode = new NameNode();
        nameNode.saveFile(savedFilePath);
        DataNode dataNode = new DataNode();
        Map<String, List<Integer>> fileBlocks = nameNode.getFileBlocks();
        Map<Integer, List<String>> blockPathMap = nameNode.getBlockPathMap();
        List<Integer> blockIds = fileBlocks.get(savedFilePath);
        for (Integer blockId : blockIds) {
            List<String> blockPaths = blockPathMap.get(blockId);
            for (String path : blockPaths) {
                dataNode.saveFile(blocks[blockId % 3], path);
            }
        }
    }


    /**
     * 读文件
     *
     * @param filePath 要读取的文件路径
     * @return
     */
    public byte[] readFile(String filePath) {
        //TODO
        return null;
    }

    public static void main(String[] args) throws FileNotFoundException {
        HdfsSystem app = new HdfsSystem();
        String filePath = "";
        app.saveFile(filePath, null);
        byte[] contents = app.readFile(filePath);
    }

    static class NameNode {
        AtomicInteger curBlockId = new AtomicInteger(0);

        Map<String, List<Integer>> fileBlocks = new HashMap<String, List<Integer>>(); // 记录文件包含的块ID
        Map<Integer, List<String>> blockPathMap = new HashMap<Integer, List<String>>(); // 存储每个文件块对应的节点地址

        public void saveFile(String savedFilePath) {
            int block1 = curBlockId.getAndIncrement();
            int block2 = curBlockId.getAndIncrement();
            int block3 = curBlockId.getAndIncrement();

            fileBlocks.put(savedFilePath, Lists.newArrayList(block1, block2, block3));

            String nodeAPath = "./nodeA/" + savedFilePath;
            String nodeBPath = "./nodeB/" + savedFilePath;
            String nodeCPath = "./nodeC/" + savedFilePath;

            blockPathMap.put(block1, Lists.newArrayList(nodeAPath, nodeCPath));
            blockPathMap.put(block2, Lists.newArrayList(nodeAPath, nodeBPath));
            blockPathMap.put(block3, Lists.newArrayList(nodeBPath, nodeCPath));
        }

        public Map<String, List<Integer>> getFileBlocks() {
            return fileBlocks;
        }

        public Map<Integer, List<String>> getBlockPathMap() {
            return blockPathMap;
        }
    }

    static class DataNode {

        public void saveFile(byte[] blockContents, String blockPath) {
            BufferedOutputStream bos = null;
            try {
                bos = new BufferedOutputStream(new FileOutputStream(new File(blockPath)));
                bos.write(blockContents, 0, blockContents.length);
                bos.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (bos != null) {
                    try {
                        bos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
