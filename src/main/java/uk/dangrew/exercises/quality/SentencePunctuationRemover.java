package uk.dangrew.exercises.quality;

/**
 * Implementation of {@link QualityControl} to remove sentence punctuation such as full stops
 * from words, when then do not contain numbers.
 */
public class SentencePunctuationRemover implements QualityControl {

   private static final String NUMBER_REGEX = ".*\\d";

   private static final String PUNCTUATION_REGEX = String.join(
         "|", "\\.", "\\,", "\\:", "\\;", "\\?", "\\!", "\\*",
         "\\{", "\\}", "\\[", "\\]", "\\(", "\\)", "\\<", "\\>", "\\\""
   );

   @Override
   public String applyQualityMeasures( String input ) {
      if ( input == null ) {
         return null;
      }
      if ( input.matches( NUMBER_REGEX ) ) {
         return input;
      }
      return input.replaceAll( PUNCTUATION_REGEX, "" );
   }

}
