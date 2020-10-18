import java.util.Enumeration;

public class TextStatement extends Statement {
  private String headerString(Customer aCustomer) { // cabeçalho
    return "Rental Record for " + aCustomer.getName() + "\n";
  }

  private String bodyString(Rental rental) { // corpo do texto
    return "\t" + rental.getMovie().getTitle()+ "\t" + 
           String.valueOf(rental.getCharge()) + "\n";
  }

  private String footerString(Customer aCustomer) {
    String footer = "Amount owed is " + String.valueOf(aCustomer.getTotalCharge()) + "\n";
    footer += "You earned " + String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
              " frequent renter points";
    
    return footer;
  }

  public String value(Customer aCustomer) {
    Enumeration rentals = aCustomer.getRentals();
    String result = headerString(aCustomer);

    while (rentals.hasMoreElements()) {
        Rental each = (Rental) rentals.nextElement();
        //show figures for this rental
        result += bodyString(each);
    }

    //add footer lines
    result += footerString(aCustomer);
    
    return result;
  }
}