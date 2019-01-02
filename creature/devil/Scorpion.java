package creature.devil;

import creature.Creature;

public class Scorpion extends Creature {

    private static int allNum= 0;

    public Scorpion() {

        if (allNum != 0)
            System.out.println("出事了，Scorpion有了");
        else {
            creaStatus =0;
            battleStatus=0;
            allNum++;
            coorX = coorY = -1;
            name = "Scorpion";
            symbolForCrea = 'x';
            kind = false;
            System.out.println(this.getName()+" success");
        }

    }

}
