package utilities;

import java.util.Random;

public class GenericUtility {

  public  String generateRandomPhoneNumber() {
    String phonenumber = "5";
    Random random = new Random();
    phonenumber += random.nextInt(1000000000);
    if (phonenumber.length() != 10) phonenumber += phonenumber.concat("0");
    return phonenumber;
  }
  
  public  static String generateEmail() {
	  String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
      StringBuilder salt = new StringBuilder();
      Random rnd = new Random();
      while (salt.length() < 18) { // length of the random string.
          int index = (int) (rnd.nextFloat() * SALTCHARS.length());
          salt.append(SALTCHARS.charAt(index));
      }
      String saltStr = salt.toString();
      
      return saltStr;
  }

  public  String generateEmail1(String country) {
	  String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
      StringBuilder salt = new StringBuilder();
      Random rnd = new Random();
      while (salt.length() < 18) { // length of the random string.
          int index = (int) (rnd.nextFloat() * SALTCHARS.length());
          salt.append(SALTCHARS.charAt(index));
      }
      String saltStr = country+salt.toString()+"yopmail.com";
      
      return saltStr;
  }

  
}