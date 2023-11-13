package org.resk.lightnote;

import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Application extends javafx.application.Application {

    public static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        initDirectories();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 500);
        stage.setTitle("LightNote!");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
    public static void initDirectories(){
        File folder = new File("notes" );
        if (!folder.exists()) {
            folder.mkdir();
            System.out.println("Папка создана");
        }else{
            System.out.println("папка не создана");
        }
    }
}