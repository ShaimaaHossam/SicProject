import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class pass1 {

    ArrayList<String> prog;
    ArrayList<String> symbols = new ArrayList<>();
    int start=0;
    String startAddress = "";

    public ArrayList<String> read_file()
    {
        prog = new ArrayList<>() ;
        //Read file
        try{

            File myObj=new File("in.txt");
            Scanner myReader=new Scanner(myObj);
            while(myReader.hasNextLine()){
                String data=myReader.nextLine();
//                System.out.println(data);
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
//        System.out.println("\n\n\nGENERATE LOCATION COUNTER: \n");
        for(int i=0; i<prog.size(); i++ ){
            String s = prog.get(i);

            String[] line = s.split(" ");
            if(line[1].equals("Start") ){
                start = Integer.parseInt(line[2]);
                String addressHex = String.format("%04X", start);
                s = addressHex + " " +s;
                startAddress = addressHex;
                prog.set(i,s);
            }
            else if(line[1].equals("RESW") && Integer.parseInt(line[2]) >1){

                int n = Integer.parseInt(line[2]);
                String addressHex = String.format("%04X", start);
                s = addressHex + " " +s;
                prog.set(i,s);
                start = start + n*3;
            }

            else if(i==1){
                //System.out.println(startAddress + " " +s);
                prog.set(i,startAddress+" "+s);
                start+=3;
            }
            else{

                String addressHex = String.format("%04X", start);
                s = addressHex + " " +s;
                prog.set(i,s);
                start+=3;
            }
        }
        for(int i =0; i<prog.size(); i++){
//            System.out.println(prog.get(i));
        }

        return prog;
    }

    public ArrayList<String> Symbol_table(){
//        System.out.println("\n\nSYMBOL TABLE:");
        for(int i=1; i<prog.size(); i++){
            String instruction = prog.get(i);
            String[] line = instruction.split(" ");
            if(line.length > 3 ){
                //symbols.add(line[1]);
                symbols.add(line[0] + " "+line[1]);
            }
        }

        for(int i =0; i<symbols.size(); i++){
//            System.out.println(symbols.get(i));
        }
        return symbols;
    }
}
