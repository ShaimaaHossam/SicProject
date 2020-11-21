import java.util.ArrayList;

public class Ascii {
    ArrayList<String> Symbol_table;
    public static final String[][] Mnemonic_Opcode = {
            {"ADD" , "18"} ,{"AND" , "40"} ,{"COMP" , "28"}
            ,{"DIV" , "24"} ,{"J" , "3C"} ,{"JEQ" , "30"}
            ,{"JGT" , "34"} ,{"JLT" , "38"} ,{"JSUB" , "28"}
            ,{"LDA" , "00"} ,{"LDCH" , "50"} ,{"LDL" , "08"}
            ,{"LDX" , "04"} ,{"MUL" , "20"} ,{"OR" , "44"}
            ,{"RSUB" , "4C"} ,{"STA" , "0C"} ,{"STCH" , "54"}
            ,{"STL" , "14"} ,{"STSW" , "E8"} ,{"STX" , "10"}
            ,{"SUB" , "1C"} ,{"TD" , "E0"} ,{"TIX" , "2C"}
            ,{"WD" , "DC"},{"RESW" , ""},{"WORD" , "00"},
            {"End" , "END"}
    };
    public Ascii(){ }
    public String getAscii(String mnem)
    {
        for(int i = 0 ; i < Mnemonic_Opcode.length ; i++)
        {
            if(mnem.equals(Mnemonic_Opcode[i][0]))
            {
                return Mnemonic_Opcode[i][1];
            }
        }
        return "-1";
    }

    public static String[][] getMNEM_HEXDECIMAL() {
        return Mnemonic_Opcode;
    }

}
