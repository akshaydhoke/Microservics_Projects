package com.design.pattern.factory;

public class EmailNotification implements NotificationSender {

	@Override
	public void notifyUser() {
		System.out.println("Message sending throw EMAIL");
	}

}
