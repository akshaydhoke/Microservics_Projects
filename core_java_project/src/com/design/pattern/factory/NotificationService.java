package com.design.pattern.factory;

public class NotificationService {
	public static void main(String[] args) {

		NotificationFactory notificatioService = new NotificationFactory();
		NotificationSender notification = notificatioService.createNotificationInstance("WA");
		notification.notifyUser();

	}
}
