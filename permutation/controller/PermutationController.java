package permutation.controller;

import java.awt.Graphics2D;
import java.util.List;


import permutation.model.DrawPermutation;
import permutation.model.FactorialPermutation;
import permutation.model.GeneratePermutation;
import permutation.model.HeapPermute;
import permutation.model.SteinhausJohnsonTrotter;
import permutation.model.WrongInputException;
import permutation.view.DisplayOutput;
import permutation.view.GetInput;


public class PermutationController {

	/*
	 * Member variables
	 */
	private static PermutationController permutationController;
	private static GeneratePermutation generatePermutation;
	private static GetInput getInput;
	private static DisplayOutput displayOutput;
	private static DrawPermutation drawPermutation;
	private static HeapPermute heapPermute;
	private static SteinhausJohnsonTrotter steinhausJohnsonTrotter;
	private static FactorialPermutation factorialPermutation;
	private static Integer input,currentCursor=0;
	private static List<Integer> lexPermutationList;
	private static List<Integer> factorialPermutationList;
	private static List<Integer> heapPermutationList;
	private static List<Integer> steinhausJohnsonTrotterPermutationList;
	/*
	 * Member function
	 */
	//constructor
	private PermutationController(){
		generatePermutation = GeneratePermutation.getInstance();
		displayOutput = DisplayOutput.getInstance();
		drawPermutation = DrawPermutation.getInstance();
		getInput = GetInput.getInstance();
		heapPermute = HeapPermute.getInstance();
		steinhausJohnsonTrotter = SteinhausJohnsonTrotter.getInstance();
		factorialPermutation = FactorialPermutation.getInstance();
	}
	
	//singleton
	public static PermutationController getInstance(){
		if(permutationController==null){
			permutationController = new PermutationController();
		}
		return permutationController;
	}
	
	//To print output in the jFrame
	public static void drawPermutation(Graphics2D graphics2D){
		if(currentCursor==0)
			drawPermutation.paintPermutation(graphics2D, getPermutationList());
		else if(currentCursor==1)
			drawPermutation.paintPermutation(graphics2D, getFactorialPermutationList());
		else if(currentCursor==2)
			drawPermutation.paintPermutation(graphics2D, getHeapPermutationList());
		else if(currentCursor==3)
			drawPermutation.paintPermutation(graphics2D, getSteinhausJohnsonTrotterPermutationList());
	}
	
	//To do lexicographic algorithm
	public static void doLex(){
		setInput(Integer.parseInt(getInput.getjTextField1Content()));
		currentCursor = 0;
		setPermutationList(generatePermutation.lexiconOrderPermutation(getInput()));
		displayOutput.refresh();
	}
	
	//To do factorial algorithm
	public static void doFactorialPermute(){
		currentCursor = 1;
		setInput(Integer.parseInt(getInput.getjTextField1Content()));
		setFactorialPermutationList(factorialPermutation.factorialOrderPermutation(getInput()));
		displayOutput.refresh();
	}
	
	//To do heap algorithm
	public static void doHeapPermute(){
		currentCursor = 2;
		setInput(Integer.parseInt(getInput.getjTextField1Content()));
		setHeapPermutationList(heapPermute.heapOrderPermutation(getInput()));
		displayOutput.refresh();
	}
	
	//To do steinhaus johnson trotter
	public static void doSteinhausJohnsonTrotter(){
		currentCursor = 3;
		setInput(Integer.parseInt(getInput.getjTextField1Content()));
		setSteinhausJohnsonTrotterPermutationList(steinhausJohnsonTrotter.steinhausJohnsonTrotterOrderPermutation(getInput()));
		displayOutput.refresh();
	}
	
	//main method of permutationController
	//here the project starts
	public static void main(String[] args) throws WrongInputException{
		permutationController = getInstance();
		getInput.setVisible(true);
		displayOutput.init();
	}

	/*
	 * Getters and Setters
	 */
	public static Integer getInput() {
		return input;
	}

	public static void setInput(Integer input) {
		PermutationController.input = input;
	}

	public static List<Integer> getPermutationList() {
		return lexPermutationList;
	}

	public static void setPermutationList(List<Integer> lexPermutationList) {
		PermutationController.lexPermutationList = lexPermutationList;
	}

	public static List<Integer> getFactorialPermutationList() {
		return factorialPermutationList;
	}

	public static void setFactorialPermutationList(List<Integer> factorialPermutationList) {
		PermutationController.factorialPermutationList = factorialPermutationList;
	}

	public static List<Integer> getHeapPermutationList() {
		return heapPermutationList;
	}

	public static void setHeapPermutationList(List<Integer> heapPermutationList) {
		PermutationController.heapPermutationList = heapPermutationList;
	}

	public static List<Integer> getSteinhausJohnsonTrotterPermutationList() {
		return steinhausJohnsonTrotterPermutationList;
	}

	public static void setSteinhausJohnsonTrotterPermutationList(List<Integer> steinhausJohnsonTrotterPermutationList) {
		PermutationController.steinhausJohnsonTrotterPermutationList = steinhausJohnsonTrotterPermutationList;
	}

}
