package ad.four;

import java.util.Scanner;

public class Zergling {
	static int iRead   = 0;
	static int iRead2  = 0;
	static int iRead3  = 0;
	static int iRead4  = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		iRead   = sc.nextInt();		
		iRead2  = sc.nextInt();
		          sc.nextLine();
		String input;
		char[][] arrRead  = new char[iRead2][iRead];
		
	    for(int i=0; i < iRead2; i++){
	    	input = sc.nextLine();
	    	char[] a = input.toCharArray();
	    	for(int j = 0; j < iRead; j++){
	    		arrRead[i][j]  = a[j];	   
	    	}	    	
	    }
	    
		iRead3  = sc.nextInt();		
		iRead4  = sc.nextInt();		

		
		arrRead[iRead4-1][iRead3-1] = 'D';
		char flag = 'G';
		int count = 0;
		
		int a,b;
		int c,d;
		
	    while(true){
	    	
		    for(int i=0; i < iRead2; i++){
		    	for(int j = 0; j < iRead; j++){
		    		
		    		if(arrRead[i][j] == '1'){
		    			
		    			if(i+1 >= iRead2){
		    				a = i;
		    				b = i-1;
		    			}else if (i-1 < 0){
		    				a = i + 1;
		    				b = i;
		    			}else{
		    				a = i + 1;
		    				b = i - 1;		    				
		    			}
		    			
		    			if(j+1 >= iRead){
		    				c = j;
		    				d = j-1;
		    			}else if (j-1 < 0){
		    				c = j + 1;
		    				d = j;
		    			}else{
		    				c = j + 1;
		    				d = j - 1;		    				
		    			}		    			
		    			//System.out.println("i = " + i + "    j = " + j);
		    			
		    			if(arrRead[i][d] == 'D' ||
			        	   arrRead[i][c] == 'D' ||
			        	   arrRead[b][j] == 'D' ||
						   arrRead[a][j] == 'D'
			        	){
		    				arrRead[i][j] = 'C';
		    				flag = 'D';
		    			}
		    		}
		    	}
		    }	
		   	/*
		    System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
	        for(int i=0; i < iRead2; i++){
	        	for(int j=0; j < iRead; j++){
	       			System.out.print(arrRead[i][j] + " ");
	        	}   
	        	System.out.println("");  
	        }		    	
	        */
		    for(int i=0; i < iRead2; i++){
		    	for(int j = 0; j < iRead; j++){
		    		if(arrRead[i][j] == 'C') arrRead[i][j] = 'D';
		    			
	    		}
	    	}		    	
		    	    	
		    if(flag == 'G') break;
		    count ++;
		    flag = 'G';
	    }		
	    
	    int alive = 0;
        for(int i=0; i < iRead2; i++){
        	for(int j=0; j < iRead; j++){
        		if(arrRead[i][j] == '1') alive++;
        	}   
        }		    
	    
	    System.out.println(count + 3);
	    System.out.println(alive);
	    
	    
		/*
		System.out.println("iRead3 = " + iRead3);
		System.out.println("iRead4 = " + iRead4);
	    System.out.println("--------------------------------------");
        for(int i=0; i < iRead2; i++){
        	for(int j=0; j < iRead; j++){
       			System.out.print(arrRead[i][j] + " ");
        	}   
        	System.out.println("");  
        }
        System.out.println("--------------------------------------");
        */

	}

}
