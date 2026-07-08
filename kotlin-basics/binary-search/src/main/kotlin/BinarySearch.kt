object BinarySearch {
    fun search(list: List<Int>, item: Int): Int {
        var left = 0
        var right = list.size - 1

        while (left <= right) {
            val mid = (left + right) / 2
            when {
                list[mid] < item -> left = mid + 1
                list[mid] > item -> right = mid - 1
                else -> return mid
            }
        }
        throw NoSuchElementException("$item is not in the list")
    }
}