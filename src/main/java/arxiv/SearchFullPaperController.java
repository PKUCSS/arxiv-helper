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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
/**

 * 
 * @author Chonghao Zhai 
 *
 */
 


public class SearchFullPaperController implements Initializable{
	@FXML
	private TextArea Text1;
	@FXML
	private TextArea Text2;
	@FXML
	private TextArea Text3;
	@FXML
	private TextArea Text4;
	@FXML
	private TextArea Text5;
	@FXML
	private Hyperlink link1;
	@FXML
	private Hyperlink link2;
	@FXML
	private Hyperlink link3;
	@FXML
	private Hyperlink link4;
	@FXML
	private Hyperlink link5;
	
	@FXML
	private TextField Search;
	
	private String lin1;
	private String lin2;
	private String lin3;
	private String lin4;
	private String lin5;
	private int page;
	
	private ArrayList<paper> papers = new ArrayList<paper>() ;
	
	
	private Main app;
	
	public void setApp(Main app) {
		this.app=app;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	public void Change_to_Register(ActionEvent event) throws Exception{
		app.user.LogOut();
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
	public void SearchAll(ActionEvent event) throws Exception{
		String All = Search.getText();
		papers = search.GetPapers("all", All, "submittedDate", "descending", "25");
		page=1;
		if(1>papers.size()) {
			Text1.setText("");
		}
		else {
			Text1.setText("1."+papers.get(0).PrintString());
			lin1 = papers.get(0).pdflink;
			link1.setText("打开PDF");
		}
		if(2>papers.size()) {
			Text2.setText("");
		}
		else {
			Text2.setText("2."+papers.get(1).PrintString());
			lin2 = papers.get(1).pdflink;
			link2.setText("打开PDF");
		}
		if(3>papers.size()) {
			Text3.setText("");
		}
		else {
			Text3.setText("3."+papers.get(2).PrintString());
			lin3 = papers.get(2).pdflink;
			link3.setText("打开PDF");
		}
		if(4>papers.size()) {
			Text4.setText("");
		}
		else {
			Text4.setText("4."+papers.get(3).PrintString());
			lin4 = papers.get(3).pdflink;
			link4.setText("打开PDF");
		}
		if(5>papers.size()) {
			Text5.setText("");
		}
		else {
			Text5.setText("5."+papers.get(4).PrintString());
			lin5 = papers.get(4).pdflink;
			link5.setText("打开PDF");
		}
	}
	public void PageOne(ActionEvent event) throws Exception{
		page=1;
		if(1>papers.size()) {
			Text1.setText("");
		}
		else {
			Text1.setText("1."+papers.get(0).PrintString());
			lin1=papers.get(0).pdflink;
			link1.setText("打开PDF");
		}
		if(2>papers.size()) {
			Text2.setText("");
		}
		else {
			Text2.setText("2."+papers.get(1).PrintString());
			lin2=papers.get(1).pdflink;
			link2.setText("打开PDF");
		}
		if(3>papers.size()) {
			Text3.setText("");
		}
		else {
			Text3.setText("3."+papers.get(2).PrintString());
			lin3=papers.get(2).pdflink;
			link3.setText("打开PDF");
		}
		if(4>papers.size()) {
			Text4.setText("");
		}
		else {
			Text4.setText("4."+papers.get(3).PrintString());
			lin4=papers.get(3).pdflink;
			link4.setText("打开PDF");
		}
		if(5>papers.size()) {
			Text5.setText("");
		}
		else {
			Text5.setText("5."+papers.get(4).PrintString());
			lin5=papers.get(4).pdflink;
			link5.setText("打开PDF");
		}
	}
	public void PageTwo(ActionEvent event) throws Exception{
		page=2;
		if(6>papers.size()) {
			Text1.setText("");
		}
		else {
			Text1.setText("6."+papers.get(5).PrintString());
			lin1=papers.get(5).pdflink;
			link1.setText("打开PDF");
		}
		if(7>papers.size()) {
			Text2.setText("");
		}
		else {
			Text2.setText("7."+papers.get(6).PrintString());
			lin2=papers.get(6).pdflink;
			link2.setText("打开PDF");
		}
		if(8>papers.size()) {
			Text3.setText("");
		}
		else {
			Text3.setText("8."+papers.get(7).PrintString());
			lin3=papers.get(7).pdflink;
			link3.setText("打开PDF");
		}
		if(9>papers.size()) {
			Text4.setText("");
		}
		else {
			Text4.setText("9."+papers.get(8).PrintString());
			lin4=papers.get(8).pdflink;
			link4.setText("打开PDF");
		}
		if(10>papers.size()) {
			Text5.setText("");
		}
		else {
			Text5.setText("10."+papers.get(9).PrintString());
			lin5=papers.get(9).pdflink;
			link5.setText("打开PDF");
		}
	}
	public void PageThree(ActionEvent event) throws Exception{
		page=3;
		if(11>papers.size()) {
			Text1.setText("");
		}
		else {
			Text1.setText("11."+papers.get(10).PrintString());
			lin1=papers.get(10).pdflink;
			link1.setText("打开PDF");
		}
		if(12>papers.size()) {
			Text2.setText("");
		}
		else {
			Text2.setText("12."+papers.get(11).PrintString());
			lin2=papers.get(11).pdflink;
			link2.setText("打开PDF");
		}
		if(13>papers.size()) {
			Text3.setText("");
		}
		else {
			Text3.setText("13."+papers.get(12).PrintString());
			lin3=papers.get(12).pdflink;
			link3.setText("打开PDF");
		}
		if(14>papers.size()) {
			Text4.setText("");
		}
		else {
			Text4.setText("14."+papers.get(13).PrintString());
			lin4=papers.get(13).pdflink;
			link4.setText("打开PDF");
		}
		if(15>papers.size()) {
			Text5.setText("");
		}
		else {
			Text5.setText("15."+papers.get(14).PrintString());
			lin5=papers.get(14).pdflink;
			link5.setText("打开PDF");
		}
	}
	public void PageFour(ActionEvent event) throws Exception{
		page=4;
		if(16>papers.size()) {
			Text1.setText("");
		}
		else {
			Text1.setText("16."+papers.get(15).PrintString());
			lin1=papers.get(15).pdflink;
			link1.setText("打开PDF");
		}
		if(17>papers.size()) {
			Text2.setText("");
		}
		else {
			Text2.setText("17."+papers.get(16).PrintString());
			lin2=papers.get(16).pdflink;
			link2.setText("打开PDF");
		}
		if(18>papers.size()) {
			Text3.setText("");
		}
		else {
			Text3.setText("18."+papers.get(17).PrintString());
			lin3=papers.get(17).pdflink;
			link3.setText("打开PDF");
		}
		if(19>papers.size()) {
			Text4.setText("");
		}
		else {
			Text4.setText("19."+papers.get(18).PrintString());
			lin4=papers.get(18).pdflink;
			link4.setText("打开PDF");
		}
		if(20>papers.size()) {
			Text5.setText("");
		}
		else {
			Text5.setText("20."+papers.get(19).PrintString());
			lin5=papers.get(19).pdflink;
			link5.setText("打开PDF");
		}
	}
	public void PageFive(ActionEvent event) throws Exception{
		page=5;
		if(21>papers.size()) {
			Text1.setText("");
		}
		else {
			Text1.setText("21."+papers.get(20).PrintString());
			lin1=papers.get(20).pdflink;
			link1.setText("打开PDF");
		}
		if(22>papers.size()) {
			Text2.setText("");
		}
		else {
			Text2.setText("22."+papers.get(21).PrintString());
			lin2=papers.get(21).pdflink;
			link2.setText("打开PDF");
		}
		if(23>papers.size()) {
			Text3.setText("");
		}
		else {
			Text3.setText("23."+papers.get(22).PrintString());
			lin3=papers.get(22).pdflink;
			link3.setText("打开PDF");
		}
		if(24>papers.size()) {
			Text4.setText("");
		}
		else {
			Text4.setText("24."+papers.get(23).PrintString());
			lin4=papers.get(23).pdflink;
			link4.setText("打开PDF");
		}
		if(25>papers.size()) {
			Text5.setText("");
		}
		else {
			Text5.setText("25."+papers.get(24).PrintString());
			lin5=papers.get(24).pdflink;
			link5.setText("打开PDF");
		}
	}
	public void PdfOne(ActionEvent event) throws Exception{
		try {
			final PDFViewer pdfviewer = new PDFViewer(false);
			lin1 = "https:"+lin1.split(":")[1] ; 
			pdfviewer.openFile(new URL(lin1+".pdf"));
			app.user.add2Read(papers.get(5*(page-1)+0));
		}catch (Exception e) {
		}
	}
    public void PdfTwo(ActionEvent event) throws Exception{
    	try {
			final PDFViewer pdfviewer = new PDFViewer(false);
			lin2 = "https:"+lin2.split(":")[1] ; 
			pdfviewer.openFile(new URL(lin2+".pdf"));
			app.user.add2Read(papers.get(5*(page-1)+1));
		}catch (Exception e) {
		}
	}
    public void PdfThree(ActionEvent event) throws Exception{
    	try {
			final PDFViewer pdfviewer = new PDFViewer(false);
			lin3 = "https:"+lin3.split(":")[1] ; 
			pdfviewer.openFile(new URL(lin3+".pdf"));
			app.user.add2Read(papers.get(5*(page-1)+2));
		}catch (Exception e) {
		}
    }
	public void PdfFour(ActionEvent event) throws Exception{
		try {
			final PDFViewer pdfviewer = new PDFViewer(false);
			lin4 = "https:"+lin4.split(":")[1] ; 
			pdfviewer.openFile(new URL(lin4+".pdf"));
			app.user.add2Read(papers.get(5*(page-1)+3));
		}catch (Exception e) {
		}
	}
	public void PdfFive(ActionEvent event) throws Exception{
		try {
			final PDFViewer pdfviewer = new PDFViewer(false);
			lin5 = "https:"+lin5.split(":")[1] ; 
			pdfviewer.openFile(new URL(lin5+".pdf"));
			app.user.add2Read(papers.get(5*(page-1)+4));
		}catch (Exception e) {
		}
	}
	public void download1(ActionEvent event) throws Exception{
		try {
			lin1 = "https:"+lin1.split(":")[1] ; 
			String title=papers.get(5*(page-1)+0).title;
			title = title.replace(" ", "");
			title = title.replace("\n", "");
			pdfdownload.downLoadByUrl(lin1+".pdf",title+".pdf","C:/Arxiv/");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void download2(ActionEvent event) throws Exception{
		try {
			lin2 = "https:"+lin2.split(":")[1] ; 
			String title=papers.get(5*(page-1)+1).title;
			title = title.replace(" ", "");
			title = title.replace("\n", "");
			System.out.println(lin2);
			System.out.println(title);
			pdfdownload.downLoadByUrl(lin2+".pdf",title+".pdf","C:/Arxiv/");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void download3(ActionEvent event) throws Exception{
		try {
			lin3 = "https:"+lin3.split(":")[1] ; 
			String title=papers.get(5*(page-1)+2).title;
			title = title.replace(" ", "");
			title = title.replace("\n", "");
			pdfdownload.downLoadByUrl(lin3+".pdf",title+".pdf","C:/Arxiv/");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void download4(ActionEvent event) throws Exception{
		try {
			lin4 = "https:"+lin4.split(":")[1] ; 
			String title=papers.get(5*(page-1)+3).title;
			title = title.replace(" ", "");
			title = title.replace("\n", "");
			pdfdownload.downLoadByUrl(lin4+".pdf",title+".pdf","C:/Arxiv/");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void download5(ActionEvent event) throws Exception{
		try {
			lin5 = "https:"+lin5.split(":")[1] ; 
			String title=papers.get(5*(page-1)+4).title;
			title = title.replace(" ", "");
			title = title.replace("\n", "");
			pdfdownload.downLoadByUrl(lin5+".pdf",title+".pdf","C:/Arxiv/");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void collection1(ActionEvent event) throws Exception{
		app.user.add2Liked(papers.get(5*(page-1)+0));
	}
	public void collection2(ActionEvent event) throws Exception{
		app.user.add2Liked(papers.get(5*(page-1)+1));
		}
	public void collection3(ActionEvent event) throws Exception{
		app.user.add2Liked(papers.get(5*(page-1)+2));
	}
	public void collection4(ActionEvent event) throws Exception{
		app.user.add2Liked(papers.get(5*(page-1)+3));
	}
	public void collection5(ActionEvent event) throws Exception{
		app.user.add2Liked(papers.get(5*(page-1)+4));
	}
	public void SetText() {
		Text1.setFont(Font.font("Georgia",20));
		Text2.setFont(Font.font("Georgia",20));
		Text3.setFont(Font.font("Georgia",20));
		Text4.setFont(Font.font("Georgia",20));
		Text5.setFont(Font.font("Georgia",20));
	}
}