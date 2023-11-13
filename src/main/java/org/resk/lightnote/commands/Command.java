package org.resk.lightnote.commands;

import org.resk.lightnote.exeptions.NoNoteToSave;
import org.resk.lightnote.model.BaseNote;

public interface Command {
    public Command execute() throws Exception;
}
