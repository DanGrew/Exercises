
package uk.dangrew.exercises.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader implements WordFeed {

   private final Scanner scanner;

   public FileReader( String fileName ) throws FileNotFoundException {
      this( new File( fileName ) );
   }

   public FileReader( File file ) throws FileNotFoundException {
      this( new Scanner( file ) );
   }

   FileReader( Scanner scanner ) {
      this.scanner = scanner;
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
