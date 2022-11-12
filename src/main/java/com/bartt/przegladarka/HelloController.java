package com.bartt.przegladarka;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;


public class HelloController {
    public Button btn1;
    public Button btn2;
    public Button btn3;
    public Button btn4;
    public WebView wb1;

    public String[] link = new String[4];

    public String[] nazwa = new String[4];

    @FXML
    public void initialize() throws IOException
    {
        Path path = Paths.get("C:/ZiomekczkiZiomy/url.txt");
        if (!Files.exists(path))
            Files.createFile(path);

        List<String> linie = Files.readAllLines(path);
        int i = 0;
        for (String linia : linie)
        {
            if(i>4)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("Przekroczyłes ilość lini url w tekscie");
                alert.showAndWait();
            }

            String[] parts = linia.split("#");
            Url url = new Url(parts[0], parts[1]);

             link[i] = (""+url.url);
             nazwa[i] = (""+url.strona);

             i++;
        }

        wb1.getEngine().load("https://google.com");
    }

    public void onClick1(ActionEvent actionEvent)
    {
        wb1.getEngine().load(link[0]);//https://www.onet.pl

        btn1.setDisable(true);
        btn1.setText(nazwa[0]);

        Stream.of(btn2, btn3, btn4).forEach(btn -> btn.setDisable(false));
    }

    public void onClick2(ActionEvent actionEvent)
    {
        wb1.getEngine().load(link[1]);//"https://www.wp.pl"

        btn2.setDisable(true);
        btn2.setText(nazwa[1]);

        Stream.of(btn1, btn3, btn4).forEach(btn -> btn.setDisable(false));
    }

    public void onClick3(ActionEvent actionEvent)
    {
        wb1.getEngine().load(link[2]);//"https://www.interia.pl"

        btn3.setDisable(true);
        btn3.setText(nazwa[2]);


        Stream.of(btn1, btn2, btn4).forEach(btn -> btn.setDisable(false));
    }

    public void onClick4(ActionEvent actionEvent)
    {
        wb1.getEngine().load(link[3]);//"https://www.gazeta.pl/0,0.html"

        btn4.setDisable(true);
        btn4.setText(nazwa[3]);

        Stream.of(btn1, btn3, btn2).forEach(btn -> btn.setDisable(false));
    }
}