 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oj;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class CChecking {
	


	private String fnamecompile;
	private String fnamerun;
	private String problemid;
	private String problemidin;
	private String problemiduserout;
	private String problemidout;
	private String p;

	public CChecking(String fnamecompile,String problemid) {
		//super();
		this.fnamecompile = fnamecompile;
		this.fnamerun="a.exe";
		this.problemid = problemid;
		this.problemidout = problemid+"_out.txt";
		this.problemidin = problemid+"_in.txt";
		this.problemiduserout = problemid+".txt";
		//System.out.println(fnamerun);
		
	}
	public String compilec() {
		int er=0;
		//String compileString = "javac "+"Show1.java";
		String compileString = "gcc "+fnamecompile;
		try {
			
			Process process = Runtime.getRuntime().exec(compileString);		
			InputStream is = process.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			BufferedReader bre = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			
			String line ;
			
			while((line=bre.readLine())!=null) {
				//System.out.println("error msg");
				//System.out.println(line);
				er++;		
			}
			bre.close();
			
			while((line=br.readLine())!=null) {
				//System.out.println(line);	
			}
			br.close();		
			
			process.destroy();
			int k =process.exitValue();
			//System.out.println(k);			
			is.close();
			
			if(er!=0) {
				return "Compilation Error";	
			}
			else {
				return runc();
                                //return "Compiled";
			}
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String runc() {
		int er=0;
		long  start,end;
		
		try {
			String []str = {"cmd"};
			String []str1 = {"cmd","javac Show.java",fnamerun};	
			//Process process = Runtime.getRuntime().exec("java "+"Show1");
			start = System.currentTimeMillis();
			Process process = Runtime.getRuntime().exec(fnamerun);
			//Process process = new ProcessBuilder("cmd").start();
			FileReader fr = new FileReader(problemidin);
			BufferedReader brin = new BufferedReader(fr);
			String lineString;
			
			OutputStream os = process.getOutputStream();
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
                        
			while ((lineString = brin.readLine())!=null) {
				bw.write(lineString+"\n");
				System.out.println(lineString);
				bw.flush();
			}

			//System.out.println("kk");
			int i=0;
			boolean deadYet = false;
			do {
				Thread.sleep(1000);
				try {
					process.exitValue();
					deadYet = true;
				} catch (IllegalThreadStateException e) {
					System.out.println("Not done yet...");
					if (++i >= 5) {
						process.destroyForcibly();
						return "Time Limit Execeeded";
					}
				}
			} while (!deadYet);
	
			InputStream is = process.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			BufferedReader bre = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			String line ;
//			os.close();
//			is.close();
			//process.destroy();
			
			while((line=bre.readLine())!=null) {
				//System.out.println("error msg");
				//System.out.println(line);
				er++;		
			}
			bre.close();
			FileWriter fw1 = new FileWriter(problemiduserout);
			FileWriter fw = new FileWriter(problemiduserout,true);
			//fW.write("file writing\nnew");
			PrintWriter pw = new PrintWriter(fw);
			
			while((line=br.readLine())!=null) {

				//System.out.println("pp");
				System.out.println(line);
				pw.println(line);
				if (line.equals("")) {
					System.out.println("equl");
				}
			}
			pw.close();
        
			
			is.close();
                      
                        os.close();
			//Thread.sleep(2000);
		
			try {
                process.exitValue();
                //process.
                //deadYet = true;
            } catch (IllegalThreadStateException e) {
                System.out.println("Not done yet2...");
                process.destroy();
               // if (++i >= 5) throw new RuntimeException("timeout");
            }

			System.out.println(process.isAlive());
			if(process.isAlive()) {
				System.out.println("pp");
				process.destroy();
				//return "Time Limit Execeeded";
			}	
			
			process.destroy();
			end = System.currentTimeMillis();
			//System.out.println("time"+(end-start));
		
			if(er!=0) {
				return "Runtime error";
			}
			else if ((end-start)>5000) {
				System.out.println("time"+(end-start));
				return "Time Limit Execeeded";
			}
			else {
				return outputcheck();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
        
	public String outputcheck() throws IOException, InterruptedException {

		boolean result= false;
		
		FileReader fr = new FileReader(problemidout);
		BufferedReader bro = new BufferedReader(fr);
		String lineString;
		
		FileReader fr1 = new FileReader(problemiduserout);
		BufferedReader bro1 = new BufferedReader(fr1);
		String lineString1;
		
		while (true) {
			lineString = bro.readLine();
			lineString1= bro1.readLine();
			if (lineString==null && lineString1!=null) {
				result=false;
				break;
			}else if (lineString!=null && lineString1==null) {
				result=false;
				break;
			}
			else if (lineString==null && lineString1==null) {
				break;
			}
			if(lineString.equals(lineString1)) {
				System.out.println(lineString +"  "+lineString1);
				result = true;
				//break;
			}
			else {
				result = false;
				System.out.println(result);
				break;
			}
		}
		bro.close();
		bro1.close();
		if (result) {
			//System.out.println("cld");
			return "Accepted";
		}
		else {
			//System.out.println("wa cld");
			return "Wrong Answer";
		}
	}

}