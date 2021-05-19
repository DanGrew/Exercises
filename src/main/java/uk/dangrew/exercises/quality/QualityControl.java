package uk.dangrew.exercises.quality;

/**
 * Api for peforming quality control on an input string. This could include removing characters
 * or correcting text.
 */
public interface QualityControl {

   /**
    * Applies the associated quality control to the given input, returning a version that
    * complies with this control.
    * @param input to quality control.
    * @return the quality controlled version of the input.
    */
   public String applyQualityMeasures( String input );
}
