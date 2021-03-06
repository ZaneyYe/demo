package util;

import java.io.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by yzy on 2017/06/14 上午 9:59.
 * email: mia5121@163.com
 */
public class Tool {
	private Tool() {
	}

	public static <T extends Serializable> T cloneObject(Object ori){
		T clone = null;
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
			objectOutputStream.writeObject(ori);
			objectOutputStream.close();
			ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
			ObjectInputStream objectInputStream = new ObjectInputStream(in);
			clone = (T) objectInputStream.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}

		//
		return clone;
	}

	public static void main(String[] args){
		Date now = new Date();
		System.out.println(now);
		Timestamp timestamp = new Timestamp(now.getTime());
		System.out.println(timestamp);
	}
}