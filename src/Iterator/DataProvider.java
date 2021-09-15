package Iterator;

import java.util.ArrayList;

public class DataProvider<T> {
    private int pointer1 = 0;//一维指针，高维
    private int pointer2 = 0;//二维指针，低维
    public boolean hasNext = true;
    private ArrayList<ArrayList<T>> data = new ArrayList<>();
    private int getSize = 0;
    public DataProvider(){

    }
    public DataProvider(ArrayList<ArrayList<T>> data,int getSize) {
        this.data = data;
        this.getSize = getSize;
        if(!(this.data.size() >0&&this.data.get(0).size()>0)){
            hasNext = false;
        }
    }
    public void setGetSize(int getSize){
        this.getSize = getSize;
    }
    public void setData(ArrayList<ArrayList<T>> data){
        this.data = data;
        if(!(this.data.size() >0&&this.data.get(0).size()>0)){
            hasNext = false;
        }

    }
    /**将迭代指针置0，使得迭代可以从头开始。 */
    public void setPointerInit(){
        pointer1 = 0;
        pointer2 = 0;
    }
    /**从对象的数据中取出适当数据，并返回。
     * 工作参数:来自对象-pointer1,pointer2,getSize,data,返回ArrayList<T>
     * */
    public ArrayList<T> get(){
        int counter = 0;
        boolean continued = true;
        ArrayList<T> collector = new ArrayList<>();
        for(int j = pointer1;j<data.size()&&continued;){
            while(counter< getSize){
                //必然入口
                if(pointer2<data.get(j).size()){
                    collector.add(data.get(j).get(pointer2));
                    counter++;
                    pointer2++;
                    if(pointer2==data.get(j).size()){
                        counter = getSize;
                        pointer2 = 0;
                        pointer1++;
                    }
                }else{
                    counter = getSize;//退出while循环
                    pointer2 = 0;
                    pointer1++;
                }
            }
            continued = false;
            //必然出口
        }
        if(pointer2<=this.data.get(pointer1).size()-1||pointer1<=this.data.size()-1){
            hasNext = true;
        }
        return collector;
    }


}

