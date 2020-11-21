import java.util.ArrayList;

public class pass2 {
    ArrayList<String> prog;
    ArrayList<String> Symbol_table;
    ArrayList<String> Objcode = new ArrayList<>();
    public pass2(ArrayList<String> prog,ArrayList<String> Symbol_table) {
        this.prog = prog;
        this.Symbol_table = Symbol_table;

    }

    public void Objcode(){
        ObjectCodeGenerator objectCode = new ObjectCodeGenerator(prog,Symbol_table);
        for (int i = 0 ; i < prog.size();i++)
        {
            Objcode.add(objectCode.Opcode().get(i)+objectCode.Operand().get(i));
            System.out.println(prog.get(i)+" "+Objcode.get(i));
        }


    }

}
