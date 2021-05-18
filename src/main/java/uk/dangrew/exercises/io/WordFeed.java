package uk.dangrew.exercises.io;

import uk.dangrew.exercises.algorithm.TextAnalyzer;

import java.util.Iterator;

/**
 * Api for providing words to the {@link TextAnalyzer}. This hides the source of data to support
 * different possible access routes to the raw text data.
 */
public interface WordFeed {

   /**
    * Determines whether the feed has any more words to process.
    * @return true if there are words to process.
    */
   public boolean hasNext();

   /**
    * Provides the next string to process, removing it from the feed. Note that this functions
    * similarly, if not identically, to {@link Iterator#next()}. Therefore, {@link #hasNext()}
    * should be used to determine when the end of the feed has been reached.
    * @return the next string.
    */
   public String next();
}
