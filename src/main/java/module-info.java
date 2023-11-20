module org.resk.lightnote {
    requires javafx.controls;
    requires javafx.fxml;
    requires fastjson;
    requires org.apache.logging.log4j;
    uses com.alibaba.fastjson.JSON;
    //opens org.resk.lightnote;

    exports org.resk.lightnote.model;
    exports org.resk.lightnote.commands;
    exports org.resk.lightnote.exeptions;
    exports org.resk.lightnote.MainControllers;

    opens org.resk.lightnote.MainControllers to javafx.fxml;
    opens org.resk.lightnote to javafx.fxml;
    exports org.resk.lightnote;

}