/**
 * 
 */
package com.gffny.leaderboard.model.impl;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

import com.gffny.leaderboard.model.IScorecard;
import com.gffny.leaderboard.util.TimeFunction;

/**
 * @author John Gaffney (john@gffny.com) Jul 30, 2012
 * 
 */
public class Scorecard implements IScorecard {

	private String teesPlayedOff = new String();
	private int[] scoreArray = null;
	private String scorecardNotes = new String();
	private Date scorecardDate;
	private int handicap;

	/**
	 * 
	 * @param teesPlayedOff
	 * @param grossScoreArray
	 * @param scorecardNotes
	 * @param scorecardDate
	 */
	public Scorecard(String teesPlayedOff, int handicap, int[] grossScoreArray,
			String scorecardNotes, String scorecardDate) {
		this.teesPlayedOff = teesPlayedOff;
		this.handicap = handicap;
		this.scoreArray = grossScoreArray;
		this.scorecardNotes = scorecardNotes;
		this.scorecardDate = formatDate(scorecardDate);
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final int maxLen = 18;
		return "Scorecard [teesPlayedOff="
				+ teesPlayedOff
				+ ", scoreArray="
				+ (scoreArray != null ? Arrays.toString(Arrays.copyOf(
						scoreArray, Math.min(scoreArray.length, maxLen)))
						: null) + ", scorecardNotes=" + scorecardNotes
				+ ", scorecardDate=" + scorecardDate + ", grossScore="
				+ getGrossScore() + ", handicap=" + getHandicapForRound() + "]";
	}

	/**
	 *
	 */
	@Override
	public int getScoreOnHole(int holeNumber) {
		return scoreArray[holeNumber - 1];
	}

	/**
	 *
	 */
	@Override
	public int getGrossScore() {
		int grossScore = 0;
		for (int i = 0; i < scoreArray.length; i++) {
			grossScore += scoreArray[i];
		}
		return grossScore;
	}

	@Override
	public int getHandicapForRound() {
		return handicap;
	};

	/**
	 * 
	 */
	@Override
	public String getScorecardNotes() {
		return this.scorecardNotes;
	}

	/**
	 * 
	 */
	@Override
	public int getTeesPlayedOffCode() {
		if (this.teesPlayedOff.equals(IScorecard.GOLDS_COLOUR)) {
			return IScorecard.GOLDS_CODE;
		}
		if (this.teesPlayedOff.equals(IScorecard.BLUES_COLOUR)) {
			return IScorecard.BLUES_CODE;
		}
		if (this.teesPlayedOff.equals(IScorecard.WHITES_COLOUR)) {
			return IScorecard.WHITES_CODE;
		}
		if (this.teesPlayedOff.equals(IScorecard.REDS_COLOUR)) {
			return IScorecard.REDS_CODE;
		}
		if (this.teesPlayedOff.equals(IScorecard.GREENS_COLOUR)) {
			return IScorecard.GREENS_CODE;
		}
		return 0;
	}

	/**
	 * 
	 */
	@Override
	public String getTeesPlayedOffColour() {
		return this.teesPlayedOff;
	}

	/**
	 * 
	 * @see com.gffny.leaderboard.model.IScorecard#getNumberOfHoles()
	 */
	@Override
	public int getNumberOfHoles() {
		return scoreArray.length;
	};

	/**
	 * 
	 */
	@Override
	public Date getScorecardDate() {
		return this.scorecardDate;
	}

	/**
	 * @param scorecardDate
	 */
	private Date formatDate(String scorecardDate) {
		try {
			return TimeFunction.parseString(scorecardDate);
		} catch (ParseException e) {
			// TODO handle parse error from time function in scorecard()
			e.printStackTrace();
			return null;
		}
	}
}
