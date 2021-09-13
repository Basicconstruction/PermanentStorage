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
    public void set(String label,String value){
        StorageItem.set(this,label,value);
    }
    public static void set(StorageItem item, String label, String value){
        if(item.name.equals(label)){
            item.value = value;
        }else{
            if(item.hasItem){
                for(int i = 0;i < item.data.size();i++){
                    StorageItem.set(item.data.get(i),label,value);
                }
            }
        }
    }
    public static String get(StorageItem item,String label){
        if(item.name.equals(label)){
            return item.value;
        }else{
            if(item.hasItem){
                for(int i = 0;i < item.data.size();i++){
                    if(StorageItem.get(item.data.get(i),label)!=null){
                        return StorageItem.get(item.data.get(i),label);
                    }
                }
            }
        }
        return null;
    }
    public String get(String label){
        if(this.name.equals(label)){
            return this.value;
        }else{
            if(this.hasItem){
                for(int i = 0;i < this.data.size();i++){
                    if(StorageItem.get(this.data.get(i),label)!=null){
                        return StorageItem.get(this.data.get(i),label);
                    }
                }
            }
        }
        return null;
    }


}
