import java.util.*;

/**
 * @author hexuan05
 * @since 2018/8/12
 * 多路归并
 */
public class KLineMergeSort {

    private class Range<T> {

        int startIndex;//include
        int endIndex;//exclude
        List<T> value;

        public Range(List<T> value) {
            this.value = value;
            startIndex = 0;
            endIndex = value.size();
        }
    }

    /**
     * @param source 待排序数组
     * @param target 存排序后数组
     */
    void merge(List<List<Integer>> source, List<Integer> target) {

        PriorityQueue<Range<Integer>> pq = new PriorityQueue<>(new Comparator<Range<Integer>>() {
            @Override
            public int compare(Range<Integer> o1, Range<Integer> o2) {
                return o1.value.get(o1.startIndex).compareTo(o2.value.get(o2.startIndex));
            }
        });

        for (List<Integer> integerList : source) {
            if (!integerList.isEmpty())
                pq.add(new Range<>(integerList));
        }

        while (!pq.isEmpty()) {

            Range<Integer> top = pq.poll();
            target.add(top.value.get(top.startIndex));

            if (++top.startIndex != top.endIndex)
                pq.add(top);
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> a = new ArrayList<>();
        a.add(Arrays.asList(new Integer[]{1, 2, 4}));
        a.add(Arrays.asList(new Integer[]{}));
        a.add(Arrays.asList(new Integer[]{2, 3, 5}));
        a.add(Arrays.asList(new Integer[]{3, 4, 6, 8}));

        System.out.println(a);

        List<Integer> target = new ArrayList<>();

        KLineMergeSort kLineMergeSort = new KLineMergeSort();

        kLineMergeSort.merge(a, target);

        System.out.println(a);
        System.out.println(target);
    }

}
