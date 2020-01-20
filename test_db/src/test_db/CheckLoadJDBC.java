package test_db;

public class CheckLoadJDBC {

	public static void main(String[] args) throws
	InstantiationException,IllegalAccessException{
		String msg = "";
		try {
//			ドライバのロード？
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			msg = "ドライバのロードに成功しました";
		} catch (ClassNotFoundException e){
			msg = "ドライバのロードに失敗しました";
		}
		System.out.println(msg);

	}

}
