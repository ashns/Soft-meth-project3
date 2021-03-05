import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.util.StringTokenizer;

public class Controller {
    @FXML
    Label display = new Label();
    @FXML
    Label rateLabel = new Label();
    @FXML
    TextField nameBox = new TextField();
    @FXML
    Label addBtn = new Label();
    @FXML
    ToggleGroup Dept = new ToggleGroup();
    @FXML
    DatePicker dateBox = new DatePicker();
    @FXML
    ToggleGroup Position = new ToggleGroup();
    @FXML
    TextField payBox = new TextField();

    StringTokenizer parse;

    public void dataTest(ActionEvent actionEvent) {
        String last = "", first = "";
        char middle = ' ';
        parse = new StringTokenizer(nameBox.getText());
        switch (parse.countTokens()) {
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

        if (first != "")
            last += ", " + first;

        if (middle != ' ')
            last += " " + middle + ".";

        if (last != "")
            display.setText("Recieved name: " + last + "\n");
    }

    public void rateChange(ActionEvent actionEvent){
        rateLabel.setText("/ hour");
    }

    public void salaryChange(ActionEvent actionEvent){
        rateLabel.setText("/ year");
    }

    public void add(ActionEvent actionEvent){
        String name = nameBox.getText();
        String department = Dept.getSelectedToggle().toString();
        Date hireDate = new Date(dateBox.getValue().toString());
        Float rate = (float)Integer.parseInt(payBox.getText());
        Profile hireProfile = new Profile(name, department, hireDate);
        if(Position.getSelectedToggle().toString()=="PTRB"){
            Parttime newHire = new Parttime(hireProfile, rate);
        }
        else if(Position.getSelectedToggle().toString()=="FTRB"){
            Fulltime newHire = new Fulltime(hireProfile, rate);
        }
        else{}
    }

}
