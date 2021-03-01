package com.block.logic;

import com.smart.shop.dblogic.AdminDao;
import java.security.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Transaction {

    public final static double minTrnxn = 0.1;
    public String trnxnId;
    public PublicKey senderKey;
    public PublicKey reciepientKey;
    public double valueCoin;
    public List<TransactionInput> trnxn_inputs = new ArrayList<>();
    public List<TransactionOutput> trnxn_outputs = new ArrayList<>();

    public byte[] signature;

    private static int sequence = 0;
    
    public static String myretval = "";

    public Transaction(){
        
    }
    public Transaction(PublicKey from, PublicKey to, double value, List<TransactionInput> inputs) {
        this.senderKey = from;
        this.reciepientKey = to;
        this.valueCoin = value;
        this.trnxn_inputs = inputs;
    }

    @Override
    public String toString() {
        return "Transaction [transactionId=" + trnxnId + ", sender=" + senderKey + ", reciepient=" + reciepientKey
                + ", value=" + valueCoin + ", signature=" + Arrays.toString(signature) + ", inputs=" + trnxn_inputs
                + ", outputs=" + trnxn_outputs + "]";
    }

    public boolean processTransaction() {

        if (verifySignature() == false) {
            System.out.println(" !!!! Transaction Signature failed to verify");
            return false;
        }

        for (TransactionInput i : trnxn_inputs) {
            i.UTXO = BlockChain.UTXOs.get(i.transactionOutputId);
        }

        if (getInputsValue() < minTrnxn) {
            System.out.println("Transaction Inputs are too small: " + getInputsValue());
            System.out.println("Please enter the amount greater than " + minTrnxn);
            return false;
        }

        double leftBalance = getInputsValue() - valueCoin;
        trnxnId = calulateHash();
        trnxn_outputs.add(new TransactionOutput(this.reciepientKey, valueCoin, trnxnId));
        trnxn_outputs.add(new TransactionOutput(this.senderKey, leftBalance, trnxnId));

        trnxn_outputs.forEach((o) -> {
            BlockChain.UTXOs.put(o.id, o);
        });

        trnxn_inputs.stream().filter((i) -> !(i.UTXO == null)).forEachOrdered((i) -> {
            BlockChain.UTXOs.remove(i.UTXO.id);
        });
        
        myretval = trnxnId +"-"+valueCoin;
        int status = new AdminDao().insertTransactionDetails(trnxnId, valueCoin);
        System.out.println("status = " + status);
        return true;
    }
    

    public float getInputsValue() {
        float total = 0;
        for (TransactionInput inp : trnxn_inputs) {
            if (inp.UTXO == null) {
                continue;
            }
            total += inp.UTXO.valueCoin;
        }
        return total;
    }

    public void generateSignature(PrivateKey privateKey) {
        String data = StringUtils.getStringFromKey(senderKey) + StringUtils.getStringFromKey(reciepientKey)
                + Double.toString(valueCoin);
        signature = StringUtils.applyDigitalSignature(privateKey, data);
    }

    public boolean verifySignature() {
        String data = StringUtils.getStringFromKey(senderKey) + StringUtils.getStringFromKey(reciepientKey)
                + Double.toString(valueCoin);
        return StringUtils.verifySignature(senderKey, data, signature);
    }

    public float getOutputsValue() {
        float total = 0;
        for (TransactionOutput out : trnxn_outputs) {
            total += out.valueCoin;
        }
        return total;
    }

    private String calulateHash() {
        sequence++;
        return StringUtils.generateHashUsingSHA256(StringUtils.getStringFromKey(senderKey)
                + StringUtils.getStringFromKey(reciepientKey) + Double.toString(valueCoin) + sequence);
    }
}
