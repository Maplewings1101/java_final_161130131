package sample;

import creature.Creature;
import creature.devil.Mobs;
import creature.devil.Scorpion;
import creature.devil.Snake;
import creature.justice.Calabashs;
import creature.justice.Grandfather;
import field.BattleField;
import field.Control;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;


public class Main extends Application {


    public void matchSymbolToImage(ImageView iv, char identifier) {
        switch (identifier) {
            case '1':
                iv.setImage(imageRed);
                break;
            case '2':
                iv.setImage(imageOrange);
                break;
            case '3':
                iv.setImage(imageYellow);
                break;
            case '4':
                iv.setImage(imageGreen);
                break;
            case '5':
                iv.setImage(imageCyan);
                break;
            case '6':
                iv.setImage(imageBlue);
                break;
            case '7':
                iv.setImage(imagePurple);
                break;
            case '8':
                iv.setImage(imageGF);
                break;
            case 'x':
                iv.setImage(imageScorpion);
                break;
            case 's':
                iv.setImage(imageSnake);
                break;
            case 'm':
                iv.setImage(imageMob);
                break;
        }
    }

    static Image imageRed = new Image("file:src/sample/Pictures/Red.jpg");
    static Image imageOrange = new Image("file:src/sample/Pictures/Orange.jpg");
    static Image imageYellow = new Image("file:src/sample/Pictures/Yellow.jpg");
    static Image imageGreen = new Image("file:src/sample/Pictures/Green.jpg");
    static Image imageCyan = new Image("file:src/sample/Pictures/Cyan.jpg");
    static Image imageBlue = new Image("file:src/sample/Pictures/Blue.jpg");
    static Image imagePurple = new Image("file:src/sample/Pictures/Purple.jpg");
    static Image imageScorpion = new Image("file:src/sample/Pictures/Scorpion.jpg");
    static Image imageSnake = new Image("file:src/sample/Pictures/Snake.jpg");
    static Image imageGF = new Image("file:src/sample/Pictures/GrandFather.jpg");
    static Image imageMob = new Image("file:src/sample/Pictures/Mob.jpg");


    @Override
    public void start(Stage primaryStage) throws Exception {


        GridPane root = new GridPane();
        Creature[] calas = {new Calabashs(), new Calabashs(), new Calabashs(), new Calabashs(), new Calabashs(), new Calabashs(), new Calabashs()};
        Creature snake = new Snake();
        Creature grandfather = new Grandfather();
        Creature[] devils = {new Scorpion(), new Mobs(), new Mobs(), new Mobs(), new Mobs(), new Mobs(), new Mobs()};
        BattleField battleField = new BattleField();
        Control control = new Control();


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


        Menu action = new Menu("action");
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
                    System.exit(0);//退出程序
                }
                battleField.battleFiledFight();

                //battleFieldtoGui(battleField, imageViews);
                battleField.printBattleFieldStatues();
            }
            System.out.println(battleAnswer);//打完了

        });

        MenuItem JHeyi = new MenuItem("Heyi");
        JHeyi.setOnAction(ActionEvent->{control.clearLeftBattleField();
            control.makeJusticeHeyi(calas,grandfather);  battleField.getMessageFromControl(control);
            battleFieldtoGui(battleField, imageViews);});
        MenuItem JYanxing = new MenuItem("Yanxing");
        JYanxing.setOnAction(ActionEvent->{control.clearLeftBattleField();
            control.makeJusticeYanxing(calas,grandfather);  battleField.getMessageFromControl(control);
            battleFieldtoGui(battleField, imageViews);});
        MenuItem JHenge = new MenuItem("Henge");
        JHenge.setOnAction(ActionEvent->{
            control.clearLeftBattleField();

            control.makeJusticeHenge(calas,grandfather);  battleField.getMessageFromControl(control);
            battleFieldtoGui(battleField, imageViews);});
        MenuItem JChangshe = new MenuItem("Changshe");
        JChangshe.setOnAction(ActionEvent->{
            control.clearLeftBattleField();

            control.makeJusticeChangshe(calas,grandfather);  battleField.getMessageFromControl(control);
            battleFieldtoGui(battleField, imageViews);});
        MenuItem JYuling = new MenuItem("Yuling");
        JYuling.setOnAction(ActionEvent->{
            control.clearLeftBattleField();
            control.makeJusticeYuling(calas,grandfather);  battleField.getMessageFromControl(control);
            battleFieldtoGui(battleField, imageViews);});
        MenuItem JFangmeng = new MenuItem("Fangmeng");
        JFangmeng.setOnAction(ActionEvent->{
            control.clearLeftBattleField();

            control.makeJusticeFangmeng(calas,grandfather);  battleField.getMessageFromControl(control);
            battleFieldtoGui(battleField, imageViews);});
        MenuItem JYanyue = new MenuItem("Yanyue");
        JYanyue.setOnAction(ActionEvent->{
            control.clearLeftBattleField();
            control.makeJusticeYanyue(calas,grandfather);
            battleField.getMessageFromControl(control);
            battleFieldtoGui(battleField, imageViews);});
        MenuItem JFengshi = new MenuItem("Fengshi");
        JFengshi.setOnAction(ActionEvent-> {
                    control.clearLeftBattleField();
                    control.makeJusticeFengshi(calas, grandfather);
                    battleField.getMessageFromControl(control);
                    battleFieldtoGui(battleField, imageViews);
                }
        );


        MenuItem DHeyi = new MenuItem("Heyi");
        DHeyi.setOnAction(ActionEvent->{control.clearRightBattleField();
            control.makeDevilHeyi(devils,snake);  battleField.getMessageFromControl(control);
            battleFieldtoGui(battleField, imageViews);});
        MenuItem DYanxing = new MenuItem("Yanxing");
        DYanxing.setOnAction(ActionEvent->{control.clearRightBattleField();
            control.makeDevilYanxing(devils,snake);  battleField.getMessageFromControl(control);
            battleFieldtoGui(battleField, imageViews);});
        MenuItem DHenge = new MenuItem("Henge");
        DHenge.setOnAction(ActionEvent->{control.clearRightBattleField();
            control.makeDevilHenge(devils,snake);  battleField.getMessageFromControl(control);
            battleFieldtoGui(battleField, imageViews);});
        MenuItem DChangshe = new MenuItem("Changshe");
        DChangshe.setOnAction(ActionEvent->{control.clearRightBattleField();
            control.makeDevilChangshe(devils,snake);  battleField.getMessageFromControl(control);
            battleFieldtoGui(battleField, imageViews);});
        MenuItem DYuling = new MenuItem("Yuling");
        DYuling.setOnAction(ActionEvent->{control.clearRightBattleField();
            control.makeDevilYuling(devils,snake);  battleField.getMessageFromControl(control);
            battleFieldtoGui(battleField, imageViews);});
        MenuItem DFangmeng = new MenuItem("Fangmeng");
        DFangmeng.setOnAction(ActionEvent->{control.clearRightBattleField();
            control.makeDevilFangmeng(devils,snake);  battleField.getMessageFromControl(control);
            battleFieldtoGui(battleField, imageViews);});
        MenuItem DYanyue = new MenuItem("Yanyue");
        DYanyue.setOnAction(ActionEvent->{control.clearRightBattleField();
            control.makeDevilYanyue(devils,snake);  battleField.getMessageFromControl(control);
            battleFieldtoGui(battleField, imageViews);});
        MenuItem DFengshi = new MenuItem("Fengshi");
        DFengshi.setOnAction(ActionEvent->{control.clearRightBattleField();
            control.makeDevilFengshi(devils,snake);  battleField.getMessageFromControl(control);
            battleFieldtoGui(battleField, imageViews);});




     //   imageViews[5][5].setImage(imageCyan);


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
    {
        Creature[][] creatures=bf.getCreatures();
        for(int i=0; i<20; i++){
            for(int j=0; j<20; j++){
               // root.getChildren().add(imageViews[i][j]);
                if(creatures[i][j]==null)
                    imageViews[i][j].setImage(null);
                else
                    matchSymbolToImage(imageViews[i][j],creatures[i][j].getSymbolForCrea());

            }
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}


