package org.resk.lightnote;

import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.stage.Stage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class Application extends javafx.application.Application {
    public static final Logger logger = LogManager.getLogger();
    public static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        initDirectories();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 500);
        stage.setTitle("LightNote!");
        stage.setScene(scene);
        stage.show();

        logger.info("Application run!");
    }

    public static void main(String[] args) {
        launch();
    }
    public static void initDirectories(){
        File folder = new File("notes" );
        File loggerfolder = new File("logs");
        if (!folder.exists()) {
            folder.mkdir();
            loggerfolder.mkdir();
            logger.info("Создана директория /notes");
            logger.info("Создана директория /logs");
        }else{
            logger.info("Директория /notes не создана, она уже существует");
        }
    }
}