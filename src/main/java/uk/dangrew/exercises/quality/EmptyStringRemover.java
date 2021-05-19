package uk.dangrew.exercises.quality;

/**
 * Implementation of {@link QualityControl} for handling empty strings, or strings with only 
 * space in them.
 */
public class EmptyStringRemover implements QualityControl {

   @Override
   public String applyQualityMeasures( String input ) {
      if ( input == null ) {
         return null;
      }

      String trimmedInput = input.trim();
      if ( trimmedInput.isEmpty() ) {
         return null;
      }

      return trimmedInput;
   }
}
