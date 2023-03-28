import java.util.Arrays;
import java.util.Scanner;
public class HelloWorld{
	public static void main(String[] args){
		int[][] a=new int[9][9];
		int[] b=new int[9];
	    int restart =0;
	    int cyc=0;
	    boolean g =false;
	    for(int i=0;i<9;i++){
	    	for(int j=0;j<9;j++){
	    		a[i][j]=(int)(Math.random()*9+1);
	    		System.arraycopy(a[i/3*3], j/3*3, b, 0, 3);
	    		System.arraycopy(a[i/3*3+1], j/3*3, b, 3, 3);
	    		System.arraycopy(a[i/3*3+2], j/3*3, b, 6, 3);
	    		for(int x=0;x<9;x++){
	    			if(j!=x&&a[i][j]==a[i][x]){
	    				a[i][j]=(int)(Math.random()*9+1);
	    				cyc++;
	    				x=-1;
	    			}
	    		    else if(i!=x&&a[i][j]==a[x][j]){	    		    
	    		    	a[i][j]=(int)(Math.random()*9+1);
	    				cyc++;
	    				x=-1;
	    			}
	    		    else if((i%3*3+j%3+1)!=x&&a[i][j]==b[x]){
	    		    	a[i][j]=(int)(Math.random()*9+1);
	    				cyc++;
	    				x=-1;
	    		    }
	    			if(cyc>80){
	    				cyc=0;
	    				restart++;
	    				g=true;
	    				break;
	    			}
	    		    	    		    
	    		}
	    		if(restart>20){
	    			for(int l=0;l<9;l++)	    				
	    			Arrays.fill(a[l], 0);
	    			restart=0;
	    			i=-1;
	    			 break;
	    	    }
	    		if(g){
	    			g =false;
	    			Arrays.fill(a[i], 0);
	    			i-=1;
	    			 break;
	    	    }
	        }
	    }
	    for(int i=0;i<9;i++)
	    	System.out.println(Arrays.toString(a[i]));
	}
}
