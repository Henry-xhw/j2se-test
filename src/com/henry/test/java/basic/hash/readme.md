解决hash冲突？
根据对冲突的处理方式不同，哈希表有两种实现方式，一种开放地址方式（Open addressing），另一种是冲突链表方式（Separate chaining with linked lists）。Java HashMap采用的是冲突链表方式。

同义词链表?
为所有Hash值是i的对象建立一个同义词链表。假设我们在放入8的时候，发现4号位置已经被占，那么就会新建一个链表结点放入8。同样，如果我们要找8，那么发现4号索引里不是8，那会沿着链表依次查找。
虽然我们还是无法彻底避免Hash值冲突的问题，但是Hash函数设计合理，仍能保证同义词链表的长度被控制在一个合理的范围里。


为什么要重写hashCode和equals方法？
https://mp.weixin.qq.com/s?__biz=MzUzMTA2NTU2Ng==&mid=2247488351&idx=3&sn=4ed1ba78787e84ac7119210779f983ba&chksm=fa496ceecd3ee5f882d3128b673f0bae12bb8a9d65b5e6f914fa823344fb0a23a8c5008aca47&scene=27#wechat_redirect

如果只是重写了hashCode，不去重写equals方法，会是什么结果呢？
因为在HashMap#getNode(int hash, Object key)中，
if (first.hash == hash && // always check first node
                ((k = first.key) == key || (**key != null && key.equals(k)**)))
                return first;
如果不去重写equals方法，会默认调用Object#equals, 
public boolean equals(Object obj) {
        return (this == obj);
    }
比较的是两个对象的内存地址，所以无法得到预期


判断两个对象是否==，是通过hashCode方法吗？
不是的，判断两个对象是否==，是通过比较两个对象的内存地址