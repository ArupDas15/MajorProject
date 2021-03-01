package com.block.logic;

import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.block.config.Global;
import java.io.Serializable;
import org.bouncycastle.jce.provider.BouncyCastleProvider;


public final class EWallet implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;
    private PrivateKey privateKey;
    private PublicKey publicKey;

    private final HashMap<String, TransactionOutput> unspentTxnOutputs = new HashMap<>();

    public EWallet(String email) {
        this.userId = email;
        generateKeyPair();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public void generateKeyPair() {
        Security.addProvider(new BouncyCastleProvider());
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance(Global.DEFAULT_KEY_GEN_ALGORITHM);
            SecureRandom prng = SecureRandom.getInstance(Global.DEFAULT_PSEUDO_RANDOM_GEN_ALGO);

            generator.initialize(new ECGenParameterSpec(Global.DEFAULT_NAMED_CURVE), prng);
            KeyPair keyPair = generator.generateKeyPair();
            setPrivateKey(keyPair.getPrivate());
            setPublicKey(keyPair.getPublic());

        } catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public double getWalletBalance() {
        double total = 0;
        for (Map.Entry<String, TransactionOutput> item : BlockChain.UTXOs.entrySet()) {
            TransactionOutput unspentTxnOutput = item.getValue();
            if (unspentTxnOutput.isCoinMine(getPublicKey())) {
                unspentTxnOutputs.put(unspentTxnOutput.id, unspentTxnOutput);
                total += unspentTxnOutput.valueCoin;
            }
        }
        return total;
    }

    public Transaction sendFunds(PublicKey recipientKey, double value) {
        if (getWalletBalance() < value) {
            System.out.println(" !!! Due to insufficient balance your transaction Cancelled.");
            return null;
        }
        List<TransactionInput> inputs = new ArrayList<>();

        float total = 0;
        for (Map.Entry<String, TransactionOutput> item : unspentTxnOutputs.entrySet()) {
            TransactionOutput UTXO = item.getValue();
            total += UTXO.valueCoin;

            TransactionInput transactionInput = new TransactionInput(UTXO.id);

            inputs.add(transactionInput);
            if (total > value) {
                break;
            }
        }

        Transaction newTransaction = new Transaction(publicKey, recipientKey, value, inputs);

        newTransaction.generateSignature(getPrivateKey());

        inputs.forEach((input) -> {
            unspentTxnOutputs.remove(input.transactionOutputId);
        });

        return newTransaction;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    @Override
    public String toString() {
        return new StringBuffer("userId :")
                .append(this.userId).append(" privateKey : ")
                .append(this.privateKey).append(" publicKey : ")
                .append(this.publicKey).append(" unspentTxnOutputs : ")
                .append(this.unspentTxnOutputs).toString();
    }

}
