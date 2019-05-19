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



public class Reader_Controller implements Initializable{
    @FXML
	private Main app;
	
	public void setApp(Main app) {
		this.app=app;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	public void Change_to_Register(ActionEvent event) throws Exception{
		app.register();
	}
	public void Change_to_Reader(ActionEvent event) throws Exception{
		app.reader();
	}
	public void Change_to_astro_phy(ActionEvent event) throws Exception{
		app.astro_phy();
	}
	public void Change_to_cond_mat(ActionEvent event) throws Exception{
		app.cond_mat();
	}
	public void Change_to_cs(ActionEvent event) throws Exception{
		app.cs();
	}
	public void Change_to_econ(ActionEvent event) throws Exception{
		app.econ();
	}
	public void Change_to_eess(ActionEvent event) throws Exception{
		app.eess();
	}
	public void Change_to_gr_qc(ActionEvent event) throws Exception{
		app.gr_qc();
	}
	public void Change_to_hep(ActionEvent event) throws Exception{
		app.hep();
	}
	public void Change_to_math(ActionEvent event) throws Exception{
		app.math();
	}
	public void Change_to_nlin(ActionEvent event) throws Exception{
		app.nlin();
	}
	public void Change_to_nucl(ActionEvent event) throws Exception{
		app.nucl();
	}
	public void Change_to_physics(ActionEvent event) throws Exception{
		app.physics();
	}
	public void Change_to_q_bio(ActionEvent event) throws Exception{
		app.q_bio();
	}
	public void Change_to_q_fin(ActionEvent event) throws Exception{
		app.q_fin();
	}
	public void Change_to_quant_ph(ActionEvent event) throws Exception{
		app.quant_ph();
	}
	public void Change_to_stat(ActionEvent event) throws Exception{
		app.stat();
	}
	public void Change_to_AuthorQuery(ActionEvent event) throws Exception{
		app.authorquery();
	}
	public void Change_to_SearchFullPaper(ActionEvent event) throws Exception{
		app.searchfullpaper();
	}
	public void Change_to_MyCollection(ActionEvent event) throws Exception{
		app.mycollection();
	}
	public void Change_to_RecentReading(ActionEvent event) throws Exception{
		app.recentreading();
	}
	public void Change_to_FocusArea(ActionEvent event) throws Exception{
		app.focusarea();
	}
}