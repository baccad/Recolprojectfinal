//Code by Dupe and Kevin
//This is class named cart that contains the information about the product that has been purchased.


public class Cart
{
  
  String productName,shippingAddress;   //Name of the product bought and the shipping address.
  double price,shippingPrice,tax,finalPrice;    //The price of the product, shipping price, tax and the final price.
  int quantity;         //How many products are bought.
  double creditCardNumber;      //      The credit card of the user to buy the product.
  int expirationMonthandYear,cvv;       //Expiration month and year of the credit card of the user and CVV on the back of the card.


  //Constructor of class cart.
  public Cart(String newProductName, String newShippingAddress, int newQuantity, double newPrice, double newCredit, int newExpiration, int newCVV)		
{
  productName = newProductName;     //assigning the name of the product.
    shippingAddress = newShippingAddress;       //      Update the shipping address
    quantity = newQuantity;                 //Set the number of quantities for user to buy.
    price = newPrice;
    creditCardNumber = newCredit;
	expirationMonthandYear = newExpiration;		
	cvv = newCVV;
}


  public void setPrice(double newPrice,double newShippingPrice,double newTax){
  price=newPrice;
  shippingPrice=newShippingPrice;
  tax=newTax;
}
  
  public void setCreditCard(double newCreditNumber,int newExpiration,int newCvv){
  creditCardNumber=newCreditNumber;
  expirationMonthandYear=newExpiration;
    cvv=newCvv;
}

public double getCreditCard(){
	return creditCardNumber;
}

public String getName(){
    return productName;
}

public int getExpiration(){
	return   expirationMonthandYear;
}

public int getCVV(){
	return cvv;
}

public String getShippingAdress(){
    return shippingAddress;
}

public double finalPrice(){
    //Shipping cost is $2.99
    //Tax is 10%
    finalPrice = (price * quantity);
    finalPrice = finalPrice + (finalPrice * 0.10) + 2.99;
    
    return finalPrice;
}

}