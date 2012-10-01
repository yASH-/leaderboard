/**
 * 
 */
package com.gffny.leaderboard.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author John Gaffney (john@gffny.com) Sep 26, 2012
 * 
 */
public interface ICompetition {

	/**
	 * 
	 * @return
	 */
	public String getCompetitionName();

	/**
	 * 
	 * @return
	 */
	public String getCompetitionTypeName();

	/**
	 * 
	 * @param roundDate
	 * @return
	 */
	public ICompetitionRound getRoundByDate(Date roundDate);

	/**
	 * 
	 * @param roundID
	 * @return
	 */
	public ICompetitionRound getRoundByNumber(int roundNumber);

	/**
	 * 
	 * @return
	 */
	public List<ICompetitionRound> getCompetitionRoundList();

	// each round will have enclosed data grouping list & tee time may be only
	// one round for certain comp. types

	/**
	 * 
	 * @param round
	 */
	public void addCompetitionRound(ICompetitionRound round);

	/**
	 * 
	 * @return
	 */
	public boolean isIndividualCompetition();

	/**
	 * 
	 * @author John Gaffney (john@gffny.com) Sep 26, 2012
	 * 
	 */
	public interface ICompetitionRound {

		/**
		 * 
		 * @return
		 */
		public String getRoundName();

		/**
		 * 
		 * @return
		 */
		public int getRoundNumber();

		/**
		 * 
		 * @return
		 */
		public Date getRoundDate();

		/**
		 * 
		 * @return
		 */
		public String getDateAsString();

		/**
		 * 
		 * @return
		 */
		public String getRoundFirstTeeTime();

		/**
		 * 
		 * @return
		 */
		public List<IGolfGroup> getGroupList();

		/**
		 * 
		 * @return
		 */
		public Map<IGolfGroup, Date> getTeeTimeMap();

		/**
		 * 
		 * @param groupID
		 * @return
		 */
		public String getGroupTeeTime(int groupID);

		/**
		 * 
		 * @return
		 */
		public ICompetitionRound clone();

		/**
		 * @param competitionName
		 */
		public void setRoundName(String roundName);

	}

	/**
	 * 
	 * @author John Gaffney (john@gffny.com) Sep 26, 2012
	 * 
	 */
	public interface IGolfGroup {

		/**
		 * 
		 */
		public static final String TWOBALL = "twoball";

		/**
		 * 
		 */
		public static final String THREEBALL = "threeball";

		/**
		 * 
		 */
		public static final String FOURBALL = "fourball";

		/**
		 * 
		 * @return
		 */
		public String getGroupName();

		/**
		 * 
		 * @return
		 */
		public int getGroupSize();

		// generated by competition name, date, and order number (i.e.
		// BLOOD_N_BANDAGES_PDWC_MONDAY_GRP1)

		/**
		 * fourball, threeball, twoball
		 * 
		 * @see IGolfGroup.TWOBALL
		 * @return
		 */
		public String getGroupType();

		/**
		 * 
		 * @return
		 */
		public List<IGolfer> getGolferList();

		// TODO is order important? can we insure its' integrity? (i.e. first
		// two out are pair one, and last two out are pair two?)

		/**
		 * 
		 */
		public void addGolfer(IGolfer golfer);
	}
}
