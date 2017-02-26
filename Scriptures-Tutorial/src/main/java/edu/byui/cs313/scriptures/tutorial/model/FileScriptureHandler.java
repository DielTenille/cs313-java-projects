/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.cs313.scriptures.tutorial.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author t2alaska
 */
public class FileScriptureHandler implements ScriptureDataHandler {
    
    private String fileName;
    
    public FileScriptureHandler(String fileName) {
       this.fileName = fileName;
    }

    public String getFileName() {
           return fileName;
    }

    public void setFileName(String fileName) {
           this.fileName = fileName;
    }
    
    public void addScripture(Scripture scripture) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(getFileName(), true));
            writer.write(scripture.toFileString() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
     public List<Scripture> getFavoriteScriptures() {
          List<Scripture> list = new ArrayList<Scripture>();

          try {
               BufferedReader reader = new BufferedReader(new FileReader(getFileName()));

               String line;

               while ((line = reader.readLine()) != null) {
                    Scripture scripture = new Scripture();
                    scripture.loadFromFileString(line);
                    list.add(scripture);
               }

          } catch (IOException e) { 
               e.printStackTrace();
          }

          return list;
     }
}
