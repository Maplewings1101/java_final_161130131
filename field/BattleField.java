package field;
import java.util.Random;
import creature.Creature;

public class BattleField {

    private int N;

    int justiceNumber;
    int devilNumber;

    /**
     * 用来标示战场状态，0为还没打完，1为正义必胜，-1为邪恶无敌。
     */
    int  battleAnswer;

    int justiceX;
    int justiceY;

    int devilX;
    int devilY;

    private Creature[][] creatures;

    public BattleField() {
        N = 20;
        creatures = new Creature[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                creatures[i][j] = null;
            }
        devilX = devilY = justiceX = justiceY = -1;
        justiceNumber = devilNumber = 8;
    }

    public void resetTheBattle()
    {

        justiceNumber=8;
        devilNumber=8;
        battleAnswer=0;

    }

    //第一次认为没问题
    public int fieldStateCheck()
    {
        if (justiceNumber == 0)
            return -1;
        else if (devilNumber == 0)
            return 1;
        if ((justiceNumber != 0) && (devilNumber != 0))
            return 0;
        return 0;
    }

    public void battleFiledFight() {
        boolean oneFightAnswer = true;

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (creatures[i][j] != null)
                {

                    if ((i == 19) && (j == 0)) {
                        if (creatures[i - 1][j] != null) {
                            if (oneFightAnswer == true)
                                oneFightAnswer = oneFigtht(creatures[i][j], creatures[i - 1][j]);
                            else
                                continue;
                        }
                        if (creatures[i][j + 1] != null) {
                            if (oneFightAnswer == true)
                                oneFightAnswer = oneFigtht(creatures[i][j], creatures[i][j + 1]);
                            else
                                continue;

                        }
                    }

                    else if ((i == 0) && (j == 19)) {
                        if (creatures[i + 1][j] != null) {
                            if (oneFightAnswer == true)
                                oneFightAnswer = oneFigtht(creatures[i][j], creatures[i + 1][j]);
                            else
                                continue;

                        }
                        if (creatures[i][j - 1] != null) {
                            if (oneFightAnswer == true)
                                oneFightAnswer = oneFigtht(creatures[i][j], creatures[i][j - 1]);
                            else
                                continue;

                        }
                    }
                    else if ((i == 19) && (j == 19)) {
                        if (creatures[i - 1][j] != null) {
                            if (oneFightAnswer == true)
                                oneFightAnswer = oneFigtht(creatures[i][j], creatures[i - 1][j]);
                            else
                                continue;

                        }
                        if (creatures[i][j - 1] != null) {
                            if (oneFightAnswer == true)
                                oneFightAnswer = oneFigtht(creatures[i][j], creatures[i][j - 1]);
                            else
                                continue;

                        }
                    }
                    else if ((i == 0) && (j == 0)) {

                        if (creatures[i + 1][j] != null) {
                            if (oneFightAnswer == true)
                                oneFightAnswer = oneFigtht(creatures[i][j], creatures[i + 1][j]);
                            else
                                continue;

                        }
                        if (creatures[i][j + 1] != null) {
                            if (oneFightAnswer == true)
                                oneFightAnswer = oneFigtht(creatures[i][j], creatures[i][j + 1]);
                            else
                                continue;

                        }


                    }
                    else if ((i == 0) && ((j > 0) && (j < 19))) {
                        if (creatures[i + 1][j] != null) {
                            if (oneFightAnswer == true)
                                oneFightAnswer = oneFigtht(creatures[i][j], creatures[i + 1][j]);
                            else
                                continue;

                        }
                        if (creatures[i][j + 1] != null) {
                            if (oneFightAnswer == true)
                                oneFightAnswer = oneFigtht(creatures[i][j], creatures[i][j + 1]);
                            else
                                continue;

                        }


                        if (creatures[i][j - 1] != null) {
                            if (oneFightAnswer == true)
                                oneFightAnswer = oneFigtht(creatures[i][j], creatures[i][j - 1]);
                            else
                                continue;

                        }
                    }
                    else if ((i == 19) && ((j > 0) && (j < 19))) {
                        if (creatures[i - 1][j] != null) {
                            if (oneFightAnswer == true)
                                oneFightAnswer = oneFigtht(creatures[i][j], creatures[i - 1][j]);
                            else
                                continue;

                        }
                        if (creatures[i][j + 1] != null) {
                            if (oneFightAnswer == true)
                                oneFightAnswer = oneFigtht(creatures[i][j], creatures[i][j + 1]);
                            else
                                continue;

                        }


                        if (creatures[i][j - 1] != null) {
                            if (oneFightAnswer == true)
                                oneFightAnswer = oneFigtht(creatures[i][j], creatures[i][j - 1]);
                            else
                                continue;

                        }
                    }
                    else if ((j == 0) && ((i > 0) && (i < 19))) {

                        if (creatures[i + 1][j] != null) {
                            if (oneFightAnswer == true)
                                oneFightAnswer = oneFigtht(creatures[i][j], creatures[i + 1][j]);
                            else
                                continue;

                        }
                        if (creatures[i - 1][j] != null) {
                            if (oneFightAnswer == true)
                                oneFightAnswer = oneFigtht(creatures[i][j], creatures[i - 1][j]);
                            else
                                continue;

                        }


                        if (creatures[i][j + 1] != null) {
                            if (oneFightAnswer == true)
                                oneFightAnswer = oneFigtht(creatures[i][j], creatures[i][j + 1]);
                            else
                                continue;

                        }
                    }
                    else if ((j == 19) && ((j > 0) && (j < 19))) {
                        if (creatures[i + 1][j] != null) {
                            if (oneFightAnswer == true)
                                oneFightAnswer = oneFigtht(creatures[i][j], creatures[i + 1][j]);
                            else
                                continue;

                        }
                        if (creatures[i - 1][j] != null) {
                            if (oneFightAnswer == true)
                                oneFightAnswer = oneFigtht(creatures[i][j], creatures[i - 1][j]);
                            else
                                continue;

                        }


                        if (creatures[i][j - 1] != null) {
                            if (oneFightAnswer == true)
                                oneFightAnswer = oneFigtht(creatures[i][j], creatures[i][j - 1]);
                            else
                                continue;

                        }
                    }
                    else {

                        if (creatures[i + 1][j] != null) {
                            if (oneFightAnswer == true)
                                oneFightAnswer = oneFigtht(creatures[i][j], creatures[i + 1][j]);
                            else
                                continue;

                        }


                        if (creatures[i - 1][j] != null) {
                            if (oneFightAnswer == true)
                                oneFightAnswer = oneFigtht(creatures[i][j], creatures[i - 1][j]);
                            else
                                continue;

                        }


                        if (creatures[i][j + 1] != null) {
                            if (oneFightAnswer == true)
                                oneFightAnswer = oneFigtht(creatures[i][j], creatures[i][j + 1]);
                            else
                                continue;

                        }


                        if (creatures[i - 1][j] != null) {
                            if (oneFightAnswer == true)
                                oneFightAnswer = oneFigtht(creatures[i][j], creatures[i - 1][j]);
                            else
                                continue;

                        }
                    }
                }
    }

    private boolean oneFigtht(Creature a,Creature b) {
        if (a.getKind() == b.getKind())
            return true;
        else {
            Random ra = new Random();
            if ((ra.nextInt(10) + 1) > 5) {
                kickCreaOut(a);
                return true;
            } else {
                kickCreaOut(b);
                return false;
            }
        }
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

    /**
     * 开打了
     */
    public int startTheBattle()
    {
        //应当有战场初始化check；
        justiceNumber=8;
        devilNumber=8;
        battleAnswer=0;

        while(true)

        {
            battleAnswer = fieldStateCheck();
            if (battleAnswer == 0)
            {
                battleAdvance();

                battleFiledFight();
            }
            else

                return battleAnswer;//打完了
        }
    }

    public void battleAdvance() {
        int goalX = 0;
        int goalY = 0;

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (creatures[i][j] != null) {
                    goalX = getOneStepGoalX(i, j);
                    goalY = getOnestepGoalY(i, j);
                    System.out.println(goalX + "," + goalY);
                    if (isPositionEmpty(i, j))
                        creatures[i][j].moveToGoal(i, j);
                }

    }

    private int getOneStepGoalX(int i, int j) {

        int diffX = 0;
        int diffY = 0;
        boolean cKind = creatures[i][j].getKind();

        if (cKind == true) {
            devilX = getDevilX();
            devilY = getDevilY();

            diffX = (i - devilX);
            diffY = (j - devilY);

        } else {
            justiceX = getJusticeX();
            justiceY = getJusticeY();

            diffX = (i - justiceX);
            diffY = (j - justiceY);
        }
        if (diffX == 0)
            return i;
        else if (diffY == 0)
            return i + diffX / Math.abs(diffX);
        else if (Math.abs(diffX) > Math.abs(diffY)) {
            return i + Math.abs(diffX);
        } else if (Math.abs(diffX) < Math.abs(diffY)) {
            return i + diffX / Math.abs((diffX));
        } else if (Math.abs(diffX) == Math.abs(diffY)) {
            return i;//选择y轴变化
        }

        return 0;
    }

    private int getOnestepGoalY(int i, int j) {

        int diffX = 0;
        int diffY = 0;
        boolean cKind = creatures[i][j].getKind();

        if (cKind == true) {
            devilX = getDevilX();
            devilY = getDevilY();

            diffX = (i - devilX);
            diffY = (j - devilY);

        } else {
            justiceX = getJusticeX();
            justiceY = getJusticeY();

            diffX = (i - justiceX);
            diffY = (j - justiceY);
        }
        if (diffX == 0)
            return j + diffY / Math.abs((diffY));
        else if (diffY == 0)
            return j;
        else if (Math.abs(diffX) > Math.abs(diffY)) {
            return j;
        } else if (Math.abs(diffX) < Math.abs(diffY)) {
            return j + diffY / Math.abs((diffY));
        } else if (Math.abs(diffX) == Math.abs(diffY)) {
            return j + diffY / Math.abs(diffY);//选择y轴变化
        }

        return 0;
    }

    private int getDevilX() {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (creatures[i][j] != null)
                    if (creatures[i][j].getKind() == false)
                        return i;
        return -1;
    }

    private int getDevilY() {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (creatures[i][j] != null)
                if (creatures[i][j].getKind() == false)
                    return j;
        return -1;
    }

    private int getJusticeX() {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (creatures[i][j] != null)
                    if (creatures[i][j].getKind() == true)
                        return i;
        return -1;
    }

    private int getJusticeY() {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (creatures[i][j] != null)
                    if (creatures[i][j].getKind() == true)
                        return j;
        return -1;
    }

    public Creature[][] getCreatures() {
        return creatures;
    }

    private boolean isPositionEmpty(int x, int y) {
        return creatures[x][y] == null;
    }

    public void printBattleFieldStatues() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isPositionEmpty(i, j))
                    System.out.print("- ");
                else
                    System.out.print(creatures[i][j].getSymbolForCrea() + " ");
                //System.out.println();
            }
            System.out.println();
        }
    }

    private void moveCreatureOut(Creature creature) {
        if (creature != null) {
            creatures[creature.getCoorX()][creature.getCoorY()] = null;
            creature.moveToGoal(-1, -1);
        }
    }

    private void kickCreaOut(Creature a) {
        if (a.getKind() == true)
            justiceNumber--;
        else
            devilNumber--;
        //  int x=a.getCoorX();
        //  int y=a.getCoorY();
        moveCreatureOut(a);
        a.kicked();
        //  moveSpecialCreatureOut();
    }

    //留作以后扩展用。谁打死了谁就出去。
    public void moveSpecialCreatureOut(Creature creature) {
        moveCreatureOut(creature);
    }

    private void setCreatureToPositon(Creature creature, int inputX, int inputY) {
        if (isPositionEmpty(inputX, inputY)) {
            creatures[inputX][inputY] = creature;
            creature.moveToGoal(inputX, inputY);
        } else {
            System.out.println("thispersion Have a PeoPLE");
        }
    }

    public void getMessageFromControl(Control control) {
        creatures = control.getCreatures();
    }
}