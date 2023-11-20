package org.resk.lightnote.commands;

import com.alibaba.fastjson.JSON;
import org.resk.lightnote.exeptions.NoNoteToSave;
import org.resk.lightnote.model.BaseNote;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.resk.lightnote.Application.logger;

public class SaveCommand implements Command{
    private BaseNote note;
    private final String relativeway = "notes//";
    public SaveCommand toSave(BaseNote note){
        this.note = note;
        return this;
    }
    @Override
    public SaveCommand execute() {
        try{
            if (this.note == null){
                throw new NoNoteToSave();
            }
            String jsonString = JSON.toJSONString(note);
            File file = new File(relativeway + note.getFullFileName());

            try (FileWriter fw = new FileWriter(file)){
                fw.write(jsonString);
            }
            logger.info("Команда сохранения выполнена успешно");

        }catch (NoNoteToSave e){
            logger.info(e.toString());
        }catch (IOException e) {
            logger.warn("Ошибка ввода - вывода");
        }

        return this;
    }
}
