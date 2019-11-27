package org.singleton.summary.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author singleton_zw
 * @title: TwoSum
 * @projectName summary-parent
 * @description: TODO
 * @date 2019/10/31 11:05
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2,2, 7, 11, 15,14,3,5};
        int target = 9;
        int[] ints = twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
        ints = twoSumMap(nums,target);
        System.out.println(Arrays.toString(ints));
        ints = twoSumMap1(nums,target);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 蛮力
     *      蛮力方法很简单。遍历每个元素Xx并查找是否存在另一个等于 target−x.
     *      时间复杂度 : O(n^2)
     *          空间复杂度: O(1).
     *
     *          复杂度分析：
     * 时间复杂度：O(n^2)
     * 对于每个元素，我们试图通过遍历数组的其余部分来寻找它所对应的目标元素，这将耗费 O(n)O(n) 的时间。因此时间复杂度为 O(n^2)
     * 空间复杂度：O(1)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j] == target){
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

    /**
     * 哈希
     * 为了对运行时间复杂度进行优化，我们需要一种更有效的方法来检查数组中是否存在目标元素。如果存在，我们需要找出它的索引。
     * 保持数组中的每个元素与其索引相互对应的最好方法是什么？哈希表。
     * 通过以空间换取速度的方式，我们可以将查找时间从 O(n)O(n) 降低到 O(1)。哈希表正是为此目的而构建的，它支持以 近似 恒定的时间进行快速查找。
     * 我用“近似”来描述，是因为一旦出现冲突，查找用时可能会退化到 O(n)。但只要你仔细地挑选哈希函数，在哈希表中进行查找的用时应当被摊销为 O(1)。
     * 一个简单的实现使用了两次迭代。在第一次迭代中，我们将每个元素的值和它的索引添加到表中。然后，在第二次迭代中，我们将检查每个元素所对应的目标元素（target - nums[i]target−nums[i]）是否存在于表中。注意，该目标元素不能是 nums[i]nums[i] 本身！
     * @param nums {2, 7, 11, 15,14,3,5};
     * @param target 9
     * @return
     */
    public static int[] twoSumMap(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            //先算出值
            int r = target - nums[i];
            //去匹配这个值 需要排除自己
            if(map.containsKey(r) && map.get(r) != i){
                return new int[] { i, map.get(r) };
            }
        }
        return null;
    }

    /**
     * 遍历一次  这里如果重复的数据 会丢失离的远的数据
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumMap1(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            //先算出值
            int r = target - nums[i];
            //去匹配这个值 先匹配在放入 所以这里不需要排除自己
            if(map.containsKey(r)){
                return new int[] { map.get(r) ,i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
