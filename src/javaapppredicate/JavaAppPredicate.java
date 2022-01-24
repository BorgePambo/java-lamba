package javaapppredicate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class JavaAppPredicate {

    
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
       
        String path = "B:\\temp\\product.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            List<Product> list = new ArrayList<>();
            String line = br.readLine();
            while(line != null){
                String[] field = line.split(",");
                String name = field[0];
                Double price = Double.parseDouble(field[1]);
                list.add(new Product(name, price));
                line = br.readLine();
            }
            
            double sum = ProductService.filterProduct(list, x -> x.getName().charAt(0) == 'T');
            System.out.println(sum);
            
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        
        
    }
    
}
