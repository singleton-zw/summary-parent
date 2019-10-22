package org.singleton.summary.algorithm;

/**
 * @author singleton_zw
 * @title: BloomFilter
 * @projectName summary-parent
 * @description: BloomFilter--大规模数据排重算法
 * @date 2019/10/22 14:34
 * Bloom Filter是一种空间效率很高的随机数据结构，它利用位数组很简洁地表示一个集合，并能判断一个元素是否属于这个集合。Bloom Filter的这种高效是有一定代价的：
 *      在判断一个元素是否属于某个集合时，有可能会把不属于这个集合的元素误认为属于这个集合（false positive）。
 *      因此，Bloom Filter不适合那些“零错误”的应用场合。而在能容忍低错误率的应用场合下，Bloom Filter通过极少的错误换取了存储空间的极大节省。
 *
 *      https://www.cnblogs.com/aspnethot/articles/3442813.html
 */
public class BloomFilter {
}
