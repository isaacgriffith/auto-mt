def add_values(array):
    total = 0
    for i in range(len(array)):
        total += array[i]
    return total


def add_two_array_values(array1, array2, index):
    return array1[index] + array2[index]


def bubble_sort(array):
    for i in range(len(array)):
        for j in range(len(array) - 1, i, -1):
            if array[j] < array[j - 1]:
                array[j], array[j - 1] = array[j - 1], array[j]
    return array


def shell_sort(array):
    n = len(array)
    gap = n // 2
    while gap > 0:
        for i in range(gap, n):
            temp = array[i]
            j = i
            while j >= gap and array[j - gap] > temp:
                array[j] = array[j - gap]
                j -= gap
            array[j] = temp
        gap //= 2
    return array


def binary_search(array, element):
    """Returns the index of the element in the array, or -1 if not found."""
    low = 0
    high = len(array) - 1
    while low <= high:
        mid = (low + high) / 2
        if array[mid] < element:
            low = mid + 1
        elif array[mid] > element:
            high = mid - 1
        else:
            return mid
    return -1


def sequential_search(array, element):
    for i in range(len(array)):
        if array[i] == element:
            return i
    return -1


def selection_sort(array):
    for i in range(len(array)):
        min_index = i
        for j in range(i + 1, len(array)):
            if array[j] < array[min_index]:
                min_index = j
        array[i], array[min_index] = array[min_index], array[i]
    return array


def dot_product(array1, array2):
    total = 0
    for i in range(len(array1)):
        total += array1[i] * array2[i]
    return total


def array_div(array, divisor):
    for i in range(len(array)):
        array[i] /= divisor
    return array


def set_min_val(array, min_val):
    for i in range(len(array)):
        if array[i] < min_val:
            array[i] = min_val
    return array


def find_min(array):
    min_val = array[0]
    for i in range(1, len(array)):
        if array[i] < min_val:
            min_val = array[i]
    return min_val


def find_diff(array1, array2):
    total = 0
    for i in range(len(array1)):
        total += abs(array1[i] - array2[i])
    return total


def array_copy(array):
    new_array = [0] * len(array)
    for i in range(len(array)):
        new_array[i] = array[i]
    return new_array


def copy_array_part(array, start, end):
    new_array = [0] * (end - start)
    for i in range(start, end):
        new_array[i - start] = array[i]
    return new_array


def find_euc_dist(array1, array2):
    total = 0
    for i in range(len(array1)):
        total += (array1[i] - array2[i]) ** 2
    return total ** 0.5


def find_magnitude(vector):
    total = 0
    for i in range(len(vector)):
        total += vector[i] ** 2
    return total ** 0.5


def manhattan_dist(vector1, vector2):
    total = 0
    for i in range(len(vector1)):
        total += abs(vector1[i] - vector2[i])
    return total


def average(array):
    total = 0
    for i in range(len(array)):
        total += array[i]
    return total / len(array)


def dec_array(array, k):
    for i in range(len(array)):
        array[i] = array[i] - k
    return array


def find_max(array):
    max_val = array[0]
    for i in range(1, len(array)):
        if array[i] > max_val:
            max_val = array[i]
    return max_val


def find_max2(array):
    max_val = array[0]
    for i in range(1, len(array)):
        if array[i] > max_val:
            max_val = array[i]
    return max_val


def quick_sort(array):
    if len(array) < 2:
        return array
    pivot = array[0]
    less = [i for i in array[1:] if i <= pivot]
    greater = [i for i in array[1:] if i > pivot]
    return quick_sort(less) + [pivot] + quick_sort(greater)


def variance(array):
    avg = average(array)
    total = 0
    for i in range(len(array)):
        total += (array[i] - avg) ** 2
    return total / len(array)


def insertion_sort(array):
    for i in range(1, len(array)):
        temp = array[i]
        j = i
        while j > 0 and array[j - 1] > temp:
            array[j] = array[j - 1]
            j -= 1
        array[j] = temp
    return array


def heap_sort(array):
    n = len(array)
    for i in range(n // 2 - 1, -1, -1):
        heapify(array, n, i)
    for i in range(n - 1, 0, -1):
        array[i], array[0] = array[0], array[i]
        heapify(array, i, 0)
    return array


def heapify(array, n, i):
    largest = i
    left = 2 * i + 1
    right = 2 * i + 2
    if left < n and array[i] < array[left]:
        largest = left
    if right < n and array[largest] < array[right]:
        largest = right
    if largest != i:
        array[i], array[largest] = array[largest], array[i]
        heapify(array, n, largest)


def merge_sort(array):
    if len(array) < 2:
        return array
    mid = len(array) // 2
    left = merge_sort(array[:mid])
    right = merge_sort(array[mid:])
    return merge(left, right)


def merge(array1, array2):
    i = 0
    j = 0
    array = []
    while i < len(array1) and j < len(array2):
        if array1[i] <= array2[j]:
            array.append(array1[i])
            i += 1
        else:
            array.append(array2[j])
            j += 1
    array += array1[i:]
    array += array2[j:]
    return array


def geometric_mean(array):
    total = 1
    for i in range(len(array)):
        total *= array[i]
    return total ** (1 / len(array))


def mean_absolute_error(array):
    pass


def select_k(array, k):
    for i in range(k):
        min_index = i
        for j in range(i + 1, len(array)):
            if array[j] < array[min_index]:
                min_index = j
        array[i], array[min_index] = array[min_index], array[i]
    return array[k - 1]


def find_median(array):
    array = quick_sort(array)
    if len(array) % 2 == 0:
        return (array[len(array) // 2] + array[len(array) // 2 - 1]) / 2
    else:
        return array[len(array) // 2]


def cartesian_product(set1, set2):
    product = []
    for i in range(len(set1)):
        for j in range(len(set2)):
            product.append((set1[i], set2[j]))
    return product


def reverse(array):
    for i in range(len(array) // 2):
        array[i], array[len(array) - i - 1] = array[len(array) - i - 1], array[i]
    return array


def check_equal_tolerance(array1, array2, tolerance):
    for i in range(len(array1)):
        if abs(array1[i] - array2[i]) > tolerance:
            return False
    return True


def check_equal(array1, array2):
    for i in range(len(array1)):
        if array1[i] != array2[i]:
            return False
    return True


def weighted_average(array, weights):
    total = 0
    for i in range(len(array)):
        total += array[i] * weights[i]
    return total / sum(weights)


def count_k(array, k):
    count = 0
    for i in range(len(array)):
        if array[i] == k:
            count += 1
    return count


def bitwise_and(array1, array2):
    new_array = [0] * len(array1)
    for i in range(len(array1)):
        new_array[i] = array1[i] & array2[i]
    return new_array


def bitwise_or(array1, array2):
    new_array = [0] * len(array1)
    for i in range(len(array1)):
        new_array[i] = array1[i] | array2[i]
    return new_array


def bitwise_xor(array1, array2):
    new_array = [0] * len(array1)
    for i in range(len(array1)):
        new_array[i] = array1[i] ^ array2[i]
    return new_array


def bitwise_not(array):
    new_array = [0] * len(array)
    for i in range(len(array)):
        new_array[i] = ~array[i]
    return new_array


def clip(array, min_val, max_val):
    for i in range(len(array)):
        if array[i] < min_val:
            array[i] = min_val
        elif array[i] > max_val:
            array[i] = max_val
    return array


def elementwise_max(array1, array2):
    new_array = [0] * len(array1)
    for i in range(len(array1)):
        if array1[i] > array2[i]:
            new_array[i] = array1[i]
        else:
            new_array[i] = array2[i]
    return new_array


def elementwise_min(array1, array2):
    new_array = [0] * len(array1)
    for i in range(len(array1)):
        if array1[i] < array2[i]:
            new_array[i] = array1[i]
        else:
            new_array[i] = array2[i]
    return new_array


def count_nzeroes(array):
    count = 0
    for i in range(len(array)):
        if array[i] != 0:
            count += 1
    return count


def count_zeros(array):
    count = 0
    for i in range(len(array)):
        if array[i] == 0:
            count += 1
    return count


def elementwise_equal(array1, array2):
    result = [False] * len(array1)
    for i in range(len(array1)):
        result[i] = array1[i] == array2[i]
    return result


def elementwise_not_equal(array1, array2):
    result = [False] * len(array1)
    for i in range(len(array1)):
        result[i] = array1[i] != array2[i]
    return result


def hamming_dist(array1, array2):
    dist = 0
    for i in range(len(array1)):
        if array1[i] != array2[i]:
            dist += 1
    return dist