package Utilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertTrue;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class DOMElements {
    static String filePath = ".//DOMElements//DOMElementsNew.csv";

    static List<String[]> elementsList = new ArrayList<String[]>();

    private static void readFile(){
        try {
            FileReader filereader = new FileReader(filePath);
            CSVReader csvReader = new CSVReader(filereader);

            String[] nextElement;
            while ((nextElement = csvReader.readNext()) != null) {
                elementsList.add(nextElement);
            }

            csvReader.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getXpath(String elementName, String pageName) {
        readFile();
        String elem;
        try {
            for (String[] element : elementsList) {
                if (element[0].equals(elementName) && element[3].equals(pageName)) {
                    if (!element[1].isEmpty()) {
                        elem = element[1].trim();
                        return elem;
                    } else {
                        elem = element[2].trim();
                        return elem;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("\nException caught");
        }

        for (String[] element : elementsList) {
            if(element[0].equals(elementName) && element[3].equals("common")){
                if(!element[1].isEmpty()){
                    elem = element[1].trim();
                    return elem;
                }
                else{
                    elem = element[2].trim();
                    return elem;
                }
            }
        }
//        System.out.println(elementName + " Page Name: " + pageName);
//        assertTrue("'" + elementName + "' on page '" + pageName + "' should be present in DOMElements", false);
        return "";
    }

}
