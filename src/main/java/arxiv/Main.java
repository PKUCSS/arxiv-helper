package arxiv;

import java.io.InputStream;



import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import com.avos.avoscloud.*;
/**

 * 
 * @author Chonghao Zhai 
 *
 */
 
public class Main extends Application {
	private Stage stage;
	  
	public User user = new User() ;
	@Override
	public void start(Stage primaryStage) {
		try {
			AVOSCloud.initialize("m0rQBplH1SM5GAYFvt22VI0z-gzGzoHsz","MS8SRy9i4rsKkk0j8HtDJm6x","EAElMEaXzhmulzrx0ddcey0Q");
			stage = primaryStage;
			stage.setTitle("ArxivFallower");
			helloworld();
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void helloworld() {
		try {
			Hello_WorldController hello_world = (Hello_WorldController) replaceSceneContent("Hello_World.fxml");
			hello_world.setApp(this);
		}catch(Exception ex) {
			System.out.println("helloworld_failed!");
			ex.printStackTrace();
		}
	}
	public void register() {
		try {
			RegisterController register = (RegisterController) replaceSceneContent("Register.fxml");
			register.setApp(this);
		}catch(Exception ex) {
			System.out.println("register_failed!");
			ex.printStackTrace();
		}
	}
	public void reader() {
		try {
			Reader_Controller reader = (Reader_Controller) replaceSceneContent("Reader.fxml");
			reader.setApp(this);
		}catch(Exception ex) {
			System.out.println("reader_failed!");
			ex.printStackTrace();
		}
	}
	public void astro_phy() {
		try {
			astro_phyController astro_phy = (astro_phyController) replaceSceneContent("astro-phy.fxml");
			astro_phy.setApp(this);
		}catch(Exception ex) {
			System.out.println("astro-phy_failed!");
			ex.printStackTrace();
		}
	}
	public void cond_mat() {
		try {
			cond_matController cond_mat = (cond_matController) replaceSceneContent("cond-mat.fxml");
			cond_mat.setApp(this);
		}catch(Exception ex) {
			System.out.println("cond-mat_failed!");
			ex.printStackTrace();
		}
	}
	public void cs() {
		try {
			csController cs = (csController) replaceSceneContent("cs.fxml");
			cs.setApp(this);
		}catch(Exception ex) {
			System.out.println("cs_failed!");
			ex.printStackTrace();
		}
	}
	public void econ() {
		try {
			econController econ = (econController) replaceSceneContent("econ.fxml");
			econ.setApp(this);
		}catch(Exception ex) {
			System.out.println("econ_failed!");
			ex.printStackTrace();
		}
	}
	public void eess() {
		try {
			eessController eess = (eessController) replaceSceneContent("eess.fxml");
			eess.setApp(this);
		}catch(Exception ex) {
			System.out.println("eess_failed!");
			ex.printStackTrace();
		}
	}
	public void gr_qc() {
		try {
			gr_qcController gr_qc = (gr_qcController) replaceSceneContent("gr-qc.fxml");
			gr_qc.setApp(this);
		}catch(Exception ex) {
			System.out.println("gr-qc_failed!");
			ex.printStackTrace();
		}
	}
	public void hep() {
		try {
			hepController hep = (hepController) replaceSceneContent("hep.fxml");
			hep.setApp(this);
		}catch(Exception ex) {
			System.out.println("hep_failed!");
			ex.printStackTrace();
		}
	}
	public void math() {
		try {
			mathController math = (mathController) replaceSceneContent("math.fxml");
			math.setApp(this);
		}catch(Exception ex) {
			System.out.println("math_failed!");
			ex.printStackTrace();
		}
	}
	public void nlin() {
		try {
			nlinController nlin = (nlinController) replaceSceneContent("nlin.fxml");
			nlin.setApp(this);
		}catch(Exception ex) {
			System.out.println("nlin_failed!");
			ex.printStackTrace();
		}
	}
	public void nucl() {
		try {
			nuclController nucl = (nuclController) replaceSceneContent("nucl.fxml");
			nucl.setApp(this);
		}catch(Exception ex) {
			System.out.println("nucl_failed!");
			ex.printStackTrace();
		}
	}
	public void physics() {
		try {
			physicsController physics = (physicsController) replaceSceneContent("physics.fxml");
			physics.setApp(this);
		}catch(Exception ex) {
			System.out.println("physics_failed!");
			ex.printStackTrace();
		}
	}
	public void q_bio() {
		try {
			q_bioController q_bio = (q_bioController) replaceSceneContent("q-bio.fxml");
			q_bio.setApp(this);
		}catch(Exception ex) {
			System.out.println("q-bio_failed!");
			ex.printStackTrace();
		}
	}
	public void q_fin() {
		try {
			q_finController q_fin = (q_finController) replaceSceneContent("q-fin.fxml");
			q_fin.setApp(this);
		}catch(Exception ex) {
			System.out.println("q-fin_failed!");
			ex.printStackTrace();
		}
	}
	public void quant_ph() {
		try {
			quant_phController quant_ph = (quant_phController) replaceSceneContent("quant-ph.fxml");
			quant_ph.setApp(this);
		}catch(Exception ex) {
			System.out.println("quant-ph_failed!");
			ex.printStackTrace();
		}
	}
	public void stat() {
		try {
			statController stat = (statController) replaceSceneContent("stat.fxml");
			stat.setApp(this);
		}catch(Exception ex) {
			System.out.println("stat_failed!");
			ex.printStackTrace();
		}
	}
	public void registerbuild() {
		try {
			RegisterBuildController registerbuild = (RegisterBuildController) replaceSceneContent("RegisterBuild.fxml");
			registerbuild.setApp(this);
		}catch(Exception ex) {
			System.out.println("registerbuild_failed!");
			ex.printStackTrace();
		}
	}
	public void resetpassword() {
		try {
			ResetPassWordController resetpassword = (ResetPassWordController) replaceSceneContent("ResetPassWord.fxml");
			resetpassword.setApp(this);
		}catch(Exception ex) {
			System.out.println("resetpassword_failed!");
			ex.printStackTrace();
		}
	}
	public void passwordtips() {
		try {
			PassWordTipsController passwordtips = (PassWordTipsController) replaceSceneContent("PassWordTips.fxml");
			passwordtips.setApp(this);
		}catch(Exception ex) {
			System.out.println("passwordtips_failed!");
			ex.printStackTrace();
		}
	}
	public void authorquery() {
		try {
			AuthorQueryController authorquery = (AuthorQueryController) replaceSceneContent("AuthorQuery.fxml");
			authorquery.setApp(this);
		}catch(Exception ex) {
			System.out.println("authorquery_failed!");
			ex.printStackTrace();
		}
	}
	public void searchfullpaper() {
		try {
			SearchFullPaperController searchfullpaper = (SearchFullPaperController) replaceSceneContent("SearchFullPaper.fxml");
			searchfullpaper.setApp(this);
		}catch(Exception ex) {
			System.out.println("searchfullpaper_failed!");
			ex.printStackTrace();
		}
	}
	public void mycollection() {
		try {
			MyCollectionController mycollection = (MyCollectionController) replaceSceneContent("MyCollection.fxml");
			mycollection.setApp(this);
		}catch(Exception ex) {
			System.out.println("mycollection_failed!");
			ex.printStackTrace();
		}
	}
	public void recentreading() {
		try {
			RecentReadingController recentreading = (RecentReadingController) replaceSceneContent("RecentReading.fxml");
			recentreading.setApp(this);
		}catch(Exception ex) {
			System.out.println("recentreading_failed!");
			ex.printStackTrace();
		}
	}
	public void focusarea() {
		try {
			FocusAreaController focusarea = (FocusAreaController) replaceSceneContent("FocusArea.fxml");
			focusarea.setApp(this);
		}catch(Exception ex) {
			System.out.println("focusarea_failed!");
			ex.printStackTrace();
		}
	}
	private Initializable replaceSceneContent(String fxml) throws Exception {        
	FXMLLoader loader = new FXMLLoader();        
	InputStream in = Main.class.getResourceAsStream(fxml);       
	loader.setBuilderFactory(new JavaFXBuilderFactory());        
	loader.setLocation(Main.class.getResource(fxml));        
	Parent root;    
	try {            
		root = loader.load(in);    
	} finally {
		in.close(); 
	}                 
	stage.setScene(new Scene(root));        
	stage.sizeToScene();        
	return (Initializable) loader.getController();    
	}
}
