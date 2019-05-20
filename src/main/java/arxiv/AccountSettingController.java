package arxiv;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;



public class AccountSettingController implements Initializable{
    
	@FXML
	private CheckBox Astro_ph;
	@FXML
	private CheckBox Cond_mat;
	@FXML
	private CheckBox Cs;
	@FXML
	private CheckBox Econ;
	@FXML
	private CheckBox Eess;
	@FXML
	private CheckBox Gr_qc;
	@FXML
	private CheckBox Hep;
	@FXML
	private CheckBox Math;
	@FXML
	private CheckBox Nlin;
	@FXML
	private CheckBox Nucl;
	@FXML
	private CheckBox Physics;
	@FXML
	private CheckBox Q_bio;
	@FXML
	private CheckBox Q_fin;
	@FXML
	private CheckBox Quant_ph;
	@FXML
	private CheckBox Stat;
	
	private Main app;
	
	public void setApp(Main app) {
		this.app=app;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	public void Change_to_Reader(ActionEvent event) throws Exception{
		ArrayList<String> papers =  new ArrayList<String>() ; 
		if(Astro_ph.isSelected()) {
			papers.add("astro-ph");
		}
		if(Cond_mat.isSelected()) {
			papers.add("cond-mat");
		}
		if(Cs.isSelected()) {
			papers.add("cs");
		}
		if(Econ.isSelected()) {
			papers.add("econ");
		}
		if(Eess.isSelected()) {
			papers.add("eess");
		}
		if(Gr_qc.isSelected()) {
			papers.add("gr-qc");
		}
		if(Hep.isSelected()) {
			papers.add("hep");
		}
		if(Math.isSelected()) {
			papers.add("Nlin");
		}
		if(Nucl.isSelected()) {
			papers.add("nucl");
		}
		if(Physics.isSelected()) {
			papers.add("physics");
		}
		if(Q_bio.isSelected()) {
			papers.add("q-bio");
		}
		if(Q_fin.isSelected()) {
			papers.add("q-fin");
		}
		if(Quant_ph.isSelected()) {
			papers.add("quant-ph");
		}
		if(Stat.isSelected()) {
			papers.add("stat");
		}
		app.user.SetLiked(papers);
		app.reader();
	}
}
