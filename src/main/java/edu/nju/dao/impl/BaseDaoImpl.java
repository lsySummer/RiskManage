package edu.nju.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nju.dao.BaseDao;

@Repository
public class BaseDaoImpl implements BaseDao {
	/** * Autowired 自动装配 相当于get() set() */
	@Autowired
	protected SessionFactory sessionFactory;

	/** * gerCurrentSession 会自动关闭session，使用的是当前的session事务 * * @return */
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/** * openSession 需要手动关闭session 意思是打开一个新的session * * @return */
	public Session getNewSession() {
		return sessionFactory.openSession();
	}

	public void flush() {
		getSession().flush();
	}

	public void clear() {
		getSession().clear();
	}

	/** * 根据 id 查询信息 * * @param id * @return */
	public <T> T load(Class<T> c, int id) {
		Session session = getSession();
		return session.get(c, id);
	}

	/** * 获取所有信息 * * @param c * * @return */

	public <T> List<T> getAllList(Class<T> c) {
		String hql = "from " + c.getName() + " order by id desc";
		Session session = getSession();
		return session.createQuery(hql).list();

	}

	/** * 获取总数量 * * @param c * @return */

	public long getTotalCount(Class<?> c) {
		try (Session session = getNewSession()) {
			String hql = "select count(*) from " + c.getName();
			Long count = (Long) session.createQuery(hql).uniqueResult();
			return count != null ? count.longValue() : 0;
		}
	}

	/** * 保存 * * @param bean * */
	public void save(Object bean) {
		try (Session session = getNewSession()) {
			Transaction tx = session.beginTransaction();
			session.save(bean);
			session.flush();
			session.clear();
			tx.commit();
		}
	}

	/** * 更新 * * @param bean * */
	public void update(Object bean) {
		try (Session session = getNewSession()) {
			session.update(bean);
			session.flush();
			session.clear();
		}
	}

	/** * 删除 * * @param bean * */
	public void delete(Object bean) {
		try (Session session = getNewSession()) {
			session.delete(bean);
			session.flush();
			session.clear();
		}
	}

	/** * 根据ID删除 * * @param c 类 * * @param id ID * */
	public void delete(Class<?> c, Serializable id) {
		try (Session session = getNewSession()) {
			Transaction tx = session.beginTransaction();
			Object obj = session.get(c, id);
			session.delete(obj);
			tx.commit();
			flush();
			clear();
		}
	}

	/** * 批量删除 * * @param c 类 * * @param ids ID 集合 * */
	public void delete(Class<?> c, Serializable... ids) {
		for (Serializable id : ids) {
			Object obj = getSession().get(c, id);
			if (obj != null) {
				getSession().delete(obj);
			}
		}
	}

	// 根据HQL语句进行查询
	public <T> List<T> find(String queryString) {
		try (Session session = getNewSession()) {
			return session.createQuery(queryString).list();
		}
	}

}
