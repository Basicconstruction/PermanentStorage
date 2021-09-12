package permanent_storage;

import java.util.ArrayList;

public class StorageItem {
    public ArrayList<StorageItem> data = new ArrayList<>();
    public String name;
    public String value;
    public boolean hasItem = false;
    public int order;
    public StorageItem(String name,String value) {
        this.name = name;
        this.value = value;
        this.order = 0;
    }
    public StorageItem(String name) {
        this.name = name;
        this.order = 0;
    }
    public void removeStorageItemByIndex(int index){
        data.remove(data.get(index));
        this.hasItem = this.data.size() > 0;
    }
    public void remove(StorageItem item){
        data.remove(item);
        this.hasItem = this.data.size() > 0;
    }
    public void add(StorageItem item){
        data.add(item);
        this.hasItem = true;
    }
}
