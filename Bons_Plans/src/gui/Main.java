package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application 
{
     @Override
    public void start(Stage primaryStage) throws Exception 
    {
<<<<<<< HEAD
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene=new Scene(root, 800, 600);
=======

        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene=new Scene(root);
        //primaryStage.setTitle("Bons Plans - Inscription");
        //Parent root = FXMLLoader.load(getClass().getResource("AffichagePane.fxml"));
        //Scene scene=new Scene(root, 800, 600);
>>>>>>> 0b086b62f81ff28e4fbee24c4b2f72f5cebbeec1
        primaryStage.setTitle("Bons Plans - Login");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    public static void main(String[] args) 
    {
        launch(args);
    }

   
}
