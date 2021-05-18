
package uk.dangrew.exercises.io;

import java.util.Collection;
import java.util.Iterator;

import static java.util.Arrays.asList;

/**
 * Implementation of {@link WordFeed} with a simple backing {@link Iterator} of strings.
 */
public class ListWordFeed implements WordFeed {

   private final Iterator< String > feed;

   /**
    * Constructs a new {@link ListWordFeed}.
    * @param words the feed is to iterate through.
    */
   public ListWordFeed( String... words ) {
      this( asList( words ) );
   }

   /**
    * Constructs a new {@link ListWordFeed}.
    * @param words the feed is to iterate through.
    */
   public ListWordFeed( Collection< String > words ) {
      this.feed = words.iterator();
   }

   @Override
   public boolean hasNext() {
      return feed.hasNext();
   }

   @Override
   public String next() {
      return feed.next();
   }
}
