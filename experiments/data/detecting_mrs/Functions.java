public class Functions {

    public static int add_values(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static int add_two_array_values(int[] array1, int[] array2, int index) {
        return array1[index] + array2[index];
    }

    public static void bubble_sort(int[] array) {
        int n = array.length;
        int temp = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < (n-i); j++) {
                if(array[j-1] > array[j]) {
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void shell_sort(int[] array) {
        int n = array.length;
        int temp = 0;
        int gap = n/2;
        while(gap > 0) {
            for(int i = gap; i < n; i++) {
                for(int j = i-gap; j >= 0 && array[j] > array[j+gap]; j -= gap) {
                    temp = array[j];
                    array[j] = array[j+gap];
                    array[j+gap] = temp;
                }
            }
            gap /= 2;
        }
    }

    public static int binary_search(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;
        int mid = 0;
        while(low <= high) {
            mid = (low + high) / 2;
            if(array[mid] < value) {
                low = mid + 1;
            } else if(array[mid] > value) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int sequential_search(int[] array, int value) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static void selection_sort(int[] array) {
        int n = array.length;
        int temp = 0;
        int min = 0;
        for(int i = 0; i < n; i++) {
            min = i;
            for(int j = i+1; j < n; j++) {
                if(array[j] < array[min]) {
                    min = j;
                }
            }
            temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }

    public static int dot_product(int[] vector1, int[] vector2) {
        int sum = 0;
        for(int i = 0; i < vector1.length; i++) {
            sum += vector1[i] * vector2[i];
        }
        return sum;
    }

    public static void array_div(int[] array, int value) {
        for(int i = 0; i < array.length; i++) {
            array[i] /= value;
        }
    }

    public static void set_min_value(int[] array, int value) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] < value) {
                array[i] = value;
            }
        }
    }

    public static int find_min(int[] array) {
        int min = array[0];
        for(int i = 1; i < array.length; i++) {
            if(array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static int[] find_diff(int[] array1, int[] array2) {
        int[] diff = new int[array1.length];
        for(int i = 0; i < array1.length; i++) {
            diff[i] = array1[i] - array2[i];
        }
        return diff;
    }

    public static int[] array_copy(int[] array) {
        int[] copy = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }

    public static int[] copy_array_part(int[] array, int start, int end) {
        int[] copy = new int[end - start];
        for(int i = start; i < end; i++) {
            copy[i - start] = array[i];
        }
        return copy;
    }

    public static int find_euc_dist(int[] vector1, int[] vector2) {
        int sum = 0;
        for(int i = 0; i < vector1.length; i++) {
            sum += Math.pow(vector1[i] - vector2[i], 2);
        }
        return (int) Math.sqrt(sum);
    }

    public static int find_magnitude(int[] vector) {
        int sum = 0;
        for(int i = 0; i < vector.length; i++) {
            sum += Math.pow(vector[i], 2);
        }
        return (int) Math.sqrt(sum);
    }

    public static int manhattan_dist(int[] vector1, int[] vector2) {
        int sum = 0;
        for(int i = 0; i < vector1.length; i++) {
            sum += Math.abs(vector1[i] - vector2[i]);
        }
        return sum;
    }

    public static int average(int[] array) {
        int sum = 0;
        for(int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }

    public static void decrement_array(int[] array, int value) {
        for(int i = 0; i < array.length; i++) {
            array[i] -= value;
        }
    }

    public static int find_max(int[] array) {
        int max = array[0];
        for(int i = 1; i < array.length; i++) {
            if(array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static int find_max2(int[] array) {

    }

    public static void quick_sort(int[] array, int low, int high) {
        if(low < high) {
            int pi = partition(array, low, high);
            quick_sort(array, low, pi-1);
            quick_sort(array, pi+1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        int temp = 0;
        for(int j = low; j < high; j++) {
            if(array[j] <= pivot) {
                i++;
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;
        return i+1;
    }

    public static int variance(int[] array) {
        int mean = average(array);
        int sum = 0;
        for(int i = 0; i < array.length; i++) {
            sum += Math.pow(array[i] - mean, 2);
        }
        return sum / array.length;
    }

    public static void insertion_sort(int[] array) {
        int n = array.length;
        int temp = 0;
        for(int i = 1; i < n; i++) {
            for(int j = i; j > 0; j--) {
                if(array[j] < array[j-1]) {
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    public static void heap_sort(int[] array) {
        int n = array.length;
        for(int i = n/2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }
        for(int i = n-1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }

    public static void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;
        if(left < n && array[left] > array[largest]) {
            largest = left;
        }
        if(right < n && array[right] > array[largest]) {
            largest = right;
        }
        if(largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array, n, largest);
        }
    }

    public static void merge_sort(int[] array, int low, int high) {
        if(low < high) {
            int mid = (low + high) / 2;
            merge_sort(array, low, mid);
            merge_sort(array, mid+1, high);
            merge(array, low, mid, high);
        }
    }

    public static void merge(int[] array, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for(int i = 0; i < n1; i++) {
            left[i] = array[low + i];
        }
        for(int i = 0; i < n2; i++) {
            right[i] = array[mid + 1 + i];
        }
        int i = 0;
        int j = 0;
        int k = low;
        while(i < n1 && j < n2) {
            if(left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }
        while(i < n1) {
            array[k] = left[i];
            i++;
            k++;
        }
        while(j < n2) {
            array[k] = right[j];
            j++;
            k++;
        }
    }

    public static double geometric_mean(int[] array) {
        int product = 1;
        for(int i = 0; i < array.length; i++) {
            product *= array[i];
        }
        return Math.pow(product, 1.0 / array.length);
    }

    public static double mean_absolute_error(int[] array1, int[] array2) {
        int sum = 0;
        for(int i = 0; i < array1.length; i++) {
            sum += Math.abs(array1[i] - array2[i]);
        }
        return sum / array1.length;
    }

    public static int select_k(int[] array, int k) {
        // Select kth largest element in array
    }

    public static int find_median(int[] array) {
        int n = array.length;
        if(n % 2 == 0) {
            return (array[n/2] + array[n/2 - 1]) / 2;
        } else {
            return array[n/2];
        }
    }

    public static int[] cartesian_product(int[] array1, int[] array2) {
        int[] product = new int[array1.length * array2.length];
        int index = 0;
        for(int i = 0; i < array1.length; i++) {
            for(int j = 0; j < array2.length; j++) {
                product[index] = array1[i] * array2[j];
                index++;
            }
        }
        return product;
    }

    public static void reverse(int[] array) {
        int n = array.length;
        int temp = 0;
        for(int i = 0; i < n/2; i++) {
            temp = array[i];
            array[i] = array[n-i-1];
            array[n-i-1] = temp;
        }
    }

    public static boolean check_equal_tolerance(int[] array1, int[] array2, int tolerance) {
        for(int i = 0; i < array1.length; i++) {
            if(Math.abs(array1[i] - array2[i]) > tolerance) {
                return false;
            }
        }
        return true;
    }

    public static boolean check_equal(int[] array1, int[] array2) {
        for(int i = 0; i < array1.length; i++) {
            if(array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int weighted_average(int[] array1, int[] array2) {
        int sum = 0;
        for(int i = 0; i < array1.length; i++) {
            sum += array1[i] * array2[i];
        }
        return sum / array1.length;
    }

    public static int count_k(int[] array, int k) {
        int count = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == k) {
                count++;
            }
        }
        return count;
    }

    public static int[] bitwise_and(int[] array1, int[] array2) {
        int[] and = new int[array1.length];
        for(int i = 0; i < array1.length; i++) {
            and[i] = array1[i] & array2[i];
        }
        return and;
    }

    public static int[] bitwise_or(int[] array1, int[] array2) {
        int[] or = new int[array1.length];
        for(int i = 0; i < array1.length; i++) {
            or[i] = array1[i] | array2[i];
        }
        return or;
    }

    public static int[] bitwise_xor(int[] array1, int[] array2) {
        int[] xor = new int[array1.length];
        for(int i = 0; i < array1.length; i++) {
            xor[i] = array1[i] ^ array2[i];
        }
        return xor;
    }

    public static int[] bitwise_not(int[] array) {
        int[] not = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            not[i] = ~array[i];
        }
        return not;
    }

    public static void clip(int[] array, int min, int max) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] < min) {
                array[i] = min;
            } else if(array[i] > max) {
                array[i] = max;
            }
        }
    }

    public static int[] elementwise_max(int[] array1, int[] array2) {
        int[] max = new int[array1.length];
        for(int i = 0; i < array1.length; i++) {
            max[i] = Math.max(array1[i], array2[i]);
        }
        return max;
    }

    public static int[] elementwise_min(int[] array1, int[] array2) {
        int[] min = new int[array1.length];
        for(int i = 0; i < array1.length; i++) {
            min[i] = Math.min(array1[i], array2[i]);
        }
        return min;
    }

    public static int count_nzeroes(int[] array) {
        int count = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] != 0) {
                count++;
            }
        }
        return count;
    }

    public static int count_zeroes(int[] array) {
        int count = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == 0) {
                count++;
            }
        }
        return count;
    }

    public static boolean[] elementwise_equal(int[] array1, int[] array2) {
        boolean[] equal = new boolean[array1.length];
        for(int i = 0; i < array1.length; i++) {
            equal[i] = array1[i] == array2[i];
        }
        return equal;
    }

    public static boolean[] elementwise_not_equal(int[] array1, int[] array2) {
        boolean[] not_equal = new boolean[array1.length];
        for(int i = 0; i < array1.length; i++) {
            not_equal[i] = array1[i] != array2[i];
        }
        return not_equal;
    }

    public static int hamming_dist(int[] array1, int[] array2) {
        int dist = 0;
        for(int i = 0; i < array1.length; i++) {
            if(array1[i] != array2[i]) {
                dist++;
            }
        }
        return dist;
    }
}