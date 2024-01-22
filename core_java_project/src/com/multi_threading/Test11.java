package com.multi_threading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

class ThreadB extends Thread {

	int total = 0;

	@Override
	public void run() {
		synchronized (this) {
			System.out.println("child thread starts calcuation");
			for (int i = 0; i < 100; i++) {
				total = total + i;
			}
			System.out.println("child thread end calcuation");
			this.notify();
		}
	}
}

public class Test11 {
	
	public static void main(String[] args) {

		ThreadB cal = new ThreadB();
		cal.start();

		synchronized (cal) {
			System.out.println("Main thread going to wait state");
			try {
				cal.wait(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Main thread Done wait state");

		}

	}

}
