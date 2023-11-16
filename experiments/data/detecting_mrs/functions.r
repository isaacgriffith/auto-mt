add_values <- function(x) {
    sum(x)
}

add_two_array_values <- function(x, y, index)) {
    x[index] + y[index]
}

bubble_sort <- function(x) {
    n <- length(x)
    for (i in 1:(n - 1)) {
        for (j in 1:(n - i)) {
            if (x[j] > x[j + 1]) {
                temp <- x[j]
                x[j] <- x[j + 1]
                x[j + 1] <- temp
            }
        }
    }
    x
}

shell_sort <- function(x) {
    n <- length(x)
    gap <- floor(n / 2)
    while (gap > 0) {
        for (i in (gap + 1):n) {
            temp <- x[i]
            j <- i
            while ((j > gap) && (x[j - gap] > temp)) {
                x[j] <- x[j - gap]
                j <- j - gap
            }
            x[j] <- temp
        }
        gap <- floor(gap / 2)
    }
    x
}

binary_search <- function(x, key) {
    n <- length(x)
    low <- 1
    high <- n
    while (low <= high) {
        mid <- floor((low + high) / 2)
        if (key == x[mid]) {
            return(mid)
        } else if (key < x[mid]) {
            high <- mid - 1
        } else {
            low <- mid + 1
        }
    }
    return(-1)
}

sequential_search <- function(x, key) {
    n <- length(x)
    for (i in 1:n) {
        if (key == x[i]) {
            return(i)
        }
    }
    return(-1)
}

selection_sort <- function(x) {
    n <- length(x)
    for (i in 1:(n - 1)) {
        min <- i
        for (j in (i + 1):n) {
            if (x[j] < x[min]) {
                min <- j
            }
        }
        if (min != i) {
            temp <- x[i]
            x[i] <- x[min]
            x[min] <- temp
        }
    }
    x
}

dot_product <- function(x, y) {
    sum(x * y)
}

array_div <- function(x, y) {
    x / y
}

set_min_value <- function(x, min) {
    n <- length(x)
    for (i in 1:n) {
        if (x[i] < min) {
            x[i] <- min
        }
    }
    x
}

find_min <- function(x) {
    n <- length(x)
    min <- x[1]
    for (i in 2:n) {
        if (x[i] < min) {
            min <- x[i]
        }
    }
    min
}

find_diff <- function(x, y) {
    n <- length(x)
    diff <- 0
    for (i in 1:n) {
        diff <- diff + abs(x[i] - y[i])
    }
    diff
}

array_copy <- function(x) {
    n <- length(x)
    y <- rep(0, n)
    for (i in 1:n) {
        y[i] <- x[i]
    }
    y
}

copy_array_part <- function(x, start, end) {
    y <- rep(0, end - start + 1)
    for (i in start:end) {
        y[i - start + 1] <- x[i]
    }
    y
}

find_euc_dist <- function(x, y) {
    n <- length(x)
    dist <- 0
    for (i in 1:n) {
        dist <- dist + (x[i] - y[i]) ^ 2
    }
    sqrt(dist)
}

find_magnitude <- function(x) {
    n <- length(x)
    sum <- 0
    for (i in 1:n) {
        sum <- sum + x[i] ^ 2
    }
    sqrt(sum)
}

manhattan_dist <- function(x, y) {
    n <- length(x)
    dist <- 0
    for (i in 1:n) {
        dist <- dist + abs(x[i] - y[i])
    }
    dist
}

average <- function(x) {
    n <- length(x)
    sum <- 0
    for (i in 1:n) {
        sum <- sum + x[i]
    }
    sum / n
}

decrement_array <- function(x, value) {
    n <- length(x)
    for (i in 1:n) {
        x[i] <- x[i] - value
    }
    x
}

find_max <- function(x) {
    n <- length(x)
    max <- x[1]
    for (i in 2:n) {
        if (x[i] > max) {
            max <- x[i]
        }
    }
    max
}

find_max2 <- function(x) {

}

quick_sort <- function(x, start, end) {
    if (start < end) {
        pivot <- partition(x, start, end)
        quick_sort(x, start, pivot - 1)
        quick_sort(x, pivot + 1, end)
    }
    x
}

partition <- function(x, start, end) {
    pivot <- x[end]
    i <- start - 1
    for (j in start:(end - 1)) {
        if (x[j] <= pivot) {
            i <- i + 1
            temp <- x[i]
            x[i] <- x[j]
            x[j] <- temp
        }
    }
    temp <- x[i + 1]
    x[i + 1] <- x[end]
    x[end] <- temp
    i + 1
}

variance <- function(x) {
    n <- length(x)
    avg <- average(x)
    sum <- 0
    for (i in 1:n) {
        sum <- sum + (x[i] - avg) ^ 2
    }
    sum / n
}

insertion_sort <- function(x) {
    n <- length(x)
    for (i in 2:n) {
        temp <- x[i]
        j <- i
        while ((j > 1) && (x[j - 1] > temp)) {
            x[j] <- x[j - 1]
            j <- j - 1
        }
        x[j] <- temp
    }
    x
}

heap_sort <- function(x) {
    n <- length(x)
    for (i in floor(n / 2):1) {
        heapify(x, i, n)
    }
    for (i in n:2) {
        temp <- x[1]
        x[1] <- x[i]
        x[i] <- temp
        heapify(x, 1, i - 1)
    }
    x
}

heapify <- function(x, i, n) {
    left <- 2 * i
    right <- 2 * i + 1
    largest <- i
    if ((left <= n) && (x[left] > x[largest])) {
        largest <- left
    }
    if ((right <= n) && (x[right] > x[largest])) {
        largest <- right
    }
    if (largest != i) {
        temp <- x[i]
        x[i] <- x[largest]
        x[largest] <- temp
        heapify(x, largest, n)
    }
}

merge_sort <- function(x, start, end) {
    if (start < end) {
        mid <- floor((start + end) / 2)
        merge_sort(x, start, mid)
        merge_sort(x, mid + 1, end)
        merge(x, start, mid, end)
    }
    x
}

merge <- function(x, start, mid, end) {
    n1 <- mid - start + 1
    n2 <- end - mid
    left <- rep(0, n1)
    right <- rep(0, n2)
    for (i in 1:n1) {
        left[i] <- x[start + i - 1]
    }
    for (i in 1:n2) {
        right[i] <- x[mid + i]
    }
    i <- 1
    j <- 1
    k <- start
    while ((i <= n1) && (j <= n2)) {
        if (left[i] <= right[j]) {
            x[k] <- left[i]
            i <- i + 1
        } else {
            x[k] <- right[j]
            j <- j + 1
        }
        k <- k + 1
    }
    while (i <= n1) {
        x[k] <- left[i]
        i <- i + 1
        k <- k + 1
    }
    while (j <= n2) {
        x[k] <- right[j]
        j <- j + 1
        k <- k + 1
    }
}

geometric_mean <- function(x) {
    n <- length(x)
    prod <- 1
    for (i in 1:n) {
        prod <- prod * x[i]
    }
    prod ^ (1 / n)
}

mean_absolute_error <- function(x, y) {
    n <- length(x)
    sum <- 0
    for (i in 1:n) {
        sum <- sum + abs(x[i] - y[i])
    }
    sum / n
}

select_k <- function(x, k) {
    # select kth largest element in array

}

find_median <- function(x) {
    n <- length(x)
    if (n %% 2 == 0) {
        (x[n / 2] + x[n / 2 + 1]) / 2
    } else {
        x[(n + 1) / 2]
    }
}

cartesian_product <- function(x, y) {
    n <- length(x)
    m <- length(y)
    z <- rep(0, n * m)
    k <- 1
    for (i in 1:n) {
        for (j in 1:m) {
            z[k] <- x[i] * y[j]
            k <- k + 1
        }
    }
    z
}

reverse <- function(x) {
    n <- length(x)
    for (i in 1:(n / 2)) {
        temp <- x[i]
        x[i] <- x[n - i + 1]
        x[n - i + 1] <- temp
    }
    x
}

check_equal_tolerance <- function(x, y, tolerance) {
    n <- length(x)
    for (i in 1:n) {
        if (abs(x[i] - y[i]) > tolerance) {
            return(FALSE)
        }
    }
    return(TRUE)
}

check_equal <- function(x, y) {
    n <- length(x)
    for (i in 1:n) {
        if (x[i] != y[i]) {
            return(FALSE)
        }
    }
    return(TRUE)
}

weighted_average <- function(x, w) {
    n <- length(x)
    sum <- 0
    for (i in 1:n) {
        sum <- sum + x[i] * w[i]
    }
    sum
}

count_k <- function(x, k) {
    n <- length(x)
    count <- 0
    for (i in 1:n) {
        if (x[i] == k) {
            count <- count + 1
        }
    }
    count
}

bitwise_and <- function(x, y) {
    n <- length(x)
    z <- rep(0, n)
    for (i in 1:n) {
        z[i] <- x[i] & y[i]
    }
    z
}

bitwise_or <- function(x, y) {
    n <- length(x)
    z <- rep(0, n)
    for (i in 1:n) {
        z[i] <- x[i] | y[i]
    }
    z
}

bitwise_xor <- function(x, y) {
    n <- length(x)
    z <- rep(0, n)
    for (i in 1:n) {
        z[i] <- x[i] ^ y[i]
    }
    z
}

bitwise_not <- function(x) {
    n <- length(x)
    z <- rep(0, n)
    for (i in 1:n) {
        z[i] <- !x[i]
    }
    z
}

clip <- function(x, min, max) {
    n <- length(x)
    for (i in 1:n) {
        if (x[i] < min) {
            x[i] <- min
        } else if (x[i] > max) {
            x[i] <- max
        }
    }
    x
}

elementwise_max <- function(x, y) {
    n <- length(x)
    z <- rep(0, n)
    for (i in 1:n) {
        if (x[i] > y[i]) {
            z[i] <- x[i]
        } else {
            z[i] <- y[i]
        }
    }
    z
}

elementwise_min <- function(x, y) {
    n <- length(x)
    z <- rep(0, n)
    for (i in 1:n) {
        if (x[i] < y[i]) {
            z[i] <- x[i]
        } else {
            z[i] <- y[i]
        }
    }
    z
}

count_nzeroes <- function(x) {
    n <- length(x)
    count <- 0
    for (i in 1:n) {
        if (x[i] != 0) {
            count <- count + 1
        }
    }
    count
}

count_zeroes <- function(x) {
    n <- length(x)
    count <- 0
    for (i in 1:n) {
        if (x[i] == 0) {
            count <- count + 1
        }
    }
    count
}

elementwise_equal <- function(x, y) {
    n <- length(x)
    z <- rep(0, n)
    for (i in 1:n) {
        if (x[i] == y[i]) {
            z[i] <- 1
        } else {
            z[i] <- 0
        }
    }
    z
}

elementwise_not_equal <- function(x, y) {
    n <- length(x)
    z <- rep(0, n)
    for (i in 1:n) {
        if (x[i] != y[i]) {
            z[i] <- 1
        } else {
            z[i] <- 0
        }
    }
    z
}

hamming_dist <- function(x, y) {
    n <- length(x)
    dist <- 0
    for (i in 1:n) {
        if (x[i] != y[i]) {
            dist <- dist + 1
        }
    }
    dist
}