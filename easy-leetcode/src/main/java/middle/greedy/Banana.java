package middle.greedy;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午12:34 2021/1/7
 */
public class Banana {

    public int minEatingSpeed(int[] piles, int H) {
        int left = 1;
        int right = getMax(piles) + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, mid, H)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean canFinish(int[] piles, int speed, int H) {
        int time = 0;
        for (int n : piles) {
            time += timeOf(n, speed);
        }
        return time <= H;

    }

    public int timeOf(int n, int speed) {
        return (n / speed) + ((n % speed > 0) ? 1 : 0);
    }


    public int shipWithinDays(int[] weights, int D) {
        int left = getMin(weights);
        int right = getMax(weights) + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish1(weights, D, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }

    public int getMin(int[] w) {
        int min = Integer.MAX_VALUE;
        for (int n : w) {
            min = Math.min(n, min);
        }
        return min;
    }


    public int getMax(int[] piles) {
        int max = 0;
        for (int n : piles) {
            max += n;
        }
        return max;
    }

    public boolean canFinish1(int[] w, int D, int cap) {
        int i = 0;
        for (int day = 0; day < D; day++) {
            int maxCap = cap;
            while ((maxCap -= w[i]) >= 0) {
                i++;
                if (i == w.length) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Banana banana = new Banana();
        int[] piles = new int[]{3, 6, 7, 11};
        int[] piles1 = new int[]{30, 11, 23, 4, 20};
        System.out.println(banana.minEatingSpeed(piles, 8));
        System.out.println(banana.minEatingSpeed(piles1, 5));

        int[] weights = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] weights1 = new int[]{3, 2, 2, 4, 1, 4};
        System.out.println(banana.shipWithinDays(weights, 5));
        System.out.println(banana.shipWithinDays(weights1, 3));
    }
}
