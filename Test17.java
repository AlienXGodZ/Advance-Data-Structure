class maxheap{

     private int[] heap;
     private int size;

    maxheap(int capacity){

        heap = new int[capacity];
        size = 0;
    }

    private int parent(int index){

        return (index - 1) / 2;

    }

    private int leftchild(int index){

        return 2 * index + 1;

    }

    private int rightchild(int index){

        return 2 * index + 2;

    }

    public void insert(int value){

        if(size == heap.length){

            throw new IllegalStateException("HEAP IS FULL");

        }

        heap[size] = value;
        size++;

        heapifyup(size -1);

    }

    private void heapifyup(int index){

        while(index > 0 ){

            int parentindex = parent(index);

            if(heap[index] <= heap[parentindex]){

                break;

            }

            swap(index,parentindex);


            index = parentindex;

        }


    }

    private void swap(int i ,int j){

        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;


    }

    public void print(){

        System.out.print("HEAP:");

        for(int i = 0; i < size ;i++){

            System.out.print(heap[i] + " ");

        }

    }

    public int extractmax() {

        if (size == 0) {

            throw new IllegalStateException("HEAP IS EMPTY");

        }

        int max = heap[0];

        heap[0] = heap[size - 1];

        size--;

        if (size > 0) {

            heapifydown(0);

        }

        return max;


    }

    private void heapifydown(int index) {


        while (true) {

            int left = leftchild(index);
            int right = rightchild(index);

            int largest = index;

            if (left < size && heap[left] > heap[largest]) {

                largest = left;

            }

            if (right < size && heap[right] > heap[largest]) {

                largest = right;

            }

            if (largest == index) {
                break;
            }

            swap(index,largest);

            index = largest;



        }
    }

    public int peek(){

        if(size == 0){

            throw new IllegalStateException("HEAP IS EMPTY");

        }

        return heap[0];

    }

    public boolean search(int value){

        for(int i = 0;i < size ; i++) {

            if (value == heap[i]) {
                return true;
            }
        }
        return false;

    }

}

 public class Test17{
    public static void main(String[] args){

        maxheap heap = new maxheap(10);

        heap.insert(10);
        heap.insert(20);
        heap.insert(30);
        heap.insert(40);
        heap.insert(50);

        heap.print();

        heap.extractmax();

        System.out.println();
        heap.print();

        System.out.println();

        System.out.println("MAX:" + heap.peek());

        if(heap.search(10)){
            System.out.println("FOUNDED");
        }else{
            System.out.println("NOT FOUNDED");
        }









    }
 }