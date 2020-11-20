import java.util.ArrayList;

public class pass2 {

    ArrayList<String> prog;
    ArrayList<String> Symbol_table;
    public pass2(ArrayList<String> prog,ArrayList<String> Symbol_table) {
        this.prog = prog;
        this.Symbol_table = Symbol_table;
        System.out.println(Symbol_table);
        this.Objcode();
    }
    Ascii ascii = new Ascii();
    public void Objcode(){
        for (int i =1;i <prog.size();i++)
        {
            String k = prog.get(i);
            System.out.println(k);
            String[] line = k.split(" ");
            if (line.length == 3)
            {
                System.out.println(ascii.getAscii(line[1]));

            }
            else if (line.length == 4)
            {
                System.out.println(ascii.getAscii(line[2]));
            }
            else
            {
                System.out.println("erroooooor");
            }
        }

    }

}
