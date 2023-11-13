package org.resk.lightnote.exeptions;

import java.io.IOException;

public class NoFileToLoad extends IOException {
    @Override
    public String toString() {
        return "No note to load found...";
    }
}
