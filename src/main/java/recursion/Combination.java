package recursion;

import java.util.ArrayList;
import java.util.List;


public class Combination {

    private static String[] group = {"A", "B", "C", "D", "E"};
//    private static String[] group = {"C", "A", "T", "S"};
    private static List<String> team = new ArrayList<>();
    private static int cursor;


    public static void main(String[] args) {

        showTeams(5, 3, team);
    }

    private static void showTeams(int groupSize, int teamSize, List<String> team) {

        if (groupSize == 0 || teamSize == 0 || teamSize > groupSize) {

            if (team.size() > 0) {
                team.remove(team.size() - 1);
            }

            return;
        }


        //left

        List<String> currentLeftTeam = new ArrayList<>(team);
        cursor = group.length - groupSize;

        currentLeftTeam.add(group[cursor]);

        showTeams(groupSize - 1, teamSize - 1, currentLeftTeam);


        //right

        List<String> currentRightTeam = new ArrayList<>(team);
        cursor = group.length - groupSize;

        if (currentRightTeam.size() + 1 == 3) {
            List<String> forPrint = new ArrayList<>(currentRightTeam);
            forPrint.add(group[cursor]);

            System.out.println(forPrint);
        }

        showTeams(groupSize - 1, teamSize, currentRightTeam);
    }
}
