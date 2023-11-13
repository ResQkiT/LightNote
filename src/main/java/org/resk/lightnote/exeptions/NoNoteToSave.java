package org.resk.lightnote.exeptions;

import java.io.IOException;

public class NoNoteToSave extends IOException {
    @Override
    public String toString() {
        return "No note to save found...";
    }
}
