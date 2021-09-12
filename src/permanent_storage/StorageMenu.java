package permanent_storage;

import java.util.ArrayList;

public class StorageMenu {
    public ArrayList<StorageItem> data = new ArrayList<>();
    public String name;
    public String value;
    public int order;
    public boolean hasItem;
    public StorageMenu(String name) {
        this.name = name;
        this.order = 0;
        hasItem = false;
    }
    public StorageMenu(String name,String value) {
        this.name = name;
        this.value = value;
        this.order = 0;
        hasItem = false;
    }
    public void removeStorageItemByIndex(int index){
        data.remove(data.get(index));
        hasItem = this.data.size()>0;
    }
    public void remove(StorageItem item){
        data.remove(item);
        hasItem = this.data.size()>0;
    }
    public void add(StorageItem item){
        data.add(item);
        hasItem = true;
    }
}
