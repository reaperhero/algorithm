public class Recursive {
    // for循环 阶乘
    public static int getFactorialFor(int n){
        int temp = 1;
        if(n >=0){
            for(int i = 1 ; i <= n ; i++){
                temp = temp*i;
            }
        }else{
            return -1;
        }
        return temp;
    }
    // 递归 阶乘
    public static int getFactorial(int n){
        if(n >= 0){
            if(n==0){
                System.out.println(n+"!=1");
                return 1;
            }else{
                System.out.println(n);
                int temp = n*getFactorial(n-1);
                System.out.println(n+"!="+temp);
                return temp;
            }
        }
        return -1;
    }
    // 不用递归的二分查找
    public static int findTwoPoint(int[] array,int key){
        int start = 0;
        int last = array.length-1;
        while(start <= last){
            int mid = (last-start)/2+start;//防止直接相加造成int范围溢出
            if(key == array[mid]){//查找值等于当前值，返回数组下标
                return mid;
            }
            if(key > array[mid]){//查找值比当前值大
                start = mid+1;
            }
            if(key < array[mid]){//查找值比当前值小
                last = mid-1;
            }
        }
        return -1;
    }
    // 递归的二分查找
    public static int search(int[] array,int key,int low,int high){
        int mid = (high-low)/2+low;
        if(key == array[mid]){//查找值等于当前值，返回数组下标
            return mid;
        }else if(low > high){//找不到查找值，返回-1
            return -1;
        }else{
            if(key < array[mid]){//查找值比当前值小
                return search(array,key,low,mid-1);
            }
            if(key > array[mid]){//查找值比当前值大
                return search(array,key,mid+1,high);
            }
        }
        return -1;
    }
    // 非递归算法
    public static int[] sort(int[] a,int[] b){
        int[] c = new int[a.length+b.length];
        int aNum = 0,bNum = 0,cNum=0;
        while(aNum<a.length && bNum < b.length){
            if(a[aNum] >= b[bNum]){//比较a数组和b数组的元素，谁更小将谁赋值到c数组
                c[cNum++] = b[bNum++];
            }else{
                c[cNum++] = a[aNum++];
            }
        }
        //如果a数组全部赋值到c数组了，但是b数组还有元素，则将b数组剩余元素按顺序全部复制到c数组
        while(aNum == a.length && bNum < b.length){
            c[cNum++] = b[bNum++];
        }
        //如果b数组全部赋值到c数组了，但是a数组还有元素，则将a数组剩余元素按顺序全部复制到c数组
        while(bNum == b.length && aNum < a.length){
            c[cNum++] = a[aNum++];
        }
        return c;
    }

    // 递归的归并排序
    public static int[] mergeSort(int[] c,int start,int last){
        if(last > start){
            //也可以是(start+last)/2，这样写是为了防止数组长度很大造成两者相加超过int范围，导致溢出
            int mid = start + (last - start)/2;
            mergeSort(c,start,mid);//左边数组排序
            mergeSort(c,mid+1,last);//右边数组排序
            merge(c,start,mid,last);//合并左右数组
        }
        return c;
    }
     
    public static void merge(int[] c,int start,int mid,int last){
        int[] temp = new int[last-start+1];//定义临时数组
        int i = start;//定义左边数组的下标
        int j = mid + 1;//定义右边数组的下标
        int k = 0;
        while(i <= mid && j <= last){
            if(c[i] < c[j]){
                temp[k++] = c[i++];
            }else{
                temp[k++] = c[j++];
            }
        }
        //把左边剩余数组元素移入新数组中
        while(i <= mid){
            temp[k++] = c[i++];
        }
        //把右边剩余数组元素移入到新数组中
        while(j <= last){
            temp[k++] = c[j++];
        }
         
        //把新数组中的数覆盖到c数组中
        for(int k2 = 0 ; k2 < temp.length ; k2++){
            c[k2+start] = temp[k2];
        }
    }
}