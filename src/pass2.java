import java.util.ArrayList;

public class pass2 {
    ArrayList<String> prog;
    ArrayList<String> Symbol_table;
    ArrayList<String> Objcode = new ArrayList<>();
    ArrayList<String> final_prog_table = new ArrayList<>();
    public pass2(ArrayList<String> prog,ArrayList<String> Symbol_table) {
        this.prog = prog;
        this.Symbol_table = Symbol_table;

    }

    public void Objcode(){
        ObjectCodeGenerator objectCode = new ObjectCodeGenerator(prog,Symbol_table);
        for (int i = 0 ; i < prog.size();i++)
        {
            Objcode.add(objectCode.Opcode().get(i)+objectCode.Operand().get(i));
            final_prog_table.add(prog.get(i)+" "+Objcode.get(i));
        }
//        System.out.println(final_prog_table);
    }

    public void HteRecord(){
        HTE hte = new HTE();
        int EndAddress = (final_prog_table.size())-1;
        for (int i = 0 ; i < final_prog_table.size();i++){
            String Record = final_prog_table.get(i);
            String[] line = Record.split(" ");
            if (line[2].equals("Start")){
                String[] EndRecord = final_prog_table.get(EndAddress).split(" ");
                hte.HeaderRecord(line[0],line[1],EndRecord[0]);
            }
            else if (line[1].equals("End")){
                String[] StartRecord = final_prog_table.get(0).split(" ");
                hte.EndRecord(StartRecord[0]);
            }
        }
        hte.TextRecord(final_prog_table);
    }

}
