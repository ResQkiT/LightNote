package org.resk.lightnote.commands;
import org.resk.lightnote.exeptions.NoMatchPattern;
import java.io.File;

import static org.resk.lightnote.Application.logger;

public class DeleteCommand implements Command{
    private String deletePath = "";

    public DeleteCommand setDeletePath(String deletePath) {
        this.deletePath = deletePath;
        return this;
    }

    @Override
    public Command execute(){
        try{
            System.out.println(deletePath);
            if (!deletePath.contains(".lightnote")){
                throw new NoMatchPattern();
            }
            File file = new File(deletePath);

            if(file.delete()){
                logger.warn("Файл "+ deletePath + " удален");
            }else{
                logger.warn("Файл "+ deletePath + " не был найден");
            }
        } catch (NoMatchPattern e) {
            logger.warn(e.toString());
        }
        return this;
    }
}
