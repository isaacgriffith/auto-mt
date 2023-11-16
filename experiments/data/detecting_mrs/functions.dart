int add_values(int[] a, int[] b) {
  int sum = 0;
  for (int i = 0; i < a.length; i++) {
    sum += a[i] + b[i];
  }
  return sum;
}

int add_two_array_values(int[] a, int[] b, int i) {
  return a[i] + b[i];
}

void bubble_sort(int[] a) {
  int n = a.length;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n - 1; j++) {
      if (a[j] > a[j + 1]) {
        int temp = a[j];
        a[j] = a[j + 1];
        a[j + 1] = temp;
      }
    }
  }
}

void shell_sort(int[] a) {
  int n = a.length;
  for (int gap = n ~/ 2; gap > 0; gap ~/= 2) {
    for (int i = gap; i < n; i += 1) {
      int temp = a[i];
      int j;
      for (j = i; j >= gap && a[j - gap] > temp; j -= gap) {
        a[j] = a[j - gap];
      }
      a[j] = temp;
    }
  }
}

int binary_search(int[] a, int x) {
  int low = 0;
  int high = a.length - 1;
  while (low <= high) {
    int mid = (low + high) ~/ 2;
    if (a[mid] < x) {
      low = mid + 1;
    } else if (a[mid] > x) {
      high = mid - 1;
    } else {
      return mid;
    }
  }
  return -1;
}

int sequential_search(int[] a, int x) {
  for (int i = 0; i < a.length; i++) {
    if (a[i] == x) {
      return i;
    }
  }
  return -1;
}

void selection_sort(int[] a) {
  int n = a.length;
  for (int i = 0; i < n - 1; i++) {
    int min_idx = i;
    for (int j = i + 1; j < n; j++) {
      if (a[j] < a[min_idx]) {
        min_idx = j;
      }
    }
    int temp = a[min_idx];
    a[min_idx] = a[i];
    a[i] = temp;
  }
}

int dot_product(int[] a, int[] b) {
  int sum = 0;
  for (int i = 0; i < a.length; i++) {
    sum += a[i] * b[i];
  }
  return sum;
}

void array_div(int[] a, int div) {
  for (int i = 0; i < a.length; i++) {
    a[i] ~/= div;
  }
}

int find_min(int[] a) {
  int min = a[0];
  for (int i = 1; i < a.length; i++) {
    if (a[i] < min) {
      min = a[i];
    }
  }
  return min;
}

int[] find_diff(int[] a, int[] b) {
  int[] diff = new int[a.length];
  for (int i = 0; i < a.length; i++) {
    diff[i] = a[i] - b[i];
  }
  return diff;
}

int[] array_copy(int[] a) {
  int[] copy = new int[a.length];
  for (int i = 0; i < a.length; i++) {
    copy[i] = a[i];
  }
  return copy;
}

int[] copy_array_part(int[] a, int start, int end) {
  int[] copy = new int[end - start];
  for (int i = start; i < end; i++) {
    copy[i - start] = a[i];
  }
  return copy;
}

int find_euc_dist(int[] a, int[] b) {
  int sum = 0;
  for (int i = 0; i < a.length; i++) {
    sum += (a[i] - b[i]) * (a[i] - b[i]);
  }
  return sum;
}

int find_magnitude(int[] a) {
  int sum = 0;
  for (int i = 0; i < a.length; i++) {
    sum += a[i] * a[i];
  }
  return sum;
}

int manhattan_dist(int[] a, int[] b) {
  int sum = 0;
  for (int i = 0; i < a.length; i++) {
    sum += a[i] - b[i];
  }
  return sum;
}

double average(int[] a) {
  int sum = 0;
  for (int i = 0; i < a.length; i++) {
    sum += a[i];
  }
  return sum / a.length;
}

void decrement_array(int[] a, int dec) {
  for (int i = 0; i < a.length; i++) {
    a[i] -= dec;
  }
}

int find_max(int[] a) {
  int max = a[0];
  for (int i = 1; i < a.length; i++) {
    if (a[i] > max) {
      max = a[i];
    }
  }
  return max;
}

int find_max2() {}

void quick_sort(int[] a, int low, int high) {
  if (low < high) {
    int pi = partition(a, low, high);
    quick_sort(a, low, pi - 1);
    quick_sort(a, pi + 1, high);
  }
}

int partition(int[] a, int low, int high) {
  int pivot = a[high];
  int i = low - 1;
  for (int j = low; j < high; j++) {
    if (a[j] < pivot) {
      i++;
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
    }
  }
  int temp = a[i + 1];
  a[i + 1] = a[high];
  a[high] = temp;
  return i + 1;
}

double variance(int[] a) {
  double avg = average(a);
  double sum = 0;
  for (int i = 0; i < a.length; i++) {
    sum += (a[i] - avg) * (a[i] - avg);
  }
  return sum / a.length;
}

void insertion_sort(int[] a) {
  int n = a.length;
  for (int i = 1; i < n; i++) {
    int key = a[i];
    int j = i - 1;
    while (j >= 0 && a[j] > key) {
      a[j + 1] = a[j];
      j -= 1;
    }
    a[j + 1] = key;
  }
}

void heap_sort(int[] a) {
  int n = a.length;
  for (int i = n ~/ 2 - 1; i >= 0; i--) {
    heapify(a, n, i);
  }
  for (int i = n - 1; i >= 0; i--) {
    int temp = a[0];
    a[0] = a[i];
    a[i] = temp;
    heapify(a, i, 0);
  }
}

void heapify(int[] a, int n, int i) {
  int largest = i;
  int l = 2 * i + 1;
  int r = 2 * i + 2;
  if (l < n && a[l] > a[largest]) {
    largest = l;
  }
  if (r < n && a[r] > a[largest]) {
    largest = r;
  }
  if (largest != i) {
    int swap = a[i];
    a[i] = a[largest];
    a[largest] = swap;
    heapify(a, n, largest);
  }
}

void merge_sort(int[] a, int l, int r) {
  if (l < r) {
    int m = (l + r) ~/ 2;
    merge_sort(a, l, m);
    merge_sort(a, m + 1, r);
    merge(a, l, m, r);
  }
}

void merge(int[] a, int l, int m, int r) {
  int n1 = m - l + 1;
  int n2 = r - m;
  int[] L = new int[n1];
  int[] R = new int[n2];
  for (int i = 0; i < n1; i++) {
    L[i] = a[l + i];
  }
  for (int j = 0; j < n2; j++) {
    R[j] = a[m + 1 + j];
  }
  int i = 0;
  int j = 0;
  int k = l;
  while (i < n1 && j < n2) {
    if (L[i] <= R[j]) {
      a[k] = L[i];
      i++;
    } else {
      a[k] = R[j];
      j++;
    }
    k++;
  }
  while (i < n1) {
    a[k] = L[i];
    i++;
    k++;
  }
  while (j < n2) {
    a[k] = R[j];
    j++;
    k++;
  }
}

double geometric_mean(int[] a) {
  double product = 1;
  for (int i = 0; i < a.length; i++) {
    product *= a[i];
  }
  return pow(product, 1 / a.length);
}

int mean_absolute_error(int[] a, int[] b) {
  int sum = 0;
  for (int i = 0; i < a.length; i++) {
    sum += (a[i] - b[i]).abs();
  }
  return sum;
}

int select_k() {}

double find_median(int[] a) {
  int n = a.length;
  if (n % 2 == 0) {
    return (a[n ~/ 2] + a[n ~/ 2 - 1]) / 2;
  } else {
    return a[n ~/ 2];
  }
}

int[] cartesian_product(int[] a, int[] b) {
  int[] product = new int[a.length * b.length];
  int k = 0;
  for (int i = 0; i < a.length; i++) {
    for (int j = 0; j < b.length; j++) {
      product[k] = a[i] * b[j];
      k++;
    }
  }
  return product;
}

void reverse(int[] a) {
  int n = a.length;
  for (int i = 0; i < n / 2; i++) {
    int temp = a[i];
    a[i] = a[n - i - 1];
    a[n - i - 1] = temp;
  }
}

boolean check_equal_tolerance(int[] a, int[] b, int tolerance) {
  for (int i = 0; i < a.length; i++) {
    if ((a[i] - b[i]).abs() > tolerance) {
      return false;
    }
  }
  return true;
}

boolean check_equal(int[] a, int[] b) {
  for (int i = 0; i < a.length; i++) {
    if (a[i] != b[i]) {
      return false;
    }
  }
  return true;
}

double weighted_average(int[] a, int[] b) {
  double sum = 0;
  for (int i = 0; i < a.length; i++) {
    sum += a[i] * b[i];
  }
  return sum / a.length;
}

int count_k(int[] a, int k) {
  int count = 0;
  for (int i = 0; i < a.length; i++) {
    if (a[i] == k) {
      count++;
    }
  }
  return count;
}

int[] bitwise_and(int[] a, int[] b) {
  int[] and = new int[a.length];
  for (int i = 0; i < a.length; i++) {
    and[i] = a[i] & b[i];
  }
  return and;
}

int[] bitwise_or(int[] a, int[] b) {
  int[] or = new int[a.length];
  for (int i = 0; i < a.length; i++) {
    or[i] = a[i] | b[i];
  }
  return or;
}

int[] bitwise_xor(int[] a, int[] b) {
  int[] xor = new int[a.length];
  for (int i = 0; i < a.length; i++) {
    xor[i] = a[i] ^ b[i];
  }
  return xor;
}

int[] bitwise_not(int[] a) {
  int[] not = new int[a.length];
  for (int i = 0; i < a.length; i++) {
    not[i] = ~a[i];
  }
  return not;
}

void clip(int[] a, int min, int max) {
  for (int i = 0; i < a.length; i++) {
    if (a[i] < min) {
      a[i] = min;
    } else if (a[i] > max) {
      a[i] = max;
    }
  }
}

int[] elementwise_max(int[] a, int[] b) {
  int[] max = new int[a.length];
  for (int i = 0; i < a.length; i++) {
    max[i] = a[i] > b[i] ? a[i] : b[i];
  }
  return max;
}

int[] elementwise_min(int[] a, int[] b) {
  int[] min = new int[a.length];
  for (int i = 0; i < a.length; i++) {
    min[i] = a[i] < b[i] ? a[i] : b[i];
  }
  return min;
}

int count_nzeroes(int[] a) {
  int count = 0;
  for (int i = 0; i < a.length; i++) {
    if (a[i] != 0) {
      count++;
    }
  }
  return count;
}

int count_zeroes(int[] a) {
  int count = 0;
  for (int i = 0; i < a.length; i++) {
    if (a[i] == 0) {
      count++;
    }
  }
  return count;
}

boolean[] elementwise_equal(int[] a, int[] b) {
  boolean[] equal = new boolean[a.length];
  for (int i = 0; i < a.length; i++) {
    equal[i] = a[i] == b[i];
  }
  return equal;
}

boolean[] elementwise_not_equal(int[] a, int[] b) {
  boolean[] not_equal = new boolean[a.length];
  for (int i = 0; i < a.length; i++) {
    not_equal[i] = a[i] != b[i];
  }
  return not_equal;
}

int hamming_dist(int[] a, int[] b) {
  int dist = 0;
  for (int i = 0; i < a.length; i++) {
    if (a[i] != b[i]) {
      dist++;
    }
  }
  return dist;
}