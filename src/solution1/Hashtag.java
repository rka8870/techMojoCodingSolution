/**
 * 
 */
package solution1;

/**
 * This class is used as a bean to store hashtag information.
 * <br>1.name specifies hashtag name.
 * <br>2.frequency specifies current frequency count.
 * <br>3.visited specifies wether the given hastag is currently trending or not. 
 * @author Raunak Agarwal
 *
 */
public class Hashtag {

	private String name;
	
	private int frequency;
	
	private boolean visited;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 * @param frequency
	 * @param visited
	 */
	public Hashtag(String name, int frequency, boolean visited) {
		super();
		this.name = name;
		this.frequency = frequency;
		this.visited = visited;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the frequency
	 */
	public int getFrequency() {
		return frequency;
	}

	/**
	 * @param frequency the frequency to set
	 */
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	/**
	 * @return the visited
	 */
	public boolean isVisited() {
		return visited;
	}

	/**
	 * @param visited the visited to set
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	
}

