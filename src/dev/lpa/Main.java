package dev.lpa;
interface Player {

    String name();
}

record BaseballPlayer (String name, String position) implements Player{
}
record FootballPlayer (String name, String position) implements Player{
}
record VolleyballPlayer (String name, String position) implements Player {
}
public class Main {
    public static void main(String[] args) {

        var philly = new Affiliation("city","nigeria","us");

        BaseballTeam england = new BaseballTeam("Red Bull");
        BaseballTeam sydney = new BaseballTeam("Houston red");


        var habeeb = new BaseballPlayer("H_Habeeb", "Right Fielder");
        var temi = new BaseballPlayer("T_TEmi", "Right Fielder");
        var jack = new BaseballPlayer("jack Grealish","Striker");
        
        england.addTeamMember(jack);
        england.addTeamMember(habeeb);
        england.addTeamMember(temi);
        scoreResult(england,3,sydney,5);

        SportsTeam england2 = new SportsTeam("Red Bull");
        SportsTeam sydney2 = new SportsTeam("Houston red");
        scoreResult(england2,3,sydney2,5);

        Team<BaseballPlayer,Affiliation> england1 = new Team<>("Red Bull",philly);

        Team<BaseballPlayer,Affiliation>sydney1 = new Team<>("Houston red");
        scoreResult(england1,3,sydney1,5);





        england.listTeamMembers();

        SportsTeam afc1 = new SportsTeam("Red goof");
        Team<FootballPlayer,String> afc = new Team<>("Red goof","City of Adelide");
        var tex = new FootballPlayer("kyle walker","left Forward");
        afc.addTeamMember(tex);
        var halland = new FootballPlayer("Erling Halland","Striker");
        afc.addTeamMember(halland);
        afc.listTeamMembers();


        Team<VolleyballPlayer,Affiliation> mancity = new Team<>("Mancity");
        mancity.addTeamMember(new VolleyballPlayer("Ronebet","Setter"));
        mancity.listTeamMembers();

        var manu = new Team<VolleyballPlayer,Affiliation>("manu");
        manu.addTeamMember(new VolleyballPlayer(" B Black","Opposite"));
        manu.listTeamMembers();
        scoreResult(manu,0,mancity,1);

        Player player = new BaseballPlayer("habeeb","kasdv");




            System.out.println("""
       Player{name = '%s', "hitPoints = %d,  strength=%d, weapon= '%s'
    """.formatted("name",12,1,"sas"));



    }
    public static void scoreResult(BaseballTeam team1, int t1_score,
                                  BaseballTeam team2, int t2_score) {
        String message = team1.setScore(t1_score,t2_score);
        team2.setScore(t2_score,t1_score);
        System.out.printf("%s %s %s %n",team1,message,team2);
    }
    public static void scoreResult(SportsTeam team1, int t1_score,
                                   SportsTeam team2, int t2_score) {
        String message = team1.setScore(t1_score,t2_score);
        team2.setScore(t2_score,t1_score);
        System.out.printf("%s %s %s %n",team1,message,team2);
    }
    public static void scoreResult(Team team1, int t1_score,
                                   Team team2, int t2_score) {
        String message = team1.setScore(t1_score,t2_score);
        team2.setScore(t2_score,t1_score);
        System.out.printf("%s %s %s %n",team1,message,team2);
    }
}
