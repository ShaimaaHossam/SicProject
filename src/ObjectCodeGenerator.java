import java.util.ArrayList;

public class ObjectCodeGenerator {
    ArrayList<String> prog;
    ArrayList<String> Symbol_table;
    ArrayList<String> Opcode_List = new ArrayList<>();
    ArrayList<String> Operand_List = new ArrayList<>();
    public ObjectCodeGenerator(ArrayList<String> prog,ArrayList<String> Symbol_table){
        this.prog = prog;
        this.Symbol_table = Symbol_table;
    }
    public ArrayList<String> Opcode(){
        Ascii ascii = new Ascii();
        for (int i =0;i <prog.size();i++)
        {
            String k = prog.get(i);
            String[] line = k.split(" ");
            if (!line[2].equals("Start")) {
                if (line.length == 3)
                {
                    Opcode_List.add(ascii.getAscii(line[1]));
                }
                else if (line.length == 4)
                {
                    Opcode_List.add(ascii.getAscii(line[2]));
                }
                else
                {
                    Opcode_List.add("Error in Opcode method");
                }
            }
            else if(line[2].equals("Start")){
                Opcode_List.add("");
            }

        }

        return Opcode_List;
    }
    public ArrayList<String> Operand() {
        IndexedMode indexedMode  = new IndexedMode();
        for (int i = 0; i < prog.size(); i++) {

            String k = prog.get(i);
            String[] line = k.split(" ");
            int wordLength = ((line[2].length())-1);
            int IndexedMode = ((line[2].length())-2);
            if (!line[2].equals("Start")){
                if (line.length == 4) {
                    if ((!line[2].equals("RESW"))&&(!line[2].equals("RSUB"))&&(!line[2].equals("WORD"))&&(!line[2].equals("BYTE"))){
                        for (int j = 0; j < Symbol_table.size(); j++) {
                            String St_record = Symbol_table.get(j);
                            String[] wordNumber = St_record.split(" ");
                            if (line[3].equals(wordNumber[1])) {
                                Operand_List.add(wordNumber[0]);
                            }
                        }
                    }
                    else if(line[2].equals("RESW")) Operand_List.add("On Object Code") ;
                    else if(line[2].equals("RSUB")) Operand_List.add("0000");
                    else if(line[2].equals("WORD")){
                        int x = Integer.parseInt(line[3]);
                        Operand_List.add(String.format("%04X",x));
                    }
                    else if(line[2].equals("BYTE"))
                    {
                        Double x = Double.parseDouble(line[3]);
                        if (x.isNaN()){
                            Operand_List.add("ascii code of each char و ليلة سودة");
                        }
                        else {
                            int y = Integer.parseInt(line[3]);
                            Operand_List.add(String.format("%04X",y));
                        }
                    }
                    else if(line[2].substring(IndexedMode,wordLength).equals(",")) Operand_List.add("Indexed Mode");
                    else{
                        Operand_List.add("error in Operand line.length 4");
                    }

                } else if (line.length == 3) {
                    if(!line[2].substring(IndexedMode,wordLength).equals(",")){
                        for (int j = 0; j < Symbol_table.size(); j++) {
                            String St_record = Symbol_table.get(j);
                            String[] wordNumber = St_record.split(" ");
                            if (line[2].equals(wordNumber[1])) {
                                Operand_List.add(wordNumber[0]);
                            }
                        }
                    }
                    else if(line[2].substring(IndexedMode,wordLength).equals(",")) {
                        for (int j = 0; j < Symbol_table.size(); j++) {
                            String St_record = Symbol_table.get(j);
                            String[] wordNumber = St_record.split(" ");
                            if (line[2].substring(0,IndexedMode).equals(wordNumber[1])) {
                                Operand_List.add(indexedMode.indexedModeConverter(wordNumber[0]));
                            }
                        }
                    }
                    else Operand_List.add("error in line.length 3");

                }
                else Operand_List.add("Error from operand line lenght"); ;
            }
            else if(line[2].equals("Start")){
                Operand_List.add("");
            }

        }
        return Operand_List;
    }

}
