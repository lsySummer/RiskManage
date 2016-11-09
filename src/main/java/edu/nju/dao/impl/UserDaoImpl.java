package edu.nju.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nju.dao.BaseDao;
import edu.nju.dao.UserDao;
import edu.nju.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private BaseDao baseDao;

	@Override
	public User register(String username, String password, String role) {
		try {
			User u = new User();
			u.setUsername(username);
			u.setPassword(password);
			u.setRole(role);
			baseDao.save(u);
			return u;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public User login(String username, String password, String role) {
		Session session = baseDao.getNewSession();
		List<User> result = session
				.createQuery("from User s where s.username=? and s.password=?")
				.setParameter(0, username).
				setParameter(1, password)
				.list();
		if (!result.isEmpty()) {
			return result.get(0);
		}
		return null;
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
			return false;
		}
	}

	@Override
	public boolean modifyUser(User user) {
		try {
			baseDao.update(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUser(String keyword) {
		String str = "from User s where s.username like \'%" + keyword + "%\'";
		return (List<User>) baseDao.find(str);
	}

	@Override
	public User getById(int id) {
		return baseDao.load(User.class, id);
	}

}
