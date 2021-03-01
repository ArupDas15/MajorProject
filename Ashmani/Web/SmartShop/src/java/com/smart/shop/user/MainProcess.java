package com.smart.shop.user;

import com.block.config.UserConfig;
import java.util.HashMap;
import java.util.List;

import com.block.logic.Block;
import com.block.logic.BlockChain;
import com.block.logic.EWallet;
import com.block.logic.Transaction;
import com.block.logic.TransactionInput;
import com.block.logic.TransactionOutput;
import java.security.Security;

public class MainProcess {

    static EWallet coinbase;
    static EWallet sender;
    static EWallet reciever;
    public static Transaction genesisTrxn;

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        MyFileConfig config = new MyFileConfig();
        config.readdata();
        System.out.println("--------------------Genesis Transaction about to start-------------------");
        createGenesisBlock(config.getUsrmobile());
        
        System.out.println("--------------------First Transaction-------------------");
        doTransaction(UserConfig.prevBlock, sender, reciever, config.getCost());
        
        System.out.println("--------------------Check blockchain is valid or not-------------------");
        boolean bool = isChainValid();
        
        System.out.println("\nIs blockchain valid : " + bool);

        MyUtils.serializeBlockChain();
        System.out.println("Blockchain serialized successfully...");

        System.out.println("Blockchain deserialization started.\n ### Blockchain details will appear here :\n");
        MyUtils.deserializeBlockChain();
        System.out.println("\nBlockchain deserialized successfully... ###");
    }
    public static void createGenesisBlock(String usrmobile) {

        coinbase = MyUtils.deserializeGenesisWallet();
        sender = MyUtils.deserializeUserWallet(usrmobile);
        reciever = MyUtils.deserializeShopWallet();

        genesisTrxn = new Transaction(coinbase.getPublicKey(), sender.getPublicKey(), 1000, null);

        genesisTrxn.generateSignature(coinbase.getPrivateKey());
        genesisTrxn.trnxnId = "0";

        TransactionOutput transactionOutput = new TransactionOutput(genesisTrxn.reciepientKey,
                genesisTrxn.valueCoin, genesisTrxn.trnxnId);

        genesisTrxn.trnxn_outputs.add(transactionOutput);

        BlockChain.UTXOs.put(genesisTrxn.trnxn_outputs.get(0).id, genesisTrxn.trnxn_outputs.get(0));

        MyUtils.serializeUserWallet(sender, usrmobile);

        System.out.println("Creating Genesis block... ");
        Block genesisBlock = new Block("0");
        genesisBlock.addTransaction(genesisTrxn);
        BlockChain.addBlock(genesisBlock);
        System.out.println("Genesis Block is created...");
        UserConfig.prevBlock = genesisBlock;
        
        doTransaction(UserConfig.prevBlock, MyUtils.deserializeUserWallet(usrmobile), MyUtils.deserializeShopWallet(), 100);

    }

    public static double getUserWalletBalance() {
        return sender.getWalletBalance();
    }

    public static void doTransaction(Block prevBlock, EWallet sender, EWallet reciever, double valueCoin) {
        
        System.out.println("---------Geneshis Hash " + prevBlock.hash);
        Block nextBlock = new Block(prevBlock.hash);
        System.out.println("\nSender Wallet's balance is: " + sender.getWalletBalance());
        System.out.println("\nSender is trying to send funds " + valueCoin + " coin to Reciever...");
        nextBlock.addTransaction(sender.sendFunds(reciever.getPublicKey(), valueCoin));
        BlockChain.addBlock(nextBlock);
        System.out.println("\nSender Wallet's balance is: " + sender.getWalletBalance());
        System.out.println("Reciever's balance is: " + reciever.getWalletBalance());

        UserConfig.prevBlock = nextBlock;
    }

    public static Boolean isChainValid() {

        Block current_block;
        Block previous_block;
        List<Block> blockList;

        blockList = BlockChain.blockchain;

        HashMap<String, TransactionOutput> tempUTXOs = new HashMap<>();

        tempUTXOs.put(genesisTrxn.trnxn_outputs.get(0).id, genesisTrxn.trnxn_outputs.get(0));

        for (int i = 1; i < blockList.size(); i++) {

            current_block = blockList.get(i);
            previous_block = blockList.get(i - 1);

            if (!current_block.hash.equals(current_block.calculateNewHashValue())) {
                System.out.println("#Current Hashes not equal");
                return false;
            }

            if (!previous_block.hash.equals(current_block.previousHash)) {
                System.out.println("#Previous Hashes not equal");
                return false;
            }

            TransactionOutput tempOutput;
            for (int t = 0; t < current_block.transactions.size(); t++) {
                Transaction currTrnxn = current_block.transactions.get(t);

                if (!currTrnxn.verifySignature()) {
                    System.out.println("#Signature on Transaction(" + t + ") is Invalid");
                    return false;
                }
                if (currTrnxn.getInputsValue() != currTrnxn.getOutputsValue()) {
                    System.out.println("#Inputs are note equal to outputs on Transaction(" + t + ")");
                    return false;
                }

                for (TransactionInput input : currTrnxn.trnxn_inputs) {
                    tempOutput = tempUTXOs.get(input.transactionOutputId);

                    if (tempOutput == null) {
                        System.out.println("#Referenced input on Transaction(" + t + ") is Missing");
                        return false;
                    }

                    if (input.UTXO.valueCoin != tempOutput.valueCoin) {
                        System.out.println("#Referenced input Transaction(" + t + ") value is Invalid");
                        return false;
                    }

                    tempUTXOs.remove(input.transactionOutputId);
                }

                for (TransactionOutput output : currTrnxn.trnxn_outputs) {
                    tempUTXOs.put(output.id, output);
                }

                if (currTrnxn.trnxn_outputs.get(0).reciepientKey != currTrnxn.reciepientKey) {
                    System.out.println("#Transaction(" + t + ") output reciepient is not who it should be");
                    return false;
                }
                if (currTrnxn.trnxn_outputs.get(1).reciepientKey != currTrnxn.senderKey) {
                    System.out.println("#Transaction(" + t + ") output 'change' is not sender.");
                    return false;
                }

            }

        }
        return true;
    }

}
