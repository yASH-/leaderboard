/**
 * 
 */
package com.gffny.leaderboard.model.impl;

import java.util.List;

import com.gffny.leaderboard.model.ICountry;
import com.gffny.leaderboard.model.abst.SQLEntity;

/**
 * @author John Gaffney (john@gffny.com) Oct 3, 2012
 * 
 */
public class Country extends SQLEntity implements ICountry {

	private String code;
	private List<IState> stateList;

	/**
	 * 
	 * @param name
	 * @param code
	 */
	public Country(String name, String code, List<IState> stateList) {
		super(name, 0);
		this.code = code;
		this.stateList = stateList;
	}

	/**
	 * 
	 * @param name
	 * @param code
	 */
	public Country(int id, String name, String code, List<IState> stateList) {
		super(name, id);
		this.setId(id);
		this.code = code;
		this.stateList = stateList;
	}

	/**
	 * @see com.gffny.leaderboard.model.ICountry#getCode()
	 */
	@Override
	public String getCode() {
		return code;
	}

	/**
	 * @see com.gffny.leaderboard.model.ICountry#getStateList()
	 */
	@Override
	public List<IState> getStateList() {
		return stateList;
	}
}
