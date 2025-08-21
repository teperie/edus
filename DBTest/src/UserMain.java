import java.util.List;

import dao.UserDao;
import dto.User;

public class UserMain {
	public static void main(String[] args) {
		User user = UserDao.select("kong");
		System.out.println(user);

		user.setName("장길동");
		UserDao.update(user);

		List<User> ls = UserDao.selectList();
		for (User u : ls) {
			System.out.println(u);
		}
	}
}
