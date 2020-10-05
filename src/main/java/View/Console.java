package View;

import Model.Hero.Hero;
import Model.Hero.Knight;
import Model.Hero.Tank;
import Model.Map;
import Model.Villain.Villain1;

import javax.validation.constraints.Min;
import java.util.Random;
import java.util.Scanner;

public class Console implements Idisplay {

    private Hero hero;
    private Map map;
    private Villain1 villain1;
    private Villain1 villain2;

    public Console(){
        map = new Map();
        villain1 = new Villain1();
        villain2 = new Villain1();
    }

    @Override
    public void initGame() {
        getHero();
        setMap();
    }
    @Override
    public void getHero() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Select option below");
        System.out.println("1 Select HERO");
        System.out.println("2 Create HERO");

        if(input.hasNextInt()){
            int choose = input.nextInt();
            if(choose == 1){
//                System.err.println("SElect HerO Delet when done !!!!");
                selectHero();
            }else if(choose == 2){
//                System.err.println("CreaT HeRo DelEte When Done !!!!");
                createHero();
            }else{
                System.err.println("Invalid Input");
                getHero();
            }
        }else {
            System.out.println("Something went wrong getting selection");
        }
    }
    @Override
    public void selectHero() {
        promptHeroName();
    }
    private void promptHeroName(){
        Scanner input = new Scanner(System.in);
        System.out.print("Please Choose Hero Type\n" +
                "1. Knight\n"+
                "2. Tank\n");
        if (input.hasNextInt()){
            int _heroType = input.nextInt();
            if (_heroType == 1){
                hero = new Knight();
            }
            else if(_heroType == 2){
                hero = new Tank();
            }
            else{
                System.err.println("Invalid Entry....");
                promptHeroName();
            }
        }
        else{
            System.err.println("Invalid Entry....");
        }
    }

    private void setMap(){
        map.setSize(hero.heroLevel());
        hero.setCo_x(map.getSize()/2);
        hero.setCo_y(map.getSize()/2);

        setVillain1();
        setVillain2();
    }
    @Min(1)
    private void setVillain1(){
        int x = new Random().nextInt(map.getSize());
        int y = new Random().nextInt(map.getSize());
        if (x == (map.getSize()) && y == (map.getSize())){
            setVillain1();
        }else {
            villain1.setVillain_X_Cor(x);
            villain1.setVillain_Y_Cor(y);
        }
    }

    private void setVillain2(){
        int x = new Random().nextInt(map.getSize());
        int y = new Random().nextInt(map.getSize());
        if (x == (map.getSize()) && y == (map.getSize())){
            setVillain1();
        }else {
            villain2.setVillain_X_Cor(x);
            villain2.setVillain_Y_Cor(y);
        }
    }

    private void canLevelUp(){
        if (hero.XP() >= nextLevel()){
            hero.setHeroLevel(hero.heroLevel()+1);
            setMap();
            playGame();
        }
    }

    private int nextLevel(){
        return (int) (hero.heroLevel() * 1000+ Math.pow((hero.heroLevel() - 1), 2)*450);
    }

    private void populateMap(){
        map.updatePosition(hero.co_x(),hero.co_y(),hero.heroFlag());
        map.updatePosition(villain1.villain_X_Cor(),villain1.villain_Y_Cor(),villain1.villainFlag());
        map.updatePosition(villain2.villain_X_Cor(),villain2.villain_Y_Cor(),villain2.villainFlag());
        map.updatePosition(villain1.villain_X_Cor(),villain1.villain_Y_Cor(),villain1.villainFlag());


    }

    private void movement(){
        canLevelUp();
        Scanner input = new Scanner(System.in);

        System.out.println("Please Make a Move\n" +
                "1. Move North\n" +
                "2. Move East\n" +
                "3. Move South\n"+
                "4. Move West\n" +
                "Enter 0 to Exit");

        if (input.hasNextInt()){
            int _heroMove = input.nextInt();
            switch (_heroMove) {
                case 0:
                  end();
                    break;
                case 1:
                    moveNorth();
                    break;
                case 2:
                    moveEast();
                    break;
                case 3:
                    moveSouth();
                    break;
                case 4:
                    moveWest();
                    break;
                default:
                    System.err.println("Invalid Entry....");
            }
            hero.setHeroXP(hero.XP() + 10);
        }else {
            System.err.println("Invalid Entry....");
            movement();
        }
        map.printMap();
        movement();
    }


    private void end(){
        System.exit(1);
    }
    private void moveNorth(){
        if(hero.co_x() == 0){
            endGame();
        }
        hero.setCo_x(hero.co_x() - 1);
        letsFight(isFight(), hero.co_x() + 1,hero.co_y());
        map.updatePosition(hero.co_x()+1,hero.co_y(),null);
        map.updatePosition(hero.co_x(),hero.co_y(),hero.heroFlag());
    }

    private void moveSouth(){

        if(hero.co_x() == map.getSize() - 1){
            endGame();
        }
        hero.setCo_x(hero.co_x() + 1);
        letsFight(isFight(), hero.co_x() - 1,hero.co_y());
        map.updatePosition(hero.co_x() - 1,hero.co_y(),null);
        map.updatePosition(hero.co_x(),hero.co_y(),hero.heroFlag());
    }

    private void moveEast(){

        if(hero.co_y() == map.getSize() - 1){
            endGame();
        }
        hero.setCo_y(hero.co_y() + 1);
        letsFight(isFight(), hero.co_x(),hero.co_y() - 1);
        map.updatePosition(hero.co_x(),hero.co_y() - 1,null);
        map.updatePosition(hero.co_x(),hero.co_y(),hero.heroFlag());
    }

    private void moveWest(){
        if(hero.co_y() == 0){

        }
        hero.setCo_y(hero.co_y() - 1);
        letsFight(isFight(), hero.co_x() ,hero.co_y() + 1);
        map.updatePosition(hero.co_x(),hero.co_y() + 1,null);
        map.updatePosition(hero.co_x(),hero.co_y(),hero.heroFlag());
    }

    private boolean isFight(){
        if ((hero.co_x() == villain1.villain_X_Cor()) &&
                (hero.co_y() == villain1.villain_Y_Cor())){
            return true;
        }
        else if ((hero.co_x() == villain2.villain_X_Cor()) &&
                (hero.co_y() == villain2.villain_Y_Cor())){
            return true;
        }
        else return (hero.co_x() == villain1.villain_X_Cor()) &&
                    (hero.co_y() == villain1.villain_Y_Cor());
    }

    private void letsFight(Boolean fight, int x, int y){
        if(fight){
            Scanner input = new Scanner(System.in);
            System.out.println("Oops looks like you have stumbled onto a villain \nDo you wish to fight \n1. Yes \n2. No");
            int fighting = input.nextInt();
            if(fighting == 1){
                fight();
                map.updatePosition(hero.co_x()+1,hero.co_y(),null);
            }else {
                hero.setCo_x(x);
                hero.setCo_y(y);
            }
        }
    }

    private void reMove(Villain1 villain1){
        villain1.setVillain_X_Cor(-1);
        villain1.setVillain_Y_Cor(-1);
    }

    private void fightVillain(){
        int Power = villain1.villain_Attack() + villain1.villain_Defence() + villain1.villain_HP();
        int heroPower = hero.Attack() + hero.Defence()+ hero.HP();
        int luck = new Random().nextInt(3);

        if (Power > heroPower*luck){
            System.out.println((villain1.villainName()+" Wins"));
            printStat();
        }
        else {
            reMove(villain1);
            hero.setHeroAttack(hero.Attack() + 80);
            hero.setHeroDefence(hero.Defence() + 80);
            hero.setHeroHP(hero.HP() + 80);
            hero.setHeroXP(hero.XP() + 1800);
            System.out.println("You defeated "+villain1.villainName()+"\n You have been upgraded");
        }
    }

    private void fight(){
        if ((hero.co_x() == villain1.villain_X_Cor()) &&
                (hero.co_y() == villain1.villain_Y_Cor())){

            System.out.println("\n");
            fightVillain();
            System.out.println("\n");
        }
        if ((hero.co_x() == villain2.villain_X_Cor()) &&
                (hero.co_y() == villain2.villain_Y_Cor())){

            System.out.println("\n");
            fightVillain();
            System.out.println("\n");
        }
    }

    private void endGame(){

        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to continue\n" +
                "1. Yes\n2. No \n"+
                "Enter 0 to Exit");
        int opt = input.nextInt();{
            if (opt == 1){
                setMap();
                playGame();
            }
        }
        System.exit(1);
    }

    @Override
    public void createHero() {
    }
    @Override
    public void printStat() {
        System.out.println("\nHeroName   : "+(hero.heroName())
                +"\nXP         : "+hero.XP()
                +"\nLevel      : "+hero.heroLevel()
                +"\nAttack     : "+hero.Attack()
                +"\nDefence    : "+hero.Defence()
                +"\nHit Points : "+hero.HP());
    }
    @Override
    public void playGame() {
        map.setSize(hero.heroLevel());
        map.setBoard();
        populateMap();
        map.printMap();
        movement();
    }
}
