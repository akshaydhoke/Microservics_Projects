package com.design.pattern.factory;

// https://www.geeksforgeeks.org/factory-method-design-pattern-in-java/

public class NotificationFactory {

	NotificationSender createNotificationInstance(String channel) {

		if (channel == null || channel.isEmpty()) {
			return null;
		}

		switch (channel) {
		case "SMS":
			return new SMSNotification();
		case "EMAIL":
			return new EmailNotification();
		case "WA":
			return new WatsappNotification();
		default:
			throw new IllegalArgumentException("Unexpected channel: " + channel);
		}

	}
}
