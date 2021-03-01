package com.block.logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BlockChain implements Serializable {

    public static List<Block> blockchain = new ArrayList<>();
    public static HashMap<String, TransactionOutput> UTXOs = new HashMap<>();

    public static void addBlock(Block newBlock) {
        blockchain.add(newBlock);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("blockchain :")
                .append(BlockChain.blockchain).append("UTXOs :")
                .append(BlockChain.UTXOs);
        return sb.toString();
    }

}
