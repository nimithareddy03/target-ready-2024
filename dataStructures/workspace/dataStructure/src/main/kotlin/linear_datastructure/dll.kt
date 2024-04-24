package linear_datastructure

class Node1(var data: Int) {
    var prev: Node1? = null
    var next: Node1? = null
}
class DoublyLinkedList {
    private var head: Node1? = null
    private var tail: Node1? = null

    fun append(value: Int) {
        val newNode = Node1(value) // O(1)

        if (head == null) { // O(1)
            head = newNode // O(1)
            tail = newNode // O(1)
            return // O(1)
        }

        tail?.next = newNode // O(1)
        newNode.prev = tail // O(1)
        tail = newNode // O(1)
    }  // O(1)

    fun prepend(value: Int) {
        val newNode = Node1(value)

        if (head == null) { // O(1)
            head = newNode // O(1)
            tail = newNode // O(1)
            return // O(1)
        }

        head?.prev = newNode // O(1)
        newNode.next = head // O(1)
        head = newNode // O(1)
    } // O(1)

    fun printForward() {
        print("start <-> ")
        var currNode = head // O(1)
        while (currNode != null) { // O(n)
            print("${currNode.data} <-> ")
            currNode = currNode.next // O(1)
        }
        println("end")
    }

    fun printBackward() {
        print("end <-> ")
        var curr = tail
        while (curr != null) {
            print("${curr.data} <-> ")
            curr = curr.prev
        }
        println("start")
    }

    fun deleteValue(value: Int): Boolean {
        var curr = head // O(1)
        var found = false // O(1)
        while (curr != null) { // O(n)
            if (curr.data == value) { // O(1)
                found = true // O(1)

                if (curr.prev != null) { // O(1)
                    curr.prev!!.next = curr.next // O(1)
                } else { // O(1)
                    head = curr.next // O(1)
                }

                if (curr.next != null) { // O(1)
                    curr.next!!.prev = curr.prev // O(1)
                } else { // O(1)
                    tail = curr.prev // O(1)
                }

                curr.prev = null // O(1)
                curr.next = null // O(1)
                break // the loop since we already found the element to be deleted // O(1)
            }

            curr = curr.next // O(1)
        }

        return found // O(1)
    }

    fun deleteAtIndex(index : Int){
        if (head == null) return
        var temp: Node1? = head
        if (index == 0) {
            head = temp?.next
            head?.prev = null
            return
        }
        for (i in 0 until index-1) {
            temp = temp?.next
            if (temp == null) return
        }
        if (temp?.next == null) return
        val next = temp.next?.next
        temp.next = next
        next?.prev = temp

    }
    fun search(value : Int) : Int{
        var current: Node1? = head
        var position = 0
        while (current != null) {
            if (current.data == value) {
                return position
            }
            current = current.next
            position++
        }
        return -1
    } //O(n)

    fun insertAtIndex(value: Int, index: Int) {
        val newNode = Node1(value)

        if (head == null || index == 0) {
            newNode.next = head
            head?.prev = newNode
            head = newNode
            return
        }

        var current: Node1? = head
        for (i in 0 until index - 1) {
            if (current?.next == null) return
            current = current.next
        }

        newNode.next = current?.next
        newNode.prev = current
        current?.next?.prev = newNode
        current?.next = newNode
    }
}


fun main() {
    val list = DoublyLinkedList()

    do {
        list.printForward()

        println("0. Exit")
        println("1. Append")
        println("2. Prepend")
        println("3. Print backwards")
        println("4. Insert a number at a given index") // Assignment task
        println("5. Delete a number at a given index") // Assignment task
        println("6. Search a number in the list") // Assignment task
        println("7. Delete a number by value")
        val choice = readInt("Enter your choice: ")

        when (choice) {
            0 -> {
                println("Exiting...")
            }

            1 -> {
                val value = readInt("Enter value to append: ")
                list.append(value)
            }

            2 -> {
                val value = readInt("Enter value to prepend: ")
                list.prepend(value)
            }

            3 -> {
                list.printBackward()
            }

            4 -> {
                val index = readInt("Enter the index to insert: ")
                val value = readInt("Enter the value: ")
                list.insertAtIndex(value,index)
            }

            5 -> {
                val index = readInt("Enter the index to delete: ")
                list.deleteAtIndex(index)
            }

            6 -> {
                val value = readInt("Enter value to search: ")
                val pos = list.search(value)
                if(pos != -1){
                    println("The value is found at " + (pos+1) + " node")
                }
                else{
                    println("The value is not present in double linked list")
                }
            }

            7 -> {
                val value = readInt("Enter value to delete: ")
                if(!list.deleteValue(value)){
                    println("$value not found in the list")
                }
            }

            else -> println("Invalid choice")
        }

    } while (choice != 0)
}