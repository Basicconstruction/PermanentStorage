package permanent_storage;

import java.util.ArrayList;

public class StorageMenu {
    public ArrayList<StorageItem> data = new ArrayList<>();
    public String name;
    public String value;
    public int order;
    public boolean hasItem;
    public boolean includedInParent = true;
    public String singleLocation = null;
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
    public StorageMenu(String name,boolean includedInParent,String singleLocation) {
        this.name = name;
        this.order = 0;
        hasItem = false;
        this.includedInParent = includedInParent;
        this.singleLocation = singleLocation;
    }
    public StorageMenu(String name,String value,boolean includedInParent,String singleLocation) {
        this.name = name;
        this.value = value;
        this.order = 0;
        hasItem = false;
        this.includedInParent = includedInParent;
        this.singleLocation = singleLocation;
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
    public static void set(StorageMenu sm, String label, String value){
        if(sm.name.equals(label)){
            sm.value = value;
        }else{
            if(sm.hasItem){
                for(int i = 0;i < sm.data.size();i++){
                    StorageItem.set(sm.data.get(i),label,value);
                }
            }
        }
    }
    public void set(String label,String value){
        if(this.name.equals(label)){
            this.value = value;
        }else{
            if(this.hasItem){
                for(int i = 0;i < this.data.size();i++){
                    StorageItem.set(this.data.get(i),label,value);
                }
            }
        }
    }
    public static String get(StorageMenu sm, String label){
        if(sm.name.equals(label)){
            return sm.value;
        }else{
            if(sm.hasItem){
                for(int i = 0;i < sm.data.size();i++){
                    if(StorageItem.get(sm.data.get(i),label)!=null){
                        return StorageItem.get(sm.data.get(i),label);
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
