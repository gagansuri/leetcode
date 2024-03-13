public class MyList {
    private String[] arr = new String[16];
    private int count = 0 ;

    public MyList() {}

    public void add(String s) {
        if(count >= arr.length) {
            resize();
        }
        arr[count++] = s;
    }

    private void resize(){
        System.out.println("resizing now : ");
        String[] temp = new String[arr.length*2];
        for(int i = 0 ; i< arr.length ;i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    public static void main(String[] args) {
        MyList myList  = new MyList();
        for(int i = 0 ; i < 100 ; i++) {
            myList.add(i+" ");
        }
        System.out.println("array length : "+myList.arr.length);
        System.out.println("index count  : "+myList.count);
    }

}
