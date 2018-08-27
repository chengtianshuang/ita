import java.util.Arrays;

/**
 * @author hexuan05
 * @since 2018/8/27
 */
public class QuickSortDemo {

    /**
     *
     * @param a 待排序数组
     * @param p 子数组最左边下标(include)
     * @param r 子数组最右边下标(include)
     */
    public void quickSort(int[] a, int p, int r) {
        if (p < r) {
            int q = partition(a, p, r);
            quickSort(a, p, q - 1);
            quickSort(a, q + 1, r);
        }
    }

    private int partition(int[] a, int p, int r) {

        int key = a[r];
        int i = p - 1;

        //只将j作为循环变量，i随j联动。
        for (int j = p; j < r; j++) {
            if (a[j] <= key) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


    public static void main(String[] args) {
        int[] a = new int[]{5, 2, 4,0,1,6,8,3};

        QuickSortDemo quickSortDemo = new QuickSortDemo();
        System.out.println("排序前：" + Arrays.toString(a));
        quickSortDemo.quickSort(a, 0, a.length - 1);
        System.out.println("排序后：" + Arrays.toString(a));


    }

}
