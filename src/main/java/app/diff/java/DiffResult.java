package app.diff.java;

import java.util.ArrayList;
import java.util.List;

public class DiffResult {
	List<? extends Diffble<?>> sourceLeft;
	List<? extends Diffble<?>> sourceRight;
	List<Diffble<?>> onlyInLeft = new ArrayList<Diffble<?>>();
	List<Diffble<?>> onlyInRight = new ArrayList<Diffble<?>>();
	List<Pair<?>> bothInLeftAndRight = new ArrayList<Pair<?>>();

	public DiffResult(List<? extends Diffble<?>> sourceLeft, List<? extends Diffble<?>> sourceRight) {
		this.sourceLeft = sourceLeft;
		this.sourceRight = sourceRight;
	}

	public List<? extends Diffble<?>> getSourceLeft() {
		return sourceLeft;
	}

	public void setSourceLeft(List<Diffble<?>> sourceLeft) {
		this.sourceLeft = sourceLeft;
	}

	public List<? extends Diffble<?>> getSourceRight() {
		return sourceRight;
	}

	public void setSourceRight(List<Diffble<?>> sourceRight) {
		this.sourceRight = sourceRight;
	}

	public List<Diffble<?>> getOnlyInLeft() {
		return onlyInLeft;
	}

	public void setOnlyInLeft(List<Diffble<?>> onlyInLeft) {
		this.onlyInLeft = onlyInLeft;
	}

	public List<Diffble<?>> getOnlyInRight() {
		return onlyInRight;
	}

	public void setOnlyInRight(List<Diffble<?>> onlyInRight) {
		this.onlyInRight = onlyInRight;
	}

	public List<Pair<?>> getBothInLeftAndRight() {
		return bothInLeftAndRight;
	}

	public void setBothInLeftAndRight(List<Pair<?>> bothInLeftAndRight) {
		this.bothInLeftAndRight = bothInLeftAndRight;
	}

	@Override
	public String toString() {
		return "{\"onlyInLeft\":\"" + onlyInLeft + "\",\"onlyInRight\":\"" + onlyInRight
				+ "\",\"bothInLeftAndRight\":\"" + bothInLeftAndRight + "\"}";
	}

}

class Pair<T> {
	T nodeLeft;
	T nodeRight;
	@Override
	public String toString() {
		return "{\"nodeLeft\":\"" + nodeLeft + "\",\"nodeRight\":\"" + nodeRight + "\"}";
	}
	
}
