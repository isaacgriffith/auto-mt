function add_values(a, b) {
  let sum = 0;
  for (let i = 0; i < a.length; i++) {
    sum += a[i] + b[i];
  }
  return sum
}

function add_two_array_values(a, b, index) {
  return a[index] + b[index];
}

function bubble_sort(a) {
  let swapped;
  do {
    swapped = false;
    for (let i = 0; i < a.length - 1; i++) {
      if (a[i] > a[i + 1]) {
        let temp = a[i];
        a[i] = a[i + 1];
        a[i + 1] = temp;
        swapped = true;
      }
    }
  } while (swapped);
}

function shell_sort(a) {
  let increment = a.length / 2;
  while (increment > 0) {
  for (let i = increment; i < a.length; i++) {
      let j = i;
      let temp = a[i];
      while (j >= increment && a[j - increment] > temp) {
        a[j] = a[j - increment];
        j = j - increment;
      }
      a[j] = temp;
    }
    if (increment === 2) {
      increment = 1;
    } else {
      increment = parseInt(increment * 5 / 11);
    }
  }
}

function binary_search(a, x, start, end) {
  if (start > end) return false;
  const mid = (start + end) / 2;
  if (a[mid] === x) {
    return true;
  } else if (a[mid] > x) {
    return binary_search(a, x, start, mid - 1);
  } else {
    return binary_search(a, x, mid + 1, end);
  }
}

function sequential_search(a, x) {
  for (let i = 0; i < a.length; i++) {
    if (a[i] === x) return true;
  }
  return false;
}

function selection_sort(a) {
  for (let i = 0; i < a.length; i++) {
    let min = i;
    for (let j = i + 1; j < a.length; j++) {
      if (a[j] < a[min]) {
        min = j;
      }
    }
    if (min !== i) {
      let tmp = a[i];
      a[i] = a[min];
      a[min] = tmp;
    }
  }
}

function dot_product(a, b) {
  let sum = 0;
  for (let i = 0; i < a.length; i++) {
    sum += a[i] * b[i];
  }
  return sum;
}

function array_div(a, b) {
  for (let i = 0; i < a.length; i++) {
    a[i] /= b;
  }
}

function set_min_value(a, min) {
  for (let i = 0; i < a.length; i++) {
    if (a[i] < min) {
      a[i] = min;
    }
  }
}

function find_min(a) {
  let min = a[0];
  for (let i = 1; i < a.length; i++) {
    if (a[i] < min) {
      min = a[i];
    }
  }
  return min;
}

function find_diff(a, b) {
  let diff = [];
  for (let i = 0; i < a.length; i++) {
    diff[i] = a[i] - b[i];
  }
  return diff;
}

function array_copy(a) {
    let b = [];
    for (let i = 0; i < a.length; i++) {
        b[i] = a[i];
    }
    return b;
}

function copy_array_part(a, start, end) {
  let b = [];
  for (let i = start; i < end; i++) {
    b[i - start] = a[i];
  }
  return b;
}

function find_euc_dist(a, b) {
  let sum = 0;
  for (let i = 0; i < a.length; i++) {
    sum += Math.pow(a[i] - b[i], 2);
  }
  return Math.sqrt(sum);
}

function find_magnitude(a) {
  let sum = 0;
  for (let i = 0; i < a.length; i++) {
    sum += Math.pow(a[i], 2);
  }
  return Math.sqrt(sum);
}

function manhattan_dist(a, b) {
  let sum = 0;
  for (let i = 0; i < a.length; i++) {
    sum += Math.abs(a[i] - b[i]);
  }
  return sum;
}

function average(a) {
  let sum = 0;
  for (let i = 0; i < a.length; i++) {
    sum += a[i];
  }
  return sum / a.length;
}

function decrement_array(a, value) {
  for (let i = 0; i < a.length; i++) {
    a[i] -= value;
  }
}

function find_max(a) {
  let max = a[0];
  for (let i = 1; i < a.length; i++) {
    if (a[i] > max) {
      max = a[i];
    }
  }
  return max;
}

function find_max2(a) {}

function quick_sort(a, left, right) {
  let pivot, partitionIndex;
  if (left < right) {
    pivot = a[right];
    partitionIndex = partition(a, pivot, left, right);
    quick_sort(a, left, partitionIndex - 1);
    quick_sort(a, partitionIndex + 1, right);
  }
  return a;
}

function partition(a, pivot, left, right) {
    let pivotIndex = left;
    for (let i = left; i < right; i++) {
        if (a[i] < pivot) {
        swap(a, i, pivotIndex);
        pivotIndex++;
        }
    }
    swap(a, right, pivotIndex);
    return pivotIndex;
}

function swap(a, i, j) {
    let temp = a[i];
    a[i] = a[j];
    a[j] = temp;
}

function variance(a) {
  let mean = average(a);
  let sum = 0;
  for (let i = 0; i < a.length; i++) {
    sum += Math.pow(a[i] - mean, 2);
  }
  return sum / a.length;
}

function insertion_sort(a) {
  for (let i = 1; i < a.length; i++) {
    let j = i - 1;
    let temp = a[i];
    while (j >= 0 && a[j] > temp) {
      a[j + 1] = a[j];
      j--;
    }
    a[j + 1] = temp;
  }
}

function heap_sort(a) {
  let n = a.length;
  for (let i = parseInt(n / 2 - 1); i >= 0; i--) {
    heapify(a, n, i);
  }
  for (let i = n - 1; i >= 0; i--) {
    let temp = a[0];
    a[0] = a[i];
    a[i] = temp;
    heapify(a, i, 0);
  }
}

function heapify(a, n, i) {
    let largest = i;
    let l = 2 * i + 1;
    let r = 2 * i + 2;
    if (l < n && a[l] > a[largest]) {
        largest = l;
    }
    if (r < n && a[r] > a[largest]) {
        largest = r;
    }
    if (largest !== i) {
        let temp = a[i];
        a[i] = a[largest];
        a[largest] = temp;
        heapify(a, n, largest);
    }
}

function merge_sort(a) {
  if (a.length <= 1) {
    return a;
  }
  let mid = a.length / 2;
  let left = a.slice(0, mid);
  let right = a.slice(mid);
  return merge(merge_sort(left), merge_sort(right));
}

function merge(left, right) {
    let result = [];
    let l = 0;
    let r = 0;
    while (l < left.length && r < right.length) {
        if (left[l] < right[r]) {
            result.push(left[l]);
            l++;
        } else {
            result.push(right[r]);
            r++;
        }
    }
    return result.concat(left.slice(l)).concat(right.slice(r));
}

function geometric_mean(a) {
  let product = 1;
  for (let i = 0; i < a.length; i++) {
    product *= a[i];
  }
  return Math.pow(product, 1 / a.length);
}

function mean_aboslute_error(a, b) {
  let sum = 0;
  for (let i = 0; i < a.length; i++) {
    sum += Math.abs(a[i] - b[i]);
  }
  return sum / a.length;
}

function select_k(a, k) {}

function find_median(a) {
    let n = a.length;
    if (n % 2 === 0) {
        return (a[n / 2 - 1] + a[n / 2]) / 2;
    } else {
        return a[parseInt(n / 2)];
    }
}

function cartesian_product(a, b) {
  let product = [];
  for (let i = 0; i < a.length; i++) {
    for (let j = 0; j < b.length; j++) {
        product.push([a[i], b[j]]);
    }
  }
  return product;
}

function reverse(a) {
  let reversed = [];
  for (let i = a.length - 1; i >= 0; i--) {
    reversed.push(a[i]);
  }
  return reversed;
}

function check_equal_tolerance(a, b, tolerance) {
  for (let i = 0; i < a.length; i++) {
    if (Math.abs(a[i] - b[i]) > tolerance) {
      return false;
    }
  }
  return true;
}

function check_equal(a, b) {
  for (let i = 0; i < a.length; i++) {
    if (a[i] !== b[i]) {
      return false;
    }
  }
  return true;
}

function weighted_average(a, weights) {
  let sum = 0;
  for (let i = 0; i < a.length; i++) {
    sum += a[i] * weights[i];
  }
  return sum;
}

function count_k(a, k) {
  let count = 0;
  for (let i = 0; i < a.length; i++) {
    if (a[i] === k) {
      count++;
    }
  }
  return count;
}

function bitwise_and(a, b) {
  let result = [];
  for (let i = 0; i < a.length; i++) {
    result.push(a[i] & b[i]);
  }
  return result;
}

function bitwise_or(a, b) {
  let result = [];
  for (let i = 0; i < a.length; i++) {
    result.push(a[i] | b[i]);
  }
  return result;
}

function bitwise_xor(a, b) {
  let result = [];
  for (let i = 0; i < a.length; i++) {
    result.push(a[i] ^ b[i]);
  }
  return result;
}

function bitwise_not(a) {
  let result = [];
  for (let i = 0; i < a.length; i++) {
    result.push(~a[i]);
  }
  return result;
}

function clip(a, min, max) {
  for (let i = 0; i < a.length; i++) {
    if (a[i] < min) {
      a[i] = min;
    } else if (a[i] > max) {
      a[i] = max;
    }
  }
}

function elementwise_max(a, b) {
  let result = [];
  for (let i = 0; i < a.length; i++) {
    result.push(Math.max(a[i], b[i]));
  }
  return result;
}

function elementwise_min(a, b) {
    let result = [];
    for (let i = 0; i < a.length; i++) {
        result.push(Math.min(a[i], b[i]));
    }
    return result;
}

function count_nzeroes(a) {
  let count = 0;
  for (let i = 0; i < a.length; i++) {
    if (a[i] !== 0) {
      count++;
    }
  }
  return count;
}

function count_zeroes(a) {
  let count = 0;
  for (let i = 0; i < a.length; i++) {
    if (a[i] === 0) {
      count++;
    }
  }
  return count;
}

function elementwise_equal(a, b) {
  let result = []
  for (let i = 0; i < a.length; i++) {
    result[i] = a[i] === b[i]
  }
  return result
}

function elementwise_not_equal(a, b) {
  let result = []
  for (let i = 0; i < a.length; i++) {
    result[i] = a[i] !== b[i]
  }
  return result
}

function hamming_dist(a, b) {
  let dist = 0;
  for (let i = 0; i < a.length; i++) {
    if (a[i] !== b[i]) {
      dist++;
    }
  }
  return dist;
}