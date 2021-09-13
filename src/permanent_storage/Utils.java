package permanent_storage;

import java.util.Arrays;

public class Utils {
    public static String MultiString(String s,int count){
        return new String(String.valueOf(s).repeat(Math.max(0,count)));
    }
    public static void print(String s){
        System.out.print(s);
    }
    public static void println(String s){
        System.out.print("\n"+s);
    }
    public static boolean startWithNumber(String s){
        return (s.charAt(0)>='0'&&s.charAt(0)<='9')||s.charAt(0)=='-';
    }
    public static int convert(String s){
        boolean df = false;
        if(s.charAt(0)=='-'){
            s = s.substring(1);
            df = true;
        }
        s = s.trim();
        //这里假设s是一个纯数字字符串，例如 123，132，788
        int l = s.length();
        int res = 0;
        for(int i = 0;i<l;i++){
            res *= 10;
            res += convert(s.charAt(l-1-i));
        }
        return df?(-1*res):res;
    }
    public static int convert(char c){
        return (int)(c-48);
    }
    public static int max(int[] array){
        Arrays.sort(array);
        return array[array.length-1];
    }
    public static void set(StorageItem item, String label, String value){
        if(item.name.equals(label)){
            item.value = value;
        }else{
            if(item.hasItem){
                for(int i = 0;i < item.data.size();i++){
                    set(item.data.get(i),label,value);
                }
            }
        }
    }

}
