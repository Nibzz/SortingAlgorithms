import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class Project1 {
	
	static int count = 0;

public static void main(String[] args) throws IOException{
	
	BufferedReader readText = new BufferedReader(new FileReader("Num8.txt"));
	int[] array8 = populateArray(readText,8);
	readText = new BufferedReader(new FileReader("Num16.txt"));
	int[] array16 = populateArray(readText,16);
	readText = new BufferedReader(new FileReader("Num32.txt"));
	int[] array32 = populateArray(readText,32);
	readText = new BufferedReader(new FileReader("Num64.txt"));
	int[] array64 = populateArray(readText,64);
	readText = new BufferedReader(new FileReader("Num128.txt"));
	int[] array128 = populateArray(readText,128);
	readText = new BufferedReader(new FileReader("Num256.txt"));
	int[] array256 = populateArray(readText,256);
	readText = new BufferedReader(new FileReader("Num512.txt"));
	int[] array512 = populateArray(readText,512);
	readText = new BufferedReader(new FileReader("Num1024.txt"));
	int[] array1024 = populateArray(readText,1024);
	readText = new BufferedReader(new FileReader("Num2048.txt"));
	int[] array2048 = populateArray(readText,2048);
	readText = new BufferedReader(new FileReader("Num4096.txt"));
	int[] array4096 = populateArray(readText,4096);
	readText = new BufferedReader(new FileReader("Num8192.txt"));
	int[] array8192 = populateArray(readText,8192);
	readText = new BufferedReader(new FileReader("Num16384.txt"));
	int[] array16384 = populateArray(readText,16384);
	
	readText = new BufferedReader(new FileReader("Num8-2.txt"));
	int[] array8_2 = populateArray(readText,8);
	readText = new BufferedReader(new FileReader("Num16-2.txt"));
	int[] array16_2 = populateArray(readText,16);
	readText = new BufferedReader(new FileReader("Num32-2.txt"));
	int[] array32_2 = populateArray(readText,32);
	readText = new BufferedReader(new FileReader("Num64-2.txt"));
	int[] array64_2 = populateArray(readText,64);
	readText = new BufferedReader(new FileReader("Num128-2.txt"));
	int[] array128_2 = populateArray(readText,128);
	readText = new BufferedReader(new FileReader("Num256-2.txt"));
	int[] array256_2 = populateArray(readText,256);
	
	insertionSort(array8);
	insertionSort(array16);
	insertionSort(array32);
	insertionSort(array64);
	insertionSort(array128);
	insertionSort(array256);
	insertionSort(array512);
	insertionSort(array1024);
	insertionSort(array2048);
	insertionSort(array4096);
	insertionSort(array8192);
	insertionSort(array16384);
	
	mergeHelper(array8);
	mergeHelper(array16);
	mergeHelper(array32);
	mergeHelper(array64);
	mergeHelper(array128);
	mergeHelper(array256);
	mergeHelper(array512);
	mergeHelper(array1024);
	mergeHelper(array2048);
	mergeHelper(array4096);
	mergeHelper(array8192);
	mergeHelper(array16384);
	
	heapSort(array8);
	heapSort(array16);
	heapSort(array32);
	heapSort(array64);
	heapSort(array128);
	heapSort(array256);
	heapSort(array512);
	heapSort(array1024);
	heapSort(array2048);
	heapSort(array4096);
	heapSort(array8192);
	heapSort(array16384);
		
	quickHelper(array8);
	quickHelper(array16);
	quickHelper(array32);
	quickHelper(array64);
	quickHelper(array128);
	quickHelper(array256);
	quickHelper(array512);
	quickHelper(array1024);
	quickHelper(array2048);
	quickHelper(array4096);
	quickHelper(array8192);
	quickHelper(array16384);

	System.out.println();
	System.out.println("---------------------------");
	System.out.println();
	
	countingHelper(array8_2);
	countingHelper(array16_2);
	countingHelper(array32_2);
	countingHelper(array64_2);
	countingHelper(array128_2);
	countingHelper(array256_2);
	
	radixHelper(array8_2);
	radixHelper(array16_2);
	radixHelper(array32_2);
	radixHelper(array64_2);
	radixHelper(array128_2);
	radixHelper(array256_2);
	
	bucketSort(array8_2);
	bucketSort(array16_2);
	bucketSort(array32_2);
	bucketSort(array64_2);
	bucketSort(array128_2);
	bucketSort(array256_2);
	
	readText.close();
}

public static int[] populateArray(BufferedReader readText, int Amount) throws NumberFormatException, IOException{
	int[] newArray = new int[Amount];
	for(int a = 0; a < Amount; a++){
		newArray[a] = Integer.parseInt(readText.readLine());
	}
	return newArray;
}

public static void insertionSort(int[] Array){
	int[] inputArray = Arrays.copyOf(Array, Array.length);
	for(int j = 1; j < inputArray.length; j++){
		int key = inputArray[j];
		int i = j - 1;
		while(i >= 0 && inputArray[i] > key){
			count++;
			inputArray[i + 1] = inputArray[i];
			i--;
		}
		inputArray[i + 1] = key;
	}
	System.out.println("Count for " + inputArray.length + " (Insertion): " + count);
	if(inputArray.length <= 64){
		System.out.println(Arrays.toString(inputArray));	
	}
	else{
		int[] partOf = Arrays.copyOfRange(inputArray, 50, 100);
		System.out.println(Arrays.toString(partOf));
	}
	count = 0;
}

public static void mergeHelper(int[] Array){
	int[] inputArray = Arrays.copyOf(Array, Array.length);
	mergeSort(inputArray, 0, inputArray.length - 1);
	System.out.println("Count for " + inputArray.length + " (Merge): " + count);
	if(inputArray.length <= 64){
		System.out.println(Arrays.toString(inputArray));	
	}
	else{
		int[] partOf = Arrays.copyOfRange(inputArray, 50, 100);
		System.out.println(Arrays.toString(partOf));
	}
	count = 0;
}

public static void mergeSort(int[] inputArray, int p, int r){
	if(p < r){
		int q = (p + r ) / 2;
			mergeSort(inputArray, p, q);
			mergeSort(inputArray, q + 1, r);
			merge(inputArray, p, q, r);
	}
}
	
public static void merge(int[] inputArray, int p, int q, int r){
	int n1 = (q - p) + 2;
	int n2 = (r - q) + 1;
	int[] LArray = new int[n1];
	int[] RArray = new int[n2];
	for(int a = 0; a < n1 - 1; a++){
		LArray[a] = inputArray[p + a];
	}
	for(int b = 0; b < n2 - 1; b++){
		RArray[b] = inputArray[q + b + 1];
	}
	LArray[LArray.length - 1] = Integer.MAX_VALUE;
	RArray[RArray.length - 1] = Integer.MAX_VALUE;
	int i = 0;
	int j = 0;
	for(int k = p; k <= r; k++){
		count++;
		if(LArray[i] <= RArray[j]){
			inputArray[k] = LArray[i];
			i++;
		}
		else{
			inputArray[k] = RArray[j];
			j++;
		}
	}
}

public static void heapSort(int[] Array){
	int[] inputArray = Arrays.copyOf(Array, Array.length);
	int heapSize = inputArray.length - 1;
	buildMaxHeap(inputArray, heapSize);
	for(int i = inputArray.length - 1; i > 0; i--){
		int temp = inputArray[i];
		inputArray[i] = inputArray[0];
		inputArray[0] = temp;
		heapSize--;
		maxHeapify(inputArray, 0, heapSize);
	}
	System.out.println("Count for " + inputArray.length + " (Heap): " + count);
	if(inputArray.length <= 64){
		System.out.println(Arrays.toString(inputArray));	
	}
	else{
		int[] partOf = Arrays.copyOfRange(inputArray, 50, 100);
		System.out.println(Arrays.toString(partOf));
	}
	count = 0;
}

public static void buildMaxHeap(int[] Array, int heapSize){
	for(int i = Array.length / 2; i >= 0; i--){
		maxHeapify(Array, i, heapSize);
	}
}
	
public static void maxHeapify(int[] Array, int i, int heapSize){
	int Left = 2 * i + 1;
	int Right = 2 * i + 2;
	int largest;
	if(Left <= heapSize && Array[Left] > Array[i]){
		largest = Left;
	}
	else{
		largest = i;
	}
	if(Right <= heapSize && Array[Right] > Array[largest]){
		largest = Right;
	}
	if(largest != i){
		int temp = Array[i];
		Array[i] = Array[largest];
		Array[largest] = temp;
		count++;
		maxHeapify(Array, largest, heapSize);
	}
}

public static void quickHelper(int[] Array){
	int[] inputArray = Arrays.copyOf(Array, Array.length);
	quickSort(inputArray, 0, inputArray.length - 1);
	System.out.println("Count for " + inputArray.length + " (Quick): " + count);
	if(inputArray.length <= 64){
		System.out.println(Arrays.toString(inputArray));	
	}
	else{
		int[] partOf = Arrays.copyOfRange(inputArray, 50, 100);
		System.out.println(Arrays.toString(partOf));
	}
	count = 0;
}

public static void quickSort(int[] Array, int p, int r){
	if(p < r){
		int q = partition(Array, p, r);
		quickSort(Array, p, q - 1);
		quickSort(Array, q + 1, r);
	}
}
	
public static int partition(int[] Array, int p, int r){
	int x = Array[r];
	int i = p - 1;
	for(int j = p; j <= r - 1; j++){
		count++;
		if(Array[j] <= x){
			i++;
			int temp = Array[i];
			Array[i] = Array[j];
			Array[j] = temp;
		}
	}
	int temp2 = Array[i + 1];
	Array[i + 1] = Array[r];
	Array[r] = temp2;
	return i + 1;
}

public static void countingHelper(int[] Array){
	int[] inputArray = Arrays.copyOf(Array, Array.length);
	int[] outputArray = new int[inputArray.length];
	countingSort(inputArray, outputArray, inputArray.length);
	System.out.println("Count for " + inputArray.length + " (Counting): " + count);
	System.out.println(Arrays.toString(outputArray));
	count = 0;
}

public static void countingSort(int[] Array, int[] Array2, int k){
	int[] countArray = new int[k + 1];
	for(int a = 0; a < Array.length; a++){
		countArray[Array[a]]++;
	}
	for(int b = 1; b <= k; b++){
		countArray[b] = countArray[b] + countArray[b - 1];
	}
	for(int c = Array.length - 1; c >= 0; c--){
		count++;
		Array2[countArray[Array[c]] - 1] = Array[c];
		countArray[Array[c]]--;
	}
}

public static void radixHelper(int[] Array){
	int[] inputArray = Arrays.copyOf(Array, Array.length);
	int digits = String.valueOf(Array.length).length();
	radixSort(inputArray, digits);
}

public static void radixSort(int[] Array, int d){
	int[] inputArray = Arrays.copyOf(Array, Array.length);
	int[] outputArray = new int[inputArray.length];
	for(int i = 1; i <= d; i++){
		radixCountSort(inputArray, outputArray, i);
		inputArray = Arrays.copyOf(outputArray, outputArray.length);
	}
	System.out.println("Count for " + inputArray.length + " (Radix): " + count);
	System.out.println(Arrays.toString(inputArray));
	count = 0;
}

public static void radixCountSort(int[] Array, int[] Array2, int i){
	int modValue = 1;
	for(int z = 0; z < i; z++){
		modValue = modValue * 10;
	}
	int[] countArray = new int[10];
	for(int a = 0; a < Array.length; a++){
		countArray[(Array[a] % modValue) / (modValue / 10)]++;
	}
	for(int b = 1; b < 10; b++){
		countArray[b] = countArray[b] + countArray[b - 1];
	}
	for(int c = Array.length - 1; c >= 0; c--){
		count++;
		Array2[countArray[(Array[c] % modValue) / (modValue / 10)] - 1] = Array[c];
		countArray[(Array[c] % modValue) / (modValue / 10)]--;
	}
}
	
public static void bucketSort(int[] Array){
	double[] inputArray = new double[Array.length];
	for(int a = 0; a < Array.length; a++){
		inputArray[a] = (double)Array[a];
	}
	bucketConvert(inputArray, 1, inputArray.length);
	double n = inputArray.length;
	LinkedList<Double> outputLL = new LinkedList<Double>();
	LinkedList<Double>[] bucketArray = new LinkedList[(int)n];
	for(int a = 0; a < n; a++){
		bucketArray[a] = new LinkedList<Double>();
	}
	for(int i = 0; i < n; i++){
		int bucketEle = (int)Math.floor(((double)inputArray[i]/(1.0/n)));
		bucketArray[bucketEle].add(inputArray[i]);
	}
	for(int b = 0; b < n; b++){
		count++;
		bucketInsertSort(bucketArray[b]);
		for(int a = 0; a < bucketArray[b].size(); a++){
			outputLL.add(numberRevert(bucketArray[b].get(a), 1, inputArray.length));
		}
	}
System.out.println("Count for " + inputArray.length + " (Bucket): " + count);
System.out.println(outputLL);
count = 0;
}

public static void bucketInsertSort(LinkedList<Double> inputLL){
	for(int j = 1; j < inputLL.size(); j++){
		double key = inputLL.get(j);
		int i = j - 1;
		while(i >= 0 && inputLL.get(i) > key){
			count++;
			inputLL.set(i + 1, inputLL.get(i));
			i--;
		}
		inputLL.set(i + 1, key);
	}
}

public static void bucketConvert(double[] Array, int min, int max){
	int x = -min;
	for(int a = 0; a < Array.length; a++){
		Array[a]+=x;
	}
	int y = max + 1;
	for(int a = 0; a < Array.length; a++){
		Array[a]/=y;
	}
}

public static double numberRevert(double Element, int min, int max){
	int y = max + 1;
	Element*=y;
	int x = -min;
	Element-=x;
	return Element;
}


}
