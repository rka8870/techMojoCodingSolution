/**
 * 
 */
package solution1;

import java.util.Comparator;

/**
 * This class is used to compare two given {@link Hashtag} on the basis of frequency
 * @author Raunak Agarwal
 *
 */
public class HashtagComparator implements Comparator<Hashtag> {

	@Override
	public int compare(Hashtag tag1, Hashtag tag2) {
		return tag1.getFrequency() - tag2.getFrequency();
	}

}
