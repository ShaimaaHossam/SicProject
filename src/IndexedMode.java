public class IndexedMode {
    public  IndexedMode(){ }
    public static final String[][] Index_table= {
            {"0" , "8"} ,{"1" , "9"} ,{"2" , "A"}
            ,{"3" , "B"} ,{"4" , "C"} ,{"5" , "D"}
            ,{"6" , "E"} ,{"7" , "F"}
    };
    public String indexedModeConverter(String x){
        String IndexedBit = x.substring(0,1);
        for (int i = 0 ; i < Index_table.length ; i++){
            if (IndexedBit.equals(Index_table[i][0])){
                return Index_table[i][1].concat(x.substring(1));
            }
        }
        return "-1";
    }
}
