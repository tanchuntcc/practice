//package test;
//
//import java.util.HashMap;
//
///**
// * @author 谭春
// * Date: 2020/3/15
// * Description:
// */
//public class HashM {
//    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
//                   boolean evict) {
//        HashMap.Node<K,V>[] tab; HashMap.Node<K,V> p; int n, i;
//        if ((tab = table) == null || (n = tab.length) == 0)
//            n = (tab = resize()).length;//初始化
//        if ((p = tab[i = (n - 1) & hash]) == null)//查找数组下标。   p为当前下标的第一个值。
//            tab[i] = newNode(hash, key, value, null);  //把对应的key/value放到指定的数组下标
//        else {
//            HashMap.Node<K,V> e; K k;
//            if (p.hash == hash &&
//                    ((k = p.key) == key || (key != null && key.equals(k))))
//                e = p;  //如果hash值相等 且key也相等，就覆盖。
//            else if (p instanceof HashMap.TreeNode)
//                e = ((HashMap.TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
//            else {
//                for (int binCount = 0; ; ++binCount) {
//                    if ((e = p.next) == null) {  //判断数组的位置上的next为空， 则插入进去形成链表。
//                        p.next = newNode(hash, key, value, null);
//                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st //如果链表大于8就转化为红黑树。
//                            treeifyBin(tab, hash);
//                        break;
//                    }
//                    if (e.hash == hash &&
//                            ((k = e.key) == key || (key != null && key.equals(k))))
//                        break;
//                    p = e;
//                }
//            }
//            if (e != null) { // existing mapping for key
//                V oldValue = e.value;
//                if (!onlyIfAbsent || oldValue == null)
//                    e.value = value;
//                afterNodeAccess(e);
//                return oldValue;
//            }
//        }
//        ++modCount;
//        if (++size > threshold)
//            resize();
//        afterNodeInsertion(evict);
//        return null;
//    }
//}
//
