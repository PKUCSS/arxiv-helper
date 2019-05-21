package arxiv;

import java.io.InputStream;
import  arxiv.User ; 


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
import javafx.scene.image.Image;
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
			stage.getIcons().add(new Image("File:../../resources/logo.jpg"));
			stage.setTitle("ArxivHelper");
			helloworld();
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void accountsetting() {
		try {
			AccountSettingController accountsetting = (AccountSettingController) replaceSceneContent("AccountSetting.fxml");
			accountsetting.setApp(this);
		}catch(Exception ex) {
			System.out.println("accountsetting_failed!");
			ex.printStackTrace();
		}
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
			astro_phy.SetText();
			astro_phy.setApp(this);
		}catch(Exception ex) {
			System.out.println("astro-phy_failed!");
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
			authorquery.SetText();
			authorquery.setApp(this);
		}catch(Exception ex) {
			System.out.println("authorquery_failed!");
			ex.printStackTrace();
		}
	}
	public void searchfullpaper() {
		try {
			SearchFullPaperController searchfullpaper = (SearchFullPaperController) replaceSceneContent("SearchFullPaper.fxml");
			searchfullpaper.SetText();
			searchfullpaper.setApp(this);
		}catch(Exception ex) {
			System.out.println("searchfullpaper_failed!");
			ex.printStackTrace();
		}
	}
	public void mycollection() {
		try {
			MyCollectionController mycollection = (MyCollectionController) replaceSceneContent("MyCollection.fxml");
			mycollection.papers=user.GetLikedPapers();
			mycollection.SetText();
			mycollection.printPaper();
			mycollection.setApp(this);
		}catch(Exception ex) {
			System.out.println("mycollection_failed!");
			ex.printStackTrace();
		}
	}
	public void recentreading() {
		try {
			RecentReadingController recentreading = (RecentReadingController) replaceSceneContent("RecentReading.fxml");
			recentreading.papers=user.GetReadPapers();
			recentreading.SetText();
			recentreading.printPaper();
			recentreading.setApp(this);
		}catch(Exception ex) {
			System.out.println("recentreading_failed!");
			ex.printStackTrace();
		}
	}
	public void focusarea() {
		try {
			FocusAreaController focusarea = (FocusAreaController) replaceSceneContent("FocusArea.fxml");
			focusarea.papers = user.GetRecommendPapers() ; 
			focusarea.SetText();
		    focusarea.printPaper();
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
