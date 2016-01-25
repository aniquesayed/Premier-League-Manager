package PremierLeague;

/**
 * Created by anique_sayed on 30/10/14.
 */
public abstract class SportsClub {

    private String SportsClubName;
    private String SportsClubLocation;

    public void setSportsClubName(String _SportsClubName) {

        SportsClubName = _SportsClubName;

    }

    public String getSportsClubName() {

        return SportsClubName;

    }

    public void setSportsClubLocation(String _SportsClubLocation) {

        SportsClubLocation = _SportsClubLocation;

    }

    public String getSportsClubLocation() {

        return SportsClubLocation;

    }


}