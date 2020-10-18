public class HtmlStatement extends Statement {
    protected String headerString(Customer aCustomer) { // cabeçalho
      return "<H1>Rentals for <EM>" + aCustomer.getName() + "</EM></H1><P>\n";
    }
  
    protected String bodyString(Rental rental) { // corpo do texto
      return rental.getMovie().getTitle()+ ": " + String.valueOf(rental.getCharge()) + "<BR>\n";
    }
  
    protected String footerString(Customer aCustomer) {
      String footer = "<P>You owe <EM>" +
      String.valueOf(aCustomer.getTotalCharge()) + "</EM><P>\n";
  
      footer += "On this rental you earned <EM>" + 
      String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
      "</EM> frequent renter points<P>";
  
      return footer;
    }
  }