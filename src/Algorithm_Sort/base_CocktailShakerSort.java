package Algorithm_Sort;

/**
 * @author Mateus Bizzo (https://github.com/MattBizzo)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 */

class base_CocktailShakerSort implements SortAlgorithm {

    /**
     * This method implements the Generic Cocktail Shaker Sort
     *
     * @param array The array to be sorted
     *              Sorts the array in increasing order
     **/

    /**
     * 鸡尾酒排序是冒泡排序的轻微变形。不同的地方在于，鸡尾酒排序是从低到高然后从高到低来回排序，
     * 而冒泡排序则仅从低到高去比较序列里的每个元素。他可比冒泡排序的效率稍微好一点，
     * 原因是冒泡排序只从一个方向进行比对(由低到高)，每次循环只移动一个项目.
     */
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {

        int length = array.length;
        int left = 0;
        int right = length - 1;
        int swappedLeft, swappedRight;
        while (left < right) {
            // front
            swappedRight = 0;
            for (int i = left; i < right; i++) {
                if (SortUtils.less(array[i + 1], array[i])) {
                    SortUtils.swap(array, i, i + 1);
                    swappedRight = i;
                }
            }
            // back
            right = swappedRight;
            swappedLeft = length - 1;
            for (int j = right; j > left; j--) {
                if (SortUtils.less(array[j], array[j - 1])) {
                    SortUtils.swap(array, j - 1, j);
                    swappedLeft = j;
                }
            }
            left = swappedLeft;
        }
        return array;

    }

    // Driver Program
    public static void main(String[] args) {
        // Integer Input
        Integer[] integers = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        base_CocktailShakerSort shakerSort = new base_CocktailShakerSort();

        // Output => 1 4 6 9 12 23 54 78 231
        SortUtils.print(shakerSort.sort(integers));

        // String Input
        String[] strings = {"c", "a", "e", "b", "d"};
        SortUtils.print(shakerSort.sort(strings));
    }


}
