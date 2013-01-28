/**
 * 
 */
package com.gffny.leaderboard.dao.abst;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.gffny.leaderboard.intralayer.DAOException;

/**
 * @author John Gaffney (john@gffny.com) Jan 27, 2013
 * 
 */
public class AbstractDAO {

	/**
	 * @param <T>
	 * @param daoEx
	 * @param class1
	 * @param log2
	 * @return
	 */
	protected <T> List<T> logErrorReturnEmptyList(DAOException daoEx,
			Logger log, Class<T> listType) {
		log.error(daoEx.getMessage());
		return new ArrayList<T>();
	}

	/**
	 * @param daoEx
	 * @param log2
	 * @param class1
	 * @return
	 * @return
	 */
	protected <T> T logErrorReturnEmptyClass(Exception ex, Logger log,
			Class<T> classToReturn) {
		log.error(ex.getMessage());
		final Class<T> classType = classToReturn;
		T objectToReturn = null;
		try {
			objectToReturn = classType.newInstance();
		} catch (Exception e) {
			log.error(classToReturn.getName() + " is not instantiable");
			return null;
		}
		return objectToReturn;
	}
}
