package field;


import creature.Creature;

public class Control {

    private int N;

    int JleaderX,JleaderY,DleaderX,DleaderY;
    int justiceNumber;
    int devilNumber;


    private Creature[][] creatures;

    public Control() {
        N = 20;
        creatures = new Creature[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                creatures[i][j] = null;
            }
        JleaderX = 9;
        JleaderY = 9;
        DleaderX = 9;
        DleaderY = 11;
        justiceNumber=8;
        devilNumber=8;

    }

    public int getJusticeNumber() {
        return justiceNumber;
    }

    public int getDevilNumber() {
        return devilNumber;
    }

    public void setJusticeNumber(int justiceNumber) {
        this.justiceNumber = justiceNumber;
    }


    public void setdevilNumber(int devilNumber) {
        this.justiceNumber = devilNumber;
    }



    private boolean isPositionEmpty(int x, int y) {
        return creatures[x][y] == null;
    }

    public Creature[][] getCreatures() {
        return creatures;
    }

    private void setCreatureToPositon(Creature creature, int inputX, int inputY) {
        if (isPositionEmpty(inputX, inputY)) {
            creatures[inputX][inputY] = creature;
            creature.moveToGoal(inputX, inputY);
        } else {
            System.out.println("thispersion Have a PeoPLE");
        }
    }

    public  void getBattleField(BattleField battleField) {
        creatures = battleField.getCreatures();
    }


    public void clearBattleField() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                try {
                    moveCreatureOut(creatures[i][j]);
                } catch (Exception e) {
                    System.out.println(i);
                    System.out.println(j);
                }
        }
    }

    public void clearLeftBattleField() {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N / 2; j++)
                try {
                    moveCreatureOut(creatures[i][j]);
                } catch (Exception e) {
                    System.out.println(i);
                    System.out.println(j);
                }
    }

    public void clearRightBattleField() {
        for (int i = 0; i < N; i++) {
            for (int j = N / 2 + 1; j < N; j++)
            try {
                moveCreatureOut(creatures[i][j]);
            }
            catch (Exception e)
            {
                System.out.println(i);
                System.out.println(j);
            }
        }
    }

    private void moveCreatureOut(Creature creature) {
        if (creature != null) {
            creatures[creature.getCoorX()][creature.getCoorY()] = null;
            creature.moveToGoal(-1, -1);
        }
    }


    public  void setImportantCrea(Creature grad,Creature snake)
    {
        setCreatureToPositon(grad,18,8);
        setCreatureToPositon(snake,2,18);
    }


    public void makeJusticeHeyi(Creature[] calas,Creature grad) {
        clearLeftBattleField();
        setCreatureToPositon(grad,18,8);
        setCreatureToPositon(calas[0], JleaderX, JleaderY);
        setCreatureToPositon(calas[1], JleaderX - 1, JleaderY - 1);
        setCreatureToPositon(calas[2], JleaderX - 2, JleaderY - 2);
        setCreatureToPositon(calas[3], JleaderX - 3, JleaderY - 3);
        setCreatureToPositon(calas[4], JleaderX + 1, JleaderY - 1);
        setCreatureToPositon(calas[5], JleaderX + 2, JleaderY - 2);
        setCreatureToPositon(calas[6], JleaderX + 3, JleaderY - 3);
    }

    public void makeDevilHeyi(Creature[] devils,Creature snake) {

        clearRightBattleField();
        setCreatureToPositon(snake,2,18);
        setCreatureToPositon(devils[0], DleaderX, DleaderY);
        setCreatureToPositon(devils[1], DleaderX - 1, DleaderY + 1);
        setCreatureToPositon(devils[2], DleaderX - 2, DleaderY + 2);
        setCreatureToPositon(devils[3], DleaderX - 3, DleaderY + 3);
        setCreatureToPositon(devils[4], DleaderX + 1, DleaderY + 1);
        setCreatureToPositon(devils[5], DleaderX + 2, DleaderY + 2);
        setCreatureToPositon(devils[6], DleaderX + 3, DleaderY + 3);
    }

    public void makeJusticeYanxing(Creature[] calas,Creature grad) {

        clearLeftBattleField();
        setCreatureToPositon(grad,18,8);
        setCreatureToPositon(calas[0], JleaderX, JleaderY);
        setCreatureToPositon(calas[1], JleaderX - 1, JleaderY - 1);
        setCreatureToPositon(calas[2], JleaderX - 2, JleaderY - 2);
        setCreatureToPositon(calas[3], JleaderX - 3, JleaderY - 3);
        setCreatureToPositon(calas[4], JleaderX - 4, JleaderY - 4);
        setCreatureToPositon(calas[5], JleaderX - 5, JleaderY - 5);
        setCreatureToPositon(calas[6], JleaderX - 6, JleaderY - 6);
    }

    public void makeDevilYanxing(Creature[] devils,Creature snake) {

        clearRightBattleField();
        setCreatureToPositon(snake,2,18);
        setCreatureToPositon(devils[0], DleaderX, DleaderY);
        setCreatureToPositon(devils[1], DleaderX - 1, DleaderY + 1);
        setCreatureToPositon(devils[2], DleaderX - 2, DleaderY + 2);
        setCreatureToPositon(devils[3], DleaderX - 3, DleaderY + 3);
        setCreatureToPositon(devils[4], DleaderX - 4, DleaderY + 4);
        setCreatureToPositon(devils[5], DleaderX - 5, DleaderY + 5);
        setCreatureToPositon(devils[6], DleaderX - 6, DleaderY + 6);
    }

    public void makeJusticeHenge(Creature[] calas,Creature grad) {

        clearLeftBattleField();
        setCreatureToPositon(grad,18,8);
        setCreatureToPositon(calas[0], JleaderX, JleaderY);
        setCreatureToPositon(calas[1], JleaderX - 1, JleaderY - 1);
        setCreatureToPositon(calas[2], JleaderX + 1, JleaderY - 1);
        setCreatureToPositon(calas[3], JleaderX - 2, JleaderY);
        setCreatureToPositon(calas[4], JleaderX + 2, JleaderY);
        setCreatureToPositon(calas[5], JleaderX - 3, JleaderY - 1);
        setCreatureToPositon(calas[6], JleaderX + 3, JleaderY - 1);
    }

    public void makeDevilHenge(Creature[] devils,Creature snake) {

        clearRightBattleField();
        setCreatureToPositon(snake,2,18);
        setCreatureToPositon(devils[0], DleaderX, DleaderY);
        setCreatureToPositon(devils[1], DleaderX - 1, DleaderY + 1);
        setCreatureToPositon(devils[2], DleaderX + 1, DleaderY + 1);
        setCreatureToPositon(devils[3], DleaderX - 2, DleaderY);
        setCreatureToPositon(devils[4], DleaderX + 2, DleaderY);
        setCreatureToPositon(devils[5], DleaderX - 3, DleaderY + 1);
        setCreatureToPositon(devils[6], DleaderX + 3, DleaderY + 1);
    }

    public void makeJusticeChangshe(Creature[] calas,Creature grad) {

        clearLeftBattleField();
        setCreatureToPositon(grad,18,8);
        setCreatureToPositon(calas[0], JleaderX, JleaderY);
        setCreatureToPositon(calas[1], JleaderX - 1, JleaderY);
        setCreatureToPositon(calas[2], JleaderX + 1, JleaderY);
        setCreatureToPositon(calas[3], JleaderX - 2, JleaderY);
        setCreatureToPositon(calas[4], JleaderX + 2, JleaderY);
        setCreatureToPositon(calas[5], JleaderX - 3, JleaderY);
        setCreatureToPositon(calas[6], JleaderX + 3, JleaderY);
    }

    public void makeDevilChangshe(Creature[] devils,Creature snake) {

        clearRightBattleField();
        setCreatureToPositon(snake,2,18);


        setCreatureToPositon(devils[0], DleaderX, DleaderY);
        setCreatureToPositon(devils[1], DleaderX - 1, DleaderY);
        setCreatureToPositon(devils[2], DleaderX + 1, DleaderY);
        setCreatureToPositon(devils[3], DleaderX - 2, DleaderY);
        setCreatureToPositon(devils[4], DleaderX + 2, DleaderY);
        setCreatureToPositon(devils[5], DleaderX - 3, DleaderY);
        setCreatureToPositon(devils[6], DleaderX + 3, DleaderY);
    }

    public void makeJusticeYuling(Creature[] calas,Creature grad) {

        clearLeftBattleField();
        setCreatureToPositon(grad,18,8);
        setCreatureToPositon(calas[0], JleaderX, JleaderY);
        setCreatureToPositon(calas[1], JleaderX - 1, JleaderY - 1);
        setCreatureToPositon(calas[2], JleaderX + 1, JleaderY - 1);
        setCreatureToPositon(calas[3], JleaderX, JleaderY - 1);
        setCreatureToPositon(calas[4], JleaderX - 1, JleaderY - 2);
        setCreatureToPositon(calas[5], JleaderX, JleaderY - 2);
        setCreatureToPositon(calas[6], JleaderX + 1, JleaderY - 2);
    }

    public void makeDevilYuling(Creature[] devils,Creature snake) {

        clearRightBattleField();
        setCreatureToPositon(snake,2,18);
        setCreatureToPositon(devils[0], DleaderX, DleaderY);
        setCreatureToPositon(devils[1], DleaderX - 1, DleaderY + 1);
        setCreatureToPositon(devils[2], DleaderX + 1, DleaderY + 1);
        setCreatureToPositon(devils[3], DleaderX, DleaderY + 1);
        setCreatureToPositon(devils[4], DleaderX - 1, DleaderY + 2);
        setCreatureToPositon(devils[5], DleaderX + 1, DleaderY + 2);
        setCreatureToPositon(devils[6], DleaderX, DleaderY + 2);
    }

    public void makeJusticeFangmeng(Creature[] calas,Creature grad) {

        clearLeftBattleField();
        setCreatureToPositon(grad,18,8);
        setCreatureToPositon(calas[0], JleaderX, JleaderY);
        setCreatureToPositon(calas[1], JleaderX - 1, JleaderY - 1);
        setCreatureToPositon(calas[2], JleaderX - 2, JleaderY - 2);
        setCreatureToPositon(calas[3], JleaderX - 1, JleaderY - 3);
        setCreatureToPositon(calas[4], JleaderX + 1, JleaderY - 1);
        setCreatureToPositon(calas[5], JleaderX + 2, JleaderY - 2);
        setCreatureToPositon(calas[6], JleaderX + 1, JleaderY - 3);
    }

    public void makeDevilFangmeng(Creature[] devils,Creature snake) {

        clearRightBattleField();
        setCreatureToPositon(snake,2,18);


        setCreatureToPositon(devils[0], DleaderX, DleaderY);
        setCreatureToPositon(devils[1], DleaderX - 1, DleaderY + 1);
        setCreatureToPositon(devils[2], DleaderX - 2, DleaderY + 2);
        setCreatureToPositon(devils[3], DleaderX - 1, DleaderY + 3);
        setCreatureToPositon(devils[4], DleaderX + 1, DleaderY + 1);
        setCreatureToPositon(devils[5], DleaderX + 2, DleaderY + 2);
        setCreatureToPositon(devils[6], DleaderX + 1, DleaderY + 3);
    }

    public void makeJusticeYanyue(Creature[] calas,Creature grad) {

        clearLeftBattleField();
        setCreatureToPositon(grad,18,8);
        setCreatureToPositon(calas[0], JleaderX, JleaderY);
        setCreatureToPositon(calas[1], JleaderX + 1, JleaderY);
        setCreatureToPositon(calas[2], JleaderX - 1, JleaderY);
        setCreatureToPositon(calas[3], JleaderX + 1, JleaderY - 1);
        setCreatureToPositon(calas[4], JleaderX - 1, JleaderY - 1);
        setCreatureToPositon(calas[5], JleaderX + 2, JleaderY - 2);
        setCreatureToPositon(calas[6], JleaderX - 2, JleaderY - 2);
    }

    public void makeDevilYanyue(Creature[] devils,Creature snake) {

        clearRightBattleField();
        setCreatureToPositon(snake,2,18);
        setCreatureToPositon(devils[0], DleaderX, DleaderY);
        setCreatureToPositon(devils[1], DleaderX + 1, DleaderY);
        setCreatureToPositon(devils[2], DleaderX - 1, DleaderY);
        setCreatureToPositon(devils[3], DleaderX + 1, DleaderY + 1);
        setCreatureToPositon(devils[4], DleaderX - 1, DleaderY + 1);
        setCreatureToPositon(devils[5], DleaderX + 2, DleaderY + 2);
        setCreatureToPositon(devils[6], DleaderX - 2, DleaderY + 2);
    }

    public void makeJusticeFengshi(Creature[] calas,Creature grad) {

        clearLeftBattleField();
        setCreatureToPositon(grad,18,8);
        setCreatureToPositon(calas[0], JleaderX, JleaderY);
        setCreatureToPositon(calas[1], JleaderX - 1, JleaderY - 1);
        setCreatureToPositon(calas[2], JleaderX - 2, JleaderY - 2);
        setCreatureToPositon(calas[3], JleaderX + 1, JleaderY - 1);
        setCreatureToPositon(calas[4], JleaderX + 2, JleaderY - 2);
        setCreatureToPositon(calas[5], JleaderX, JleaderY - 1);
        setCreatureToPositon(calas[6], JleaderX, JleaderY - 2);
    }

    public void makeDevilFengshi(Creature[] devils,Creature snake) {
        clearRightBattleField();
        setCreatureToPositon(snake,2,18);
        setCreatureToPositon(devils[0], DleaderX, DleaderY);
        setCreatureToPositon(devils[1], DleaderX - 1, DleaderY + 1);
        setCreatureToPositon(devils[2], DleaderX - 2, DleaderY + 2);
        setCreatureToPositon(devils[3], DleaderX + 1, DleaderY + 1);
        setCreatureToPositon(devils[4], DleaderX + 2, DleaderY + 2);
        setCreatureToPositon(devils[5], DleaderX, DleaderY + 1);
        setCreatureToPositon(devils[6], DleaderX, DleaderY + 2);
    }
}