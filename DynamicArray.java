//A custom-built implementation of a dynamic ArrayList class in Java.

public class DynamicArray{
    static int DEFAULT_CAPACITY = 2;
    static int length=0;
    public static class array{
        Object arr[];
        int size;

        public array(){ //Constructor
            arr = new Object[DEFAULT_CAPACITY]; //Notice how object array is declared, arr can be resolved to a variable even without type decleration.
            this.size = DEFAULT_CAPACITY;
        }

        public array(int size){
            arr = new Object[size];
            this.size = size;
        }

        public void add(Object data){
            arr[length++] = data;
            if(length>this.size-1){
                grow();
            }
        }

        public void add(int idx, Object data){
            System.arraycopy(arr, idx, arr, idx + 1, length - idx);
            arr[idx] = data;
        }

        public void remove(){
            arr[--length]=null;
            if(length==(this.size)/3){
                shrink();
            }
        }

        public void remove(int idx){
            System.arraycopy(arr, idx + 1, arr, idx, length - idx - 1); 
            arr[--length]=null;
            if(length==(this.size)/3){
                shrink();
            }
        }

        public int length(){
            return length;
        }

        public int size(){
            return size;
        }

        public void print(){
            for(int i=0;i<length;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }

        public boolean isEmpty(){
            return length==0;
        }

        public boolean contains(Object element){
            boolean flag = false;
            for(int i=0;i<length;i++){
                if(arr[i]==element){
                    flag = true;
                }
            }
            return flag;
        }

        public void grow(){
            this.size = this.size*2;
            Object duplicate[] = new Object[this.size];
            System.arraycopy(arr, 0, duplicate, 0, length);
            arr = duplicate;
        }

        public void shrink(){
            this.size = this.size/3;
            Object duplicate[] = new Object[size];
            System.arraycopy(arr, 0, duplicate, 0, length);
            arr = duplicate;
        }

        //Override toString() method
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (int i = 0; i < length; i++) {
                sb.append(arr[i]);
                sb.append(", ");
            }
            sb.delete(sb.length() - 2, sb.length()); 
            sb.append(']');
            return sb.toString();
        }

    }   

    public static void main(String[] args) {
        array arr = new array();
        arr.add(5);
        arr.add(7);
        arr.add(10);
        System.out.println(arr);
        System.out.println("length = "+ arr.length());
        System.out.println("size = " + arr.size());
        System.out.println();
        arr.add(25);
        arr.remove(2);
        arr.remove(0);
        System.out.println(arr.contains(10));
        System.out.println(arr);
        arr.remove();
        System.out.println(arr);
        System.out.println("length = "+ arr.length());
        System.out.println("size = " + arr.size());
        System.out.println();
        System.out.println(arr.isEmpty());

    }

}
