package edu.nju.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

public interface BaseDao {

	public Session getSession();

	public Session getNewSession();

	public void flush();

	public void clear();

	public <T> T load(Class<T> c, int id);

	public <T> List<T> find(String queryString);

	public <T> List<T> getAllList(Class<T> c);

	public long getTotalCount(Class<?> c);

	public void save(Object bean);

	public void update(Object bean);

	public void delete(Object bean);

	public void delete(Class<?> c, Serializable id);

	public void delete(Class<?> c, Serializable... ids);
}
