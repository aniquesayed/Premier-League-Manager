package PremierLeague;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by anique_sayed on 30/10/14.
 */
public class PremierLeagueManager implements PremierLeague {

    String day, month, year;
    int i, j;

    ArrayList<FootballClub> FC = new ArrayList<FootballClub>();

    public void Menu() {

        // write your code here

        Scanner UserInput = new Scanner(System.in);

        PremierLeagueManager PLM = new PremierLeagueManager();

        int MO = 0;

        while (MO != 10) {

            System.out.println("Please pick from one of the following options:");
            System.out.println("To add a team name enter '1'.");
            System.out.println("To view teams, enter '2'.");
            System.out.println("To delete a team, enter '3'.");
            System.out.println("To view the statistics of a team, enter '4'.");
            System.out.println("To view the Premier League Table, enter '5'.");
            System.out.println("To add a played match, enter '6'.");
            System.out.println("To view the calendar, enter '7'.");
            System.out.println("To exit, enter '8'.");

            MO = UserInput.nextInt();

            switch (MO) {
                case 1:
                    PLM.Add();
                    break;
                case 2:
                    PLM.View();
                    break;
                case 3:
                    PLM.Delete();
                    break;
                case 4:
                    PLM.Stats();
                    break;
                case 5:
                    PLM.PremierLeagueTable();
                    break;
                case 6:
                    PLM.Match();
                    break;
                case 7:
                    PLM.Calendar();
                    break;
                case 8:
                    System.exit(0);
                    break;

            }

        }

    }

    public void Add() {

        Scanner UserInput = new Scanner(System.in);
        System.out.println("Please enter the name of the club you wish to add.");
        String SportsClubName = UserInput.nextLine();
        System.out.println("Please enter the location of the club you wish to add.");
        String SportsClubLocation = UserInput.nextLine();
        FC.add(new FootballClub(SportsClubName, SportsClubLocation));
        System.out.println("Team " + SportsClubName + " with location " + SportsClubLocation + " has been added.");

    }

    public void View() {

        if (FC.isEmpty()) {
            System.out.println("Sorry, no teams have been added.");
        } else {
            for (i = 0; i < FC.size(); i++) {
                System.out.println("Sports Club: " + FC.get(i).getSportsClubName() + " based in: " + FC.get(i).getSportsClubLocation());
            }
        }
    }


    public void Delete() {

        Scanner UserInput = new Scanner(System.in);
        System.out.println("Please enter the name of the team you wish to relegate: ");
        String delete;
        delete = UserInput.nextLine();

        if (FC.isEmpty()) {
            System.out.println("Sorry, no teams exist.");
        } else {
            for (i = 0; i < FC.size(); i++) {
                boolean retrieval = FC.get(i).getSportsClubName().contains(delete);
                if (retrieval) {
                    FC.remove(i);
                    System.out.println("Team " + delete + " has been relegated.");
                }
            }
        }
    }

    public void Stats() {

        Scanner UserInput = new Scanner(System.in);
        System.out.println("What teams stats would you like to see? ");
        String teamStats;
        teamStats = UserInput.nextLine();

        for (i = 0; i < FC.size(); i++) {

            if (FC.get(i).getSportsClubName().equals(teamStats)) {

                System.out.printf("%-20s %-4s %-5s %-7s %-12s %-14s %-11s \n",
                        "Team Name", "Wins", "Draws", "Defeats", "Goals Scored", "Goals Conceded", "Club Points");
                System.out.printf("%-20s %-4s %-5s %-7s %-12s %-14s %-11s \n",
                        FC.get(i).getSportsClubName(),
                        FC.get(i).getFootballClubWins(),
                        FC.get(i).getFootballClubDraws(),
                        FC.get(i).getFootballClubDefeats(),
                        FC.get(i).getFootballClubGoalsScored(),
                        FC.get(i).getFootballClubGoalsConceded(),
                        FC.get(i).getFootballClubPoints());
            }
        }

    }

    public void PremierLeagueTable() {

        Collections.sort(FC);


        for (i = 0; i < FC.size(); i++) {

            FC.get(i).setFootballClubGoalDifference();

        }

        Comparator<FootballClub> rankOrder = new Comparator<FootballClub>() {
            public int compare(FootballClub s1, FootballClub s2) {
                return s2.getFootballClubPoints() - s1.getFootballClubPoints();
            }
        };
        Collections.sort(FC, rankOrder);

        System.out.printf("%-20s %-3s %-3s %-3s %-3s %-3s %-3s %-3s \n",
                "Team Name",
                "W",
                "D",
                "L",
                "GF",
                "GA",
                "GD",
                "PTS");
        for (i = 0; i < FC.size(); i++) {

            System.out.printf("%-20s %-3s %-3s %-3s %-3s %-3s %-3s %-3s \n",
                    FC.get(i).getSportsClubName(),
                    FC.get(i).getFootballClubWins(),
                    FC.get(i).getFootballClubDraws(),
                    FC.get(i).getFootballClubDefeats(),
                    FC.get(i).getFootballClubGoalsScored(),
                    FC.get(i).getFootballClubGoalsConceded(),
                    FC.get(i).getFootballClubGoalDifference(),
                    FC.get(i).getFootballClubPoints());

        }

    }


    public void Match() {

        Scanner UserInput = new Scanner(System.in);
        Scanner UserInputV2 = new Scanner(System.in);
        Scanner UserInputV3 = new Scanner(System.in);

        String teamOne, teamTwo;
        int teamOneG, teamTwoG;

        System.out.println("Please enter the year the match was played:");
        day = UserInputV3.nextLine();
        System.out.println("Please enter the month the match was played:");
        month = UserInputV3.nextLine();
        System.out.println("Please enter the date the match was played:");
        year = UserInputV3.nextLine();

        System.out.println("Please enter the first team in the match: ");
        teamOne = UserInput.nextLine();
        System.out.println("Please enter how many goals they scored: ");
        teamOneG = UserInput.nextInt();

        System.out.println("Please enter the second team in the match:");
        teamTwo = UserInputV2.nextLine();
        System.out.println("Please enter how many goals they scored: ");
        teamTwoG = UserInputV2.nextInt();

        if (teamOneG > teamTwoG) {

            for (i = 0; i < FC.size(); i++) {

                if (FC.get(i).getSportsClubName().equals(teamOne)) {

                    FC.get(i).setFootballClubWins();
                    FC.get(i).setFootballClubGoalsScored(teamOneG);
                    FC.get(i).setFootballClubGoalsConceded(teamTwoG);
                    FC.get(i).setFootballClubPoints(3);

                    FC.get(i).setDay(day);
                    FC.get(i).setMonth(month);
                    FC.get(i).setYear(year);

                } else if (FC.get(i).getSportsClubName().equals(teamTwo)) {

                    FC.get(i).setFootballClubDefeats();
                    FC.get(i).setFootballClubGoalsScored(teamTwoG);
                    FC.get(i).setFootballClubGoalsConceded(teamOneG);

                    FC.get(i).setDay(day);
                    FC.get(i).setMonth(month);
                    FC.get(i).setYear(year);

                }
            }
        } else if (teamOneG == teamTwoG) {

            for (i = 0; i < FC.size(); i++) {

                if (FC.get(i).getSportsClubName().equals(teamOne)) {

                    FC.get(i).setFootballClubDraws();
                    FC.get(i).setFootballClubGoalsScored(teamOneG);
                    FC.get(i).setFootballClubGoalsConceded(teamTwoG);
                    FC.get(i).setFootballClubPoints(1);

                    FC.get(i).setDay(day);
                    FC.get(i).setMonth(month);
                    FC.get(i).setYear(year);

                } else if (FC.get(i).getSportsClubName().equals(teamTwo)) {

                    FC.get(i).setFootballClubDraws();
                    FC.get(i).setFootballClubGoalsScored(teamTwoG);
                    FC.get(i).setFootballClubGoalsConceded(teamOneG);
                    FC.get(i).setFootballClubPoints(1);

                    FC.get(i).setDay(day);
                    FC.get(i).setMonth(month);
                    FC.get(i).setYear(year);

                }
            }
        } else if (teamOneG < teamTwoG) {

            for (i = 0; i < FC.size(); i++) {

                if (FC.get(i).getSportsClubName().equals(teamOne)) {

                    FC.get(i).setFootballClubDefeats();
                    FC.get(i).setFootballClubGoalsScored(teamOneG);
                    FC.get(i).setFootballClubGoalsConceded(teamTwoG);

                    FC.get(i).setDay(day);
                    FC.get(i).setMonth(month);
                    FC.get(i).setYear(year);

                } else if (FC.get(i).getSportsClubName().equals(teamTwo)) {

                    FC.get(i).setFootballClubWins();
                    FC.get(i).setFootballClubGoalsScored(teamTwoG);
                    FC.get(i).setFootballClubGoalsConceded(teamOneG);
                    FC.get(i).setFootballClubPoints(3);

                    FC.get(i).setDay(day);
                    FC.get(i).setMonth(month);
                    FC.get(i).setYear(year);

                }
            }
        } else {

            System.out.println("Teams don't exist.");

        }

    }

    public void Calendar() {

        Scanner UserInput = new Scanner(System.in);
        Scanner UserInputV2 = new Scanner(System.in);
        Scanner UserInputV3 = new Scanner(System.in);
        Scanner UserInputV4 = new Scanner(System.in);

        int k = 10;
        int days;
        String day;
        String Day;

        String Month;
        int Year;
        System.out.println("Please enter the month you wish to view:");
        Month = UserInputV3.nextLine();
        System.out.println("Please enter the year you wish to view:");
        Year = UserInputV4.nextInt();
        System.out.println("Enter the number of days in the month:");
        days = UserInput.nextInt();
        days = days + 1;

        String[] calendar = new String[days];

        for (i = 0, j = calendar.length; i < j; i++) {
            calendar[i] = i + " ";
        }

        while (k == 10) {
            System.out.println("Enter starting day of the week (Su,Mo,Tu,We,Th,Fr,Sa): ");
            Day = UserInputV2.next();
            day = Day.toLowerCase();

            if ("mo".equals(day)) {
                k = 1;
            } else if ("tu".equals(day)) {
                k = 2;
            } else if ("we".equals(day)) {
                k = 3;
            } else if ("th".equals(day)) {
                k = 4;
            } else if ("fr".equals(day)) {
                k = 5;
            } else if ("sa".equals(day)) {
                k = 6;
            } else if ("su".equals(day)) {
                k = 0;
            }
        }

        System.out.printf("%11s %-8s \n", Month, Year);
        System.out.println("Su Mo Tu We Th Fr Sa");

        for (i = 0; i < k; i++) {
            System.out.print("   ");
        }

        k -= 7;

        for (i = 1; i < calendar.length; k++, i++) {
            if (k % 7 == 0 && i > 1) {
                System.out.println();
            }
            System.out.printf("%-3s", calendar[i]);
        }

        System.out.println();

        for (i = 0; i < FC.size(); i++) {

            System.out.println("Matches Played on:");
            System.out.printf("%-2s, %-10s, %-4s \n", FC.get(i).getDay(), FC.get(i).getMonth(), FC.get(i).getYear());
            System.out.println("by:");
            System.out.printf("%-15s, %-5s \n", FC.get(i).getSportsClubName(), FC.get(i).getFootballClubGoalsScored());

        }

    }

}