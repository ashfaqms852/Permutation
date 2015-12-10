package permutation.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeneratePermutation {

	//member variable
	private static GeneratePermutation generatePermutation;
	List<Integer> permutationList = new ArrayList<Integer>();
	Integer[] factorialImplementationArray;
	static int count;
	//member function
	
	//Singleton
	public static GeneratePermutation getInstance(){
		if(generatePermutation==null){
			generatePermutation = new GeneratePermutation();
		}
		return generatePermutation;
	}
	
	//constructor
	private GeneratePermutation(){
		
	}
	
	//will return the lexicon order of permutation
	public List<Integer> lexiconOrderPermutation(Integer input){
		permutationList.clear();
		Integer[] inputArr = new Integer[input.toString().length()];
		for(Integer itr = 0;itr<input.toString().length();itr++){
			inputArr[itr] = Integer.parseInt(input.toString().charAt(itr)+"");
		}
		Arrays.sort(inputArr);
		permutationRecursive(inputArr,0);
		return permutationList;
	}
	
	//will calculate the permutation in recursive manner
	private void permutationRecursive(Integer[] tempInputArr,int cursor){
		if(cursor==tempInputArr.length){
			String temp="";
			for(Integer itr : tempInputArr) {
			    temp+=itr;
			}
			permutationList.add(Integer.parseInt(temp));
			return;
		}else{
			for (Integer itr = cursor;itr < tempInputArr.length; itr++) {
				Integer temp=tempInputArr[cursor];
				tempInputArr[cursor]=tempInputArr[itr];
				tempInputArr[itr]=temp;
				permutationRecursive(tempInputArr,cursor+1);
				temp=tempInputArr[cursor];
				tempInputArr[cursor]=tempInputArr[itr];
				tempInputArr[itr]=temp;
		
			}
		}
	}
	
	//getters and setters
	
}
