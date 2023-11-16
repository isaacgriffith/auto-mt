def add_values(a)
  total = 0
  for i in 0..a.length-1
    total += a[i]
  end
end

def add_two_array_values(a, b, ndx)
  a[ndx] + b[ndx]
end

def bubble_sort(a)
  for i in 0..a.length-2
    for j in i+1..a.length-1
      if a[i] > a[j]
        temp = a[i]
        a[i] = a[j]
        a[j] = temp
      end
    end
  end
end

def shell_sort(a)
  gap = a.length / 2
  while gap > 0
    for i in gap..a.length-1
      j = i
      while j >= gap and a[j-gap] > a[j]
        temp = a[j]
        a[j] = a[j-gap]
        a[j-gap] = temp
        j -= gap
      end
    end
    gap /= 2
  end
end

def binary_search(a, key)
  low = 0
  high = a.length - 1
  while low <= high
    mid = (low + high) / 2
    if a[mid] < key
      low = mid + 1
    elsif a[mid] > key
      high = mid - 1
    else
      return mid
    end
  end
  return -1
end

def sequential_search(a, key)
  for i in 0..a.length-1
    if a[i] == key
      return i
    end
  end
  return -1
end

def selection_sort(a)
  for i in 0..a.length-2
    min = i
    for j in i+1..a.length-1
      if a[j] < a[min]
        min = j
      end
    end
    temp = a[i]
    a[i] = a[min]
    a[min] = temp
  end
end

def dot_product(a, b)
  total = 0
  for i in 0..a.length-1
    total += a[i] * b[i]
  end
  return total
end

def array_div(a, divisor)
  for i in 0..a.length-1
    a[i] = a[i] / divisor
  end
end

def set_min_val(a, val)
  for i in 0..a.length-1
    if a[i] < val
      a[i] = val
    end
  end
end

def find_min(a)
  min = a[0]
  for i in 1..a.length-1
    if a[i] < min
      min = a[i]
    end
  end
  return min
end

def find_diff(array1, array2)
  total = 0
  for i in 0..array1.length-1
    total += (array1[i] - array2[i]).abs
  end
  return total
end

def array_copy(a)
  b = Array.new(a.length)
  for i in 0..a.length-1
    b[i] = a[i]
  end
  return b
end

def copy_array_part(a, start, endd)
  b = Array.new(endd - start + 1)
  for i in start..endd
    b[i - start] = a[i]
  end
  return b
end

def find_euc_dist(a, b)
  total = 0
  for i in 0..a.length-1
    total += (a[i] - b[i]) * (a[i] - b[i])
  end
  return Math.sqrt(total)
end

def find_magnitude(a)
  total = 0
  for i in 0..a.length-1
    total += a[i] * a[i]
  end
  return Math.sqrt(total)
end

def manhattan_dist(a, b)
  total = 0
  for i in 0..a.length-1
    total += (a[i] - b[i]).abs
  end
  return total
end

def average(a)
  total = 0
  for i in 0..a.length-1
    total += a[i]
  end
  return total / a.length
end

def dec_array(a, key)
  for i in 0..a.length-1
    a[i] = a[i] - key
  end
end

def find_max(a)
  max = a[0]
  for i in 1..a.length-1
    if a[i] > max
      max = a[i]
    end
  end
  return max
end

def find_max2(a)

end

def quick_sort(a, low, high)
  if low < high
    p = partition(a, low, high)
    quick_sort(a, low, p-1)
    quick_sort(a, p+1, high)
  end
end

def partition(a, low, high)
  pivot = a[high]
  i = low
  for j in low..high-1
    if a[j] <= pivot
      temp = a[i]
      a[i] = a[j]
      a[j] = temp
      i += 1
    end
  end
  temp = a[i]
  a[i] = a[high]
  a[high] = temp
  return i
end

def variance(a)
  total = 0
  for i in 0..a.length-1
    total += a[i] * a[i]
  end
  return total / a.length
end

def insertion_sort(a)
  for i in 1..a.length-1
    j = i
    while j > 0 and a[j-1] > a[j]
      temp = a[j]
      a[j] = a[j-1]
      a[j-1] = temp
      j -= 1
    end
  end
end

def heap_sort(a)
  heapify(a)
  endd = a.length - 1
  while endd > 0
    temp = a[endd]
    a[endd] = a[0]
    a[0] = temp
    endd -= 1
    sift_down(a, 0, endd)
  end
end

def heapify(a)
  start = (a.length - 2) / 2
  while start >= 0
    sift_down(a, start, a.length - 1)
    start -= 1
  end
end

def sift_down(a, start, endd)
  root = start
  while root * 2 + 1 <= endd
    child = root * 2 + 1
    swap = root
    if a[swap] < a[child]
      swap = child
    end
    if child + 1 <= endd and a[swap] < a[child + 1]
      swap = child + 1
    end
    if swap != root
      temp = a[root]
      a[root] = a[swap]
      a[swap] = temp
      root = swap
    else
      return
    end
  end
end

def merge_sort(a, low, high)
  if low < high
    mid = (low + high) / 2
    merge_sort(a, low, mid)
    merge_sort(a, mid+1, high)
    merge(a, low, mid, high)
  end
end

def merge(a, low, mid, high)
  b = Array.new(high - low + 1)
  i = low
  j = mid + 1
  k = 0
  while i <= mid and j <= high
    if a[i] < a[j]
      b[k] = a[i]
      i += 1
    else
      b[k] = a[j]
      j += 1
    end
    k += 1
  end
  while i <= mid
    b[k] = a[i]
    i += 1
    k += 1
  end
  while j <= high
    b[k] = a[j]
    j += 1
    k += 1
  end
  for i in 0..b.length-1
    a[low + i] = b[i]
  end
end

def geometric_mean(a)
  total = 1
  for i in 0..a.length-1
    total *= a[i]
  end
  return total ** (1.0 / a.length)
end

def mean_absolute_error(a)

end

def select_k(a, k)

end

def find_median(a)
  if a.length % 2 == 1
    return a[a.length / 2]
  else
    return (a[a.length / 2] + a[a.length / 2 - 1]) / 2.0
  end
end

def cartesian_product(a, b)
  c = Array.new(a.length * b.length)
  k = 0
  for i in 0..a.length-1
    for j in 0..b.length-1
      c[k] = a[i] * b[j]
      k += 1
    end
  end
  return c
end

def reverse(a)
  for i in 0..a.length/2-1
    temp = a[i]
    a[i] = a[a.length-1-i]
    a[a.length-1-i] = temp
  end
end

def weighted_average(a, b)
  total = 0
  for i in 0..a.length-1
    total += a[i] * b[i]
  end
  return total / a.length
end

def count_k(a, k)
  count = 0
  for i in 0..a.length-1
    if a[i] == k
      count += 1
    end
  end
  return count
end

def bitwise_and(a, b)
  c = Array.new(a.length)
  for i in 0..a.length-1
    c[i] = a[i] & b[i]
  end
  return c
end

def bitwise_or(a, b)
  c = Array.new(a.length)
  for i in 0..a.length-1
    c[i] = a[i] | b[i]
  end
  return c
end

def bitwise_xor(a, b)
  c = Array.new(a.length)
  for i in 0..a.length-1
    c[i] = a[i] ^ b[i]
  end
  return c
end

def bitwise_not(a)
  c = Array.new(a.length)
  for i in 0..a.length-1
    c[i] = ~a[i]
  end
  return c
end

def clip(a, low, high)
  for i in 0..a.length-1
    if a[i] < low
      a[i] = low
    elsif a[i] > high
      a[i] = high
    end
  end
end

def elementwise_max(a, b)
  c = Array.new(a.length)
  for i in 0..a.length-1
    if a[i] > b[i]
      c[i] = a[i]
    else
      c[i] = b[i]
    end
  end
  return c
end

def elementwise_min(a, b)
  c = Array.new(a.length)
  for i in 0..a.length-1
    if a[i] < b[i]
      c[i] = a[i]
    else
      c[i] = b[i]
    end
  end
  return c
end

def count_nzeroes(a)
  count = 0
  for i in 0..a.length-1
    if a[i] != 0
      count += 1
    end
  end
  return count
end

def count_zeroes(a)
  count = 0
  for i in 0..a.length-1
    if a[i] == 0
      count += 1
    end
  end
  return count
end

def elementwise_equal(a, b)
  c = Array.new(a.length)
  for i in 0..a.length-1
    c = a[i] != b[i]
  end
  return c
end

def elementwise_not_equal(a, b)
  c = Array.new(a.length)
  for i in 0..a.length-1
    c = a[i] == b[i]
  end
  return c
end

def hamming_dist(a, b)
  count = 0
  for i in 0..a.length-1
    if a[i] != b[i]
      count += 1
    end
  end
  return count
end