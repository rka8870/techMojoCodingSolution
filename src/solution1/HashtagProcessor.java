/**
 * 
 */
package solution1;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * This class is used process tweets entered by the user
 * @author Raunak Agarwal
 *
 */
public class HashtagProcessor {

	/**
	 * This specifies the max size of heap.
	 */
	private static int NO_OF_HASHTAGS=10;
	
	/**
	 * This method is used to extract all the hashtags(A valid hastag is a word starting with # folowed by A-Z/a-z/0-9/_ example #india)
	 * from a given line and store in a map while maintaining top trending hashtags at the same time(in a heap).
	 * @param message
	 * @param map
	 * @param minHeap
	 */
	public void extractAndStoreHashtags(String message, Map<String, Hashtag> map, PriorityQueue<Hashtag> minHeap) {
		int length = message.length();
		char ch;
		int i = 0;
		while (i < length) {
			ch = message.charAt(i);
			if (ch == '#') {
				StringBuilder tag = new StringBuilder();
				tag.append(ch);
				i++;
				while (i < length && checkEndOfTag(message.charAt(i))) {
					ch = message.charAt(i);
					tag.append(ch);
					i++;
				}
				if (tag.length() > 1) {
					storeAndUpdateHashtag(tag.toString(), map, minHeap);
				}
			}
			i++;
		}

	}

	/**This method is used to check wether a given character can be a part of hashtag or not.
	 * (A valid hastag character can be either  A-Z/a-z/0-9/_)
	 * @param c
	 * @return boolean
	 */
	private boolean checkEndOfTag(char c) {
		return (c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122) || c == 95;
	}

	/**
	 * This method is used to store hashtags in a map along with their updation in the min heap.
	 * <br>At any point of time only constant no of hashtag remains in the min heap.  
	 * @param key
	 * @param map
	 * @param q
	 */
	private void storeAndUpdateHashtag(String key, Map<String, Hashtag> map, PriorityQueue<Hashtag> q) {
		Hashtag tag, oldTag;
		if (!map.containsKey(key)) {
			tag = new Hashtag(key, 1, false);
			map.put(key, tag);
			if (q.size() < NO_OF_HASHTAGS) {
				tag.setVisited(true);
				q.add(tag);
			}
		} else {
			tag = map.get(key);
			tag.setFrequency(tag.getFrequency() + 1);
			if (tag.isVisited()) {
				q.remove(tag);
				q.add(tag);
			} else {
				if (q.peek().getFrequency() < tag.getFrequency()) {
					oldTag = q.remove();
					oldTag.setVisited(false);
					tag.setVisited(true);
					q.add(tag);
				}
			}
		}
	}

	/**
	 * This method is used to display the top trending hashtags present in the min heap at any particular point of time.
	 * @param queue
	 */
	public void displayTopTrendingHashtags(PriorityQueue<Hashtag> queue) {
		Stack<Hashtag> stack = new Stack<>();
		while (!queue.isEmpty()) {
			stack.push(queue.poll());
		}
		if (!stack.isEmpty())
			System.out.println("Hashtag ---> Mentions");
		else
			System.out.println("No Hashtag appeared till now");
		int i = 1;
		Hashtag hashtag;
		while (!stack.isEmpty()) {
			hashtag = stack.pop();
			System.out.println(i + ". " + hashtag.getName() + " ---> " + hashtag.getFrequency());
			i++;
		}
	}
}
