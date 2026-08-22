class minheap{

    private int[] heap;
    private int size;

    minheap(int capacity){

        heap = new int [capacity];
        size = 0;

    }

    private int parent(int index){

        return (index - 1 )/ 2;

    }

    private int leftchild(int index){

        return index * 2 + 1;

    }

    private int rightchild(int index){

        return index * 2 + 2;

    }

    private void swap(int i,int j){

        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;


    }


    public void insert(int value){

        if(size == heap.length){
            throw new IllegalStateException("HEAP IS FULL");
        }

        heap[size] = value;
        size++;

        heapifyup(size - 1);

    }

    private void heapifyup(int index){

        while(index > 0){

            int parent = parent(index);

            if(heap[parent] <= heap[index]){
                break;
            }

            swap(index,parent);

            index = parent;


        }
    }

    public void extractmin(){

        if(size == 0){
            throw new IllegalStateException("HEAP IS EMPTY");
        }

        int min = heap[0];

        heap[0] = heap[size - 1];

        size--;

        if( size > 0) {

            heapifydown(0);

        }

    }

    private void heapifydown(int index){

        while(true){

            int left = leftchild(index);

            int right = rightchild(index);

            int smallest = index;

            if(left < size && heap[left] < heap[smallest]){

                smallest = left;

            }

            if(right < size && heap[right] < heap[smallest]){

                smallest = right;

            }

            if(smallest == index){

                break;

            }

            swap(index,smallest);

            index = smallest;

        }

    }

    public int peek(){

        if(size == 0){

            throw new IllegalStateException("HEAP IS EMPTY");

        }

        return heap[0];

    }

    public boolean search(int value){

        for(int i = 0 ; i < size ; i++){

            if(value == heap[i]){
                return true;
            }
        }

        return false;

    }

    public void print(){

        System.out.print("MIN:");
        for(int i = 0 ; i < size ; i++){

            System.out.print(heap[i] + " ");

        }
        System.out.println();
    }

    public void buildminheap(int[] arr){

        heap = arr;
        size = arr.length;

        for(int i = size / 2 -1; i >= 0 ; i--){
            heapifydown(i);
        }
    }


}


public class Test18 {
    public static void main(String[] args){

        minheap heap = new minheap(10);

        heap.insert(50);
        heap.insert(40);
        heap.insert(30);
        heap.insert(20);
        heap.insert(10);

        heap.print();

        heap.extractmin();

        heap.print();

        System.out.println(heap.peek());

        if(heap.search(20)){
            System.out.println("VALUE FOUND");
        }else{
            System.out.println("VALUE NOT FOUND");
        }

        int[] arr = {90,80,70,60};

        heap.buildminheap(arr);

    }
}
