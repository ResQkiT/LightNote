package org.resk.lightnote.model;

public class Note implements BaseNote{
    private String fileName;
    private String noteName;
    private String date;
    private String data;

    public void setData(String data) {
        this.data = data;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public Note(String data, String date, String fileName, String noteName) {
        this.data = data;
        this.date = date;
        this.fileName = fileName;
        this.noteName = noteName;
    }

    public String getData() {
        return data;
    }

    public String getDate() {
        return date;
    }
    @Override
    public String getFileName() {
        return fileName;
    }
    @Override
    public String getFullFileName() {
        return fileName + ".lightnote";
    }

    public String getNoteName() {
        return noteName;
    }

    public Note() {
        this.data = "";
        this.date = "";
        this.fileName = "";
        this.noteName = "";
    }

    @Override
    public String toString() {
        return "Note{" +
                "fileName='" + fileName + '\'' +
                ", noteName='" + noteName + '\'' +
                ", date='" + date + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Note note = new Note();
        note.setFileName(this.fileName);
        note.setNoteName(this.noteName);
        note.setDate(this.date);
        note.setData(this.data);
        return note;
    }
}
