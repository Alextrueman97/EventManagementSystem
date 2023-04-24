import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.Writer;
import java.io.IOException;




public class MenuReader{
    
    
    public static void menuReader(){
        
        try{
            Reader read = new FileReader("menu.txt");
            BufferedReader br = new BufferedReader(read);
            String line = null;
            while((line = br.readLine()) !=null){  //The null represents the end of the file 
                System.out.println(line);
            }
            read.close();
            br.close();
        
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    
    
    
    
}
