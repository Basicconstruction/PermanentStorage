package boostup;

import permanent_storage.PermanentStorage;
import permanent_storage.StorageItem;
import permanent_storage.StorageMenu;

import java.util.ArrayList;

public class CMain {
    public CMain(){
        PermanentStorage ps = new PermanentStorage("test");
        StorageMenu m1 = new StorageMenu("水果");
        ps.add(m1);
//        StorageItem i11 = new StorageItem("热带水果");
//        StorageItem i12 = new StorageItem("亚热带水果","0");
//        m1.add(i11);
//        m1.add(i12);
//        StorageItem i111 = new StorageItem("菠萝","100");
//        StorageItem i112 = new StorageItem("牛皮","2000");
//        i11.add(i111);
//        i11.add(i112);
//        ps.TestPrint();
        ArrayList<StorageItem> hj = new ArrayList<>();
        hj.add(new StorageItem("热带水果"));
        hj.add(new StorageItem("亚热带水果"));
        m1.add(hj.get(0));
        m1.add(hj.get(1));
        hj.add(new StorageItem("菠萝"));
        hj.add(new StorageItem("牛皮"));
        hj.get(0).add(hj.get(2));
        hj.get(0).add(hj.get(3));

        ps.write(ps.file.getAbsolutePath());
        PermanentStorage kl = PermanentStorage.getInstance("C:\\Users\\Public\\Roaming\\test.ps");
        kl.write(kl.file.getAbsolutePath());
//        for(StorageMenu sm:ps.data){
//            if(sm.data.size()>0){
//                for(StorageItem si:sm.data){
//                    if(si.data.size()>0){
//                        for(StorageItem sis:si.data){
//                            System.out.println(sm.name+" "+si.name+" "+sis.name);
//                        }
//                    }else{
//                        System.out.println(sm.name+" "+si.name);
//                    }
//                }
//            }else{
//                System.out.println(sm.name);
//            }
//
//        }
    }
}
