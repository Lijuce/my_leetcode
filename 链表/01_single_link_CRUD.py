# 用python实现的单链表基本操作，包括增、删、查、改。

class Node(object):
    # 节点创建
    def __init__(self, val, p=0):
        self.data = val
        self.next = p

class SingleLinkList(object):
    def __init__(self):
        self.head = 0  # 头结点
    
    def construct(self, datas: list):
        # 单链表创建
        self.head = Node(datas[0])
        p = self.head
        for number in datas[1:]:
            new_node = Node(number)
            p.next = new_node
            p = p.next
        p.next = None  # 尾部结点指向None

    def travel(self):
        # 链表遍历
        cur = self.head
        while cur is not None:
            print(cur.data)
            cur = cur.next
        # print(cur.data)  # 尾结点的值
        print("遍历完成！")

    def add_data_tail(self, data):
        # 链表尾部添加元素
        insert_node = Node(data) # 待插入的节点
        cur = self.head
        while cur.next is not None:
            cur = cur.next
        insert_node.next = None  # 尾部结点封住
        cur.next = insert_node
        print("尾部成功添加新元素！")

    def add_data_head(self, data):
        # 链表头部添加元素
        insert_node = Node(data)
        insert_node.next = self.head
        self.head = insert_node
        print("头部成功添加新元素！")
        
    def remove_data(self, data):
        # 按值 删除节点
        cur = self.head
        pre = cur # 前驱节点
        if cur.data == data:
            self.head = cur.next
            
        while cur is not None:
            if cur.data == data:
                pre.next = cur.next
                cur.next = None
                print("成功删除节点: {}".format(str(data)))
                return 
            else:
                pre = cur
                cur = cur.next
                # if cur.next is None:


    def search_data(self, data):
        # 按值 查找节点
        # return: index索引
        cur = self.head
        index = 1 # 节点索引
        if self.head.data == data:
            return index
        while cur is not None:
            if cur.data == data:
                return index
            else:
                cur = cur.next
                index += 1
        print("不存在此节点")
        return None
                
    def modify_data(self, index, data):
        # 按索引 更改节点
        cur = self.head
        search_idx = 1

        while cur is not None:
            if search_idx == index:
                cur.data = data
                print("成功修改相应节点")
                return 
            else:
                cur = cur.next
                search_idx += 1
        print("不存在此节点")
        return 

SingleLink = SingleLinkList()
SingleLink.construct([1,2,3,4])  # 链表初始化
SingleLink.travel()  # 遍历输出
SingleLink.add_data_tail(10)  # 尾部插入新元素
SingleLink.travel()
SingleLink.add_data_head(20)  # 头部插入新元素
SingleLink.travel()
SingleLink.remove_data(2)  # 删除元素
SingleLink.travel()
idx = SingleLink.search_data(10)  # 查找元素
print(idx)
SingleLink.modify_data(idx, 100)  # 修改元素
SingleLink.travel()
