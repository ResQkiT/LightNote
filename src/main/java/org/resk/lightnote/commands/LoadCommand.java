package org.resk.lightnote.commands;

import com.alibaba.fastjson.JSON;
import org.resk.lightnote.MainControllers.Controller;
import org.resk.lightnote.exeptions.NoFileToLoad;
import org.resk.lightnote.exeptions.NoNoteToSave;
import org.resk.lightnote.model.Note;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.channels.Pipe;
import java.util.Scanner;

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
                System.out.println(this.note);
            }

        } catch (NoFileToLoad e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return this;
    }
}
