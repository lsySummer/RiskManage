package edu.nju.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nju.LOGGER;
import edu.nju.ParamMap;
import edu.nju.dao.BaseDao;
import edu.nju.dao.UserDao;
import edu.nju.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private BaseDao baseDao;

	@Override
	public User register(String username, String password, String role) {
		boolean notExisted = this.baseDao.find(User.class, new ParamMap("username", username)).isEmpty();
		if (notExisted) {
			User u = new User();
			u.setUsername(username);
			u.setPassword(password);
			u.setRole(role);
			baseDao.save(u);
			return u;
		} else {
			return null;
		}
	}

	@Override
	public User login(String username, String password, String role) {
		ParamMap map = new ParamMap("username", username)
				.append("password", password).append("role",role);
		List<User> result = this.baseDao.find(User.class, map);
		if (!result.isEmpty()) {
			return result.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<User> showAll() {
		return baseDao.getAllList(User.class);
	}

	@Override
	public boolean deleteUser(int id) {
		try {
			baseDao.delete(User.class, id);
			return true;
		} catch (Exception e) {
			LOGGER.log(e);
			return false;
		}
	}

	@Override
	public boolean modifyUser(User user) {
		try {
			baseDao.update(user);
			return true;
		} catch (Exception e) {
			LOGGER.log(e);
			return false;
		}
	}

	@Override
	public List<User> getUser(String keyword) {
		String str = "from User s where s.username like \'%" + keyword + "%\'";
		return baseDao.find(str);
	}

	@Override
	public User getById(int id) {
		return baseDao.load(User.class, id);
	}

}
