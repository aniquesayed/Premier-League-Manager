package PremierLeague;

import java.util.Random;

/**
 * Created by anique_sayed on 30/10/14.
 */
public class FootballClub extends SportsClub implements Comparable<FootballClub> {

    Random rNumber = new Random();

    private int FootballClubWins = rNumber.nextInt(10) + 1;
    private int FootballClubDraws = rNumber.nextInt(10) + 1;
    private int FootballClubDefeats = rNumber.nextInt(10) + 1;
    private int FootballClubGoalsScored = rNumber.nextInt(10) + 5;
    private int FootballClubGoalsConceded = rNumber.nextInt(10) + 5;
    private int FootballClubPoints = ((FootballClubWins * 3) + FootballClubDraws);
    private int FootballClubGoalDifference;
    private String Day;
    private String Month;
    private String Year;


    public FootballClub(String _SportsClubName, String _SportsClubLocation) {
        super.setSportsClubName(_SportsClubName);
        super.setSportsClubLocation( _SportsClubLocation);
    }

    public int getFootballClubPoints() {
        return FootballClubPoints;
    }

    public void setFootballClubPoints(int _FootballClubPoints) {
        FootballClubPoints = FootballClubPoints + _FootballClubPoints;
    }

    public void setFootballClubWins() {
        FootballClubWins = FootballClubWins + 1;
    }

    public int getFootballClubWins() {
        return FootballClubWins;
    }

    public void setFootballClubDraws() {
        FootballClubDraws = FootballClubDraws + 1;
    }

    public int getFootballClubDraws() {
        return FootballClubDraws;
    }

    public void setFootballClubDefeats() {
        FootballClubDefeats = FootballClubDefeats + 1;
    }

    public int getFootballClubDefeats() {
        return FootballClubDefeats;
    }

    public void setFootballClubGoalsScored(int _FootballClubGoalsScored) {
        FootballClubGoalsScored = FootballClubGoalsScored + _FootballClubGoalsScored;
    }

    public int getFootballClubGoalsScored() {
        return FootballClubGoalsScored;
    }

    public void setFootballClubGoalsConceded(int _FootballClubGoalsConceded) {
        FootballClubGoalsConceded = FootballClubGoalsConceded + _FootballClubGoalsConceded;
    }

    public int getFootballClubGoalsConceded() {
        return FootballClubGoalsConceded;
    }

    public void setFootballClubGoalDifference() {
        FootballClubGoalDifference = FootballClubGoalsScored - FootballClubGoalsConceded;
    }

    public int getFootballClubGoalDifference() {
        return FootballClubGoalDifference;
    }

    public void setDay(String _Day) {
        Day = _Day;
    }

    public String getDay() {
        return Day;
    }

    public void setMonth(String _Month) {
        Month = _Month;
    }

    public String getMonth() {
        return Month;
    }

    public void setYear(String _Year) {
        Year = _Year;
    }

    public String getYear() {
        return Year;
    }

    public int compareTo(FootballClub compare) {

        int sorted = compare.getFootballClubGoalDifference();
        return sorted - this.getFootballClubGoalDifference();

    }

}