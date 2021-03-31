# 146.LRU缓存机制（中等）
# 双链表+哈希表
class DLinkedNode:
    def __init__(self, key=0, value=0):
        self.key = key
        self.val = value
        self.next = None
        self.prev = None

class LRUCache:
    def __init__(self, capacity):
        self.cache = dict()
        self.head = DLinkedNode()
        self.tail = DLinkedNode()
        self.head.next = self.tail
        self.tail.prev = self.head
        self.capacity = capacity
        self.size = 0

    def get(self, key):
        if key not in self.cache:
            return -1
        query_node = self.cache[key]  # 哈希表获取要查询的链表节点

        self.moveToTail(query_node)
        return query_node.val
    
    def put(self, key, value):  
        if key not in self.cache:
            add_node = DLinkedNode(key=key, value=value)

            self.moveToTail(add_node)  # 新节点插入到尾部

            self.cache[key] = add_node  # 添加至缓存中
            self.size += 1
            if self.size > self.capacity:  # 超出缓存，则删除头部节点
                remove_node = self.head.next  # 待删除节点
                self.head.next.next.prev = self.head
                self.head.next = self.head.next.next

                self.size -= 1
                self.cache.pop(remove_node.key)
        else:
            modify_node = self.cache[key]
            modify_node.val = value  # 修改指定节点
            modify_node.prev.next = modify_node.next  
            modify_node.next.prev = modify_node.prev

            self.moveToTail(modify_node)

    def moveToTail(self, node):
        node.next = self.tail  # 移至尾部
        node.prev = self.tail.prev
        self.tail.prev.next = node
        self.tail.prev = node
    
    # def removeNode(self, node):

LRU = LRUCache(2)
LRU.put(2,1)
LRU.put(2,2)
print(LRU.get(2))
LRU.put(1,3)
LRU.put(3,4)
print(LRU.get(2))