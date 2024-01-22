package com.collectorsmethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
//import com.auruspay.manager.acquirer.participants.wakefern.TransactionBO;

class TransactionBO {
	
	
	private String tenderId;
	private String transactionType;
	private String tenderType;
	private String token;
	private String cardExpiry;
	private String cvv;
	private String securityCode;
	private String maskedCard;
	private String amount;
	private String cardNumber;
	private String walletSubTransType;
	private String walletIdentifier;
	private String invoiceNumber;
	private String updateAmount;
	private String laneNumber;

	public TransactionBO(String tenderId, String transactionType, String tenderType, String token, String cardExpiry,
			String cvv, String securityCode, String maskedCard, String amount, String cardNumber,
			String walletSubTransType, String walletIdentifier, String invoiceNumber, String updateAmount,
			String laneNumber)
	{
		this.tenderId = tenderId;
		this.transactionType = transactionType;
		this.tenderType = tenderType;
		this.token = token;
		this.cardExpiry = cardExpiry;
		this.cvv = cvv;
		this.securityCode = securityCode;
		this.maskedCard = maskedCard;
		this.amount = amount;
		this.cardNumber = cardNumber;
		this.walletSubTransType = walletSubTransType;
		this.walletIdentifier = walletIdentifier;
		this.invoiceNumber = invoiceNumber;
		this.updateAmount = updateAmount;
		this.laneNumber = laneNumber;
	}


	public String getLaneNumber() {
		return laneNumber;
	}

	public void setLaneNumber(String laneNumber) {
		this.laneNumber = laneNumber;
	}

	public String getUpdateAmount() {
		return updateAmount;
	}

	public void setUpdateAmount(String updateAmount) {
		this.updateAmount = updateAmount;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getTenderId() {
		return tenderId;
	}

	public void setTenderId(String tenderId) {
		this.tenderId = tenderId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTenderType() {
		return tenderType;
	}

	public void setTenderType(String tenderType) {
		this.tenderType = tenderType;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getCardExpiry() {
		return cardExpiry;
	}

	public void setCardExpiry(String cardExpiry) {
		this.cardExpiry = cardExpiry;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getMaskedCard() {
		return maskedCard;
	}

	public void setMaskedCard(String maskedCard) {
		this.maskedCard = maskedCard;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getWalletSubTransType() {
		return walletSubTransType;
	}

	public void setWalletSubTransType(String walletSubTransType) {
		this.walletSubTransType = walletSubTransType;
	}

	public String getWalletIdentifier() {
		return walletIdentifier;
	}

	public void setWalletIdentifier(String walletIdentifier) {
		this.walletIdentifier = walletIdentifier;
	}

	@Override
	public String toString() {
		return "TransactionBO [tenderId=" + tenderId + ", transactionType=" + transactionType + ", tenderType="
				+ tenderType + ", maskedCard=" + maskedCard + ", amount=" + amount + ", invoiceNumber=" + invoiceNumber
				+ ", updateAmount=" + updateAmount + "]";
	}

}

class ListTest {

	public static void main(String[] args) {

		List<TransactionBO> list1 = new ArrayList<>();
		List<TransactionBO> list2 = new ArrayList<>();
		List<TransactionBO> list3 = new ArrayList<>();

		
		list1.add(new TransactionBO("", "", "28", "", "", "", "", "", "2.79", "", "", "", "", "", ""));
		list1.add(new TransactionBO("", "", "22", "", "", "", "", "", "1.79", "", "", "", "", "", ""));
		list1.add(new TransactionBO("", "", "21", "", "", "", "", "", "3.79", "", "", "", "", "", ""));
		list1.add(new TransactionBO("", "", "9", "", "", "", "", "", "0.21", "", "", "", "", "", ""));

		System.out.println(list1.size());
		

		/*
		 * for(int i =list1.size()-1; i>=0;i--) { list2.add(list1.get(i)); }
		 */
		
		for (TransactionBO transactionBO : list1) {
			if (Arrays.asList("21","22","9","28").contains(transactionBO.getTenderType())) {
				list3.add(transactionBO);
			}
		}

		for (TransactionBO transactionBO : list1) {
			if (StringUtils.equals("21", transactionBO.getTenderType())) {
				list2.add(transactionBO);
			}
		}

		for (TransactionBO transactionBO : list1) {
			if (StringUtils.equals("22", transactionBO.getTenderType())) {
				list2.add(transactionBO);
			}
		}

		for (TransactionBO transactionBO : list1) {
			if (StringUtils.equals("9", transactionBO.getTenderType())) {
				list2.add(transactionBO);
			}
		}

		for (TransactionBO transactionBO : list1) {
			if (StringUtils.equals("28", transactionBO.getTenderType())) {
				list2.add(transactionBO);
			}
		}

		System.out.println(">>>"+list3);
		
		
		System.out.println(list2);


		/*
		 * System.out.println(list1.get(1)); System.out.println(list1.get(0));
		 * 
		 * list2.add(list1.get(1)); list2.add(list1.get(0));
		 * 
		 * 
		 * System.out.println(list1); System.out.println(list2);
		 * 
		 */

	}

}
