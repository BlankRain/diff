package app.diff.java;

import java.util.List;

/**
 * do it in a hard way with for loop compare
 * 
 * @author Administrator
 *
 */
public class ForLoopDiff implements DiffAlgorithms {

	public DiffResult diff(List<? extends Diffble<?>> left, List<? extends Diffble<?>> right) {
		DiffResult dr = new DiffResult(left, right);
		/**
		 * both and only in left
		 */
		for (Diffble<?> nodeLeft : left) {
			boolean leftOnly = true;
			for (Diffble<?> nodeRight : right) {
				if (nodeLeft.amITheSameAs(nodeRight)) {
					Pair<Diffble<?>> p = new Pair<Diffble<?>>();
					p.nodeLeft = nodeLeft;
					p.nodeRight = nodeRight;
					dr.getBothInLeftAndRight().add(p);
					leftOnly = false;
					break;
				}
			}
			if (leftOnly) {
				dr.getOnlyInLeft().add(nodeLeft);
			}
		}
		/**
		 * only in right
		 */
		for (Diffble<?> nodeRight : right) {
			boolean rightOnly = true;
			for (Diffble<?> nodeLeft : left) {
				if (nodeRight.amITheSameAs(nodeLeft)) {
					rightOnly = false;
					break;
				}
			}
			if (rightOnly) {
				dr.getOnlyInRight().add(nodeRight);
			}
		}
		return dr;
	}
}
