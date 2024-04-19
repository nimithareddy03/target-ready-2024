
fun main() {
    var array = arrayOf(10, 20, 30, 40, 50, 12, 23, 34, 45, 56)

    do {
        println("Array content -> ${array.joinToString()}")

        println("0. Exit")
        println("1. Insert a number at a given index")
        println("2. Delete a number at a given index")
        println("3. Search for a specific number in the array")
        println("4. Reverse the array content")
        println("5. Accept values for a sub array and insert at given index") // Assignment task
        println("6. Delete a sub array at a given index") // Assignment task
        println("7. Check if the given sub array exists") // Assignment task
        var choice = readInt("Enter your choice: ")

        when (choice) {
            0 -> {
                println("Exiting...")
            }
            1 -> {
                val index = readInt("Enter the index to insert at: ")
                val value = readInt("Enter the value to insert: ")
                array = insertAtIndex(array, index, value)
            }

            2 -> {
                val index = readInt("Enter the index to delete at: ")
                array = deleteAtIndex(array, index)
            }

            3 -> {
                val value = readInt("Enter the value to search: ")
                val index = findIndexOfValue(array, value)
                if (index == -1) {
                    println("$value not in the array")
                } else {
                    println("$value was found at index $index of the array")
                }
            }

            4 -> {

                array = reverseArray(array)
            }
            5 -> {
                println("Enter the elements of subarray separated by space :")
                var inp = readln()
                var sa = inp.split(" ").map { it.toInt() }.toTypedArray()
                val index = readInt("Enter the index to insert at: ")
                array = insertSubarray(array, sa, index)
            }
            6 -> {
                val index = readInt("Enter the starting index to delete subarray at: ")
                val len = readInt("Enter the length of the subarray to delete :")
                array = deleteSubarray(array, index, len)
            }
            7 -> {
                print("Enter the elements of subarray separated by space :")
                val inp = readln()
                val sa = inp.split(" ").map { it.toInt() }.toTypedArray()
                checkSubarray(array, sa)
            }
            else -> println("Invalid choice.")
        }

    } while (choice != 0)
}

fun checkSubarray(array: Array<Int>, sa : Array<Int>){
    var found = false

    for (i in array.indices) {  // O(n)
        if (array[i] == sa[0]) {
            var j = 1
            while (j < sa.size && array[i + j] == sa[j]) { // O(m)
                j++
            }

            if (j == sa.size) {
                found = true
                break
            }
        }
    }
    if (found) {
        println("The subarray is present in the array")
    } else {
        println("The subarray is not present in the array")
    }
} // O(n+m)


fun deleteSubarray(array: Array<Int>, i: Int, len : Int) : Array<Int>{
    val na = array.filterIndexed { index, element -> index < i || index >= i+len }.toTypedArray()
    return na
} //O(index + len)


fun insertSubarray(array: Array<Int>, subarray : Array<Int>, pos : Int) : Array<Int>{
    var na = array.copyOfRange(0, pos) + subarray+ array.copyOfRange(pos, array.size)
    return na
} // O(n)
fun reverseArrayInPlace(array: Array<Int>) {
    var start = 0
    var end = array.size - 1
    while (start < end) {
        val tmp = array[start]
        array[start] = array[end]
        array[end] = tmp
        start++
        end--
    }
} // O(n/2)

fun reverseArray(array: Array<Int>): Array<Int> {
    val newArray = Array<Int>(array.size){0} // O(1)
    var j = array.size-1 // O(1)
    for(i in array.indices){ // O(n)
        newArray[j--] = array[i] // O(1)
    }
    return newArray // O(1)
} // O(n)

fun findIndexOfValue(array: Array<Int>, value: Int): Int {
    for (i in array.indices) { // O(n)
        if (value == array[i]) { // O(1)
            return i // O(1)
        }
    }

    return -1 // O(1)
} // O(n)

fun deleteAtIndex(array: Array<Int>, index: Int): Array<Int> {
    if (index !in 0..array.size) { // if(index !in 0..array.size){
        println("`index` must be between 0 and ${array.size}")
        return array;
    }

    val newArray = Array(array.size - 1) { 0 }
    for (i in 0..<index) { // for(i in 0..<index){
        newArray[i] = array[i]
    }

    for (i in index..<newArray.size) {
        newArray[i] = array[i + 1]
    }

    return newArray
} // O(n)

fun insertAtIndex(array: Array<Int>, index: Int, value: Int): Array<Int> {
    if (index !in 0..array.size) { // if(index !in 0..array.size){
        println("`index` must be between 0 and ${array.size}")
        return array;
    }

    val newArray = Array(array.size + 1) { 0 }
    for (i in 0..<index) { // for(i in 0..<index){
        newArray[i] = array[i]
    }
    newArray[index] = value

    for (i in index..<array.size) {
        newArray[i + 1] = array[i]
    }

    return newArray
} // O(n)

fun readInt(prompt: String): Int {
    print(prompt)
    return readln().toInt()
}