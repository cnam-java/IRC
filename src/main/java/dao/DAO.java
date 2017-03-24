package dao;

import io.Message;

public interface DAO<T> {
	public T find(Object id) throws DAOException;
	public T create(T obj) throws DAOException;
	public T update(T obj) throws DAOException;
	public void delete(T obj) throws DAOException;
}
