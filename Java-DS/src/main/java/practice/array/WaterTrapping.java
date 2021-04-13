package practice.array;

public class WaterTrapping {

    private static int getCapacity(int[] a) {
        if(a == null || a.length <= 2) {
            return 0;
        }

        int lMax = a[0];
        int rMax = a[a.length-1];
        int l = 0;
        int r = a.length - 1;
        int capacity = 0;
        while(l < r) {
            if(a[l] < a[r]) {
               if(a[l] > lMax) {
                    lMax = a[l];
                } else {
                    capacity = capacity + lMax - a[l];
               }
               l++;
            } else {
                if(a[r] > rMax) {
                    rMax = a[r];
                } else {
                    capacity = capacity + rMax - a[r];
                }
                r--;
            }
        }
        return capacity;
    }


    public static void main(String[] args) {
        System.out.println(getCapacity(new int[]{3,5,6,7,9}));
        System.out.println(getCapacity(new int[]{15, 3,9,11,15,1}));
    }
}
