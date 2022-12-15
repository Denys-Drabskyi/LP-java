package com.lw3.game;

import com.lw3.attacks.Attack;
import com.lw3.droids.Droid;
import com.lw3.droids.SneakyDroid;
import com.lw3.droids.TankDroid;
import com.lw3.game.team.Team;
import com.lw3.record.json.GameDataDto;
import com.lw3.record.json.JsonConverter;
import com.lw3.record.json.JsonConverterData;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameImpl extends Game{
    private boolean firstTeamAttacks;

    private boolean recordedGame;

    private StringBuilder moves = new StringBuilder();
    private int round = 1;

    private GameDataDto gameDataDto;

    private InputStream defaultInputStream = System.in;

    public GameImpl() {
        Droid droid = new SneakyDroid("namebvghjghj",1,10,12);
        Droid droid1 = new TankDroid("name2",1,5,20);
        Droid droid2 = new TankDroid("name3",1,13,20);
        Droid droid3 = new TankDroid("name4",1,13,20);
        ArrayList<Droid> droids = new ArrayList<>();
        droids.add(droid);
        droids.add(droid2);
        ArrayList<Droid> droids1 = new ArrayList<>();
        droids1.add(droid1);
        droids1.add(droid3);

        this.team1 = new Team("team",droids);
        this.team2 = new Team("team1",droids1);
    }

    public GameImpl(Team team1, Team team2){
        this.team1 = team1;
        this.team2 = team2;
        firstRoundRandom();
        this.gameDataDto = GameDataDto.builder()
                .team1(team1)
                .team2(team2)
                .firstTeamAttacks(firstTeamAttacks)
                .build();
    }

    public GameImpl(GameDataDto gameDataDto){
        this.team1 = gameDataDto.getTeam1();
        this.team2 = gameDataDto.getTeam2();
        firstTeamAttacks = gameDataDto.isFirstTeamAttacks();
        this.recordedGame = true;
        System.setIn(new ByteArrayInputStream(gameDataDto.getMoves().getBytes()));
    }

    @Override
    public void run() {
        Team attackerTeam;
        Team defendingTeam;

//        if (!recordedGame)
//            firstRoundRandom();
        if (firstTeamAttacks){
            attackerTeam = team1;
            defendingTeam = team2;
        } else {
            attackerTeam = team2;
            defendingTeam = team1;
        }
        printRound(attackerTeam, defendingTeam);
        chooseDroidsAndAttack(attackerTeam,defendingTeam);
        gameEndOrNextRound(attackerTeam,defendingTeam);
    }

    private void gameEndOrNextRound(Team attackerTeam, Team defendingTeam){
        if (defendingTeam.droids().stream().noneMatch(droid -> droid.getHp() > 0)) {
            System.out.printf("\n%s перемогли", attackerTeam.name());
            if (!recordedGame)
                recordGame();
            else
                System.setIn(defaultInputStream);
        }
        else
        {
            firstTeamAttacks = !firstTeamAttacks;
            attackerTeamAttacksDecreaseCooldown(attackerTeam);
            round++;
            this.run();
        }
    }

    private void printRound(Team attackerTeam, Team defendingTeam){
        roundInfo(attackerTeam,defendingTeam);
        printDroidsInfo(attackerTeam,defendingTeam);
    }

    private void chooseDroidsAndAttack(Team attackerTeam, Team defendingTeam){
        Droid atcDroid = chooseDroid(attackerTeam, true);
        Droid defDroid = chooseDroid(defendingTeam, false);
        attack(atcDroid, defDroid);
        if (defendingTeam.droids().stream().noneMatch(droid -> droid.getHp() > 0))
            System.out.printf("%s перемогли",attackerTeam.name());
    }

    private int chooseAttack(Droid atcDroid) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder("\n" +
                "Виберіть атаку" +
                "\nДля інформації про атаку дублюйте її номер\n");
        int input = -1;
        for (int i = 0; i < 3; i++) {
            sb.append(String.format("\n| %d-> %s", i+1, atcDroid.getAttacks().get(i).getName()));
        }
        do {
            System.out.println(sb);
            input = sc.nextInt();
            moves.append(input).append(" ");
            if (input == 11)
                System.out.println(atcDroid.getAttacks().get(0).getShortDesc());
            if (input == 22)
                System.out.println(atcDroid.getAttacks().get(1).getShortDesc());
            if (input == 33)
                System.out.println(atcDroid.getAttacks().get(2).getShortDesc());
        }
        while (input<1 || input>3);
        return input;
    }

    private void attack(Droid atcDroid, Droid defDroid){
        int input = chooseAttack(atcDroid);
        if (!atcDroid.getAttacks().get(input-1).attack(atcDroid,defDroid)){
            System.out.println("ця атака ще не відновилася, зачекайте "+ atcDroid.getAttacks().get(input-1).getCoolDown()+" ходів");
            attack(atcDroid,defDroid);
        }
    }

    private void attackerTeamAttacksDecreaseCooldown(Team attackerTeam) {
        attackerTeam.droids().forEach(
                droid -> droid.getAttacks().forEach(Attack::reduceCoolDown)
        );
    }

    private Droid chooseDroid(Team team, boolean attacker) {
        Scanner sc = new Scanner(System.in);
        if (team.droids().size() == 1)
            return team.droids().get(0);
        else{

            int input = -1;

            List<Droid> liveDroids = team.droids().stream().filter(droid -> droid.getHp()>0).toList();

            do {
                if (attacker)
                    System.out.println("Виберіть дроїда для атаки");
                else
                    System.out.println("Виберіть дроїда якого атакувати");

                for (int i = 0; i < team.droids().size(); i++) {
                    if (liveDroids.contains(team.droids().get(i)))
                        System.out.printf("%d -> %s\n",i+1, team.droids().get(i).getName());
                    else
                        System.out.printf("dead -> %s\n", team.droids().get(i).getName());
                }
                input = sc.nextInt();
                moves.append(input).append(" ");
            } while (input<1 || input>team.droids().size());
            if (!liveDroids.contains(team.droids().get(input-1))){
                System.out.println("Не можна обрати мертвого дроїда");
                chooseDroid(team,attacker);
            }
            return team.droids().get(input-1);
        }
    }

    private void printDroidsInfo(Team attackerTeam, Team defendingTeam){
        for (int i = 0; i < attackerTeam.droids().size(); i++) {
            printPairOfDroids(attackerTeam.droids().get(i),defendingTeam.droids().get(i));
        }
        System.out.println("-------------------------------------------------------------");
    }

    private void printPairOfDroids(Droid attackerTeamDroid, Droid defendingTeamDroid) {
        StringBuilder sb = new StringBuilder();
        String s = String.format("""
                        |                                                         \t|
                        |\tdroid:\t%s%s\t\tdroid:\t%s%s|
                        |\ttype :\t%s%s\t\ttype :\t%s%s|
                        |\thp  =\t%s%s\t\thp  =\t%s%s|
                        |\tatc =\t%s%s\t\tatc =\t%s%s|
                        |\tdef =\t%s%s\t\tdef =\t%s%s|""",
                attackerTeamDroid.getName(),
                spacesPerNumber(16- attackerTeamDroid.getName().chars().count()),
                defendingTeamDroid.getName(),
                spacesPerNumber(16- defendingTeamDroid.getName().chars().count()),
                attackerTeamDroid.getClass().getSimpleName(),
                spacesPerNumber(16- attackerTeamDroid.getClass().getSimpleName().chars().count()),
                defendingTeamDroid.getClass().getSimpleName(),
                spacesPerNumber(16- defendingTeamDroid.getClass().getSimpleName().chars().count()),
                attackerTeamDroid.getHp(),
                spacesPerNumber(16-String.valueOf(attackerTeamDroid.getHp()).chars().count()),
                defendingTeamDroid.getHp(),
                spacesPerNumber(16-String.valueOf(defendingTeamDroid.getHp()).chars().count()),
                attackerTeamDroid.getAtc(),
                spacesPerNumber(16-String.valueOf(attackerTeamDroid.getAtc()).chars().count()),
                defendingTeamDroid.getAtc(),
                spacesPerNumber(16-String.valueOf(defendingTeamDroid.getAtc()).chars().count()),
                attackerTeamDroid.getDefence(),
                spacesPerNumber(16-String.valueOf(attackerTeamDroid.getDefence()).chars().count()),
                defendingTeamDroid.getDefence(),
                spacesPerNumber(16-String.valueOf(defendingTeamDroid.getDefence()).chars().count())

                );
        sb.append(s);
//        sb.append("\n-------------------------------------------------------------");
        System.out.println(sb);
    }

    private String spacesPerNumber(long spaces) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < spaces; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private void roundInfo(Team atcTeam, Team defTeam){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("--------------------------Round №%d---------------------------",round));
            sb.append("\n|\t\t")
                    .append(atcTeam.name())
                    .append(spacesPerNumber(20 - atcTeam.name().length()))
                    .append("->").append("\t\t ")
                    .append(defTeam.name())
                    .append(spacesPerNumber(20 - defTeam.name().length())).append("\t|");
        System.out.println(sb);
    }

    private void firstRoundRandom(){
        if (round == 1) {
            firstTeamAttacks = new Random().nextBoolean();
//            firstTeamStartsGame = firstTeamAttacks;
            if (firstTeamAttacks)
                System.out.println("Team "+team1.name()+ " attacks first");
            else
                System.out.println("Team "+team2.name()+" attacks first");
        }
    }

    private void recordGame(){
        JsonConverterData jsonConverterData = JsonConverter.convertToJsonConverterData();

        gameDataDto.setTime(LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yy hh:mm")));
        gameDataDto.setMoves(moves.toString());

        jsonConverterData.getGames().add(gameDataDto);
        JsonConverter.convertToJson(jsonConverterData);
    }
}
