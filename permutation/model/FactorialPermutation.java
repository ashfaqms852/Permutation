package permutation.model;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

public class FactorialPermutation {

	//member variables
	
	//output will be saved in the permutation list
	List<Integer> permutationList = new ArrayList<Integer>();
	private static FactorialPermutation factorialPermutation;
	
	//Singleton
	public static FactorialPermutation getInstance(){
		if(factorialPermutation==null)
			factorialPermutation = new FactorialPermutation();
		return factorialPermutation;
	}
	
	//Constructor
	private FactorialPermutation(){
		
	}
	
	//will return the number of permutation
	private Integer getNumberOfPermutation(String[] tempInputArr){
		Integer n=0;
		n = findFactorial(tempInputArr.length)/(findFactorial(tempInputArr.length-tempInputArr.length));
		return n;
	}
	
	//will return the factorial result of an integer
	private Integer findFactorial(Integer temp){
		Integer factorial =1;
		for(Integer i=2;i<=temp;i++){
			factorial*=i;
		}
		return factorial;
	}
	
	//will return the maximum value of the factorial
	private Integer findMaxFactorial(Integer input){
		Integer itr=0,max=0;
		while(true){
			Integer temp = findFactorial(itr);
			if(temp>input){
				break;
			}else{
				max = itr;
			}
			itr++;
		}
		return max;
	}
	
	//will return the factorial list
	private List<Integer> findFactoradic(Integer input, Integer max){
		List<Integer> factoradicList = new ArrayList<Integer>();
		Integer itr = input;
		while(max>=0){
			Integer remainder=0,result=0;
			result = itr / findFactorial(max);
			remainder = itr % findFactorial(max);
			max--;
			itr = remainder;	
			factoradicList.add(result);
		}		
		return factoradicList;
	}
	
	//will return the factoradic permutation of the 
	private Integer findFactoradicPermute(List<Integer> inputList, List<Integer> factoriadicList){
		Integer factoradicPermute = 0;
		StringBuilder sb = new StringBuilder();
		List<Integer> tempList = new ArrayList<Integer>();
		for(Integer innerItr = 0;innerItr<inputList.size();innerItr++){
			tempList.add(inputList.get(innerItr));
		}
		Integer itr = 0;
		while(true){
			sb.append(tempList.get(factoriadicList.get(itr)));
			boolean a = tempList.remove(tempList.get(factoriadicList.get(itr)));
			if(a)
				itr++;
			if((tempList.size()==0))
				break;
		}
		factoradicPermute = Integer.parseInt(sb.toString());
		return factoradicPermute;
	}
	
	//Will permute the factor order number of permutation
	private void doPermute(List<Integer> inputList, Integer noOfPermutation){
		for(Integer itr = 0;itr<noOfPermutation;itr++){
			Integer check = findMaxFactorial(itr);
			List<Integer> factoradicList = findFactoradic(itr,check);
			for(Integer innerItr=0;innerItr<inputList.size();innerItr++){
				if(factoradicList.size()==inputList.size())
					break;
				
				factoradicList.add(innerItr,0);
			}
			Integer checkPermute = findFactoradicPermute(inputList,factoradicList);
			permutationList.add(checkPermute);
		}
	}
	
	//will return the factorial permutation list
	public List<Integer> factorialOrderPermutation(Integer input){
		permutationList.clear();
		List<Integer> factorialPermutationList = new ArrayList<Integer>();
		for(Integer itr = 0;itr<input.toString().length();itr++){
			factorialPermutationList.add(Integer.parseInt(input.toString().charAt(itr)+""));
		}
		Integer noOfPermutation = getNumberOfPermutation(input.toString().split(""));
		doPermute(factorialPermutationList, noOfPermutation);
		return permutationList;
	}
}
