package com.bartt.przegladarka;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.web.WebView;


public class HelloController {
    public Button btn1;
    public Button btn2;
    public Button btn3;
    public Button btn4;
    public WebView wb1;

    @FXML
    public void initialize()
    {
        wb1.getEngine().load("https://google.com");
    }

    public void onClick1(ActionEvent actionEvent)
    {
        wb1.getEngine().load("https://www.onet.pl");
    }

    public void onClick2(ActionEvent actionEvent)
    {
        wb1.getEngine().load("https://www.wp.pl");
    }

    public void onClick3(ActionEvent actionEvent)
    {
        wb1.getEngine().load("https://www.interia.pl");
    }

    public void onClick4(ActionEvent actionEvent)
    {
        wb1.getEngine().load("https://www.gazeta.pl/0,0.html");
    }
}