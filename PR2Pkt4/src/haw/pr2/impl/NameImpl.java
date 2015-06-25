package haw.pr2.impl;

import haw.pr2.interfaces.adminValue.Name;
import static com.google.common.base.Preconditions.*;

public class NameImpl implements Name {
	public final String name;

	private NameImpl(String name) {
		this.name = name;
	}

	public static Name valueOf(String name) {
		checkNotNull(name);
		return new NameImpl(name);
	}

	@Override
	public String nameString() {
		return this.name;
	}

	@Override
	public int compareTo(Name other) {
		checkNotNull(other);
		return this.nameString().compareTo(other.nameString());
	}

	@Override
	public int hashCode() {
		return this.nameString().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (!(obj instanceof Name))
			return false;

		Name other = (Name) (obj);
		return (this.compareTo(other) == 0);
	}

}
