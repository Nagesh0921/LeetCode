public class Sort1 {
    public static void main(String[] args) {
        int[] arr = {5,6,1,2,3,7,8,4};
        Sort1 s = new Sort1();
        s.sort(0, arr.length-1, arr);
        for(int n : arr){
            System.out.print(n + " ");
        }
    }

    private void sort(int start, int end, int[] arr){
        if(start < end){
            int pivot = start + (end - start)/2;
            // System.out.println(pivot);
            sort(start, pivot, arr);
            sort(pivot+1, end, arr);

            merge(start, pivot, end, arr);
        }
    }

    private void merge(int start, int pivot, int end, int[] arr){
        // System.out.println("Entered Merge "+start+" "+pivot+" "+end);
        int leftLength = pivot - start + 1;
        int rightLength = end - pivot;

        int[] leftArr = new int[leftLength];
        int[] rightArr = new int[rightLength];

        for(int i=0; i<leftLength; i++){
            leftArr[i] = arr[i + start];
        }
        for(int i=0; i<rightLength; i++){
            rightArr[i] = arr[pivot + 1 + i];
        }

        int l = 0, r = 0, i = start;
        while(l < leftLength && r < rightLength){
            if(leftArr[l] <= rightArr[r]){
                arr[i++] = leftArr[l];
                l++;
            } else {
                arr[i++] = rightArr[r];
                r++;
            }
        }
        while(l < leftLength){
            arr[i] = leftArr[l]; l++; i++;
        }
        while(r < rightLength){
            arr[i] = rightArr[r]; r++; i++;
        }
    }
}
