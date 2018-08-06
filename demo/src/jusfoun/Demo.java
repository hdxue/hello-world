package jusfoun;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.mockito.internal.verification.api.VerificationData;

import com.sun.corba.se.spi.presentation.rmi.PresentationManager.StubFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Demo {

	public static void main(String[] args) throws IOException {
		Demo test = new Demo();

		// 八进制转十进制
		// Scanner sc = new Scanner(System.in);
		// System.out.println("请输入一个八进制的数");
		// String b =sc.nextLine();
		// int q = Integer.valueOf(b, 8);
		// System.out.println(b + "的十进制是" + q);

		// 产生随机密码
		// System.out.println(test.getStringRandom(10));

		// 读取文件并打印
		// test.readFile("e://demo.txt");

		// 冒泡排序
		// test.sort();

		// json转数组
		// JsonToArray();
		// json转Javabeen
		// JsonToBean();

		// n个人站一圈报数
		// baoshu();

		// 字符串转驼峰式
		//stringFomat("user_name_password");

		// 去除集合中重复对象
		//user();
	}

	/**
	 * 除去集合中重复的对象
	 */
	public static void user() {
		Student student1 = new Student();
		student1.setAge(11);
		student1.setHobby(new String[] { "篮球", "游戏" });
		student1.setId(0);
		student1.setName("张赛");
		student1.setSex("男");

		Student student2 = new Student();
		student2.setAge(110);
		student2.setHobby(new String[] { "降龙十八掌", "游戏" });
		student2.setId(0);
		student2.setName("乔峰");
		student2.setSex("男");

		List<Student> list = new ArrayList<Student>();
		list.add(student1);
		list.add(student2);
		list.add(student1);
		List<Student> list2 = new ArrayList<Student>();
		for (Student student : list) {
			if (!list2.contains(student)) {
				list2.add(student);
			}
		}
		System.out.println(list2.toString());
	}

	/**
	 * 字符串转成驼峰式
	 * 
	 * @param str
	 */
	public static void stringFomat(String str) {
		StringBuffer sBuffer = new StringBuffer();
		String[] arry = str.split("_");
		String string = "";

		sBuffer.append(arry[0]);
		for (int i = 1; i < arry.length; i++) {
			string = arry[i].substring(0, 1).toUpperCase() + arry[i].substring(1, arry[i].length());
			sBuffer.append(string);
		}
		System.out.println(sBuffer.toString());
	}

	// n个人站一个圈
	public static void baoshu() {
		final int n = 10;
		final int flag = 3;

		List<Integer> mans = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			mans.add(i + 1);
		}
		System.out.println("初始化编号为" + mans + "的" + mans.size() + "个人围成一圈");

		Iterator<Integer> iter = null;
		int k = 1;
		do {
			iter = mans.listIterator();
			while (iter.hasNext()) {
				int i = iter.next();
				if (k++ % flag == 0) {
					System.out.println("编号" + i + "的人退出圈子");
					iter.remove();
					k = 1;
				}
			}
		} while (mans.size() > 1);

		System.out.println("剩下编号为" + mans + "的" + mans.size() + "个人");
	}

	/*
	 * 产生随机数
	 */
	public String getStringRandom(int length) {
		String val = "";
		Random random = new Random();
		// 参数length，表示生成几位随机数
		for (int i = 0; i < length; i++) {
			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			// 输出字母还是数字
			if ("char".equalsIgnoreCase(charOrNum)) {
				// 输出是大写字母还是小写字母
				int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val += (char) (random.nextInt(26) + temp);
			} else if ("num".equalsIgnoreCase(charOrNum)) {
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}

	/*
	 * 读取磁盘文件打印
	 */
	public StringBuffer readFile(String dir) throws IOException {
		StringBuffer buffer = null;
		try {
			buffer = new StringBuffer();
			InputStream fis = new FileInputStream(dir);
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis, "GBK"));

			String line = null;// 用来保存每行读取的内容
			line = reader.readLine(); // 读取第一行
			while (line != null) { // 如果 line 为空说明读完了
				buffer.append(line); // 将读到的内容添加到 buffer 中
				buffer.append("\n"); // 添加换行符
				line = reader.readLine(); // 读取下一行
			}
			System.out.println(buffer); // 将读到 buffer 中的内容写出来
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return buffer;
	}

	/*
	 * 冒泡排序
	 */
	public void sort() {
		int a[] = { 1, 4, 3, 12, 8, 9 };
		int temp = 0;
		for (int i = a.length - 1; i > 0; --i) {
			for (int j = 0; j < i; ++j) {
				if (a[j + 1] < a[j]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		for (int j = 0; j < a.length; j++) {
			System.out.print(a[j]);
		}
	}

	/*
	 * java对象转json数组
	 */
	public static void JsonToArray() {
		Student student1 = new Student();
		student1.setId(1);
		student1.setName("李白");
		student1.setSex("男");
		student1.setAge(25);
		student1.setHobby(new String[] { "篮球", "游戏" });

		Student student2 = new Student();
		student2.setId(2);
		student2.setName("杜甫");
		student2.setSex("男");
		student2.setAge(23);
		student2.setHobby(new String[] { "上网", "跑步" });

		List<Student> list = new ArrayList<Student>();
		list.add(student1);
		list.add(student2);

		JSONArray jsonArray = JSONArray.fromObject(list);
		System.out.println(jsonArray.toString());

		JSONArray new_jsonArray = JSONArray.fromObject(jsonArray.toArray());
		Collection java_collection = JSONArray.toCollection(new_jsonArray);
		if (java_collection != null && !java_collection.isEmpty()) {
			Iterator it = java_collection.iterator();
			while (it.hasNext()) {
				JSONObject jsonObj = JSONObject.fromObject(it.next());
				Student stu = (Student) JSONObject.toBean(jsonObj, Student.class);
				System.out.println(stu.getName());
			}
		}
	}

	/*
	 * java对象与json对象互相转换
	 */
	private static void JsonToBean() {
		/**
		 * 创建java对象
		 */
		Student student = new Student();
		student.setId(1);
		student.setName("张三");
		student.setSex("男");
		student.setAge(25);
		student.setHobby(new String[] { "篮球", "上网", "跑步", "游戏" });
		/**
		 * java对象转换成json对象，并获取json对象属性
		 */
		JSONObject jsonStu = JSONObject.fromObject(student);
		System.out.println(jsonStu.toString());
		System.out.println(jsonStu.getJSONArray("hobby"));
		/**
		 * json对象转换成java对象，并获取java对象属性
		 */
		Student stu = (Student) JSONObject.toBean(jsonStu, Student.class);
		System.out.println(stu.getName());
		/**
		 * 创建json对象
		 */
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("id", 2);
		jsonObj.put("name", "李四");
		jsonObj.put("sex", "男");
		jsonObj.put("age", 24);
		jsonObj.put("hobby", new String[] { "上网", "游戏", "跑步", "音乐" });
		System.out.println(jsonObj.toString());
		/**
		 * json对象转换成java对象
		 */
		Student stud = (Student) JSONObject.toBean(jsonObj, Student.class);
		System.out.println(stud.toString());
	}

}
