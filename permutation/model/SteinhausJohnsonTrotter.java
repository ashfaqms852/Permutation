package permutation.model;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SteinhausJohnsonTrotter {
	
	private static SteinhausJohnsonTrotter steinhausJohnsonTrotter;
	List<Integer> permutationList = new ArrayList<Integer>();
	
	//singleton
	public static SteinhausJohnsonTrotter getInstance(){
		if(steinhausJohnsonTrotter==null)
			steinhausJohnsonTrotter = new SteinhausJohnsonTrotter();
		return steinhausJohnsonTrotter;
	}
	
	//constructor
	private SteinhausJohnsonTrotter(){
		
	}
	
	//will check the steinhaus johnson trotter and return the boolean result
	boolean checkCondition(List<Integer> tempList, Integer max,List<Integer> directionList){
		boolean isMobile = false;
		Integer maxIndex = tempList.indexOf(max);
		if(directionList.get(maxIndex)==-1){
			if(maxIndex!=0){
				if( (tempList.get(maxIndex)) > (tempList.get(maxIndex-1)) ){
					isMobile = true;
					
				}
				if(!isMobile){
					boolean isSmallValuesAvailable=false;
					Integer itr=(maxIndex+1);
					if(tempList.get(itr)<max){
						isSmallValuesAvailable = true;
						//break;
					}
					if(isSmallValuesAvailable)
						directionList.set(maxIndex, 1);
				}
			}else{
				boolean isSmallValuesAvailable=false;
				Integer itr=(maxIndex+1);
				if(tempList.get(itr)<max){
					isSmallValuesAvailable = true;
				}
				if(isSmallValuesAvailable)
					directionList.set(maxIndex, 1);
			}
		}else if(directionList.get(maxIndex)==1){
			if(maxIndex!=(tempList.size()-1)){
				if( (tempList.get(maxIndex)) > (tempList.get(maxIndex+1)) ){
					isMobile = true;
				}
				if(!isMobile){
					boolean isSmallValuesAvailable=false;
					Integer itr=(maxIndex-1);
					if(tempList.get(itr)<max){
						isSmallValuesAvailable = true;
					}
					if(isSmallValuesAvailable)
						directionList.set(maxIndex, -1);
				}
			}else{
				boolean isSmallValuesAvailable=false;
				Integer itr=(maxIndex-1);
				if(tempList.get(itr)<max){
					isSmallValuesAvailable = true;
				}
				if(isSmallValuesAvailable)
					directionList.set(maxIndex, -1);
			}
		}
		return isMobile;
	}

	//will return the largest number from the list
	Integer findLargest(List<Integer> inputList,List<Integer> directionList){
		Integer max = 0;
		Integer fMax = null;
		List<Integer> tempList = new ArrayList<Integer>(inputList);
		List<Integer> tempDirectionList = new ArrayList<Integer>(directionList);
		Integer listSize = tempList.size();
		for(Integer itr = 0;itr<listSize;itr++){
			max = Collections.max(tempList);
			if(checkCondition(inputList,max,directionList)){
				fMax = max;
				break;
			}else{
				tempDirectionList.remove(tempList.indexOf(max));
				tempList.remove(tempList.indexOf(max));
				
			}
		}
		return fMax;
	}
	
	//will do the steeinhaus johnson trotter permute
	void doSteinhausJohnsonTrotterPermute(List<Integer> inputList,List<Integer> directionList){
		while(true){
			Integer max = findLargest(inputList,directionList);
			if(max==null)
				break;
			Integer maxIndex = inputList.indexOf(max);
			if(directionList.contains(-1) || directionList.contains(1)){
				if(directionList.get(maxIndex)==-1){
					if( maxIndex > 0 ){
						if( (inputList.get(maxIndex)) > (inputList.get(maxIndex-1)) ){
							Integer temp = inputList.get((maxIndex-1));
							inputList.set((maxIndex-1), inputList.get(maxIndex));
							inputList.set(maxIndex, temp);
							Integer temp1 = directionList.get((maxIndex-1));
							directionList.set((maxIndex-1), directionList.get(maxIndex));
							directionList.set(maxIndex, temp1);
							StringBuilder sb = new StringBuilder();
							for(Integer itr : inputList)
								sb.append(itr+"");
							permutationList.add(Integer.parseInt(sb.toString()));
						}else{
							directionList.set((maxIndex-1), 1);
						}
					}else{
						directionList.set((maxIndex), 1);
						System.out.println(" 0 out of index ");
					}
				}else if(directionList.get(maxIndex)==1){
					if( maxIndex < (inputList.size()-1) ){
						if( (inputList.get(maxIndex)) > (inputList.get(maxIndex+1)) ){
							Integer temp = inputList.get((maxIndex+1));
							inputList.set((maxIndex+1), inputList.get(maxIndex));
							inputList.set(maxIndex, temp);
							Integer temp1 = directionList.get((maxIndex+1));
							directionList.set((maxIndex+1), directionList.get(maxIndex));
							directionList.set(maxIndex, temp1);
							StringBuilder sb = new StringBuilder();
							for(Integer itr : inputList)
								sb.append(itr+"");
							permutationList.add(Integer.parseInt(sb.toString()));
						}else{
							break;
						}
					}else{
						System.out.println("Out of bounds buddy");
					}
				}else{
					System.out.println("Else coming");
				}
			}else{
				break;
			}
		}
	}
	
	//will return the permutation list to the controller
	public List<Integer> steinhausJohnsonTrotterOrderPermutation(Integer input) {
		permutationList.clear();
		permutationList.add(input);
		/*
		 * -1 for left
		 * 0 for stable
		 * +1 for right
		 */
		List<Integer> directionList = new ArrayList<Integer>();
		List<Integer> inputList = new ArrayList<Integer>();
		for(Integer itr = 0;itr<input.toString().length();itr++){
			inputList.add(Integer.parseInt(input.toString().charAt(itr)+""));
			directionList.add(-1);
		}
		//sort
		Collections.sort(inputList);
		System.out.println(inputList+" count : "+1);
		//Permutation
		doSteinhausJohnsonTrotterPermute(inputList,directionList);
		return permutationList;
	}
}
