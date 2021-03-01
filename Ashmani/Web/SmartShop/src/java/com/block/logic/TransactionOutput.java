package com.block.logic;

import java.security.PublicKey;

public class TransactionOutput {
	public String id;
	public PublicKey reciepientKey;
	public double valueCoin;
	public String parentTransactionId;

	public TransactionOutput(PublicKey reciepientKey, double valueCoin, String parentTransactionId) {
		this.reciepientKey = reciepientKey;
		this.valueCoin = valueCoin;
		this.parentTransactionId = parentTransactionId;
		this.id = StringUtils
				.generateHashUsingSHA256(StringUtils.getStringFromKey(reciepientKey) + Double.toString(valueCoin) + parentTransactionId);
	}

	public boolean isCoinMine(PublicKey publicKey) {
		return (publicKey == reciepientKey);
	}

}
