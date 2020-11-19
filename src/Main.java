import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;




public class Main {

     Dictionary instructionSet = new Hashtable();

    public static void main(String[] args){
        ArrayList<String> prog = new ArrayList<>() ;
        int start=0;
        String startAddress = "";
        //Read file
        try{
            File myObj=new File("in.txt");
            Scanner myReader=new Scanner(myObj);
            while(myReader.hasNextLine()){
                String data=myReader.nextLine();
                prog.add(data);

            }
            myReader.close();
        }
        catch(FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        for(int i=0; i<prog.size(); i++ ){
            String s = prog.get(i);
            //System.out.println(s);
            String[] line = s.split(" ");
            if(line[1].equals("Start") ){
                start = Integer.parseInt(line[2],16);
                String addressHex = String.format("%04X", start);
                s = addressHex + " " +s;
                startAddress = addressHex;
                prog.set(i,s);
                //System.out.println(s);

            }
            else if(line[1].equals("RESW")){

                int n = Integer.parseInt(line[2])*3;
                start+=n;
                String addressHex = String.format("%04X", start);
                s = addressHex + " " +s;
                prog.set(i,s);

            }

            else if(i==1){
                //System.out.println(startAddress + " " +s);
                prog.set(i,startAddress+" "+s);
            }
            else{
                start+=3;
                String addressHex = String.format("%04X", start);
                s = addressHex + " " +s;
                prog.set(i,s);

            }
        }
        for(int i =0; i<prog.size(); i++){
            System.out.println(prog.get(i));
        }


    }


}
