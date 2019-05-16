package com.stokey.algorithmdemo.LeetCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeNumSum {
    public static void main(String[] args) {
        List<List<Integer>> result = threeSum(new int[]{-12,-1,4,-14,0,10,7,-7,-6,9,6,-2,7,13,9,-1,4,12,9,4,14,0,-4,0,0,10,2,-7,7,-4,-11,10,2,8,4,-12,-4,-12,-4,-3,12,9,11,4,-1,-3,10,-12,-6,-4,-1,-14,3,2,-7,-11,-3,10,-11,-10,13,-15,7,0,0,-4,-5,11,0,-2,-14,-11,-8,12,1,-1,-14,-12,-6,-5,0,9,-4,-12,-4,4,14,9,-9,10,14,-11,10,6,-3,-4,10,-1,14,-13,13,7,-9,12,4,-1,-4,5,3,6,8,10,0,11,13,11,-7,5,-3,-1,0,-4,-4,-4,10,0});
        Iterator iterator = result.iterator();
        while (iterator.hasNext()) {
            List<Integer> path = (List<Integer>) iterator.next();
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            for (int i = 0; i < path.size(); i++) {
                builder.append(path.get(i));
                if (i != path.size() - 1) {
                    builder.append(",");
                }
            }
            builder.append("]");
            System.out.println("result:" + builder.toString());
        }
    }

    /**
     * TODO 效率过低
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums != null && nums.length >= 3) {
            int length = nums.length;
            for (int firstIndex = 0; firstIndex < length - 2; firstIndex++) {
                for (int secondIndex = firstIndex + 1; secondIndex < length - 1; secondIndex++) {
                    for (int thirdIndex = secondIndex + 1; thirdIndex < length; thirdIndex++) {
                        if (nums[firstIndex] + nums[secondIndex] + nums[thirdIndex] == 0) {
                            List<Integer> tempResult = new ArrayList<>();
                            tempResult.add(nums[firstIndex]);
                            tempResult.add(nums[secondIndex]);
                            tempResult.add(nums[thirdIndex]);
                            // 去重判断
                        if (!hasPath(result, tempResult)) {
                                result.add(tempResult);
                            }
                        }
                    }
                }

            }
        }
        return result;
    }

    private static boolean hasPath(List<List<Integer>> result, List<Integer> tempResult) {
        if (result == null || result.isEmpty()) {
            return false;
        }
        for (int i = 0; i < result.size(); i++) {
            List<Integer> temp = result.get(i);
            boolean hasPath = true;
            if (tempResult.get(0).compareTo(tempResult.get(1)) == 0 && tempResult.get(0).compareTo(0)==0) {
                if (temp.get(0).compareTo(0)==0 && temp.get(0).compareTo(temp.get(1)) == 0) {
                    hasPath = true;
                } else {
                    hasPath = false;
                }
            } else {
                for (int j = 0; j < tempResult.size(); j++) {
                    if (!temp.contains(tempResult.get(j))) {
                        hasPath = false;
                    }
                }
            }
            if (hasPath) {
                return true;
            }
        }
        return false;
    }
}
