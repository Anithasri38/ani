class ArrayExample
{
    public int[] arrA(int[] arr)
    {
        int min=arr[0];
        int max=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]<min)
            {
                min=arr[i];
            }
            else if(arr[i]>max)
            {
                max=arr[i];
            }
        }
        int a[]={min,max};
        return a;
    }
}
/*lass Ma
{
   public static void main(String args[])
    {
        ArrayExample s=new ArrayExample();
        int[] arr1={66,9,1,4};
        int[] arr2=s.arrA(arr1);
        System.out.println(arr2[0]);
    }
}*/