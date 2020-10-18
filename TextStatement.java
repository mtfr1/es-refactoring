public class TextStatement extends Statement {
    protected String headerString(Customer aCustomer) { // cabeçalho
      return "Rental Record for " + aCustomer.getName() + "\n";
    }
  
    protected String bodyString(Rental rental) { // corpo do texto
      return "\t" + rental.getMovie().getTitle()+ "\t" + 
             String.valueOf(rental.getCharge()) + "\n";
    }
  
    protected String footerString(Customer aCustomer) {
      String footer = "Amount owed is " + String.valueOf(aCustomer.getTotalCharge()) + "\n";
      footer += "You earned " + String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
                " frequent renter points";
      
      return footer;
    }
  }