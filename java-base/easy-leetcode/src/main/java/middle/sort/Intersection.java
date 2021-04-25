package middle.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午4:17 2021/1/17
 */
public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        int[] tmp = new int[nums1.length];
        int idx = 0;
        while (i < nums1.length && j < nums2.length) {
            int a = nums1[i];
            int b = nums2[j];
            if (a == b) {
                tmp[idx] = a;
                idx++;
                while (i < nums1.length && nums1[i] == a) i++;
                while (j < nums2.length && nums2[j] == a) j++;
            } else if (a < b) {
                i++;
            } else {
                j++;
            }
        }
        return Arrays.copyOf(tmp, idx);
    }


    /**
     * 315 计算右侧小于当前元素的个数
     *
     * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
     *
     *
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = search(list, nums[i]);
            res.add(index);
            list.add(index, nums[i]);
        }
        Collections.reverse(res);
        return res;
    }

    private int search(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
