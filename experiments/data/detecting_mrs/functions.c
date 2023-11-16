int add_values(int *a, int *b) {
    int sum = 0;
    for (int i = 0; i < 10; i++) {
        sum += a[i] + b[i];
    }
    return sum;
}

int add_two_array_values(int *a, int *b, int i) {
    return a[i] + b[i];
}

void bubble_sort(int *a, int n) {
    int i, j, temp;
    for (i = 0; i < n; i++) {
        for (j = 1; j < (n - i); j++) {
            if (a[j - 1] > a[j]) {
                temp = a[j - 1];
                a[j - 1] = a[j];
                a[j] = temp;
            }
        }
    }
}

void shell_sort(int *a, int n) {
    int i, j, k, temp;
    for (i = n / 2; i > 0; i = i / 2) {
        for (j = i; j < n; j++) {
            for (k = j - i; k >= 0; k = k - i) {
                if (a[k + i] >= a[k])
                    break;
                else {
                    temp = a[k];
                    a[k] = a[k + i];
                    a[k + i] = temp;
                }
            }
        }
    }
}

int binary_search(int *a, int n, int x) {
    int l = 0, r = n - 1, mid;
    while (l <= r) {
        mid = (l + r) / 2;
        if (a[mid] == x)
            return mid;
        else if (a[mid] > x)
            r = mid - 1;
        else
            l = mid + 1;
    }
    return -1;
}

int sequential_search(int *a, int n, int x) {
    int i;
    for (i = 0; i < n; i++) {
        if (a[i] == x)
            return i;
    }
    return -1;
}

void selection_sort(int *a, int n) {
    int i, j, min, temp;
    for (i = 0; i < n - 1; i++) {
        min = i;
        for (j = i; j < n; j++) {
            if (a[j] < a[min])
                min = j;
        }
        temp = a[i];
        a[i] = a[min];
        a[min] = temp;
    }
}

int dot_product() {
    int a[10], b[10], i, sum = 0;
    for (i = 0; i < 10; i++) {
        a[i] = i;
        b[i] = i;
    }
    for (i = 0; i < 10; i++) {
        sum += a[i] * b[i];
    }
    return sum;
}

void array_div(int *a, int *b, int *c, int n) {
    int i;
    for (i = 0; i < n; i++) {
        c[i] = a[i] / b[i];
    }
}

void set_min_value(int *a, int n, int x) {
    int i;
    for (i = 0; i < n; i++) {
        if (a[i] < x)
            a[i] = x;
    }
}

int find_min(int *a, int n) {
    int i, min = a[0];
    for (i = 1; i < n; i++) {
        if (a[i] < min)
            min = a[i];
    }
    return min;
}

int* find_diff(int *a, int *b, int n) {
    int i;
    int *c = (int *)malloc(sizeof(int) * n);
    for (i = 0; i < n; i++) {
        c[i] = a[i] - b[i];
    }
    return c;
}

int* array_copy(int *a, int n) {
    int i;
    int *b = (int *)malloc(sizeof(int) * n);
    for (i = 0; i < n; i++) {
        b[i] = a[i];
    }
    return b;
}

int* copy_array_part(int *a, int n, int start, int end) {
    int i;
    int *b = (int *)malloc(sizeof(int) * (end - start + 1));
    for (i = start; i <= end; i++) {
        b[i - start] = a[i];
    }
    return b;
}

int find_euc_dist(int *a, int *b, int n) {
    int i, sum = 0;
    for (i = 0; i < n; i++) {
        sum += (a[i] - b[i]) * (a[i] - b[i]);
    }
    return sum;
}

int find_magnitude(int *a, int n) {
    int i, sum = 0;
    for (i = 0; i < n; i++) {
        sum += a[i] * a[i];
    }
    return sum;
}

int manhattan_dist(int *a, int *b, int n) {
    int i, sum = 0;
    for (i = 0; i < n; i++) {
        sum += abs(a[i] - b[i]);
    }
    return sum;
}

int average(int *a, int n) {
    int i, sum = 0;
    for (i = 0; i < n; i++) {
        sum += a[i];
    }
    return sum / n;
}

void decrement_array(int *a, int n, int val) {
    int i;
    for (i = 0; i < n; i++) {
        a[i] -= val;
    }
}

int find_max(int *a, int n) {
    int i, max = a[0];
    for (i = 1; i < n; i++) {
        if (a[i] > max)
            max = a[i];
    }
    return max;
}

int find_max2() {}

void quick_sort(int *a, int l, int r) {
    int i, j, pivot, temp;
    if (l < r) {
        pivot = l;
        i = l;
        j = r;
        while (i < j) {
            while (a[i] <= a[pivot] && i < r)
                i++;
            while (a[j] > a[pivot])
                j--;
            if (i < j) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        temp = a[pivot];
        a[pivot] = a[j];
        a[j] = temp;
        quick_sort(a, l, j - 1);
        quick_sort(a, j + 1, r);
    }
}

int variance(int *a, int n) {
    int i, sum = 0, avg;
    for (i = 0; i < n; i++) {
        sum += a[i];
    }
    avg = sum / n;
    sum = 0;
    for (i = 0; i < n; i++) {
        sum += (a[i] - avg) * (a[i] - avg);
    }
    return sum / n;
}

void insertion_sort(int *a, int n) {
    int i, j, temp;
    for (i = 1; i < n; i++) {
        temp = a[i];
        j = i - 1;
        while (temp < a[j] && j >= 0) {
            a[j + 1] = a[j];
            j--;
        }
        a[j + 1] = temp;
    }
}

void heap_sort(int *a, int n) {
    int i, temp;
    for (i = n / 2 - 1; i >= 0; i--)
        heapify(a, n, i);
    for (i = n - 1; i >= 0; i--) {
        temp = a[0];
        a[0] = a[i];
        a[i] = temp;
        heapify(a, i, 0);
    }
}

void heapify(int *a, int n, int i) {
    int largest = i, l = 2 * i + 1, r = 2 * i + 2, temp;
    if (l < n && a[l] > a[largest])
        largest = l;
    if (r < n && a[r] > a[largest])
        largest = r;
    if (largest != i) {
        temp = a[i];
        a[i] = a[largest];
        a[largest] = temp;
        heapify(a, n, largest);
    }
}

void merge_sort(int *a, int l, int r) {
    int m;
    if (l < r) {
        m = (l + r) / 2;
        merge_sort(a, l, m);
        merge_sort(a, m + 1, r);
        merge(a, l, m, r);
    }
}

void merge(int *a, int l, int m, int r) {
    int i, j, k, n1 = m - l + 1, n2 = r - m, L[n1], R[n2];
    for (i = 0; i < n1; i++)
        L[i] = a[l + i];
    for (j = 0; j < n2; j++)
        R[j] = a[m + 1 + j];
    i = 0;
    j = 0;
    k = l;
    while (i < n1 && j < n2) {
        if (L[i] <= R[j])
            a[k++] = L[i++];
        else
            a[k++] = R[j++];
    }
    while (i < n1)
        a[k++] = L[i++];
    while (j < n2)
        a[k++] = R[j++];
}

double geometric_mean(int *a, int n) {
    int i, prod = 1;
    for (i = 0; i < n; i++) {
        prod *= a[i];
    }
    return pow(prod, 1.0 / n);
}

double mean_absolute_error(int *a, int *b, int n) {
    int i, sum = 0;
    for (i = 0; i < n; i++) {
        sum += abs(a[i] - b[i]);
    }
    return sum / n;
}

int select_k() {}

double find_median(int *a, int n) {
    int i, j, temp;
    for (i = 0; i < n - 1; i++) {
        for (j = 1; j < (n - i); j++) {
            if (a[j - 1] > a[j]) {
                temp = a[j - 1];
                a[j - 1] = a[j];
                a[j] = temp;
            }
        }
        if (i == (n / 2) - 1)
            return a[i];
    }
    return a[n / 2];
}

int* cartesian_product(int *a, int *b, int n) {
    int i, j, k = 0;
    int *c = (int *)malloc(sizeof(int) * n * n);
    for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {
            c[k++] = a[i] * b[j];
        }
    }
    return c;
}

void reverse(int *a, int n) {
    int i, temp;
    for (i = 0; i < n / 2; i++) {
        temp = a[i];
        a[i] = a[n - 1 - i];
        a[n - 1 - i] = temp;
    }
}

bool check_equal_tolerance(int *a, int *b, int n, int tol) {
    int i;
    for (i = 0; i < n; i++) {
        if (abs(a[i] - b[i]) > tol)
            return false;
    }
    return true;
}

bool check_equal(int *a, int *b, int n) {
    int i;
    for (i = 0; i < n; i++) {
        if (a[i] != b[i])
            return false;
    }
    return true;
}

double weighted_average(int *a, int *b, int n) {
    int i, sum = 0, wsum = 0;
    for (i = 0; i < n; i++) {
        sum += a[i] * b[i];
        wsum += b[i];
    }
    return sum / wsum;
}

int count_k(int *a, int n, int k) {
    int i, count = 0;
    for (i = 0; i < n; i++) {
        if (a[i] == k)
            count++;
    }
    return count;
}

int* bitwise_and(int *a, int *b, int n) {
    int i;
    int *c = (int *)malloc(sizeof(int) * n);
    for (i = 0; i < n; i++) {
        c[i] = a[i] & b[i];
    }
    return c;
}

int* bitwise_or(int *a, int *b, int n) {
    int i;
    int *c = (int *)malloc(sizeof(int) * n);
    for (i = 0; i < n; i++) {
        c[i] = a[i] | b[i];
    }
    return c;
}

int* bitwise_xor(int *a, int *b, int n) {
    int i;
    int *c = (int *)malloc(sizeof(int) * n);
    for (i = 0; i < n; i++) {
        c[i] = a[i] ^ b[i];
    }
    return c;
}

int* bitwise_not(int *a, int n) {
    int i;
    int *b = (int *)malloc(sizeof(int) * n);
    for (i = 0; i < n; i++) {
        b[i] = ~a[i];
    }
    return b;
}

void clip(int *a, int n, int min, int max) {
    int i;
    for (i = 0; i < n; i++) {
        if (a[i] < min)
            a[i] = min;
        else if (a[i] > max)
            a[i] = max;
    }
}

int* elementwise_max(int *a, int *b, int n) {
    int i;
    int *c = (int *)malloc(sizeof(int) * n);
    for (i = 0; i < n; i++) {
        if (a[i] > b[i])
            c[i] = a[i];
        else
            c[i] = b[i];
    }
    return c;
}

int* elementwise_min(int *a, int *b, int n) {
    int i;
    int *c = (int *)malloc(sizeof(int) * n);
    for (i = 0; i < n; i++) {
        if (a[i] < b[i])
            c[i] = a[i];
        else
            c[i] = b[i];
    }
    return c;
}

int count_nzeroes(int *a, int n) {
    int i, count = 0;
    for (i = 0; i < n; i++) {
        if (a[i] != 0)
            count++;
    }
    return count;
}

int count_zeroes(int *a, int n) {
    int i, count = 0;
    for (i = 0; i < n; i++) {
        if (a[i] == 0)
            count++;
    }
    return count;
}

bool* elementwise_equal(int *a, int *b, int n) {
    int i;
    bool *c = (bool *)malloc(sizeof(bool) * n);
    for (i = 0; i < n; i++) {
        if (a[i] == b[i])
            c[i] = true;
        else
            c[i] = false;
    }
    return c;
}

bool* elementwise_not_equal(int *a, int *b, int n) {
    int i;
    bool *c = (bool *)malloc(sizeof(bool) * n);
    for (i = 0; i < n; i++) {
        if (a[i] != b[i])
            c[i] = true;
        else
            c[i] = false;
    }
    return c;
}

int hamming_dist(int *a, int *b, int n) {
    int i, count = 0;
    for (i = 0; i < n; i++) {
        if (a[i] != b[i])
            count++;
    }
    return count;
}