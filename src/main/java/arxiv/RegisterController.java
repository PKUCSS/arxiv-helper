package arxiv;
/**

 * 
 * @author Chonghao Zhai 
 *
 */
 
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



public class RegisterController implements Initializable{
    @FXML
    private TextField account;
    @FXML
    private TextField password;
    
	private Main app;
	
	public void setApp(Main app) {
		this.app=app;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	public void Change_to_Reader(ActionEvent event) throws Exception{
		if(app.user.LogIn(account.getText(), password.getText())) {
			app.reader();
		}
	}
	public void Change_to_RegisterBuild(ActionEvent event) throws Exception{
		app.registerbuild();
	}
	public void Change_to_ResetPassWord(ActionEvent event) throws Exception{
		app.resetpassword();
	}
}
