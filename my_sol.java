package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class main_misc {

	
	public static int MAX = 1_000_000;
	
	
	public static void main(String[] args) {

	
		
	List<Integer> m0 = new ArrayList<>(Arrays.asList(1,2,3,4));
	List<Integer> m1 = new ArrayList<>(Arrays.asList(12,1,2,5));
	List<Integer> m2 = new ArrayList<>(Arrays.asList(11,4,3,6));
	List<Integer> m3 = new ArrayList<>(Arrays.asList(10,9,8,7));
	
	List<List<Integer>> m = new ArrayList<>(Arrays.asList(m0,m1,m2,m3));
	
	rotate_matrix(m,2);
		
	
	System.out.println("-------------------------");
	
	List<Integer> a0 = new ArrayList<>(Arrays.asList(1,2,3,4));
	List<Integer> a1 = new ArrayList<>(Arrays.asList(5,6,7,8));
	List<Integer> a2 = new ArrayList<>(Arrays.asList(9,10,11,12));
	List<Integer> a3 = new ArrayList<>(Arrays.asList(13,14,15,16));
	
	List<List<Integer>> a = new ArrayList<>(Arrays.asList(a0,a1,a2,a3));
	
	rotate_matrix(a,2);
	
	}
	
	private static void rotate_layer(List<List<Integer>> matrix,int[] x,int[] y){
		
		//MxN
		
		//rotate in x[0] = 0;
		
		Integer overflow = null;
		for(int i = y[0];i <= y[1];i++){
			
			int k = matrix.get(i).get(x[0]);
			matrix.get(i).set(x[0], overflow);
			overflow = k;
			
		}
		
		//y[1] = M;
		for(int i = x[0]+1;i <= x[1];i++){
			int k = matrix.get(y[1]).get(i);
			matrix.get(y[1]).set(i, overflow);
			overflow = k;
		}
		
		//x[1] = N;
		for(int i = y[1]-1;i >= y[0];i--) {
			int k = matrix.get(i).get(x[1]);
			matrix.get(i).set(x[1],overflow);
			overflow = k;
		}
		
		//y[0] = 0;
		for(int i = x[1]-1;i >= x[0];i--){
			Integer k = matrix.get(y[0]).get(i);
			matrix.get(y[0]).set(i, overflow);
			overflow = k;
		}
		
	}
	
	private static void rotate_matrix_unit(List<List<Integer>> matrix){
		
		int[] x = {0,matrix.size()-1};
		int[] y = {0,matrix.get(0).size()-1};
		
		
		while(x[0] <= x[1] && y[0] <= y[1]) {
			
			rotate_layer(matrix,x,y);
			x[0]++;
			x[1]--;
			y[0]++;
			y[1]--;
			
		}
		
	}
	
	private static void rotate_matrix(List<List<Integer>> matrix,int r){
		
		//all rotations bigger than the number of elments on the biggest layer is the not a different rotation
		
		int real_rotation = r%((2*matrix.size()) + (2*matrix.get(0).size()) - 2); 
		
		for(int i = 0;i < real_rotation;i++){
			rotate_matrix_unit(matrix);
		}
		
		for(int i = 0;i < matrix.size();i++) {
			System.out.println(matrix.get(i));
		}
		
	}
	
	
}
