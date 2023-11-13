package org.resk.lightnote.MainControllers;



import com.alibaba.fastjson.JSON;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;


import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.skin.TableHeaderRow;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import org.resk.lightnote.Application;
import org.resk.lightnote.commands.Command;
import org.resk.lightnote.commands.LoadCommand;
import org.resk.lightnote.commands.SaveCommand;
import org.resk.lightnote.model.BaseNote;
import org.resk.lightnote.model.Note;


import java.io.File;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Label date_field;
    @FXML
    private MenuItem save_menu_button, load_menu_button;
    @FXML
    private TextArea main_text_area;
    @FXML
    private TextField name_text_field;

    @FXML
    protected void saveNote(){
        Note note = new Note();
        String name = name_text_field.getText();
        String text = main_text_area.getText();
        String dateTime = DateTimeFormatter.ofPattern("dd_MM_hh_mm_ss_ms")
                .format(LocalDateTime.now());

        String fileName = name + dateTime;

        note.setData(text);
        note.setNoteName(name);
        note.setDate(dateTime);
        note.setFileName(fileName);

        try{
            new SaveCommand().toSave(note).execute();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    @FXML
    protected void loadNote(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open LightNote!");
        fileChooser.setInitialDirectory(new File("notes//"));
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("Light Note (*.lightnote)", "*.lightnote");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(Application.stage);
        if (file != null) {
            //Open
            System.out.println(file.getAbsolutePath());
            try {
                Note note = new LoadCommand().toLoad(file).execute().getNote();
                loadNoteUi(note);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
    @FXML
    private void loadNoteUi(Note note){
        name_text_field.setText(note.getNoteName());
        main_text_area.setText(note.getData());
        date_field.setText(note.getDate());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //System.out.println("Инициализация!");

        String dateTime = DateTimeFormatter.ofPattern("dd MMMM hh:mm")
                .format(LocalDateTime.now());

        date_field.setText(dateTime);
    }
}