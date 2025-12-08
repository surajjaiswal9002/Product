package com.Target.Product.LowLevelDesign;


 interface BaseEncoder {

  /**
   * Encode a base 10 number into the target base.
   *
   * @param number number to encode
   * @return encoded string
   */
  String encode(long number);

  /**
   * Decode a number string from the target base into base 10.
   *
   * @param number encoded string
   * @return decoded base 10 number
   */
  long decode(String number);
}

public class Base10Encoder implements BaseEncoder {

  private final int base;
  private final String characters;

  public static final BaseEncoder BASE_2 =
      new Base10Encoder(2, "01");
  public static final BaseEncoder BASE_16 =
      new Base10Encoder(16, "0123456789ABCDEF");
  public static final BaseEncoder BASE_62 =
      new Base10Encoder(62, "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
  public static final BaseEncoder BASE_58 =
      new Base10Encoder(58, "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz");

  public Base10Encoder(int base, String characters) {
    this.base = base;
    this.characters = characters;
  }

  @Override
  public String encode(long number) {
    if (number == 0) return String.valueOf(characters.charAt(0));

    StringBuilder stringBuilder = new StringBuilder();
    while (number > 0) {
      int remainder = (int) (number % base);
      stringBuilder.insert(0, characters.charAt(remainder));
      number /= base;
    }
    return stringBuilder.toString();
  }

  @Override
  public long decode(String number) {
    long result = 0L;
    int length = number.length();
    for (int i = 0; i < length; i++) {
      int index = characters.indexOf(number.charAt(length - i - 1));
      if (index == -1) {
        throw new IllegalArgumentException("Invalid character found: " + number.charAt(length - i - 1));
      }
      result += (long) Math.pow(base, i) * index;
    }
    return result;
  }
  
  
  public static void main(String[] args) {
	    BaseEncoder base16 = Base10Encoder.BASE_16;
	    BaseEncoder base62 = Base10Encoder.BASE_62;

	    long number = 123456789L;

	    String encodedHex = base16.encode(number);
	    String encoded62 = base62.encode(number);

	    System.out.println("Base 10 : " + number);
	    System.out.println("Base 16 : " + encodedHex);
	    System.out.println("Base 62 : " + encoded62);

	    System.out.println("Decoded (Base 16): " + base16.decode(encodedHex));
	    System.out.println("Decoded (Base 62): " + base62.decode(encoded62));
	  }
}
