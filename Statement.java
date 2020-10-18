import java.util.Enumeration;

public abstract class Statement {
  protected abstract String headerString(Customer aCustomer);
  protected abstract String bodyString(Rental rental);
  protected abstract String footerString(Customer aCustomer);

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