package haha;

import java.util.ArrayList;
import java.util.List;

public class Workers extends Person {

	public static void main(String[] args) {
		List<Workers> list = new ArrayList<Workers>();
		Person person =  new Person();
		list.add(new Worker1());
		list.add(new Worker2());
		list.add(new Workers());
	}
}
