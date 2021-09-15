package boostup;

import permanent_storage.PermanentStorage;
import permanent_storage.StorageItem;
import permanent_storage.StorageMenu;

import java.io.File;
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
        hj.add(new StorageItem("热带水果","2000"));
        hj.add(new StorageItem("亚热带水果"));
        m1.add(hj.get(0));
        m1.add(hj.get(1));
        hj.add(new StorageItem("菠萝","100"));
        hj.add(new StorageItem("牛皮","299"));
        hj.get(0).add(hj.get(2));
        hj.get(0).add(hj.get(3));
        ps.set("牛皮","77777");

        ps.write(ps.file.getAbsolutePath());
        PermanentStorage kl = PermanentStorage.getInstance(new File("C:\\Users\\Public\\Roaming\\test.ps"));
        kl.TestPrint();
        kl.write("C:\\Users\\Public\\Roaming\\test2.ps");
    }
}
