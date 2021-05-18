package uk.dangrew.exercises.main;

import uk.dangrew.exercises.io.FileReader;
import uk.dangrew.exercises.io.WordFeed;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;

/**
 * Encapsulates the simple solution to quickly loading a file for analysis.
 */
class WordFeedProvider {

   /**
    * Provides a {@link WordFeed} by requesting the user open a text file.
    * @return the build {@link WordFeed}, or empty if fails to do so.
    */
   Optional< WordFeed > buildWordFeed() {
      Optional< File > selectedFile = selectFile();
      if ( !selectedFile.isPresent() ) {
         System.out.println( "No file has been selected. Unable to perform text analysis." );
         return Optional.empty();
      }

      try {
         return Optional.of( new FileReader( selectedFile.get() ) );
      } catch ( FileNotFoundException e ) {
         System.out.println( String.format(
               "Unable to read selected file %s. Unable to perform text analysis.",
               selectedFile.get().getName()
         ) );
         return Optional.empty();
      }
   }

   /**
    * Brute force swing file chooser, to allow user to select file.
    * @return the file chosen, or empty if not provided for any reason.
    */
   private Optional< File > selectFile() {
      JFileChooser chooser = new JFileChooser();
      FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "Text Files", "txt", "dat"
      );
      chooser.setFileFilter( filter );
      int returnVal = chooser.showOpenDialog( null );
      if ( returnVal == JFileChooser.APPROVE_OPTION ) {
         return Optional.ofNullable( chooser.getSelectedFile() );
      }

      return Optional.empty();
   }
}
