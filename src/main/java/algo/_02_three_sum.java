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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class _02_three_sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return ret;
        }

        // 存放奇数
        Map<Integer, AtomicInteger> cache1 = new HashMap<Integer, AtomicInteger>();

        // 存放偶数
        Map<Integer, AtomicInteger> cache2 = new HashMap<Integer, AtomicInteger>();


        for(int i = 0; i<nums.length; i++){
            if(nums[i] % 2 != 0){
                if(!cache1.containsKey(nums[i])){
                    cache1.put(nums[i], new AtomicInteger(1));
                }else{
                    //changeValue(cache, nums[i], 1);
                    int value = cache1.get(nums[i]).get();
                    if(value < 3){
                        cache1.get(nums[i]).incrementAndGet();
                    }
                }
            }else{
                if(!cache2.containsKey(nums[i])){
                    cache2.put(nums[i], new AtomicInteger(1));
                }else{
                    //changeValue(cache, nums[i], 1);
                    int value = cache2.get(nums[i]).get();
                    if(value < 3){
                        cache2.get(nums[i]).incrementAndGet();
                    }

                }
            }

        }

        Map<Integer, Set<Integer>> repeatMap = new HashMap<Integer, Set<Integer>>();
        Set<Integer> keySet1 = cache1.keySet();
        Set<Integer> keySet2 = cache2.keySet();
        for(Integer i : keySet1){
            cache1.get(i).decrementAndGet();
            //changeValue(cache, i, -1);
            //cache.put(i, cache.get(i)-1);
            for(Integer j: keySet1){
                if(cache1.get(j).get() > 0){
                    cache1.get(j).decrementAndGet();
                    //changeValue(cache, j, -1);
                    //cache.put(j, cache.get(j)-1);
                    int remain = 0 - i - j;
                    if(cache2.containsKey(remain)){
                        if(cache2.get(remain).get() > 0){
                            int max = Math.max(i, Math.max(j, remain));
                            int min = Math.min(i, Math.min(j, remain));

                            boolean flag = false;
                            if(!repeatMap.containsKey(max)){
                                flag = true;
                                Set<Integer> tmpSet = new HashSet<Integer>();
                                tmpSet.add(min);
                                repeatMap.put(max, tmpSet);
                            }else{
                                Set<Integer> tmpSet = repeatMap.get(max);
                                if(!tmpSet.contains(min)){
                                    flag = true;
                                    tmpSet.add(min);
                                }
                            }
                            if(flag){
                                List<Integer> list = new ArrayList<Integer>();
                                list.add(i);
                                list.add(j);
                                list.add(remain);

                                ret.add(list);
                            }
                        }
                    }
                    //cache.put(j, cache.get(j)+1);
                    //changeValue(cache, j, 1);
                    cache1.get(j).incrementAndGet();
                }
            }

            for(Integer j: keySet2){
                if(cache2.get(j).get() > 0){
                    cache2.get(j).decrementAndGet();
                    //changeValue(cache, j, -1);
                    //cache.put(j, cache.get(j)-1);
                    int remain = 0 - i - j;
                    if(cache1.containsKey(remain)){
                        if(cache1.get(remain).get() > 0){
                            int max = Math.max(i, Math.max(j, remain));
                            int min = Math.min(i, Math.min(j, remain));

                            boolean flag = false;
                            if(!repeatMap.containsKey(max)){
                                flag = true;
                                Set<Integer> tmpSet = new HashSet<Integer>();
                                tmpSet.add(min);
                                repeatMap.put(max, tmpSet);
                            }else{
                                Set<Integer> tmpSet = repeatMap.get(max);
                                if(!tmpSet.contains(min)){
                                    flag = true;
                                    tmpSet.add(min);
                                }
                            }
                            if(flag){
                                List<Integer> list = new ArrayList<Integer>();
                                list.add(i);
                                list.add(j);
                                list.add(remain);

                                ret.add(list);
                            }
                        }
                    }
                    //cache.put(j, cache.get(j)+1);
                    //changeValue(cache, j, 1);
                    cache2.get(j).incrementAndGet();
                }
            }
            //cache.put(i, cache.get(i)+1);
            //changeValue(cache, i, 1);
            cache1.get(i).incrementAndGet();
        }

        for(Integer i : keySet2){
            cache2.get(i).decrementAndGet();
            //changeValue(cache, i, -1);
            //cache.put(i, cache.get(i)-1);
            for(Integer j: keySet1){
                if(cache1.get(j).get() > 0){
                    cache1.get(j).decrementAndGet();
                    //changeValue(cache, j, -1);
                    //cache.put(j, cache.get(j)-1);
                    int remain = 0 - i - j;
                    if(cache1.containsKey(remain)){
                        if(cache1.get(remain).get() > 0){
                            int max = Math.max(i, Math.max(j, remain));
                            int min = Math.min(i, Math.min(j, remain));

                            boolean flag = false;
                            if(!repeatMap.containsKey(max)){
                                flag = true;
                                Set<Integer> tmpSet = new HashSet<Integer>();
                                tmpSet.add(min);
                                repeatMap.put(max, tmpSet);
                            }else{
                                Set<Integer> tmpSet = repeatMap.get(max);
                                if(!tmpSet.contains(min)){
                                    flag = true;
                                    tmpSet.add(min);
                                }
                            }
                            if(flag){
                                List<Integer> list = new ArrayList<Integer>();
                                list.add(i);
                                list.add(j);
                                list.add(remain);

                                ret.add(list);
                            }
                        }
                    }
                    //cache.put(j, cache.get(j)+1);
                    //changeValue(cache, j, 1);
                    cache1.get(j).incrementAndGet();
                }
            }

            for(Integer j: keySet2){
                if(cache2.get(j).get() > 0){
                    cache2.get(j).decrementAndGet();
                    //changeValue(cache, j, -1);
                    //cache.put(j, cache.get(j)-1);
                    int remain = 0 - i - j;
                    if(cache2.containsKey(remain)){
                        if(cache2.get(remain).get() > 0){
                            int max = Math.max(i, Math.max(j, remain));
                            int min = Math.min(i, Math.min(j, remain));

                            boolean flag = false;
                            if(!repeatMap.containsKey(max)){
                                flag = true;
                                Set<Integer> tmpSet = new HashSet<Integer>();
                                tmpSet.add(min);
                                repeatMap.put(max, tmpSet);
                            }else{
                                Set<Integer> tmpSet = repeatMap.get(max);
                                if(!tmpSet.contains(min)){
                                    flag = true;
                                    tmpSet.add(min);
                                }
                            }
                            if(flag){
                                List<Integer> list = new ArrayList<Integer>();
                                list.add(i);
                                list.add(j);
                                list.add(remain);

                                ret.add(list);
                            }
                        }
                    }
                    //cache.put(j, cache.get(j)+1);
                    //changeValue(cache, j, 1);
                    cache2.get(j).incrementAndGet();
                }
            }
            //cache.put(i, cache.get(i)+1);
            //changeValue(cache, i, 1);
            cache2.get(i).incrementAndGet();
        }
        return ret;
    }

    public void changeValue(Map<Integer, Integer> map, Integer key, int ince){
        Integer value = map.get(key);
        int intVal = value.intValue();
        map.put(key, value + ince);
    }

    // [-1,0,1,2,-1,-4]

    private long l;
    private _02_three_sum obj;

    @Before
    public void set(){
        obj = new _02_three_sum();
        l = System.currentTimeMillis();
    }

    @After
    public void clean(){
        l=System.currentTimeMillis()-l;
        System.out.println("运行时间是 " + l);
    }

    @Test
    public void testThreeSum(){
        int[] sums = {-1,0,1,2,-1,-4};
        List<List<Integer>> ret = obj.threeSum(sums);
        System.out.println(Arrays.toString(ret.toArray()));
    }


}
