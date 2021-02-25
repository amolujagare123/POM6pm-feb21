package utilities;

public class Conversion {

    public static  String convertCountry(String shortCounty)
    {
        String convertedCountry ="";

        switch (shortCounty)
        {
            case "IN" : convertedCountry ="India"; break;
            case "BD" : convertedCountry ="Bangladesh"; break;
            case "BH" : convertedCountry ="Bahrain"; break;
            case "CN" : convertedCountry ="China"; break;
            case "HU" : convertedCountry ="Hungary"; break;
        }

        return convertedCountry;
    }

}
