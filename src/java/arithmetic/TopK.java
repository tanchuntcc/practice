package arithmetic;

/**
 * Created by TanChun on 2019/2/13.
 * Topk问题情景1：有 N (N>1000000)个数,求出其中的前K个最小的数（又被称作topK问题）
 * 思路1：最基本的思路，将N个数进行完全排序，从中选出排在前K的元素即为所求。
 * 有了这个思路，我们可以选择相应的排序算法进行处理，目前来看快速排序，
 * 堆排序和归并排序都能达到O(NlogN)的时间复杂度。当然，这样的答案也是无缘offer的。
 *
 * 思路2：可以采用数据池的思想，选择其中前K个数作为数据池，后面的N-K个数与这K个数进行
 * 比较，若小于其中的任何一个数，则进行替换。这种思路的算法复杂度是O(N*K)，
 * 当答出这种算法时，似乎离offer很近了。
 *
 * 思路3：大根堆维护一个大小为K的数组，目前该大根堆中的元素是排名前K的数，其中根是最大的数。
 * 此后，每次从原数组中取一个元素与根进行比较，如小于根的元素，则将根元素替换并进行堆调整
 * （下沉），即保证大根堆中的元素仍然是排名前K的数，且根元素仍然最大；否则不予处理，
 * 取下一个数组元素继续该过程。该算法的时间复杂度是O(N*logK)，一般来说企业中都采用该策略
 * 处理topK问题，因为该算法不需要一次将原数组中的内容全部加载到内存中，而这正是海量数据处
 * 理必然会面临的一个关卡。如果能写出代码，offer基本搞定。
 *
 * 思路4：利用快速排序的分划函数找到分划位置K，则其前面的内容即为所求。该算法是一种非常
 * 有效的处理方式，时间复杂度是O(N)（证明可以参考算法导论书籍）。对于能一次加载到内存中
 * 的数组，该策略非常优秀。如果能完整写出代码，那么相信面试官会对你刮目相看的。
 *
 * 思路5：
 * TopK问题描述：在N个无序元素中，找到最大的K个（或最小的K）。
 * 如果使用排序类似的算法，其时间复杂度为O(NlogN)+O(K)。当N远大于K时，例如N为1e9，而K为10时，
 * 这种方法显然太慢。使用堆化和堆调整则可以快速解决。以下以寻找最小的K个元素为例。
 * 设有一个K长度的最大堆，如果在数组中有一个元素小于该堆顶，则该元素有可能为寻找的最小K元素之
 * 一。则将该元素替换堆顶，然后进行堆调整。反复迭代，直到遍历了数组中的所有元素。此时，该长度
 * 为K的最大堆就是待寻找的TopK。
 *
 *
 * Topk问题情景2：有一个1G大小的一个文件，里面每一行是一个词，词的大小不超过16字节，内存
 * 限制大小是1M。返回频数最高的100个词。
 * 思路：把这1G的数据一次性全部读入内存是不可能了，可以每次读一行，然后将该词存到一个哈希表
 * 里去，哈希表的value是词出现的次数。将单词的哈希值对5000取模，根据结果将单词分配到5000个文件中去。
 * 这样，平均情况下，一个文件中有1G/5000 = 0.2M个词，哈希表基本上能装得下了。
 *  对每个文件进行hashmap统计，将词与频率写到一个新的文件中，得到5000个新文件。
 * 维护一个100个节点的最小堆，依次读5000个文件中的每一条记录。如果频率小于堆顶，证明该词比堆里的100个
 * 单词频率都低，不可能进top100，舍弃。如果频率大于堆顶，就将该词至于堆顶，然后调用维护函数，维护最小堆的性质。
 * 所有的记录遍历完了，最小堆中的单词就是结果。
 * 总结：
 *     哈希表的大小不是根据单词的数量，而是根据不同单词的数量。
 *     最大的topK用最小堆，最小的topK用最大堆。
 *     算法的时间复杂度：
 *         分小文件 O(n)
 *         hashmap统计 O(n)
 *         维护最小堆 O(n'logK)   n'是不同的单词数，K是topK
 *
 * https://blog.csdn.net/juzihongle1/article/details/70212243（总结很全面）
 */
public class TopK {
    //采用思路5，用最大堆（最小堆解决）

    // Method 2
// Create (Initialize) Heap, from bottom to top
    void heap_create(int arr[], int n)
    {
        int i;      // from bottom to top
        for(i=(n>>1)-1; i>-1; heap_adjust(arr,i--,n));
    }

    void heap_adjust(int arr[], int p, int n)
    {   // c - children, p - parent
        int maxid=p, temp;
        // heap_adjust for maxtop, from top to bottom
        for(; p<(n>>1); p=maxid){
            if ((p<<1)+1<n && arr[(p<<1)+1]>arr[maxid])
                maxid = (p<<1)+1;
            if ((p<<1)+2<n && arr[(p<<1)+2]>arr[maxid])
                maxid = (p<<1)+2;
            if (maxid == p) break;
            // swap arr[maxid] and arr[p]
            temp = arr[maxid];
            arr[maxid] = arr[p];
            arr[p] = temp;
        }
    }   // Time O(logn)

    // Heap Sort - ascending order
    void heap_sort(int arr[], int n)
    {
        int i, temp;
        // init maxtop heap, using method 2 (from bottom to top)
        for (i=(n>>1)-1; i>-1; heap_adjust(arr,i--,n));
        for (i=n-1; i>0; heap_adjust(arr,0,i--)){
            // mv heap top to end (heap top is max)
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
        }
    }   // Time O(nlogn)

    // TopK problem : find max k (or min k) elements from unordered set
// eg. find min k elements from arr[], stored in res[]
    void topk(int arr[], int n, int res[], int k)
    {
        int i;      // copy and k elements to res
        for (i=0; i<k; res[i]=arr[i],++i);
        // make maxtop heap for res[]
        for(i=(k>>1)-1; i>-1; heap_adjust(res,i--,k));
        for(i=k; i<n; ++i){
            if (res[0] <= arr[i]) continue;
            // now arr[i] < heap top
            res[0] = arr[i];
            heap_adjust(res,0,k);
        }
    }   // Time O(nlogk)
}
