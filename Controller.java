package softMetProject3;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.StringTokenizer;

public class Controller {
    @FXML
    Label display = new Label();
    @FXML
    Label rateLabel = new Label();
    @FXML
    TextField nameBox = new TextField();

    StringTokenizer parse;

    public void dataTest(ActionEvent actionEvent) {
        String last = "", first = "";
        char middle = ' ';
        parse = new StringTokenizer(nameBox.getText());
        switch(parse.countTokens()){
            case 1:
                last = parse.nextToken();
                break;
            case 2:
                first = parse.nextToken();
                last = parse.nextToken();
                break;
            case 3:
                first = parse.nextToken();
                middle = parse.nextToken().charAt(0);
                last = parse.nextToken();
                break;
            default:
                display.setText("Please enter a valid name.");
                break;
        }

        if(first!= "")
            last += ", " + first;

        if(middle != ' ')
            last += " " + middle + ".";

        if(last != "")
            display.setText("Recieved name: " + last + "\n");
    }

    public void rateChange(ActionEvent actionEvent){
        rateLabel.setText("/ hour");
    }

    public void salaryChange(ActionEvent actionEvent){
        rateLabel.setText("/ year");
    }
}
