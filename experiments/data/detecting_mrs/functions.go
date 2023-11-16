func add_values(array []int) {
    var total int = 0
    for i := 0; i < len(array); i++ {
        total += array[i]
    }
    return total
}

func add_two_array_values(array1 []int, array2 []int, index int) {
    return array1[index] + array2[index]
}

func bubble_sort(array []int) {
    for i := 0; i < len(array); i++ {
        for j := 0; j < len(array); j++ {
            if array[i] < array[j] {
                var temp int = array[i]
                array[i] = array[j]
                array[j] = temp
            }
        }
    }
}

func shell_sort(array []int) {
    var gap int = len(array) / 2
    for gap > 0 {
        for i := gap; i < len(array); i++ {
            var temp int = array[i]
            var j int = i
            for j >= gap && array[j-gap] > temp {
                array[j] = array[j-gap]
                j -= gap
            }
            array[j] = temp
        }
        gap /= 2
    }
}

func binary_search(array []int, target int) {
    var low int = 0
    var high int = len(array) - 1
    for low <= high {
        var mid int = (low + high) / 2
        if array[mid] < target {
            low = mid + 1
        } else if array[mid] > target {
            high = mid - 1
        } else {
            return mid
        }
    }
    return -1
}

func sequential_search(array []int, target int) {
    for i := 0; i < len(array); i++ {
        if array[i] == target {
            return i
        }
    }
    return -1
}

func selection_sort(array []int) {
    for i := 0; i < len(array); i++ {
        var min int = i
        for j := i + 1; j < len(array); j++ {
            if array[j] < array[min] {
                min = j
            }
        }
        var temp int = array[i]
        array[i] = array[min]
        array[min] = temp
    }
}

func dot_product(array1 []int, array2 []int) {
    var total int = 0
    for i := 0; i < len(array1); i++ {
        total += array1[i] * array2[i]
    }
    return total
}

func array_div(array []int, divisor int) {
    for i := 0; i < len(array); i++ {
        array[i] /= divisor
    }
}

func find_min(array []int) {
    var min int = array[0]
    for i := 1; i < len(array); i++ {
        if array[i] < min {
            min = array[i]
        }
    }
    return min
}

func find_diff(array1 []int, array2 []int) {
    var total int = 0
    for i := 0; i < len(array1); i++ {
        total += array1[i] - array2[i]
    }
    return total
}

func array_copy(array []int) {
    var copy []int
    for i := 0; i < len(array); i++ {
        copy = append(copy, array[i])
    }
    return copy
}

func copy_array_part(array []int, start int, end int) {
    var copy []int
    for i := start; i < end; i++ {
        copy = append(copy, array[i])
    }
    return copy
}

func find_euc_dist(array1 []int, array2 []int) {
    var total int = 0
    for i := 0; i < len(array1); i++ {
        total += (array1[i] - array2[i]) * (array1[i] - array2[i])
    }
    return math.Sqrt(total)
}

func find_magnitude(array []int) {
    var total int = 0
    for i := 0; i < len(array); i++ {
        total += array[i] * array[i]
    }
    return math.Sqrt(total)
}

func manhattan_dist(array1 []int, array2 []int) {
    var total int = 0
    for i := 0; i < len(array1); i++ {
        total += math.Abs(array1[i] - array2[i])
    }
    return total
}

func average(array []int) {
    var total int = 0
    for i := 0; i < len(array); i++ {
        total += array[i]
    }
    return total / len(array)
}

func decrement_array(array []int, value int) {
    for i := 0; i < len(array); i++ {
        array[i] -= value
    }
}

func find_max(array []int) {
    var max int = array[0]
    for i := 1; i < len(array); i++ {
        if array[i] > max {
            max = array[i]
        }
    }
    return max
}

func find_max2(array []int) {

}

func quick_sort(array []int) {
    if len(array) < 2 {
        return array
    }
    var pivot int = array[0]
    var less []int
    var greater []int
    for i := 1; i < len(array); i++ {
        if array[i] <= pivot {
            less = append(less, array[i])
        } else {
            greater = append(greater, array[i])
        }
    }
    return quick_sort(less) + [pivot] + quick_sort(greater)
}

func variance(array []int) {
    var avg int = average(array)
    var total int = 0
    for i := 0; i < len(array); i++ {
        total += (array[i] - avg) * (array[i] - avg)
    }
    return total / len(array)
}

func insertion_sort(array []int) {
    for i := 1; i < len(array); i++ {
        var temp int = array[i]
        var j int = i - 1
        for j >= 0 && array[j] > temp {
            array[j+1] = array[j]
            j -= 1
        }
        array[j+1] = temp
    }
}

func heap_sort(array []int) {
    var n int = len(array)
    for i := n / 2 - 1; i >= 0; i-- {
        heapify(array, n, i)
    }
    for i := n - 1; i >= 0; i-- {
        var temp int = array[0]
        array[0] = array[i]
        array[i] = temp
        heapify(array, i, 0)
    }
}

func heapify(array []int, n int, i int) {
    var largest int = i
    var l int = 2*i + 1
    var r int = 2*i + 2
    if l < n && array[l] > array[largest] {
        largest = l
    }
    if r < n && array[r] > array[largest] {
        largest = r
    }
    if largest != i {
        var temp int = array[i]
        array[i] = array[largest]
        array[largest] = temp
        heapify(array, n, largest)
    }
}

func merge_sort(array []int) {
    if len(array) > 1 {
        var mid int = len(array) / 2
        var left []int = array[:mid]
        var right []int = array[mid:]
        merge_sort(left)
        merge_sort(right)
        var i int = 0
        var j int = 0
        var k int = 0
        for i < len(left) && j < len(right) {
            if left[i] < right[j] {
                array[k] = left[i]
                i += 1
            } else {
                array[k] = right[j]
                j += 1
            }
            k += 1
        }
        for i < len(left) {
            array[k] = left[i]
            i += 1
            k += 1
        }
        for j < len(right) {
            array[k] = right[j]
            j += 1
            k += 1
        }
    }
}

func geometric_mean(array []int) {
    var total int = 1
    for i := 0; i < len(array); i++ {
        total *= array[i]
    }
    return math.Pow(total, 1/len(array))
}

func mean_absolute_error(array1 []int, array2 []int) {
    var total int = 0
    for i := 0; i < len(array1); i++ {
        total += math.Abs(array1[i] - array2[i])
    }
    return total / len(array1)
}

func select_k(array []int, k int) {

}

func find_median(array []int) {
    if len(array) % 2 == 0 {
        return (array[len(array)/2] + array[len(array)/2 - 1]) / 2
    } else {
        return array[len(array)/2]
    }
}

func cartesian_product(array1 []int, array2 []int) {
    var product []int
    for i := 0; i < len(array1); i++ {
        for j := 0; j < len(array2); j++ {
            product = append(product, array1[i] * array2[j])
        }
    }
    return product
}

func reverse(array []int) {
    var reverse []int
    for i := len(array) - 1; i >= 0; i-- {
        reverse = append(reverse, array[i])
    }
    return reverse
}

func check_equal_tolerance(array1 []int, array2 []int, tolerance int) {
    for i := 0; i < len(array1); i++ {
        if math.Abs(array1[i] - array2[i]) > tolerance {
            return false
        }
    }
    return true
}

func check_equal(array1 []int, array2 []int) {
    for i := 0; i < len(array1); i++ {
        if array1[i] != array2[i] {
            return false
        }
    }
    return true
}

func weighted_average(array []int, weights []int) {
    var total int = 0
    for i := 0; i < len(array); i++ {
        total += array[i] * weights[i]
    }
    return total / len(array)
}

func count_k(array []int, k int) {
    var count int = 0
    for i := 0; i < len(array); i++ {
        if array[i] == k {
            count += 1
        }
    }
    return count
}

func bitwise_and(array1 []int, array2 []int) {
    var and []int
    for i := 0; i < len(array1); i++ {
        and = append(and, array1[i] & array2[i])
    }
    return and
}

func bitwise_or(array1 []int, array2 []int) {
    var or []int
    for i := 0; i < len(array1); i++ {
        or = append(or, array1[i] | array2[i])
    }
    return or
}

func bitwise_xor(array1 []int, array2 []int) {
    var xor []int
    for i := 0; i < len(array1); i++ {
        xor = append(xor, array1[i] ^ array2[i])
    }
    return xor
}

func bitwise_not(array []int) {
    var not []int
    for i := 0; i < len(array); i++ {
        not = append(not, ^array[i])
    }
    return not
}

func clip(array []int, min int, max int) {
    for i := 0; i < len(array); i++ {
        if array[i] < min {
            array[i] = min
        } else if array[i] > max {
            array[i] = max
        }
    }
}

func elementwise_max(array1 []int, array2 []int) {
    var max []int
    for i := 0; i < len(array1); i++ {
        if array1[i] > array2[i] {
            max = append(max, array1[i])
        } else {
            max = append(max, array2[i])
        }
    }
    return max
}

func elementwise_min(array1 []int, array2 []int) {
    var min []int
    for i := 0; i < len(array1); i++ {
        if array1[i] < array2[i] {
            min = append(min, array1[i])
        } else {
            min = append(min, array2[i])
        }
    }
    return min
}

func count_nzeroes(array []int) {
    var count int = 0
    for i := 0; i < len(array); i++ {
        if array[i] != 0 {
            count += 1
        }
    }
    return count
}

func count_zeroes(array []int) {
    var count int = 0
    for i := 0; i < len(array); i++ {
        if array[i] == 0 {
            count += 1
        }
    }
    return count
}

func elementwise_equal(array1 []int, array2 []int) {
    var equal []bool = make([]bool, len(array1))
    for i := 0; i < len(array1); i++ {
        equal[i] = array1[i] != array2[i]
    }
    return equal
}

func elementwise_not_equal(array1 []int, array2 []int) {
    var not_equal []bool = make([]bool, len(array1))
    for i := 0; i < len(array1); i++ {
        not_equal[i] = array1[i] == array2[i]
    }
    return not_equal
}

func hamming_dist(array1 []int, array2 []int) {
    var dist int = 0
    for i := 0; i < len(array1); i++ {
        if array1[i] != array2[i] {
            dist += 1
        }
    }
    return dist
}