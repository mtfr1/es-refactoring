import java.util.Enumeration;

public class HtmlStatement extends Statement {
  private String headerString(Customer aCustomer) { // cabeçalho
    return "<H1>Rentals for <EM>" + aCustomer.getName() + "</EM></H1><P>\n";
  }

  private String bodyString(Rental rental) { // corpo do texto
    return rental.getMovie().getTitle()+ ": " + String.valueOf(rental.getCharge()) + "<BR>\n";
  }

  private String footerString(Customer aCustomer) {
    String footer = "<P>You owe <EM>" +
    String.valueOf(aCustomer.getTotalCharge()) + "</EM><P>\n";

    footer += "On this rental you earned <EM>" + 
    String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
    "</EM> frequent renter points<P>";

    return footer;
  }

  public String value(Customer aCustomer) {
    Enumeration rentals = aCustomer.getRentals();
    String result = headerString(aCustomer);
    
    while (rentals.hasMoreElements()) {
        Rental each = (Rental) rentals.nextElement();
        //show figures for each rental
        result += bodyString(each);
    }

    //add footer lines
    result += footerString(aCustomer);

    return result;
  }
}