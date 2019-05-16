public class StarRating {

  public static String interpret(double rating) {

    String review = " ";

    if (rating > 5 || rating < 1) {
      throw new IllegalArgumentException("Film rating out of bounds");
    } else if (rating == 5) {
      review = "[HAS ONLY ONE REVIEW]";
    } else if (rating >= 4.5) {
      review = "EXCELLENT";
    } else if (rating >= 4) {
      review = "OK";
    } else if (rating >= 1) {
      review = "CRAP";
    }

    return review;
  }

}
