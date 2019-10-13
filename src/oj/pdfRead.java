package oj;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class pdfRead {

	public void openPdf(File pdf) throws IOException {
		if(pdf.exists()) {
			if(Desktop.isDesktopSupported()) {
				Desktop.getDesktop().open(pdf);
			}else {
				jp("error to open pdf");
			}
		}else {
			jp("error to open pdf");
		}
	}
	
	public void openPdf(String s) throws IOException {
		try {
			File pdf = new File(s);
			//File pdf = new File("data\\problem\\"+s+".pdf");
			//File pdf = new File("E:\\practice\\java swing practice\\swing practice\\data\\problem\\codef.pdf");
			//File pdf = new File("C:\\Users\\MD. Fahim Faisal\\Documents\\dadospdf.com_problem-4a-codeforces-.pdf");
			if(pdf.exists()) {
				if(Desktop.isDesktopSupported()) {
					Desktop.getDesktop().open(pdf);
				}else {
					jp("error to open pdf");
				}
			}else {
				jp("error to open pdf");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			jp("error to open pdf");
			e.printStackTrace();
		}
	}
	
	public void jp(String s) {
		JOptionPane.showMessageDialog(null, s);
	}
}
