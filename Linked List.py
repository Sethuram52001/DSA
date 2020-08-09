class Node:
    def __init__(self, value):
        self.value = value
        self.next = None


class LinkedList:
    def __init__(self):
        self.first = self.last = Node(None)

    def is_empty(self):
        return self.first.value is None and self.last.value is None

    def add_first(self, value):
        node = Node(value)
        if LinkedList.is_empty(self):
            self.first = self.last = node

        else:
            node.next = self.first
            self.first = node

    def add_last(self, value):
        node = Node(value)
        if LinkedList.is_empty(self):
            self.first = self.last = node
        if not LinkedList.is_empty(self):
            self.last.next = node
            self.last = node

    def index_of(self, value=0, length=False):
        index = 0
        current = self.first
        while current.next is not None:
            if length:
                if current.next.next is None:
                    return index + 1
                else:
                    current = current.next
                    index += 1
            else:
                if current.value == value:
                    return index
                else:
                    if current.next.value == value:
                        return index + 1
                    else:
                        current = current.next
                        index += 1
        return "Not Available"

    def contains(self, value):
        return LinkedList.index_of(self, value) != "Not Available"

    def remove_first(self):
        if not LinkedList.is_empty(self) or self.first == self.last:
            self.first = self.first.next
        else:
            return False

    def remove_last(self):
        current = self.first
        if LinkedList.is_empty(self):
            return "The List is Empty"
        elif self.first == self.last:
            self.first = self.last = None
            return "No More Elements"
        while current.next is not None:
            if current.next.next is None:
                current.next = None
                self.last = current
                break
            else:
                current = current.next

    def to_array(self):
        array = []
        current = self.first
        while current.next is not None:
                array.append(current.value)
                current = current.next
        array.append(current.value)
        return array


    def reversed_list(self, array):
        for i in array[::-1]:
            self.add_last(i)

    def conventional_reverse(self):
        pass



list1 = LinkedList()
list2 = LinkedList()

list1.add_first(1)
list1.add_first(2)
list1.add_first(3)
list1.add_first(4)
list1.add_last(5)
array = list1.to_array()
list2.reversed_list(array)
print((list2.to_array()))
