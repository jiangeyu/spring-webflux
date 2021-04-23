package middle.arrays;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午4:44 2021/4/22
 */
public class Matrix2 {

    int ans;
    int[] temp;

    public int reversePairs(int[] nums) {
        int n = nums.length;
        temp = new int[n];
        mergeSort(nums, 0, n - 1);
        return ans;
    }

    public void mergeSort(int[] nums, int l, int r) {
        if(l>= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    public void merge(int[] nums, int l, int mid, int r) {
        int index = l;
        int i = l;
        int j = mid + 1;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                temp[index++] = nums[i++];
            } else {
                ans += mid - i + 1;
                temp[index++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[index++] = nums[i++];
        }
        while (j <= r) {
            temp[index++] = nums[j++];
        }
        for (int k = l; k <= r; k++) {
            nums[k] = temp[k];
        }

    }





}
