package algorithm.algorithm;
 
import java.util.Arrays;
 
public class Combination {
    public static void main(String[] ar){
        Combination ex = new Combination();
        int[] arr = { 1, 2, 3, 4 };
        int n = arr.length;
        int r = 3;
        int[] combArr = new int[n];
 
        ex.doCombination(combArr, n, r, 0, 0, arr);
    }
 
    public void doCombination(int[] combArr, int n, int r, int index, int target, int[] arr){
        System.out.println("=> "+n+" "+r+" "+index+" "+target);
         
        // r ==0 �̶� ���� ���� ���Ҹ� �� �̾Ҵٴ� ��.
        if(r == 0){
            System.out.println(Arrays.toString(combArr));
            for(int i=0; i<index; i++)
            	System.out.print(arr[combArr[i]] + " ");           
            System.out.println();
         
        //������ �� �˻��� ���..1���� ���� ���¿��� ������ ����� ������ return ���� ����
        }else if(target == n){ 
             
            return;
         
        }else{
            combArr[index] = target;
            // (i) �̴� ��� 
            // �����ϱ�, r-1
            // �̾����� ���� index + 1 ����� ��
            doCombination(combArr, n, r-1, index+1, target+1, arr);
             
            //(ii) �� �̴°��
            // �Ȼ����ϱ� �״�� r
            // �Ȼ̾�����, index�� �״��!
            doCombination(combArr, n, r, index, target+1, arr); 
        }
    }
}