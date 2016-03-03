package Sorting;

public class MergeSort {

    public static void main(String[] args) {
        int a[] =  {5,6,7,9,5,4,3,6,7,9,1};
        mergeSort(a,0,a.length-1);
        print(a);
    }

    private static void print(int[] a) {
        for (int anA : a) {
            System.out.println("a[i] = " + anA);
        }
    }

    private static void mergeSort(int[] array, int start, int end) {
        int mid;
        if(end > start){
            mid = (start + end)/2;
            mergeSort(array,start,mid);
            mergeSort(array,mid+1,end);
            merge(array, start, mid, end);
        }
        System.out.println("over");
    }

    private static void merge(int[] array, int start, int mid, int end) {
        int aLength = mid - start +1;
        int bLength = end - (mid + 1) +1;

        int a[] = new int[aLength];
        int b[] = new int[bLength];

        System.arraycopy(array, start, a, 0, aLength);

        for(int i = 0;i< bLength;i++){
            b[i] = array[mid+1+i];
        }

        int index=start;
        int left=0, right = 0;
        while (left < aLength && right < bLength){
            if(a[left] <= b[right]){
                array[index] = a[left];
                left++;
            }
            else{
                array[index] = b[right];
                right++;
            }
            index++;
        }

        if(left < aLength){
            while (left<aLength){
                array[index] = a[left];
                left++;
                index++;
            }
        }

        if(right < bLength){
            while (right<bLength){
                array[index] = b[right];
                right++;
                index++;
            }
        }
    }
}