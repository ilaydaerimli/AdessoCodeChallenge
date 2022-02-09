import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Earthquake {
    //Dosyadan okuduğumuz verileri bir liste atacağız. Country, Place of the earthquake, magnitude, date and time of the earthquake şeklinde tutacağız.
    static LinkedList listOfCountries = new LinkedList();


    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the country (The first letter must be uppercase letter): ");
        String country = input.nextLine();

        System.out.println("Please enter the count of days: ");
        int countOfDays = input.nextInt();


        FileReader fileReader = new FileReader("EarthquakesFile.txt");
        String line;

        BufferedReader br = new BufferedReader(fileReader);

        while ((line = br.readLine()) != null) {
            if (line.contains(country)){
                //Kelimeleri bölmek lazım ve bölünmüş şekilde placeOfTheEarthq'ten sonraki kelime olarak bakman ve eklemen lazım.
                splitSentence(line);

            }
        }
        System.out.println("List of countries: ");
        System.out.println(listOfCountries);

        br.close();


        if(listOfCountries != null){
            Iterator iter = listOfCountries.iterator();

            for (int i = 0; i < listOfCountries.size(); i++){
                //System.out.println(iter.next());
            }
        }
        else{
            System.out.println("No Earthquakes were recorded past {countOfDays} days");
        }


    }


    static void splitSentence(String sentence) {
        //String[] arrSplit = sentence.split(" \":\" ");
        String[] arrSplit = sentence.split(",");

        String placeOfTheEarthquake = null, country = null, dateAndTime = null, magnitude = null;

        //BURADAKİ IFLER DOĞRU SAĞLARSAN KOD ÇALIŞACAK
        for(int i = 0; i < arrSplit.length; i++){
            System.out.println(arrSplit[i]);
            if(arrSplit[i].contains("place")){
                country = arrSplit[i+1];
            }
            if(arrSplit[i].contains("time")){
                dateAndTime = arrSplit[i+1];
            }
            if(arrSplit[i].contains("mag")){
                magnitude = arrSplit[i+1];
            }
            String newVariable = "Country: " + country + ", Place of the eathquake: " + placeOfTheEarthquake + ", Magnitude: " + magnitude + ", Date and Time: " + dateAndTime;
            listOfCountries.add(newVariable);
        }


    }
}
