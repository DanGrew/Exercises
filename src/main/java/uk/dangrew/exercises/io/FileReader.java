
package uk.dangrew.exercises.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader implements WordFeed {
   
   private final String fileName;
   private Scanner scanner;
   
   public FileReader(String fileName) {
      this.fileName = fileName;
      try {
         this.scanner = new Scanner(new File(fileName));
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
   }
   
   @Override
   public boolean hasNext() {
      return scanner.hasNext();
   }
   
   @Override
   public String next() {
      return scanner.next();
   }
}
