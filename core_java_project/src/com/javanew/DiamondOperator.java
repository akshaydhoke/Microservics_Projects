package com.javanew;

public class DiamondOperator {

	public abstract static class StringAppender<T> {
		public abstract T append(String a, String b);
	}

	StringAppender<String> appender = new StringAppender<String>() {

		@Override
		public String append(String a, String b) {
			return new StringBuilder().append(a).append("-").append(b).toString();
		}

	};

}
