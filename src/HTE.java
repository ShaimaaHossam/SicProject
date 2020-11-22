import java.util.ArrayList;

public class HTE {
    ArrayList<String> Temp = new ArrayList<>();
    ArrayList<String> Temp_T = new ArrayList<>();
    ArrayList<String> Temp_ObjCode = new ArrayList<>();
    public String Trecord="";
    public HTE(){ };
    int TLength;
    public void HeaderRecord(String StartAddress,String progName,String EndAddress){
        if (progName.length() != 6) {
            for (int i=progName.length();i < 6;i++){
                progName = progName.concat("_");
            }
        }
        String SAddress = String.format("%06X",Integer.parseInt(StartAddress));
        int StartAddr = Integer.parseInt(StartAddress,16);
        int EndAddr = Integer.parseInt(EndAddress,16);
        TLength = EndAddr - StartAddr;
        String Length = String.format("%06X",TLength);
        System.out.println("H."+progName+"."+SAddress+"."+Length);
    }


    public void TextRecord(ArrayList<String> final_prog_table){
        int i = 1;
        int k = i +11;
        int v = 1;
        while (v != 0){
            if (k <= final_prog_table.size() ){
                for ( i =i ; i<k;i++){
                    String  s1 = final_prog_table.get(i);
                    String[] line = s1.split(" ");
                    Temp.add(s1);
                }
                String[] line1 = Temp.get(Temp.size()-1).split(" ");
                String[] line2 = Temp.get(0).split(" ");
                int IntegerTLenght = Integer.parseInt(line1[0],16) - Integer.parseInt(line2[0],16);
                String Tlength = String.format("%02X",IntegerTLenght);
                System.out.println("\n\n");
                for (int j = 0 ; j < Temp.size()-1;j++){
                    String[] SelectedObjs = Temp.get(j).split(" ");
                    Temp_ObjCode.add("."+SelectedObjs[SelectedObjs.length-1]);
                    Trecord = Trecord.concat(Temp_ObjCode.get(j));
                }

                System.out.println("\nT."+Tlength+Trecord);
                v=0;
            }
            else if(k > final_prog_table.size()){
                k--;
            }
            else{
                v = 0;
            }
        }


    }


    public void EndRecord(String StartAddress){
        String SAddress = String.format("%06X",Integer.parseInt(StartAddress));
        System.out.println("E."+SAddress);
    }
}