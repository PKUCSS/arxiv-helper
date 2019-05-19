package arxiv;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class RegisterBuildController implements Initializable{
    
	@FXML
	private TextField Email;
	@FXML
	private TextField password;
	
	private Main app;
	
	public void setApp(Main app) {
		this.app=app;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	public void Change_to_Register(ActionEvent event) throws Exception{
		app.user.SignUp(Email.getText(), password.getText());
		app.register();
	}
}