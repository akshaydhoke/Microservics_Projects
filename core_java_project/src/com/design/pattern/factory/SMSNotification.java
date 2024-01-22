package com.design.pattern.factory;

public class SMSNotification implements NotificationSender {

	@Override
	public void notifyUser() {
		System.out.println("Sending message throw SMS");
	}

}
