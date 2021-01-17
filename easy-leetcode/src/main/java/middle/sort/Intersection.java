package middle.sort;

import java.util.Arrays;

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
        while(i < nums1.length && j < nums2.length){
            int a = nums1[i];
            int b = nums2[j];
            if(a == b){
                tmp[idx] = a;
                idx++;
                while(i < nums1.length && nums1[i] == a) i++;
                while(j < nums2.length && nums2[j] == a) j++;
            }else if(a < b){
                i++;
            }else{
                j++;
            }
        }
        return Arrays.copyOf(tmp, idx);
    }
}
