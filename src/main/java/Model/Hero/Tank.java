package Model.Hero;

public class Tank implements Hero{

    private final String heroName;
    private final String heroFlag;
    private int heroLevel;
    private int heroAttack;
    private int heroDefence;
    private int heroHP;
    private int heroXP;
    private int co_x;
    private int co_y;

    public Tank() {
        this.heroName = "Tank";
        this.heroFlag = "T";

        setHeroXP(0);
        setHeroLevel(1);
        setHeroAttack(45);
        setHeroDefence(100);
        setHeroHP(120);
    }

    public void setHeroLevel(int heroLevel) {
        this.heroLevel = heroLevel;
    }

    public void setHeroAttack(int heroAttack) {
        this.heroAttack = heroAttack;
    }

    public void setHeroDefence(int heroDefence) {
        this.heroDefence = heroDefence;
    }

    public void setHeroHP(int heroHP) {
        this.heroHP = heroHP;
    }

    public void setHeroXP(int heroXP) {
        this.heroXP = heroXP;
    }

    public void setCo_x(int co_x) {
        this.co_x = co_x;
    }

    public void setCo_y(int co_y) {
        this.co_y = co_y;
    }

    @Override
    public String heroName() {
        return this.heroName;
    }

    @Override
    public String heroFlag() {
        return this.heroFlag;
    }

    @Override
    public int heroLevel() {
        return this.heroLevel;
    }

    @Override
    public int co_x() {
        return this.co_x;
    }

    @Override
    public int co_y() {
        return this.co_y;
    }

    @Override
    public int Attack() {
        return this.heroAttack;
    }

    @Override
    public int Defence() {
        return this.heroDefence;
    }

    @Override
    public int HP() {
        return this.heroHP;
    }

    @Override
    public int XP() {
        return this.heroXP;
    }
}
