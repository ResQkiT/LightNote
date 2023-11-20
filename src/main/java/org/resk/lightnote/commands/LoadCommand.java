package org.resk.lightnote.commands;

import com.alibaba.fastjson.JSON;
import org.resk.lightnote.exeptions.NoFileToLoad;
import org.resk.lightnote.model.Note;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static org.resk.lightnote.Application.logger;

public class LoadCommand implements Command{
    private File file;
    private Note note;
    public  LoadCommand toLoad(File file){
        this.file = file;
        return this;
    }
    public Note getNote() {
        return this.note;
    }

    @Override
    public LoadCommand execute(){
        try {
            if (this.file == null){
                throw new NoFileToLoad();
            }
            String string;
            try(FileReader fr = new FileReader(file)) {
                Scanner scanner = new Scanner(fr);
                string = scanner.nextLine();
                this.note = JSON.parseObject(string, Note.class);
            }
            logger.info("Команда загрузки заметки выполнена успешно");
        } catch (NoFileToLoad e) {
            logger.warn(e.toString());
        } catch (FileNotFoundException e) {
            logger.warn("Фай не найден");
        } catch (IOException e) {
            logger.warn("Ошибка ввода - вывода");
        }

        return this;
    }
}
