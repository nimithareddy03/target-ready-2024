package linear_datastructure

class Node(var data: Int) {
    var next: Node? = null;
}

class SinglyLinkedList { // O(n)

    private var head: Node? = null

    fun print() {
        print("start -> ")
        var currNode = head // O(1)
        while (currNode != null) { // O(n)
            print("${currNode.data} -> ")
            currNode = currNode.next // O(1)
        }
        println("end")
    }

    fun append(value: Int) {
        val newNode = Node(value) // O(1)

        if (head == null) { // O(1)
            head = newNode // O(1)
            return // O(1)
        }

        var currNode = head // O(1)
        while (currNode?.next != null) { // O(n)
            currNode = currNode.next // O(1)
        }
        currNode?.next = newNode // O(n)
    }

    fun prepend(value: Int) {
        val newNode = Node(value) // O(1)
        newNode.next = head // O(1)
        head = newNode // O(1)
    } // O(1)

    fun reverse() {
        var prev: Node? = null // O(1)
        var curr = head // O(1)
        var next: Node? // O(1)

        while (curr != null) { // O(n)
            next = curr.next // O(1)
            curr.next = prev // O(1)
            prev = curr // O(1)
            curr = next // O(1)
        }
        head = prev // O(1)
    } // O(n)

    fun insertAtindex(value : Int, index : Int) {
        var curr = head
        var prev: Node? = null
        var next: Node?
        for (i in 0 until index) {
            prev = curr
            if (curr != null) {
                next = curr.next
                curr = next
            }
            else{
                break
            }
        }

        val newNode = Node(value)
        newNode.next = curr
        prev?.next = newNode
    } //O(n)
    fun deleteAtindex(index: Int) {
        if (head == null) return
        var temp: Node? = head
        if (index == 0) {
            head = temp?.next
            return
        }
        for (i in 0 until index - 1) {
            temp = temp?.next
            if (temp == null) return
        }
        if (temp?.next == null) return
        val next = temp.next?.next
        temp.next = next
    } // O(n)

    fun search(value : Int) : Int{
        var current: Node? = head
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
}

fun main() {
    val list = SinglyLinkedList()

    do {
        list.print()

        println("0. Exit")
        println("1. Append")
        println("2. Prepend")
        println("3. Reverse")
        println("4. Insert a number at a given index") // Assignment task
        println("5. Delete a number at a given index") // Assignment task
        println("6. Search a number in the list") // Assignment task
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
                list.reverse()
            }

            4 -> {
                val value = readInt("Enter value to append: ")
                val index = readInt("Enter the index to insert: ")
                list.insertAtindex(value, index)
            }

            5 -> {
                val index = readInt("Enter the index to delete: ")
                list.deleteAtindex(index)
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
            else -> println("Invalid choice")
        }

    } while (choice != 0)
}

