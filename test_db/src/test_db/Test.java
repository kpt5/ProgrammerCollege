package test_db;

public class Test {

	public static void main(String[] args) {
		TestUserDAO dao = new TestUserDAO();

		System.out.println("dao.select(\"taro\", \"123\");");
		System.out.println("public void select(String name, String password)");
		dao.select("taro", "123");
		System.out.println();

		System.out.println("dao.selectAll();");
		dao.selectAll();
		System.out.println();

		System.out.println("dao.selectByName(\"taro\");");
		dao.selectByName("taro");
		System.out.println();

		System.out.println("dao.selectByPassword(\"123\");");
		dao.selectByPassword("123");
		System.out.println();

		System.out.println("dao.updateUserNameByUserName(\"taro\", \"saburo\");");
		System.out.println("public void updateUserNameByUserName(String oldName, String newName)");
		dao.updateUserNameByUserName("taro", "saburo");
		System.out.println();

		System.out.println("dao.insert(4, \"shiro\", \"012\");");
		System.out.println("public void insert(int user_id, String name, String password)");
		dao.insert(4, "shiro", "012");
		System.out.println();

		System.out.println("dao.delete(\"jiro\");");
		dao.delete("jiro");
		System.out.println();

	}

}
