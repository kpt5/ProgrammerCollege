package iphone;

public class Iphone {

	public static void main(String[] args) {
		SmartPhone iphone = new SmartPhone();
		SmartPhone android = new SmartPhone();
		iphone.play();
		iphone.stop();
		iphone.next();
		iphone.back();

		iphone.call();
		iphone.mail();
		iphone.photo();
		iphone.internet();

		android.play();
		android.stop();
		android.next();
		android.back();

		android.call();
		android.mail();
		android.photo();
		android.internet();

	}

}
