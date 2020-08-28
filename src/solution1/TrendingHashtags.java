/**
 * 
 */
package solution1;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Raunak Agarwal
 *
 */
public class TrendingHashtags {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		int option = 1;
		Map<String, Hashtag> map = new HashMap<>();
		PriorityQueue<Hashtag> minHeap = new PriorityQueue<>(new HashtagComparator());
		HashtagProcessor processor = new HashtagProcessor();
		try {
		while (option != 2) {
			System.out.println("Type 1 and press Enter Key for submitting tweet.");
			System.out.println("Type 2 and press Enter Key to see top 10 hashtags.");
			option = scanner.nextInt();
			switch (option) {
			case 1:
				System.out.println("Enter the tweet.");
				processor.extractAndStoreHashtags(new Scanner(System.in).nextLine(), map, minHeap);
				continue;
			case 2:
				processor.displayTopTrendingHashtags(minHeap);
				break;
			default:
				System.out.println("Wrong input choice end either option 1 or 2.");
				break;
			}

		}
	}
	catch(Exception e) {
		System.out.println("Exception occured failed to processs tweets");
		e.printStackTrace();
	}
	}
}
