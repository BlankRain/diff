package app.diff.java;

import java.util.List;

/**
 * Diff算法
 * 
 * @author Administrator
 *
 */
public interface DiffAlgorithms {
	/**
	 * do diff
	 * 
	 * @param left
	 * @param right
	 * @return
	 *
	 */
	public DiffResult diff(final List<? extends Diffble<?>> left, final List<? extends Diffble<?>> right);
}
