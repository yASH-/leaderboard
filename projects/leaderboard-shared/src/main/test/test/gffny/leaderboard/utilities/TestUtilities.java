/**
 * 
 */
package test.gffny.leaderboard.utilities;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.gffny.leaderboard.component.scheduler.ICompetitionScheduler;
import com.gffny.leaderboard.component.scheduler.impl.SimpleCompetitionScheduler;
import com.gffny.leaderboard.model.ICompetition;
import com.gffny.leaderboard.model.ICompetition.ICompetitionRound;
import com.gffny.leaderboard.model.ICompetitionType;
import com.gffny.leaderboard.model.ICountry;
import com.gffny.leaderboard.model.ICountry.IState;
import com.gffny.leaderboard.model.IGolfCourse;
import com.gffny.leaderboard.model.IGolfer;
import com.gffny.leaderboard.model.IScorecard;
import com.gffny.leaderboard.model.impl.Competition;
import com.gffny.leaderboard.model.impl.CompetitionType;
import com.gffny.leaderboard.model.impl.Country;
import com.gffny.leaderboard.model.impl.GolfCourse;
import com.gffny.leaderboard.model.impl.Golfer;
import com.gffny.leaderboard.model.impl.Scorecard;
import com.gffny.leaderboard.model.impl.State;
import com.gffny.leaderboard.util.CollectionUtils;

/**
 * @author John Gaffney (john@gffny.com) Oct 1, 2012
 * 
 */
public class TestUtilities {

	public static ICompetitionScheduler getTestScheduler() {
		return SimpleCompetitionScheduler.getInstance();
	}

	public static List<ICountry> getTestCountryList() {
		List<IState> irishStateList = new ArrayList<IState>();
		irishStateList.add(new State("Westmeath", "WH"));
		irishStateList.add(new State("Kerry", "KY"));
		irishStateList.add(new State("Down", "DN"));
		irishStateList.add(new State("Kilkenny", "KK"));
		List<ICountry> countryList = new ArrayList<ICountry>();
		countryList.add(new Country("Ireland", "IE", irishStateList));
		List<IState> usStateList = new ArrayList<IState>();
		usStateList.add(new State("Florida", "FL"));
		usStateList.add(new State("Massachussetts", "MA"));
		usStateList.add(new State("Hawaii", "HI"));
		countryList.add(new Country("United States of America", "US",
				usStateList));
		return countryList;
	}

	public static List<IGolfer> getTestGolferList() {
		List<IGolfer> testList = new ArrayList<IGolfer>();
		testList.add(new Golfer(11, "John", "Gaffney", "gffny"));
		testList.add(new Golfer(12, "Eoin", "Barry", "eoindeb"));
		testList.add(new Golfer(13, "Mick", "Lyons", "leo"));
		testList.add(new Golfer(14, "Colm", "Caffrey", "mink"));
		testList.add(new Golfer(15, "Niall", "O'Connor", "nile"));
		testList.add(new Golfer(16, "Mick", "O'Connor", "big bear"));
		testList.add(new Golfer(17, "Dave", "Hughes", "dub"));
		testList.add(new Golfer(18, "John", "Wyrcherly", "hair"));
		testList.add(new Golfer(19, "Joe", "Regan", "chairman"));
		testList.add(new Golfer(20, "Lar", "Barden", "bardo"));
		testList.add(new Golfer(21, "Kenny", "McCarthy", "kenny"));
		testList.add(new Golfer(22, "Mike", "Canny", "canny"));
		testList.add(new Golfer(23, "Jeff", "Saunders", "jeff"));
		testList.add(new Golfer(24, "John", "Crowley", "jc"));
		testList.add(new Golfer(25, "Theo", "Foley", "theo"));
		testList.add(new Golfer(26, "Mark", "Cahillane", "markie"));
		testList.add(new Golfer(27, "Mike", "Moynihan", "mikey"));
		testList.add(new Golfer(28, "John", "Foley", "foley"));
		testList.add(new Golfer(29, "Graham", "MacDowell", "gmac"));
		testList.add(new Golfer(30, "Rory", "McIlroy", "roy"));
		return testList;
	}

	public static IGolfer getTestGolferByID(String golferId) {
		Map<Integer, IGolfer> testMap = new HashMap<Integer, IGolfer>();
		testMap.put(11, new Golfer(11, "John", "Gaffney", "gffny"));
		testMap.put(12, new Golfer(12, "Eoin", "Barry", "eoindeb"));
		testMap.put(13, new Golfer(13, "Mick", "Lyons", "leo"));
		testMap.put(14, new Golfer(14, "Colm", "Caffrey", "mink"));
		testMap.put(15, new Golfer(15, "Niall", "O'Connor", "nile"));
		testMap.put(16, new Golfer(16, "Mick", "O'Connor", "big bear"));
		testMap.put(17, new Golfer(17, "Dave", "Hughes", "dub"));
		testMap.put(18, new Golfer(18, "John", "Wyrcherly", "hair"));
		testMap.put(19, new Golfer(19, "Joe", "Regan", "chairman"));
		testMap.put(20, new Golfer(20, "Lar", "Barden", "bardo"));
		testMap.put(21, new Golfer(21, "Kenny", "McCarthy", "kenny"));
		testMap.put(22, new Golfer(22, "Mike", "Canny", "canny"));
		testMap.put(23, new Golfer(23, "Jeff", "Saunders", "jeff"));
		testMap.put(24, new Golfer(24, "John", "Crowley", "jc"));
		testMap.put(25, new Golfer(25, "Theo", "Foley", "theo"));
		testMap.put(26, new Golfer(26, "Mark", "Cahillane", "markie"));
		testMap.put(27, new Golfer(27, "Mike", "Moynihan", "mikey"));
		testMap.put(28, new Golfer(28, "John", "Foley", "foley"));
		testMap.put(29, new Golfer(29, "Graham", "MacDowell", "gmac"));
		testMap.put(30, new Golfer(30, "Rory", "McIlroy", "roy"));
		return testMap.get(new Integer(golferId));
	}

	public static Map<Integer, IGolfer> getTestGolferMap() {
		Iterator<IGolfer> golferItr = getTestGolferList().iterator();
		Map<Integer, IGolfer> golferIdMap = new HashMap<Integer, IGolfer>();
		while (golferItr.hasNext()) {
			IGolfer golfer = golferItr.next();
			golferIdMap.put(golfer.getUserId(), golfer);
		}
		return golferIdMap;
	}

	public static String[] getTestTeeTimeArray(String firstTime,
			String interval, int number) {
		String[] testTeeTimeArray = { "12:00", "12:10", "12:20", "12:30",
				"12:40" };
		return testTeeTimeArray;
	}

	/**
	 * @param numberOfHoles
	 * @param par
	 * @return
	 */
	public static IGolfCourse getTestGolfCourse(int numberOfHoles, int par) {
		int[] holePar = { 4, 5, 4, 3, 4, 3, 4, 5, 4, 4, 5, 4, 3, 4, 3, 4, 5, 4 };
		int[] holeIndex = { 1, 7, 14, 2, 8, 15, 3, 9, 16, 4, 10, 17, 5, 11, 18,
				6, 12, 13 };
		int[] holeDistance = { 323, 545, 450, 160, 411, 200, 350, 602, 320,
				323, 545, 450, 160, 411, 200, 350, 602, 320 };
		return new GolfCourse("10001", "Newton Commonwealth", par,
				"Newton, MA", "Blue", holePar, holeIndex, holeDistance);
	}

	/**
	 * @return
	 */
	public static ICompetition getTestCompetition() {
		return new Competition("President's Day Cup 2012", new CompetitionType(
				"Stableford", "Stableford", "Stableford", true, true, true),
				"President's Day Cup 2012");
	}

	/**
	 * @return
	 */
	public static ICompetitionRound getTestRound(int roundNumber) {
		ICompetitionRound testRound = getTestScheduler()
				.scheduleCompetitionRound(
						getTestCompetition().getCompetitionName(), roundNumber,
						new Date(System.currentTimeMillis()),
						getTestGolfCourse(18, 72),
						getTestTeeTimeArray("12:00", "10", 5),
						getTestGolferList(), 4, 18);
		testRound.setRoundId(roundNumber + 1000);
		return testRound;
	}

	/**
	 * @return
	 */
	public static Map<Integer, IScorecard> getTestScoreCardMap() {
		Map<Integer, IScorecard> scorecardMap = new HashMap<Integer, IScorecard>();
		Iterator<IGolfer> golferIterator = getTestGolferList().iterator();
		IGolfer golfer = null;
		while (golferIterator.hasNext()) {
			golfer = golferIterator.next();
			IScorecard scorecard = getTestScorecard();
			scorecardMap.put(golfer.getUserId(), scorecard);
			System.out.println(golfer.getFirstName() + " "
					+ golfer.getLastName() + "|" + scorecard.toString());
		}
		return scorecardMap;
	}

	/**
	 * @return
	 */
	public static IScorecard getTestScorecard() {
		int[] scorearray = new int[18];
		for (int i = 0; i < 18; i++) {

			scorearray[i] = randomInt(3, 10);
		}
		return new Scorecard(Scorecard.BLUES_COLOUR, randomInt(9, 33),
				scorearray, "", "01/10/2012");
	}

	/**
	 * @return
	 */
	private static int randomInt(int min, int max) {
		// http://stackoverflow.com/questions/363681/generating-random-number-in-a-range-with-java
		// Min + (int)(Math.random() * ((Max - Min) + 1)
		return min + (int) (Math.random() * ((max - min) + 1));
	}

	/**
	 * @return
	 */
	public static List<ICompetitionType> getTestCompetitionTypeList() {
		ICompetitionType stableford = new CompetitionType("Stableford",
				"STABLEFORD", "STABLEFORD", true, true, true);
		ICompetitionType matchplay = new CompetitionType("Matchplay",
				"MATCHPLAY", "MATCHPLAY", false, true, true);
		return CollectionUtils.asList(stableford, matchplay);
	}
}
