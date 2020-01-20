package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.template.dto.LoginDTO;
import com.internousdev.template.util.DBConnector;

public class LoginDAO {

	public LoginDTO getLoginUserInfo(String loginUserId, String loginPassword) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		LoginDTO loginDTO = new LoginDTO();

		String sql = "SELECT * FROM login_user_transaction where login_id = ? AND login_pass = ?";

//		MariaDB [template]> DESC login_user_transaction;
//		+--------------+-------------+------+-----+---------+----------------+
//		| Field        | Type        | Null | Key | Default | Extra          |
//		+--------------+-------------+------+-----+---------+----------------+
//		| id           | int(11)     | NO   | PRI | NULL    | auto_increment |
//		| login_id     | varchar(16) | YES  | UNI | NULL    |                |
//		| login_pass   | varchar(16) | YES  |     | NULL    |                |
//		| user_name    | varchar(50) | YES  |     | NULL    |                |
//		| insert_date  | datetime    | YES  |     | NULL    |                |
//		| updated_date | datetime    | YES  |     | NULL    |                |
//		+--------------+-------------+------+-----+---------+----------------+

		try {
//			セキュリティを考慮し、javaではPreparedStatementを利用します。
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ps.setString(2, loginPassword);

			ResultSet rs = ps.executeQuery();

			//	next()：次の行にデータが存在していれば true、存在しなければ false
			//	（最初は0行目の次の行＝1行目を見る）
			//	if (rs.next())なので一行分で終了。login_idはユニークなので０か1件しかありえない。
			//	DBから取得した情報を、buyItemDTOクラスのsetterを利用して、DTOクラスに格納します。
			if(rs.next()) {
				loginDTO.setLoginId(rs.getString("login_id"));
				loginDTO.setLoginPassword(rs.getString("login_pass"));
				loginDTO.setUserName(rs.getString("user_name"));

//				login_pass、user_nameのnull判定はしていないが、あり得る
//				login_idだけ入っている場合でもログインできてしまう
				if(rs.getString("login_id") != null) {
					loginDTO.setLoginFlg(true);
				}
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

		return loginDTO;
	}
}
