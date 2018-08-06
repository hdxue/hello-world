package jusfoun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.classification.InterfaceAudience.Private;

public class Test {

	String string = "good";
	char[] ch = { 'a', 'b', 'c' };

	public static void main(String[] args) {
		Test test = new Test();
		test.charge(test.string, test.ch);

		System.out.println(test.string);
		System.out.println(test.ch);
	}

	public void charge(String str, char[] ch) {
		str = "test";
		ch[0] = 'g';

		new Thread(new Runnable() {

			@Override
			public void run() {
				aaa();
			}
		}).start();
	}

	void aaa() {
		System.out.println("aaaaa");
	}
}
