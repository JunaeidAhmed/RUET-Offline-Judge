/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oj;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTable;

/**
 *
 * @author Junaeid
 */
public class textrecord {
    
    public void writein(String[] ad) throws IOException{
         BufferedWriter in,probin;
                in = new BufferedWriter(new FileWriter("Data\\Probleminfo\\Problems.txt",true));
                in.write(ad[0]);
                in.write("\t");
                in.write(ad[1]);
                in.write("\t");
                in.write(ad[2]);
                in.write("\n");
      probin = new BufferedWriter(new FileWriter("Data\\Probleminfo\\Probname.txt"));
      probin.write(ad[1]);
      in.close();
      probin.close();
    }
    public void submission(String[] ad) throws IOException{
        BufferedWriter in,probin;
                in = new BufferedWriter(new FileWriter("Data\\Submissions\\submissions.txt",true));
                in.write(ad[0]);
                in.write(" \t ");
                in.write(ad[1]);
                in.write(" \t ");
                in.write(ad[2]);
                in.write(" \t ");
                in.write(ad[3]);
                in.write(" \t ");
                in.write(ad[4]);
                in.write(" \t ");
                in.write(ad[5]);
                in.write("\n");
  
      in.close();
  
    }
    public void mysub(String[] ad,String us) throws IOException{
         BufferedWriter in;
                in = new BufferedWriter(new FileWriter("Data\\Submissions\\"+us+"sub.txt",true));
                in.write(ad[0]);
                in.write(" \t ");
                in.write(ad[1]);
                in.write(" \t ");
                in.write(ad[2]);
                in.write(" \t ");
                in.write(ad[3]);
                in.write(" \t ");
                in.write(ad[4]);
                in.write("\n");
  
      in.close();
    }
}
