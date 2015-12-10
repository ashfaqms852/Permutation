package permutation.model;

import java.util.ArrayList;
import java.util.List;

public class HeapPermute {
	
	List<Integer> permutationList = new ArrayList<Integer>();
	private static HeapPermute heapPermute;
	
	//Singleton
	public static HeapPermute getInstance(){
		if(heapPermute==null)
			heapPermute = new HeapPermute();
		return heapPermute;
	}
	
	//constructor
	private HeapPermute(){
		
	}
	
	//swapping the elements in the list
	private void swap(List<Integer> heapList, Integer valueX, Integer valueY) {
		Integer t = heapList.get(valueX);
		heapList.set(valueX, heapList.get(valueY));
		heapList.set(valueY, t);
	}
	
	//will do the heap permutation
	public void permute(List<Integer> heapList, Integer heapSize) {
		if (heapSize == 1) {
			System.out.println(heapList);
			StringBuilder sb = new StringBuilder();
			for(Integer itr : heapList)
				sb.append(itr+"");
			permutationList.add(Integer.parseInt(sb.toString()));
		} else {
			for (Integer i = 0; i < heapSize; i++) {
				permute(heapList, heapSize-1);
				if (heapSize % 2 == 1) {
					swap(heapList, 0, heapSize-1);
				} else {
					swap(heapList, i, heapSize-1);
				}
			}
		}
	}

	//will return the heap order permutation
	public List<Integer> heapOrderPermutation(Integer input){
		permutationList.clear();
		List<Integer> heapPermutationList = new ArrayList<Integer>();
		for(Integer itr = 0;itr<input.toString().length();itr++){
			heapPermutationList.add(Integer.parseInt(input.toString().charAt(itr)+""));
		}
		permute(heapPermutationList, heapPermutationList.size());
		return permutationList;
	}
	
}
