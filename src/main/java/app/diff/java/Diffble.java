package app.diff.java;

public interface Diffble<T> extends Comparable<T> {
	/**
	 * 
	 * <img src="https://unsplash.it/200/100/?random"/>
	 * 
	 * @return
	 *
	 */
	public boolean amITheSameAs(Diffble<?> right);
}
