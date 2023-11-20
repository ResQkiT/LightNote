package org.resk.lightnote.exeptions;

public class NoMatchPattern extends Exception {
    @Override
    public String toString() {
        return "Файл назначенный на удаление не соответствует шаблону";
    }
}
