# java Final Project 设计思路

标签（空格分隔）： JavaHw

---

##需求分析
由于采用javafx架构进行图形化架构，故必须在javafx限定的框架下进行数据传输。


##类的建立
本次作业根据需求建立不同的类别。
###未实现的功能
    多线程，maven管理，文件存储与读取，战局输出
###creature包
    creature包下属一个父类Creature:
```java
public class Creature {
    protected int coorX;//坐标表示
    protected int coorY;
    protected String name;
    /**
     * 用来标示生物属性，true为好，false为坏
     */
    protected boolean kind;
    /**
     * char用来在控制台等地表示属性，也可以用来做标示
     */
    protected char symbolForCrea;
    /**
    * 设置坐标函数
    */
    public void moveToGoal(int coorX, int coorY);
    //其余设计并未用到
```   
    后有不同的类，继承Creature为子类
| 所属包 | 类名 |
| ------: | :------: |
| justice | Calabashs |
| |GrandFather |
|devil|Mobs|
||Snake|
||Scorpion|

在子类中（以GrandFather为例），利用allNum标识，防止过度初始化
```java
 private static int allNum = 0;
 public class Grandfather extends Creature {
    public Grandfather() {
        if (allNum != 0) {
            System.out.println("出事了，爷爷有了");
        } else {
            allNum++;
            coorX = coorY = -1;//初始坐标制定为-1
            name = this.getClass().getName();
            symbolForCrea = '8';
            kind = true;
            System.out.println(this.getName() + " success");
        }
    }
}
```
###field包
在战场部分设置两个类BattleField和Control，主体设计思想为：Control类用来控制成员的排布，而BattleFiled用来控制战场输出，战局判断，战局进行。
两个类成员分别如下：
```java
public class BattleField{
    private int N;
    private Creature[][] creatures;
    }
    
public class Control {
    private int N;
    int JleaderX,JleaderY,DleaderX,DleaderY;
    int justiceNumber;
    int devilNumber;


    //用于设定双方队列领头人
    private Creature[][] creatures;
    }
```
二者拥有同样的一个Creature数组（这里没想到如何抽象使得数据传递完善），应该设定一个公用的creature数组进行传递。


二者中拥有相似的函数用来传递数组。
```java
    public Creature[][] getCreatures() {
        return creatures;
    }
    //Class BattleField 中
       public void getMessageFromControl(Control control) {
        creatures = control.getCreatures();
    }
```

但不同类的初始化方式不同：
BattleField：
```java
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
```

Control:
```java
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
```

具体的生物设置位置以如下函数实现：
```java
    private void setCreatureToPositon(Creature creature, int inputX, int inputY) {
        if (isPositionEmpty(inputX, inputY)) {
            creatures[inputX][inputY] = creature;
            creature.moveToGoal(inputX, inputY);
        } else {
            System.out.println("thispersion Have a PeoPLE");
        }
    }
```

生物位置清理以如下函数实现：
```java
    public void clearBattleField() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                try {
                    moveCreatureOut(creatures[i][j]);
                } catch (Exception e) {//用来debug。
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
```

以鹤翼阵为例，葫芦娃一方实现方式如下：
```java
    public void makeJusticeHeyi(Creature[] calas,Creature grad) {
        clearLeftBattleField();//对之前的排布进行清理
        setCreatureToPositon(grad,18,8);//设立爷爷的位置
        setCreatureToPositon(calas[0], JleaderX, JleaderY);
        setCreatureToPositon(calas[1], JleaderX - 1, JleaderY - 1);
        setCreatureToPositon(calas[2], JleaderX - 2, JleaderY - 2);
        setCreatureToPositon(calas[3], JleaderX - 3, JleaderY - 3);
        setCreatureToPositon(calas[4], JleaderX + 1, JleaderY - 1);
        setCreatureToPositon(calas[5], JleaderX + 2, JleaderY - 2);
        setCreatureToPositon(calas[6], JleaderX + 3, JleaderY - 3);
    }

```
其余阵型相似。

在BattleField中，打印战场的函数为：
```java
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
```


战局判断部分：
主体函数如下：
```java
  public int startTheBattle()
    {
        //战场初始化check；
        justiceNumber=8;
        devilNumber=8;
        battleAnswer=0;
        while(true)
        {
            battleAnswer = fieldStateCheck();
            if (battleAnswer == 0)
            {
                battleAdvance();//生物向敌人前进
                battleFiledFight();//互相攻击
            }
            else
                return battleAnswer;//返回战果
        }
    }
```
###GUI部分
采用GridPane布局，以menu菜单实现控制阵型。
Class Main主体部分：（对部分代码进行了简化）
```java

public class Main extends Application {


    public void matchSymbolToImage(ImageView iv, char identifier) {
        }//实现从creature中数据到Image的转化

    static Image imageRed = new Image("file:src/sample/Pictures/Red.jpg");
   ...
   ...
   ...
    static Image imageMob = new Image("file:src/sample/Pictures/Mob.jpg");
//图形变量

    @Override
    //start函数。
    public void start(Stage primaryStage) throws Exception {
        GridPane root = new GridPane();
        
        Creature[] calas = {new Calabashs(), new Calabashs(), new Calabashs(), new Calabashs(), new Calabashs(), new Calabashs(), new Calabashs()};
    ...
    ...
    ...
        BattleField battleField = new BattleField();
        Control control = new Control();
//生物与战场构建

        Scene scene = new Scene(root, 800, 800, Color.WHITE);
        
        ImageView[][] imageViews = new ImageView[20][20];
        {
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    imageViews[i][j] = new ImageView();
                    imageViews[i][j].setFitWidth(30);
                    imageViews[i][j].setFitHeight(30);
                    root.setRowIndex(imageViews[i][j], i+1);
                    root.setColumnIndex(imageViews[i][j], j);
                }
            }
        }

        /**
         * 创建菜单环节
         */
        MenuBar menuBar = new MenuBar();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

        Menu action = new Menu("justice");
        Menu justice = new Menu("justice");
        Menu devil = new Menu("devil");

        MenuItem start = new MenuItem("start");
        start.setOnAction(ActionEvent->
        {
            battleField.resetTheBattle();

            int battleAnswer = 0;
            //  battleAnswer = battleField. fieldStateCheck();
            battleAnswer = battleField.fieldStateCheck();
            while (battleAnswer == 0) {
                battleField.battleAdvance();
                //battleFieldtoGui(battleField, imageViews);
                battleField.printBattleFieldStatues();

                try {
                    Thread.sleep(60000);
                } catch (Exception e) {
                    System.exit(0);//函数暂停
                }
                battleField.battleFiledFight();
                //battleFieldtoGui(battleField, imageViews);
                battleField.printBattleFieldStatues();
            }
            System.out.println(battleAnswer);//
        });
        //本段函数有bug，因为在循环中，Gradpane无法得知具体战场情况。
        //应采用多线程技术监视battleField中的行为，传递至图形化界面

        MenuItem JHeyi = new MenuItem("Heyi");
        JHeyi.setOnAction(ActionEvent->{control.clearLeftBattleField();
            control.makeJusticeHeyi(calas,grandfather);  battleField.getMessageFromControl(control);
            battleFieldtoGui(battleField, imageViews);});
            //监听对菜单的click，采用lambda表达式进行输出。
      ...
      ...
      ...
        DFengshi.setOnAction(ActionEvent->{control.clearRightBattleField();
            control.makeDevilFengshi(devils,snake);  battleField.getMessageFromControl(control);
            battleFieldtoGui(battleField, imageViews);});

        action.getItems().addAll(start);
        justice.getItems().addAll(JHeyi, JYanxing, JHenge, JChangshe, JYuling, JFangmeng, JYanyue, JFengshi);
        devil.getItems().addAll(DHeyi, DYanxing, DHenge, DChangshe, DYuling, DFangmeng, DYanyue, DFengshi);
        menuBar.getMenus().addAll(action, justice, devil);
        root.getChildren().add(menuBar);

     //   root.getChildren().add(new ImageView());
        for(int i=0; i<20; i++){
            for(int j=0; j<20; j++){
                root.getChildren().add(imageViews[i][j]);
            }
        }
        primaryStage.setTitle("Hello Hulu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void battleFieldtoGui(BattleField bf,ImageView[][] imageViews)
    {}
    //对战场数据到GUI的转化。
    
    public static void main(String[] args) {
        launch(args);
    }
}

```

##程序运行截图
在仓库首页

##写在最后
    感谢老师和助教一学期以来的辛苦！


  [1]: C:%5CUsers%5CMaplewings%5CDesktop%5C%E7%A8%8B%E5%BA%8F%E6%88%AA%E5%9B%BE.png