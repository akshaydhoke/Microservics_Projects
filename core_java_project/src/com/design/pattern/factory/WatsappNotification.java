package com.design.pattern.factory;

public class WatsappNotification implements NotificationSender {

	@Override
	public void notifyUser() {
		System.out.println("Message sending throw Whatsapp");
	}

}
