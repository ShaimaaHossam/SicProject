import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args){

        ArrayList<String> original_file;
        ArrayList<String> code_plus_address;

        pass1 p1 = new pass1();
        original_file = p1.read_file();
        code_plus_address = p1.Generate_LOCCR();
        p1.Symbol_table();

        pass2 p2 = new pass2(original_file);
    }


}
