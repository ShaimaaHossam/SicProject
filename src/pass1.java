import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.math.BigInteger;

public class pass1 {

    ArrayList<String> prog;
    ArrayList<String> symbols = new ArrayList<>();
    BigInteger start ;
    String startAddress = "";

    public ArrayList<String> read_file()
    {
        System.out.println("PASS 1 READ: \n");
        prog = new ArrayList<>() ;
        //Read file
        try{

            File myObj=new File("in.txt");
            Scanner myReader=new Scanner(myObj);
            while(myReader.hasNextLine()){
                String data=myReader.nextLine();
                System.out.println(data);
                prog.add(data);
            }
            myReader.close();

        }
        catch(FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return prog;
    }

    public ArrayList<String> Generate_LOCCR(){
        System.out.println("\n\n\nGENERATE LOCATION COUNTER: \n");
        for(int i=0; i<prog.size(); i++ ){

            String s = prog.get(i);
            String[] line = s.split(" ");
            if(line[1].equals("Start") ){
                start = new BigInteger(line[2], 16);
                String addressHex = String.format("%04X", start);
                s = addressHex + " " +s;
                startAddress = addressHex;
                prog.set(i,s);
            }
            else if(line[1].equals("RESW") && Integer.parseInt(line[2]) >1){
                int address = Integer.parseInt(line[2])*3;
                String num = Integer.toHexString(address);
                BigInteger n = new BigInteger(num, 16);
                String addressHex = String.format("%04X", start);
                s = addressHex + " " +s;
                prog.set(i,s);
                start = start.add(n);
            }

            else if(i==1){
                prog.set(i,startAddress+" "+s);
                start = start.add(new BigInteger("3",16));
            }
            else{

                String addressHex = String.format("%04X", start);
                s = addressHex + " " +s;
                prog.set(i,s);
                start = start.add(new BigInteger("3", 16));
            }
        }

        for(int i =0; i<prog.size(); i++){
          System.out.println(prog.get(i));
        }

        return prog;
    }

    public ArrayList<String> Symbol_table(){
        System.out.println("\n\nSYMBOL TABLE:\n");
        for(int i=1; i<prog.size(); i++){
            String instruction = prog.get(i);
            String[] line = instruction.split(" ");
            if(line.length > 3 ){
                symbols.add(line[0] + " "+line[1]);
            }
        }

        for(int i =0; i<symbols.size(); i++){
           System.out.println(symbols.get(i));
        }
        return symbols;
    }
}
