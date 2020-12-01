//
// Created by John on 2020/4/19.
//

#include <MacTypes.h>
#include "unordered_map"

using namespace std;


class KeyValue {
public:
    int key, value;
    KeyValue *next;
    KeyValue(int key, int value) {
        next = NULL;
        this->key = key;
        this->value = value;
    }
    KeyValue() {
        this->next = NULL;
        this->key = 0;
        this->value = 0;
    }
};

class LRUCache {
private:
    void moveToTail(KeyValue *prev) { //将节点移动至尾部
        if (prev->next == tail) {
            return;
        }
        // 先断开当前的链接
        KeyValue *node = prev->next;
        prev->next = node->next;
        if (node->next != NULL) {
            hash[node->next->key] = prev;
        }
        // 当前node 绑定到tail
        tail->next = node;
        node->next = NULL;
        // hash put
        hash[node->key] = tail;
        tail = node;
    }

public:
    unordered_map<int, KeyValue *> hash;
    KeyValue * head, * tail;
    int capactiy, size;

    LRUCache(int capacity) {
        this->head = new KeyValue(0, 0);
        this->tail = head;
        this->capactiy = capacity;
        this->size = 0;
        hash.clear();
    }

    int get(int key) {
        if (hash.find(key) == hash.end()) {
            return -1;
        }
        moveToTail(hash[key]);  // 每次get, 使用次数+ 1, 最近使用， 放于尾部
        return hash[key]->next->value;
    }

    void set(int key, int value) { // 数据放入缓存
        if (hash.find(key) != hash.end()) { // key可以找到
            hash[key]->next->value = value;
            moveToTail(hash[key]);
        } else {
            KeyValue *node = new KeyValue(key, value); // 新建节点
            tail->next = node;
            hash[key] = tail;
            tail = node;
            size++;
            if (size > capactiy) {     // 超出缓存上限
                hash.erase(head->next->key);   // 删除头部数据
                head->next = head->next->next;
                // 如果下一个不是空， 重新指一下下一个的prev节点
                if (head->next != NULL) {
                    hash[head->next->key] = head;
                }
                size--;
            }
        }
    }
};
