
import java.lang.management.ManagementFactory;
import java.util.Random;

/**
 * @author hexuan05
 * @since 2018/8/7
 */
public class MergeSort {
    /**
     * @param arr 待排序数组
     * @param p   本次递归待排序子数组起始下标
     * @param q   本次递归待排序子数组结束下标（不包含）
     */
    public void mergeSort(int[] arr, int p, int q) {
        if (p < q - 1) {
            int m = (q - p) / 2 + p;
            mergeSort(arr, p, m);
            mergeSort(arr, m, q);
            merge(arr, p, m, q);
        }
    }

    /**
     * 合并两个子数组
     *
     * @param arr 待排序数组
     * @param p   左数组起始坐标
     * @param m   左数组结束左边（不包含），右数组起始坐标
     * @param q   右边数组结束坐标（不包含）
     */
    private void merge(int[] arr, int p, int m, int q) {
        int[] leftArr = new int[m - p];
        int[] rightArr = new int[q - m];
        System.arraycopy(arr, p, leftArr, 0, m - p);
        System.arraycopy(arr, m, rightArr, 0, q - m);

        int i = 0;
        int j = 0;
        for (int k = 0; k < q - p; k++) {

            if (i < leftArr.length && j < rightArr.length) {
                if (leftArr[i] <= rightArr[j]) {
                    arr[p + k] = leftArr[i];
                    i++;
                } else {
                    arr[p + k] = rightArr[j];
                    j++;
                }
            } else {//某一个子数组遍历完了的情况
                if (i < leftArr.length) {
                    arr[p + k] = leftArr[i];
                    i++;
                }
                if (j < rightArr.length) {
                    arr[p + k] = rightArr[j];
                    j++;
                }
            }
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();

        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(name);
        String pid = name.split("@")[0];
        System.out.println("Pid is:" + pid);

        int arr[] = new int[1000 * 1000 * 100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt();
        }

        System.out.println("开始排序:" + System.currentTimeMillis());
        mergeSort.mergeSort(arr, 0, arr.length);
        System.out.println("结束排序:" + System.currentTimeMillis());

    }

}
