package creature;

public class Creature {
    protected int coorX;
    protected int coorY;


    protected String name;

    /**
     * 用来标示生物状态，0为未上场，1为上场，-1为被踢出场外。
     */
    protected int creaStatus;//0表示没上场

    /**
     * 用来标示生物战场状态，0为未主动进行过战斗检定，1为主动进行过战斗检定。
     */
    protected int battleStatus;

    /**
     * 用来标示生物属性，true为好，false为坏
     */
    protected boolean kind;
    /**
     * 用来在控制台等地表示属性，也可以用来做标示
     */
    protected char symbolForCrea;

    public boolean isKind() {
        return kind;
    }

    public int getCoorX() {
        return coorX;
    }

    public int getCoorY() {
        return coorY;
    }

    public char getSymbolForCrea() {
        return symbolForCrea;
    }

    public String getName() {
        return name;
    }

    public void kicked() {
        creaStatus = -1;
    }

    public void reBitrh() {
        creaStatus = 0;
    }

    public void gotoBattle() {
        creaStatus = 1;
    }

    public int getCreaStatus() {
        return creaStatus;
    }

    public int getBattleStatus() {
        return battleStatus;
    }

    public boolean getKind()
    {

        return kind;
    }

    public void setBattleStatus(int battleStatus) {
        this.battleStatus = battleStatus;
    }

    /**
     * 设置坐标函数
     */
    public void moveToGoal(int coorX, int coorY) {
        this.coorX = coorX;
        this.coorY = coorY;
        System.out.println(name + "says: " + name + "move to Goal (" + coorX + "," + coorY + ")");
    }

}