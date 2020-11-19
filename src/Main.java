import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;




public class Main {

    public static void main(String[] args){
        ArrayList<String> prog = new ArrayList<>() ;
        int start=0;
        String startAddress = "";
        //Read file
        try{
            File myObj=new File("in2.txt");
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
                String incHex = Integer.toHexString(start);
                s = incHex + " " +s;
                startAddress = incHex;
                prog.set(i,s);
                //System.out.println(s);
            }
            else if(i==1){
                //System.out.println(startAddress + " " +s);
                prog.set(i,startAddress+" "+s);
            }
            else{
                start+=3;
                String incHex = Integer.toHexString(start);
                s = incHex + " " +s;
                prog.set(i,s);
                //System.out.println(s);
            }
        }
        for(int i =0; i<prog.size(); i++){
            System.out.println(prog.get(i));
        }


    }

}
