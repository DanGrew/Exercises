package uk.dangrew.exercises.report;

/**
 * Implementation of {@link Reporter} that just collates the messages into one resulting string.
 */
public class StringBuilderReporter implements Reporter {

   private final StringBuilder stringBuilder;

   /**
    * Constructs a new {@link StringBuilderReporter}.
    */
   public StringBuilderReporter() {
      this.stringBuilder = new StringBuilder();
   }

   @Override
   public void report( Report report ) {
      stringBuilder.append( report.getMessage() );
   }

   /**
    * Provides the result which collates all messages from analysis.
    * @return the resulting output.
    */
   public String getResult() {
      return stringBuilder.toString();
   }
}
