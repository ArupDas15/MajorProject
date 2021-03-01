package com.block.logic;

import java.util.ArrayList;
import java.util.Date;


public class Block {

	public String hash;
	public String previousHash;
	public ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	public long timeStamp;

	public Block(String previousHash) {
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.hash = calculateNewHashValue();
	}

	@Override
	public String toString() {
		return "Block [hash=" + hash + ", previousHash=" + previousHash + ", transactions=" + transactions
				+ ", timeStamp=" + timeStamp + "]";
	}

	public String calculateNewHashValue() {
		String calculatedhashvalue = StringUtils
				.generateHashUsingSHA256(previousHash + Long.toString(timeStamp));
		return calculatedhashvalue;
	}

	

	public boolean addTransaction(Transaction transaction) {
		if (transaction == null)
			return false;
		if ((!"0".equals(previousHash))) {
			if ((transaction.processTransaction() != true)) {
				System.out.println("Transaction failed / Something went wrong...");
				return false;
			}
		}

		transactions.add(transaction);
		System.out.println("Transaction Successfully added to Block");
		return true;
	}


}
