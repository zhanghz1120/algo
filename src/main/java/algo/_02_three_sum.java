package algo;

/**
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */

import java.util.*;

public class _02_three_sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return ret;
        }

        int[] tmp = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            tmp[i] = nums[i];
        }
        Arrays.sort(tmp);

        List<Integer> buffer = null;
        for(int i = 0; i<tmp.length-1; i++){
            int remain = 0 - tmp[i];
            int left = i+1;
            int right = tmp.length - 1;
            while(left < right){
                if(tmp[left] + tmp[right] > remain){
                    right--;
                }else if(tmp[left] + tmp[right] < remain){
                    left++;
                }else{
                    buffer = new ArrayList<Integer>();
                    buffer.add(tmp[i]);
                    buffer.add(tmp[left]);
                    buffer.add(tmp[right]);
                    ret.add(buffer);
                }
            }
        }
        return ret;
    }


}
