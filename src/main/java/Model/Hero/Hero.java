package Model.Hero;

public interface Hero {

    String heroName();
    String heroFlag();
    int heroLevel();
    int co_x();
    int co_y();
    int Attack();
    int Defence();
    int HP();
    int XP();
    void setCo_x(int co_x);
    void setCo_y(int co_y);
    void setHeroLevel(int heroLevel);
    void setHeroAttack(int heroAttack);
    void setHeroDefence(int heroDefence);
    void setHeroHP(int heroHP);
    void setHeroXP(int heroXP);
}
