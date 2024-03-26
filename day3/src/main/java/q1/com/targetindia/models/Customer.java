package q1.com.targetindia.models;

import q1.com.targetindia.utils.KeyboardUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private int id;
    private String name;
    private String city;
    private String email;
    private String phone;
    public static int readId(String msg){
        int i = KeyboardUtil.getInt(msg);
        return i;
    }
    public static String readName(String msg){
        var na = KeyboardUtil.getString(msg);
        return na;
    }
    public static String readEmail(String msg){
        var em = KeyboardUtil.getString(msg);
        return em;
    }
    public static String  readCity(String msg){
        var ci = KeyboardUtil.getString(msg);
        return ci;
    }
    public static String readNumber(String msg){
        var nu = KeyboardUtil.getString(msg);
        return nu;
    }

}