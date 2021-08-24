def search(ar, size):
    l = 0
    h = size - 1
    mid = 0
    while h > l + 1:
        mid = (l + h) // 2
        if (ar[l] - l) != (ar[mid] - mid):
            h = mid
        elif (ar[h] - h) != (ar[mid] - mid):
            l = mid
    return ar[l] + 1