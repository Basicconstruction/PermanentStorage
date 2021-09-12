package permanent_storage;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

import static permanent_storage.Utils.*;

public class PermanentStorage {
    public File file;
    public ArrayList<StorageMenu> data = new ArrayList<>();
    public PermanentStorage(){

    }
    public PermanentStorage(File file){
        initialize(file);
    }
    public PermanentStorage(String names){
        this.file = new File(names+".ps");
        initialize(file);
    }
    public void initialize(File file){
        if(file.exists()){
            boolean status = file.delete();
            if(status){
                System.out.println("previous file has been deleted");
            }else{
                System.out.println("error when delete the file!");
            }
            try{
                boolean status2 = file.createNewFile();
                if(status2){
                    System.out.println("file create ok");
                }else{
                    System.out.println("error when create the file!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try{
                boolean status2 = file.createNewFile();
                if(status2){
                    System.out.println("file create ok");
                }else{
                    System.out.println("error when create the file!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void removeStorageMenuByIndex(int index){
        data.remove(data.get(index));
    }
    public void remove(StorageMenu menu){
        data.remove(menu);
    }
    public void add(StorageMenu menu){
        data.add(menu);
    }
    public void write(String path){
        try{
            FileWriter fw = new FileWriter(new File(path));
            BufferedWriter bfw = new BufferedWriter(fw);
            StringBuilder sb = new StringBuilder();
            StringBuilder bo = new StringBuilder();
            for(StorageMenu menu:this.data){
                menu.order = 1;
                sb.append(menu.name).append("\n");
                bo.append(menu.order).append(" ");
                for(StorageItem si : menu.data){
                    si.order = 2;
                    if(si.hasItem){
                        iterator(si,sb,si.order,bo);
                    }else{
                        sb.append(si.name).append("\n");
                        bo.append(si.order).append(" ");
                    }
                }
            }
            bfw.write((bo.append("\n")).toString());
            bfw.write(sb.toString());
            bfw.close();
            fw.close();
            System.out.println("保存到文件成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void iterator(StorageItem item,StringBuilder bs,int order,StringBuilder ob){
        item.order = order;
        if(item.hasItem){
            bs.append(item.name).append("\n");
            ob.append(order).append(" ");
            for(StorageItem si:item.data){
                iterator(si,bs,order+1,ob);
            }
        }else{
            bs.append(item.name).append("\n");
            ob.append(order).append(" ");

        }
    }
    public void TestPrint(){
        for(StorageMenu menu:this.data){
            println(menu.name);
            for(StorageItem si : menu.data){
                PrintItem(si);
            }
        }
    }
    public static void PrintItem(StorageItem item){
        println(item.name);
        if(item.hasItem){
            for(StorageItem si:item.data){
                PrintItem(si);
            }
        }else{
            System.out.print(" : "+item.value);
        }
    }
    public static PermanentStorage getInstance(String path){
        PermanentStorage ps = new PermanentStorage();
        ps.file = new File(path);
        try{
            FileReader fr = new FileReader(ps.file);
            BufferedReader br = new BufferedReader(fr);
            ArrayList<Object> ob = new ArrayList<>();
            String s;
            int[] sys = new int[0];
            int counter = 0;
            int start = 0;
//            Object[] objs = new Object[0];
            int maxOrder = 0;
            boolean hasGenerate = false;
            int mini = 1;
            int maxi = 1;
            while((s=br.readLine())!=null){
                s = s.trim();
                if(startWithNumber(s)){
                    String[] symbols;
                    symbols = s.split(" ");
                    sys = new int[symbols.length];
                    counter = sys.length;
                    System.out.println("counter "+counter);
//                    objs = new Object[counter];
                    for(int i = 0;i<symbols.length;i++){
                        sys[i] = convert(symbols[i]);
                        maxOrder = Math.max(maxOrder,sys[i]);
                    }
                }else{
                    start++;
                    if(start<=counter){
                        if(!hasGenerate){
                            ob = new ArrayList<Object>(maxOrder-1);
                            ob.add("1");
                            ob.add("1");
                            ob.add("1");
                            ob.add("1");
                            hasGenerate = true;
                        }
//                    objs[start-1] = new StorageItem(s);
                        if(sys[start-1]==mini){
                            System.out.println(start+"mini == 1"+s);
                            ob.set(0,new StorageMenu(s));
                            ps.add(((StorageMenu)(ob.get(0))));
                            maxi = mini;
//                        System.out.println(sys[start-1]+s+" added to "+"root");
                        }else if(sys[start-1]>maxi){
                            System.out.println(start+">"+s);
                            ob.set(sys[start-1]-1,new StorageItem(s));
                            if(maxi==1){
                                ((StorageMenu)(ob.get(0))).add(new StorageItem(s));
                            }else{
                                ((StorageItem)(ob.get(maxi-1))).add(new StorageItem(s));
                            }
//                        System.out.println(sys[start-1]+s+" added to "+maxi);
                            maxi = sys[start-1];
                        }else if(sys[start-1]==maxi){
                            System.out.println(start+"="+s);
                            //忽略了1，1这种情况
                            ob.set(sys[start-1]-1,new StorageItem(s));
                            ((StorageItem)(ob.get(sys[start-1]-2))).add(new StorageItem(s));
                            System.out.println("set ob "+((StorageItem)(ob.get(sys[start-1]-2))).name+s);
//                        System.out.println("add "+s+" to "+(maxi-1));
                        }else if(sys[start-1]<maxi){
                            System.out.println(start+"<"+s);
                            ob.set(sys[start-1]-1,new StorageItem(s));
                            maxi = sys[start-1];
                        }else{
                            System.out.println(start+"?"+s);
                            System.out.println("un thinking problems");
                        }
                        System.out.println("start "+start);
//                        if(start==4){
//                            for(StorageItem si : ((StorageMenu)ob.get(0)).data){
//                                PrintItem(si);
//                            }
//                            System.out.println();
//                        }
                    }


                }
                //我们使得数字层次加载在前
            }
//            System.out.println("start"+start);
//            System.out.println("counter"+counter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ps;
    }
}
