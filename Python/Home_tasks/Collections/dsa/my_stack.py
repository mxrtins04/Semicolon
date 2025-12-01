class MyStack:
    def __init__(self):
        self.number_of_items = 0
        self.items = [None] * 3

    def push(self, item):
        self.items[self.number_of_items] = item
        self.number_of_items += 1

    def is_empty(self):
        if self.number_of_items > 0:
            return False
        else:
            return True

    def pop(self):
        if self.number_of_items == 0:
            raise ValueError("Stack is empty")
        self.number_of_items -= 1
        return self.items[self.number_of_items]

    def peek(self):
        return self.items[self.number_of_items - 1]
