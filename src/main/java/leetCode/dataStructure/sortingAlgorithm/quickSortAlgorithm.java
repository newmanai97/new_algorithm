package leetCode.dataStructure.sortingAlgorithm;

import java.util.Arrays;

public class quickSortAlgorithm {

    public static void quickSort(int[] arr, int startIndex, int endIndex){
        if (startIndex >= endIndex){
            return;
        }

        int pivotIndex = partition(arr, startIndex, endIndex);
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }


    /**
     * 双边循环方法
     * @param arr 数组
     * @param startIndex 数组排序开始位置，默认为第一个元素
     * @param endIndex 数组排序结束位置，默认为数组最后一个元素
     * @return 排序完成后基准元素位置索引
     */
    private static int partition(int[] arr, int startIndex, int endIndex){
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left != right){
            while (left < right && arr[right] > pivot){
                right--;
            }
            while (left < right && arr[left] <= pivot){
                left++;
            }

            if (left < right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        arr[startIndex] = arr[left];
        arr[left] = pivot;

        return left;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{5,6,8,2,3,9,1,7};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
