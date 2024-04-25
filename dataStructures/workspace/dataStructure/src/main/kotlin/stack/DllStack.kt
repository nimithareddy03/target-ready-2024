package stack

import linear_datastructure.checkSubarray

class DoublyLinkedList : Stack {
    private class Node1(val data: Int) {
        var prev: Node1? = null
        var next: Node1? = null
    }

    private var top: Node1? = null
    var _size = 0

    override fun push(value: Int) {
        val newNode = Node1(value)
        if (top != null) {
            newNode.next = top
            top?.prev = newNode
        }
        top = newNode// O(1)
        _size++
    }
    override fun display() {
        if (isEmpty()) {
            println("stack is empty")
            return
        }

        print("Top")
        var curr = top
        while (curr != null) {
            print(" <-> ${curr.data}")
            curr = curr.next
        }
        println()
    }

    override fun isEmpty(): Boolean {
        return top == null
    }

    override fun size(): Int {
        return _size
    }

    override fun pop(): Int {
        if (isEmpty()) {
            throw RuntimeException("stack is empty; pop not possible")
        }

        _size--
        val curr = top
        top = top?.next
        top?.prev = null
        return curr!!.data
    }

    override fun peek(): Int {
        if (isEmpty()) {
            throw RuntimeException("stack is empty; nothing to peek")
        }

        return top!!.data
    }
}