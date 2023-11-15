package org.resk.lightnote.commands;

import com.alibaba.fastjson.JSON;
import org.resk.lightnote.exeptions.NoNoteToSave;
import org.resk.lightnote.model.BaseNote;
import org.resk.lightnote.model.Note;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.SortedMap;

public class SaveCommand implements Command{
    private BaseNote note;
    private final String relativeway = "notes//";
    public SaveCommand toSave(BaseNote note){
        this.note = note;
        return this;
    }
    @Override
    public SaveCommand execute() {
        //код сохранения
        try{
            if (this.note == null){
                throw new NoNoteToSave();
            }
            String jsonString = JSON.toJSONString(note);
            File file = new File(relativeway + note.getFileName());

            if (file.createNewFile())
                System.out.println("File created");

            try (FileWriter fw = new FileWriter(file)){
                fw.write(jsonString);
            }
            System.out.println("Выполнена команда сохранения!");
        }catch (NoNoteToSave e){
            System.out.println("Нет заметки для сохранения");
        }catch (IOException e) {
            System.out.println("Ошибка при сохранении заметки");
        }

        return this;
    }
}
